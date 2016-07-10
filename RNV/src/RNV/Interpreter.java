/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */

package RNV;

import Game.*;
import java.util.HashSet;

/**
 *
 * @author Isaac
 */

public class Interpreter {
    
    public static int interpreteWith(Network net, RunningGame game, int sleep) throws InterruptedException {
        game.reset();
        
        //Pour calculer le nombre de cycles pendant lesquels le token n'a pas avancé
        int cyclesStopped = 0;
        while (game.getScore() != game.getMaxScore() && cyclesStopped < 10) {
            Tile[][] input = game.getViewRadius(2);
            Tile[] view = new Tile[25];
            int oldScore = game.getScore();

            //Transforme la table de Tiles en une liste
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    view[i+j*5] = input[i][j];
                }
            }
            
            
            //Liste les neurones activés par toutes les cases
            HashSet<Integer> activatedNeurons = new HashSet<>();
            for (int i = 0; i < 25; i++) {
                int type = view[i].getIntType();
                int[] addNeurons = net.getNeuronsActivatedBy(i,type);
                for (int id : addNeurons) {
                    activatedNeurons.add(id);
                }
            }
            
//            Integer[] activatedNeurons = (Integer[]) activatedNeuronsList.toArray();
            
            interpreteNextLevel(net, game, activatedNeurons);
            
            //Exécute les actions bufferées et réinitialise les booléens
            if (up) {game.goUp(); up = false;}
            if (down) {game.goDown(); down = false;}
            if (left) {game.goLeft(); left = false;}
            if (right) {game.goRight(); right = false;}
            
            //Vérifie que le score ait bien avancé. Si ce n'est pas le cas, compte le nombre de cycles passés sans avancer
            if (game.getScore() == oldScore) {
                cyclesStopped++;
            } else {
                cyclesStopped = 0;
            }
            
            //Thread.sleep(sleep); //TODO remettre sleep.
            
        }
        return game.getScore();
    }
    
    private static void interpreteNextLevel(Network net, RunningGame game, HashSet<Integer> activatedNeurons) {
        
        //Liste les touches activées
        for(Integer i = 1; i <= 4; i++) {
            if (activatedNeurons.remove(i)) {
                switch (i) {
                
                    case 1 : up = true; break;

                    case 2 : down = true; break;

                    case 3 : left = true; break;

                    case 4 : right = true; break;
                    
                }
            }
        }
        
        HashSet<Integer> nextActivatedNeurons = new HashSet<>();
        for (Integer i : activatedNeurons.toArray(new Integer[activatedNeurons.size()])) {
            if (net.getNetwork()[net.getNeuronIndexFromId(i)].inhibitor == false) {
                int[] addNeurons = net.getNetwork()[net.getNeuronIndexFromId(i)].getSynapses();
                for (int id : addNeurons) {
                    nextActivatedNeurons.add(id);
                }
            }
        }
        
        
        for (Integer i : activatedNeurons.toArray(new Integer[activatedNeurons.size()])) {
            if (net.getNetwork()[net.getNeuronIndexFromId(net.getNeuronIndexFromId(i))].inhibitor == true) {
                int[] rmNeurons = net.getNetwork()[net.getNeuronIndexFromId(i)].getSynapses();
                for (int id : rmNeurons) {
                    nextActivatedNeurons.remove(id);
                }
            }
        }
//        Integer[] nextActivatedNeurons = (Integer[]) nextActivatedNeuronsList.toArray();
        
        if (!nextActivatedNeurons.isEmpty()) {
            interpreteNextLevel(net,game,nextActivatedNeurons);
        }
        
//        for (int i = 0; i < activatedNeurons.length; i++) {
//            
//            int id = activatedNeurons[i];
//            
//            switch (id) {
//                
//                case 1 : up = true; break;
//                
//                case 2 : down = true; break;
//                
//                case 3 : left = true; break;
//                
//                case 4 : right = true; break;
//                
//                default :
//                    int[] nextActivatedNeurons = net.getNetwork()[net.getNeuronIndexFromId(id)].getSynapses();
//                    if (nextActivatedNeurons.length != 0) {
//                        interpreteNextLevel(net,game,nextActivatedNeurons);
//                    }
//                    break;
//                    
//            }
//        }
    }
    
    //Booléens pour bufferer les actions avant de toutes les exécuter à la fin
    private static boolean up;
    private static boolean down;
    private static boolean left;
    private static boolean right;
    
}
