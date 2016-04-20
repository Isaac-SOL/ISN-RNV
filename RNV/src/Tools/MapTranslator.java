/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Game.Tile;
import javax.swing.ImageIcon;

/**
 *
 * @author Dironiil
 */


public class MapTranslator {   
    
    //Transformation d'un Integer[][] en Tile[][] TODO Rajouter des exceptions, rendre ce commentaire propre (Dironiil)
    public static Tile[][] intToTiles(Integer[][] tMap) {
        Tile[][] Tiles = new Tile[tMap.length][tMap[0].length];       //Définit les dimensions de la nouvelle table à partir des dimensions de la table d'Integer
        for (int i = 0; i < tMap.length; i++) {
            for (int j = 0; j < tMap[0].length; j++) {
                Tiles[i][j] = new Tile(tMap[i][j],i,j);        //Définit la Tile à chaque case avec le constructeur
            }
        }
        return Tiles;
    }
    
    //Transformation d'un Tile[][] en Integer[][] TODO Rajouter des exceptions, rendre ce commentaire propre (Dironiil)
    public static Integer[][] tilesToInt(Tile[][] Tiles) {
        Integer[][] tMap = new Integer[Tiles.length][Tiles[0].length];       //Définit les dimensions de la nouvelle table à partir des dimensions de la table d'Integer
        for (int i = 0; i < Tiles.length; i++) {
            for (int j = 0; j < Tiles[0].length; j++) {
                tMap[i][j] = Tiles[i][j].getIntType();       //Définit la Tile à chaque case avec le constructeur
            }
        }
        return tMap;
    }
    
    //Transformation d'un Tile[][] en BufferedImage[][] pour l'interface TODO Rajouter des exceptions, rendre ce commentaire propre (Dironiil)
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
