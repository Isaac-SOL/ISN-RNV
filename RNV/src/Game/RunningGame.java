/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */
package Game;

import static Tools.MapTranslator.intToTiles; //TODO rendre ces imports plus propres, je sais plus comment on fait
import static Tools.MapTranslator.tilesToIcons;
import static Tools.MapTranslator.tilesToInt;
import java.awt.image.BufferedImage;


/**
 *
 * @author Isaac
 */
public class RunningGame {
    
    //Constructeurs
    
    public RunningGame() {
        
    }
    
    //TODO Peut-être qu'il faudra caler tout ça dans un Tool? Le MapTranslator peut-être?
    public RunningGame(Integer[][] map) {
        currentMap = intToTiles(map);
    }
    
    //Méthodes
        //Input
    
    public void goLeft() {
        //TODO flèche gauche
    }
    
    public void goRight() {
        //TODO flèche droite
    }
    
    public void goUp() {
        //TODO flèche haut
    }
    
    public void goDown() {
        //TODO flèche bas
    }
    
        //Output
    
    public int getScore() {
        return score;
    }
    
    public Tile[][] getRawMap() {
        return currentMap;
    }
    
    public BufferedImage[][] getIconMap() {
        return tilesToIcons(currentMap);
    }
    
    public Integer[][] getIntMap() {
        return tilesToInt(currentMap);
    }
    
    public void getViewRadius(int r) {   //Contiendra une table de 5x5 qui représentera la "vue" du Token. Sera utilisée notamment par le RNV. Note: Je peux aussi faire dans l'overkill et mettre un radius variable. Je vais voir ça
        Tile[][] viewRadius = new Tile[2*r + 1][2*r + 1];
    }
    
    //Variables
    
    Tile[][] currentMap;
    int score;
}
