/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */

package Game;

/**
 *
 * @author Isaac
 */


public class Tile {
    
    //Constructeurs
    
    public Tile() {
        
    }
    
    public Tile(String t) {
        setType(t);
    }
    
    public Tile(String t, int x, int y) {
        setType(t);
        setXPos(x);
        setYPos(y);
    }
    
    //Méthodes
    
    public void setType(String t) {
        this.type = t;
    }
    
    public void setXPos(int x) {
        this.xPos = x;
    }
    
    public void setYPos(int y) {
        this.yPos = y;
    }
    
    public String getType() {
        return this.type;
    }
    
    //Variables
    int xPos;
    int yPos;
    String type;
}
