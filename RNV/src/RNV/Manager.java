/*
 * Projet de fin d'ann�e d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */
package RNV;

import Game.RunningGame;
import Game.Tile;
import Tools.FileIO;
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Guillaume
 */
public class Manager {
    
    //Constructeurs avec et sans réseau de base
    
    public Manager(String name, Tile[][] mapUsed) { 
        
        //Créé la première génération du manager.
        netArray = new Network[10][15];
        for (int i = 0; i < netArray.length; i++) {
            for (int j = 0; j < netArray[0].length; j++) {
                netArray[i][j] = Generator.create();
            }
        }
        
        //Initialise la map
        game = new RunningGame(mapUsed);
        Manager.name = name;
        endingNetwork = null;
        scoreMax = game.getMaxScore();
        System.out.println("Score max possible : " + game.getMaxScore());
        numeroGen = 0;
        scoreMaxRnv = 0;
    }
    
    public Manager(String name, Network network, Tile[][] mapUsed) { 
        
        //Créé la première génération du manager à partir d'un réseau.
        netArray = new Network[10][15];
        for (int i = 0; i < netArray.length; i++) {
            for (int j = 0; j < netArray[0].length; j++) {
                netArray[i][j] = Generator.mutate(network);
            }
        }  
        
        //Initialise la map
        game = new RunningGame(mapUsed);
        Manager.name = name;
        endingNetwork = null;
        scoreMax = game.getMaxScore();
        numeroGen = 0;
        scoreMaxRnv = 0;
    }
 
    
    //Méthodes d'utilisation
    
    /**
     * Procédure qui lance les tests de RNV (se termine au bout de 150 générations ou lorsqu'un réseau a atteint le score max)
     */
    public void launch() throws InterruptedException {
        
        System.out.println("\n\n\n\n\n\nGénération " + numeroGen);
       
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
                System.out.println("Avant interpreter");
                netArray[i][j].setScore(Interpreter.interpreteWith(netArray[i][j], game, 0));
                System.out.println("Après interpreter");
                
                //Actualise les scores si nécessaire
                if (netArray[i][j].getScore() > scoreMaxFamily[i]) {
                    scoreMaxFamily[i] = netArray[i][j].getScore();
                    bestNetworkFamily[i] = j;
                }
                if (scoreMaxFamily[i] > scoreMaxRnv) {
                    scoreMaxRnv = scoreMaxFamily[i];
                    bestNetwork[0] = numeroGen;
                    bestNetwork[1] = i;
                    bestNetwork[2] = j;
                }
                if (scoreMaxRnv >= scoreMax) {
                    endingNetwork = netArray[i][j];
                    System.out.println("Le network " + numeroGen + "/" + i + "/" + j + " a terminé la map");
                } 
                
                //Sauvegarde le réseau actuel avant de passer au suivant
                save(netArray[i][j], numeroGen, i, j);
            }
        }
        
        /* TODO Trouver une solution pour exclure les familles (ça fait pour l'instant bugger, je ne sais pas pourquoi)
        System.out.println("Excluded family");
        //Met une famille hors jeu si elle est est trop mauvaise
        boolean[] excludedFamily = new boolean[netArray.length];
        int numberExcluded = 0;
        for (int i = 0; i < scoreMaxFamily.length; i++) {
            if (scoreMaxFamily[i] < scoreMaxRnv - (scoreMax/4)) {
                excludedFamily[i] = true;
                numberExcluded++;
            } else {
                excludedFamily[i] = false;
            }
        }
        */
        
        System.out.println("numberTimeTaken");
        //Network[][] buffer pour la prochaine génération
        Network[][] newNetArray = new Network[netArray.length][netArray[0].length];
        int[] numberTimeTaken = new int[netArray.length];
        for (int i = 0; i < numberTimeTaken.length; i++) {
            numberTimeTaken[i] = 0;
        }
        
        /* TODO Voir ligne 103
        System.out.println("excludedFamily -> numberTimeTaken");
        for (int i = 0; i < numberExcluded; i++) {
            int random;
            
            do {
                random = (int)(Math.random()*10);
            } while (excludedFamily[random]);
            numberTimeTaken[random]--;
            
            do {
                random = (int)(Math.random()*10);
            } while (excludedFamily[random]);
            numberTimeTaken[random]--;
        }
        */
        
        System.out.println("Combinaison");
        //Créé la nouvelle génération en combinant les meilleures individus de deux familles au hasard (chaque famille est combiné deux fois grace au tableau numberTimeTaken)
        for (int i = 0; i < newNetArray.length; i++) {
            
            int choosenFamily1, choosenFamily2, count = 0;
            do {
                count++;
                choosenFamily1 = (int)(Math.random()*10);
                choosenFamily2 = (int) (Math.random()*10);
            } while((numberTimeTaken[choosenFamily1] >= 2) || (numberTimeTaken[choosenFamily2] >= 2) && (choosenFamily1 == choosenFamily2) && (count < 30));
            
            while (choosenFamily1 == choosenFamily2) {
                choosenFamily1 = (int) (Math.random()*10);
            }
            
            numberTimeTaken[choosenFamily1]++; numberTimeTaken[choosenFamily2]++;
            
            for (int j = 0; j < newNetArray[0].length; j++) {
                System.out.println("Mutate + Synthesis depuis le manager : Familles combiné " + choosenFamily1 + " et " + choosenFamily2 + ". Individu " + i + "/" + j);
                Network newNet = new Network();
                newNet = Generator.synthesis(netArray[choosenFamily1][bestNetworkFamily[choosenFamily1]], netArray[choosenFamily2][bestNetworkFamily[choosenFamily2]]);
                newNetArray[i][j] = Generator.mutate(newNet);
            }
        }
        
        System.out.println("Copie");
        System.arraycopy(newNetArray, 0, netArray, 0, newNetArray.length);
        
        numeroGen++;
    
    }
    
    private static void save(Network net, int gen, int family, int numero) {
        
        char familyChar = 'a';
        for (int i = 0; i < family; i++) {
           familyChar++;        
        }
        
        System.out.println("Sauvegarde du réseau " + gen + "/" + familyChar + "/" + numero);
        
        String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "/RNV/Networks/" + name + "/" + gen + "/" + familyChar;
        File file = new File(path);
        file.mkdirs();
        path +=  "/" + numero + ".ntw";
        
        try {
            FileIO.writeNetworkFile(net, path);
        } catch (IOException e) {
//            System.out.println("Erreur lors de l'écriture du réseau " + gen + "/" + family + "/" + numero + " : " + e.getMessage()); TODO ce machin balance des erreurs pour rien, je commente pour le moment
        }
    }

    
    //Variables de classe
    
    /**
     * netArray est l'ensemble des familles et des individus de la génération actuelle.
     * Une famille est une colonne de netArray (= une liste), i.e. netArray[x] est la x-ème famille de netArray.
     * Chaque famille contient un certain nombre d'individu. Pour accèder à l'individu n° y de la famille x, il faut donc faire netArray[x][y]
     */
    private Network[][] netArray;
    private RunningGame game;
    public static String name;
    public Network endingNetwork;
    
    //Le meilleur score possible / le meilleur score atteint, toutes générations confondues / Le nombre de génération testée / Le meilleur network, toutes générations confondues
    public int scoreMax;
    public int scoreMaxRnv;
    public int numeroGen;
    public int[] bestNetwork = new int[3];
    
}
