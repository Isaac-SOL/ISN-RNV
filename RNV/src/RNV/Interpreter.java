/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */

package RNV;

import Game.*;

/**
 *
 * @author Isaac
 */

public class Interpreter {
    
    public static int interpreteWith(Network net, RunningGame game) {
        //Pour calculer le nombre de cycles pendant lesquels le token n'a pas avancé
        int cyclesStopped = 0;
        while (game.getScore() != game.getMaxScore() && cyclesStopped < 10) {
            Tile[][] input = game.getViewRadius(2);
            Tile[] view = new Tile[25];
            int oldScore = game.getScore();

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    view[i+j*5] = input[i][j];
                }
            }

            for (int i = 1; i < 25; i++) {
                int type = view[i].getIntType();
                int[] activatedNeurons = net.getNeuronsActivatedBy(i,type);
                interpreteNextLevel(net,game,activatedNeurons);
            }
            
            if (game.getScore() == oldScore) {
                cyclesStopped++;
            } else {
                cyclesStopped = 0;
            }
            
        }
        return game.getScore();
    }
    
    private static void interpreteNextLevel(Network net, RunningGame game, int[] activatedNeurons) {
        for (int i = 0; i < activatedNeurons.length; i++) {
            
            int id = activatedNeurons[i];
            
            switch (id) {
                
                case 1 : game.goUp(); break;
                
                case 2 : game.goDown(); break;
                
                case 3 : game.goLeft(); break;
                
                case 4 : game.goRight(); break;
                
                default :
                    int[] nextActivatedNeurons = net.getNetwork()[net.getNeuronIndexFromId(id)].activate();
                    if (nextActivatedNeurons.length != 0) {
                        interpreteNextLevel(net,game,nextActivatedNeurons);
                    }
                    break;
                    
            }
        }
    }
}
