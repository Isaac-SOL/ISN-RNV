/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */

package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

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
    
    //TODO voir si y'a pas une meilleure manière de faire ça
    //TODO préparer des exceptions (Dironiil)
    public void setIcon(String t) {
        ImageIcon i = new ImageIcon(getClass().getResource(t + ".png"));        //Trouve le fichier PNG avec le même nom que le type de tile
        icon = new BufferedImage(i.getIconWidth(), i.getIconHeight(), BufferedImage.TYPE_INT_ARGB);       //Crée une BufferedImage avec la taille de l'icône. ARGB pour avoir la transparence
        Graphics g = icon.createGraphics();
        i.paintIcon(null, g, 0,0);       //Met l'image de l'icône dans les graphiques g de la BufferedImage
        g.dispose();
    }
    
    public String getType() {
        return this.type;
    }
    
    public BufferedImage getIcon() {
        return this.icon;
    }
    
    //Variables
    int xPos;
    int yPos;
    String type;
    BufferedImage icon;
}
