/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */

package Game;

import java.awt.Image;
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
    
    /**
     * Définit le type et l'icon de la tile
     * @param t type à définir
     */
    public void setType(String t) {
        this.type = t;
        setIcon(t);
    }
    
    /**
     * Définit le type et l'icône de la Tile à partir d'un Integer
     * @param i type à définir
     */
    public void setType(Integer i) {
        switch (i) {
            
            case 0 : this.type = "Token"; setIcon("Token"); break;
                
            case 1 : this.type = "Empty"; setIcon("Empty"); break;
                
            case 2 : this.type = "Obstacle"; setIcon("Obstacle"); break;
                
        }
    }
    
    /**
     * Définit la position x de la tile
     * @param x 
     */
    public void setXPos(int x) {
        this.xPos = x;
    }
    
    /**
     * Définit la position y de la tile
     * @param y 
     */
    public void setYPos(int y) {
        this.yPos = y;
    }
    
    /**
     * Définit l'icone de la tile à partir d'un type (String)
     * @param t 
     */
    public void setIcon(String t) {
        icon = new ImageIcon(getClass().getResource(t + ".png"));        //Trouve le fichier PNG avec le même nom que le type de tile
        if (icon == null) {
            System.out.println("Aucun icone n'a été trouvé avec ce nom : " + t);
            icon = new ImageIcon(getClass().getResource("Error.png"));
        }
    }
    
    /**
     * @return Le type de la tile
     */
    public String getType() {
        return this.type;
    }
    
    /** 
     * @return Le type de la tile sous forme d'Integer (null si il y a un problème de type)
     */
    // TODO Faire une meilleure gestion d'exception
    public Integer getIntType() {
        Integer iType = 0;
        switch (type) {
            
            case "Token" : iType = 0; break;
                
            case "Empty" : iType = 1; break;
                
            case "Obstacle" : iType = 2; break;
                
            default : System.out.println("Le type actuel n'est pas lisible.");
                      iType = null;
                
        }
        return iType;
    }
    
    /**
     * @return L'icône de la tile
     */
    public ImageIcon getIcon() {
        return this.icon;
    }
    
    /**
     * @param size Le nombre de pixels de côté de la nouvelle icône
     * @return l'icon de la tile redimensionnée
     */
    public ImageIcon getScaledIcon(int size) {
        return new ImageIcon(icon.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
    }
    
    //Variables
    int xPos;
    int yPos;
    String type;
    ImageIcon icon;
}
