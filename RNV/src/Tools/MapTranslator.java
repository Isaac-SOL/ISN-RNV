/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Game.Tile;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Dironiil
 */


public class MapTranslator {   
    
    /**
     * Convertit un Integer[][] en Tile[][]
     * @param tMap Integer[][] à convertir Tile[][]
     * @return Integer[][] créé à partir de tMap
     */
    public static Tile[][] intToTiles(Integer[][] tMap) {
        Tile[][] Tiles = new Tile[tMap.length][tMap[0].length];       //Définit les dimensions de la nouvelle table à partir des dimensions de la table d'Integer
        for (int i = 0; i < tMap.length; i++) {
            for (int j = 0; j < tMap[0].length; j++) {
                Tiles[i][j] = new Tile(tMap[i][j],i,j);        //Définit la Tile à chaque case avec le constructeur
            }
        }
        return Tiles;
    }
    
    /**
     * Convertit un Tile[][] en Integer[][]
     * @param Tiles Tile[][] à convertir en Integer[][]
     * @return Integer[][] créé à partir de Tiles
     */
    public static Integer[][] tilesToInt(Tile[][] Tiles) {
        Integer[][] tMap = new Integer[Tiles.length][Tiles[0].length];       //Définit les dimensions de la nouvelle table à partir des dimensions de la table d'Integer
        for (int i = 0; i < Tiles.length; i++) {
            for (int j = 0; j < Tiles[0].length; j++) {
                tMap[i][j] = Tiles[i][j].getIntType();       //Définit la Tile à chaque case avec le constructeur
            }
        }
        return tMap;
    }
    
    /**
     * Transformation d'un Tile[][] en ImageIcon[][], en redimensionnant les images pour une certaine taille
     * @param Tiles Tile[][] transformé
     * @param size Nombre de pixels de côté des ImageIcons
     * @return ImageIcon[][] créé à partir de Tiles
     */
    public static ImageIcon[][] tilesToScaledIcons(Tile[][] Tiles, int size) {
        ImageIcon[][] iconMap = new ImageIcon[Tiles.length][Tiles[0].length];       //Définit les dimensions de la nouvelle table à partir des dimensions de la table d'Integer
        for (int i = 0; i < Tiles.length; i++) {
            for (int j = 0; j < Tiles[0].length; j++) {
                iconMap[i][j] = Tiles[i][j].getScaledIcon(size);       //Définit la Tile à chaque case avec le constructeur, en la redimensionnant
            }
        }
        return iconMap;
    }
    
    /**
     * Transformation d'un Tile[][] en ImageIcon[][]
     * @param Tiles Tile[][] transformé
     * @return ImageIcon[][] créé à partir de Tiles
     */
    public static ImageIcon[][] tilesToIcons(Tile[][] Tiles) {
        ImageIcon[][] iconMap = new ImageIcon[Tiles.length][Tiles[0].length];       //Définit les dimensions de la nouvelle table à partir des dimensions de la table d'Integer
        for (int i = 0; i < Tiles.length; i++) {
            for (int j = 0; j < Tiles[0].length; j++) {
                iconMap[i][j] = Tiles[i][j].getIcon();       //Définit la Tile à chaque case avec le constructeur
            }
        }
        return iconMap;
    }
}
