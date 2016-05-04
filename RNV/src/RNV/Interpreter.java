/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */

package RNV;

import Game.*;
import javax.swing.SwingWorker;

/**
 *
 * @author Isaac
 */

public class Interpreter {
    
    public void interpreteWith(Network net, RunningGame game) {
        
        Tile[][] input = game.getViewRadius(2);
        
        SwingWorker worker = new SwingWorker<Void, String>() {
            
            @Override
            protected Void doInBackground() throws Exception {
                return null;
            }
            
//            @Override
            protected void process() {

            }
        };
        worker.execute();
        
    }
    
}
