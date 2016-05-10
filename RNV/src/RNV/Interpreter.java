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
    
    public void interpreteWith(Network net, RunningGame game) {
        
        Tile[][] input = game.getViewRadius(2);
        Tile[] view = new Tile[25];
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                view[i+j*5] = input[i][j];
            }
        }
        
        for (int i = 1; i <= 25; i++) {
            int type = view[i].getIntType();
        }
        
        
    }
    
}
