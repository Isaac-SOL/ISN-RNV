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

            //Vérifie les actions de toutes les cases
            for (int i = 1; i < 25; i++) {
                int type = view[i].getIntType();
                int[] activatedNeurons = net.getNeuronsActivatedBy(i,type);
                interpreteNextLevel(net,game,activatedNeurons);
            }
            
            //Exécute les actions bufferées
            if (up) {game.goUp();}
            if (down) {game.goDown();}
            if (left) {game.goLeft();}
            if (right) {game.goRight();}
            
            //Réinitialise les booléens
            up = false;
            down = false;
            left = false;
            right = false;
            
            //Vérifie que le score ait bien avancé. Si ce n'est pas le cas, compte le nombre de cycles passés sans avancer
            if (game.getScore() == oldScore) {
                cyclesStopped++;
            } else {
                cyclesStopped = 0;
            }
            
            Thread.sleep(sleep);
            
        }
        return game.getScore();
    }
    
    private static void interpreteNextLevel(Network net, RunningGame game, int[] activatedNeurons) {
        for (int i = 0; i < activatedNeurons.length; i++) {
            
            int id = activatedNeurons[i];
            
            switch (id) {
                
                case 1 : up = true; break;
                
                case 2 : down = true; break;
                
                case 3 : left = true; break;
                
                case 4 : right = true; break;
                
                default :
                    int[] nextActivatedNeurons = net.getNetwork()[net.getNeuronIndexFromId(id)].activate();
                    if (nextActivatedNeurons.length != 0) {
                        interpreteNextLevel(net,game,nextActivatedNeurons);
                    }
                    break;
                    
            }
        }
    }
    
    //Booléens pour bufferer les actions avant de toutes les exécuter à la fin
    private static boolean up;
    private static boolean down;
    private static boolean left;
    private static boolean right;
    
}
