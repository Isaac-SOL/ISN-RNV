/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */

package Game;

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
    
    public Tile(Integer i) {
        setType(i);
    }
    
    public Tile(Integer i, int x, int y) {
        setType(i);
        setXPos(x);
        setYPos(y);
    }
    
    //Méthodes
    
    public void setType(String t) {
        this.type = t;
    }
    
    //Définit le type et l'icône de la Tile à partir d'un Integer
    public void setType(Integer i) {
        switch (i) {
            
            case 0 : this.type = "Token"; setIcon("Token"); break;
                
            case 1 : this.type = "Empty"; setIcon("Empty"); break;
                
            case 2 : this.type = "Obstacle"; setIcon("Obstacle"); break;
                
        }
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
        icon = new ImageIcon(getClass().getResource(t + ".png"));        //Trouve le fichier PNG avec le même nom que le type de tile
//        icon = new BufferedImage(i.getIconWidth(), i.getIconHeight(), BufferedImage.TYPE_INT_ARGB);       //Crée une BufferedImage avec la taille de l'icône. ARGB pour avoir la transparence
//        Graphics g = icon.createGraphics();
//        i.paintIcon(null, g, 0,0);       //Met l'image de l'icône dans les graphiques g de la BufferedImage
//        g.dispose();
    }
    
    public String getType() {
        return this.type;
    }
    
    //Renvoie le type de Tile, sous forme d'un nombre. TODO Rendre ce comentaire propre (Dironiil)
    public Integer getIntType() {
        Integer iType = 0;
        switch (type) {
            
            case "Token" : iType = 0; break;
                
            case "Empty" : iType = 1; break;
                
            case "Obstacle" : iType = 2; break;
                
        }
        return iType;
    }
    
    public ImageIcon getIcon() {
        return this.icon;
    }
    
    //Variables
    int xPos;
    int yPos;
    String type;
    ImageIcon icon;
}
