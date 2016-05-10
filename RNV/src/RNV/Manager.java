/*
 * Projet de fin d'ann�e d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */
package RNV;

import Game.RunningGame;
import Tools.FileIO;
import java.io.IOException;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Guillaume
 */
public class Manager {
    
    //Constructeurs avec et sans réseau de base
    
    public Manager(String name, Integer[][] mapUsed) { 
        
        //Créé la première génération du manager.
        netArray = new Network[10][15];
        for (int i = 0; i < netArray.length; i++) {
            Network net = Generator.create();
            for (int j = 0; j < netArray[0].length; j++) {
                netArray[i][j] = Generator.mutate(net);
            }
        }
        
        //Initialise la map
        game = new RunningGame(mapUsed);
        this.name = name;
        endingNetwork = null;
    }
    
    public Manager(String name, Network network, Integer[][] mapUsed) { 
        
        //Créé la première génération du manager à partir d'un réseau.
        netArray = new Network[10][15];
        for (int i = 0; i < netArray.length; i++) {
            for (int j = 0; j < netArray[0].length; j++) {
                netArray[i][j] = Generator.mutate(network);
            }
        }  
        
        //Initialise la map
        game = new RunningGame(mapUsed);
        this.name = name;
        endingNetwork = null;
    }
 
    
    //Méthodes d'utilisation
    
    /**
     * Procédure qui lance les tests de RNV (se termine au bout de 150 générations ou lorsqu'un réseau a atteint le score max)
     */
    public void launch() {
        
        //Le meilleur score possible / le meilleur score atteint, toutes générations confondues
        int scoreMax = game.getMaxScore();
        int scoreMaxRnv = 0;
        int numberGen = 0;
        
        while (scoreMaxRnv < scoreMax && numberGen < 150) { //Lance les tests tant que les meilleur score atteint n'est pas le meilleurs score possible
            
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
                    netArray[i][j].setScore(Interpreter.interpreteWith(netArray[i][j], game));
                    
                    //Actualise les scores si nécessaire
                    if (netArray[i][j].getScore() > scoreMaxFamily[i]) {
                        scoreMaxFamily[i] = netArray[i][j].getScore();
                        bestNetworkFamily[i] = j;
                    }
                    if (scoreMaxFamily[i] > scoreMaxRnv) {
                        scoreMaxRnv = scoreMaxFamily[i];
                    }
                    if (scoreMaxRnv >= scoreMax) {
                        endingNetwork = netArray[i][j];
                        System.out.println("Le network " + numberGen + "/" + i + "/" + j + " a terminé la map");
                    } 
                    
                    //Sauvegarde le réseau actuel avant de passer au suivant
                    save(netArray[i][j], numberGen, i, j);
                }
            }
            
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
            
            //Network[][] buffer pour la prochaine génération
            Network[][] newNetArray = new Network[netArray.length][netArray[0].length];
            int[] numberTimeTaken = new int[netArray.length];
            for (int i = 0; i < numberTimeTaken.length; i++) {
                numberTimeTaken[i] = 0;
            }
            
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
                    newNetArray[i][j] = Generator.mutate(Generator.synthesis(netArray[choosenFamily1][bestNetworkFamily[choosenFamily1]], netArray[choosenFamily2][bestNetworkFamily[choosenFamily2]]));
                }
            }
            
            System.arraycopy(newNetArray, 0, netArray, 0, newNetArray.length);
            
            numberGen++;
        }
    }
    
    private static void save(Network net, int gen, int family, int numero) {
        String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "/RNV/Networks/" + name + "/" + gen + "/" + family + "/" + numero + ".ntw";
        try {
            FileIO.writeNetworkFile(net, path);
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du réseau " + gen + "/" + family + "/" + numero + " : " + e.getMessage());
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
    private static String name;
    private Network endingNetwork;
    
}
