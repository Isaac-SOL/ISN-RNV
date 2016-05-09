/*
 * Projet de fin d'ann�e d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */
package RNV;

/**
 *
 * @author Guillaume
 */
public class Manager {
    
    //Constructeurs avec et sans réseau de base
    
    public Manager(Integer[][] mapUsed) { 
        
        //Créé la première génération du manager.
        netArray = new Network[10][15];
        for (int i = 0; i < netArray.length; i++) {
            Network net = Generator.create();
            for (int j = 0; j < netArray[0].length; j++) {
                netArray[i][j] = Generator.mutate(net);
            }
        }
        
        //Initialise la map
        map = mapUsed;
    }
    
    public Manager(Network network, Integer[][] mapUsed) { 
        
        //Créé la première génération du manager à partir d'un réseau.
        netArray = new Network[10][15];
        for (int i = 0; i < netArray.length; i++) {
            for (int j = 0; j < netArray[0].length; j++) {
                netArray[i][j] = Generator.mutate(network);
            }
        }  
        
        //Initialise la map
        map = mapUsed;
    }
 
    
    //Méthodes d'utilisation
    
    /**
     * Procédure qui lance les tests de RNV ( /!\ actuellement inarrêtable tant que le RNV n'a pas atteint le score maximum possible /!\ )
     */
    public void launch() {
        
        //Le meilleur score possible / le meilleur score atteint, toutes générations confondues
        int scoreMax = map[0].length;
        int scoreMaxRnv = 0;
        
        
        while (scoreMaxRnv < scoreMax) { //Lance les tests tant que les meilleur score atteint n'est pas le meilleurs score possible
            
            //Les meilleurs score par famille et de meilleur individu par famille : rappel, une famille = une colonne de netArray
            int[] scoreMaxFamily = new int[netArray.length];
            int[] bestNetworkFamily= new int[netArray.length];
            
            //Chaque itération de cette boucle est une famille de la génération
            for (int i = 0; i < netArray.length; i++) {
                
                scoreMaxFamily[i] = 0;
                bestNetworkFamily[i] = 0;
                
                //Chaque itération de cette boucle est un individu de la famille
                for (int j = 0; j < netArray[0].length; j++) {
                    //Fait jouer cet individu
                    netArray[i][j].play(map);
                    
                    //Actualise les scores si nécessaire
                    if (netArray[i][j].getScore() > scoreMaxFamily[i]) {
                        scoreMaxFamily[i] = netArray[i][j].getScore();
                        bestNetworkFamily[i] = j;
                    }
                    if (scoreMaxFamily[i] > scoreMaxRnv) {
                        scoreMaxRnv = scoreMaxFamily[i];
                    }
                }
            }
            
            //Met une famille hors jeu si elle est est trop mauvaise
            boolean[] excludedFamily = new boolean[netArray.length];
            for (int i = 0; i < scoreMaxFamily.length; i++) {
                if (scoreMaxFamily[i] < scoreMaxRnv - (scoreMax/4)) {
                    excludedFamily[i] = true;
                } else {
                    excludedFamily[i] = false;
                }
            }
            
            //Network[][] buffer pour la prochaine génération
            Network[][] newNetArray = new Network[netArray.length][netArray[0].length];
            int[] numberTimeTaken = new int[netArray.length];
            for (int i = 0; i < numberTimeTaken.length; i++) {
                numberTimeTaken[i] = 0;
            }
            
            //Créé la nouvelle génération en combinant les meilleures individus de deux familles au hasard (chaque famille est combiné deux fois grace au tableau numberTimeTaken)
            for (int i = 0; i < newNetArray.length; i++) {
                
                int choosenFamily1, choosenFamily2;
                do {
                    choosenFamily1 = (int)(Math.random()*10);
                    do {
                        choosenFamily2 = (int) (Math.random()*10);
                    } while (choosenFamily2 == choosenFamily1);
                } while((numberTimeTaken[choosenFamily1] >= 2) || (numberTimeTaken[choosenFamily2] >= 2));
                
                numberTimeTaken[choosenFamily1]++; numberTimeTaken[choosenFamily2]++;
                
                for (int j = 0; j < newNetArray[0].length; j++) {
                    newNetArray[i][j] = Generator.mutate(Generator.assemble(netArray[choosenFamily1][bestNetworkFamily[choosenFamily1]], netArray[choosenFamily2][bestNetworkFamily[choosenFamily2]]));
                }
            }
            
            System.arraycopy(newNetArray, 0, netArray, 0, newNetArray.length);
        }
    }

    
    //Variables de classe
    
    /**
     * netArray est l'ensemble des familles et des individus de la génération actuelle.
     * Une famille est une colonne de netArray (= une liste), i.e. netArray[x] est la x-ème famille de netArray.
     * Chaque famille contient un certain nombre d'individu. Pour accèder à l'individu n° y de la famille x, il faut donc faire netArray[x][y]
     */
    private Network[][] netArray;
    private Integer[][] map;
    
}
