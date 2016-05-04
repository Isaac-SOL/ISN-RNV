/*
 * Projet de fin d'ann�e d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */
package RNV;

/**
 *
 * @author Guillaume
 */
public class RnvManager {
    
    //Constructeurs avec et sans réseau de base
    
    public RnvManager(Integer[][] mapUsed) { 
        
        //Créé la première génération du manager.
        netArray = new Network[10][15];
        for (int i = 0; i < netArray.length; i++) {
            for (int j = 0; j < netArray[0].length; j++) {
                netArray[i][j] = RnvGenerator.create();
            }
        }
        
        //Initialise la map
        map = mapUsed;
    }
    
    public RnvManager(Network network, Integer[][] mapUsed) { 
        
        //Créé la première génération du manager à partir d'un réseau.
        netArray = new Network[10][15];
        for (int i = 0; i < netArray.length; i++) {
            for (int j = 0; j < netArray[0].length; j++) {
                netArray[i][j] = RnvGenerator.mutate(network);
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
            int[] scoreMaxFamily = new int[netArray[0].length];
            int[] bestNetworkFamily= new int[netArray[0].length];
            
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
            
            Network[][] newNetArray = new Network[10][15];
            
            for (int i = 0; i < newNetArray.length; i++) {
                for (int j = 0; j < newNetArray[0].length; j++) {
                    newNetArray[i][j] = RnvGenerator.mutate(RnvGenerator.assemble(netArray[i][bestNetworkFamily[i]], netArray[9-i][bestNetworkFamily[9-i]]));
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
