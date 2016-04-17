/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Exceptions.*;
import Game.Tile;
import java.awt.image.BufferedImage;

/**
 *
 * @author Dironiil
 */


public class MapTranslator {   
    
    /**
     * Transformation d'un String en Integer[][]
     * @param sMap            String à convertir en Integer[][]
     * @throws MapException   Exception si le format du string est incorrect
     * @return Integer[][] si la conversion a été correcte
     */    
    public static Integer[][] textToTable(String sMap) throws MapException{
        
        // <editor-fold defaultstate="collapsed" desc="Récupération de nbColumns et nbLines + gestion des erreurs de format">
        int nbColumns, nbLines;
        String tiles = sMap.substring(4);
        
        try { //Bloc try / catch pour éviter les erreurs de conversion de parseInt
            nbColumns = Integer.parseInt(sMap.substring(0,2));
            nbLines = Integer.parseInt(sMap.substring(2,4));
        } catch (NumberFormatException e) {
            throw new MapException(11);
        }
        
        if (tiles.length() != nbColumns*nbLines) { //Vérification qu'il y a le bon nombre de contenu de tiles
            throw new MapException(12);
        }
        // </editor-fold>
       
        Integer[][] tMap = new Integer[nbLines][nbColumns];      //Création du tableau avec lignes et colonnes (inversé pour la lecture par JTable)

        //<editor-fold defaultstate="collapsed" desc="Remplissage du tableau">
        for(int j = 0; j < nbLines; j++) {
            for(int i = 0; i < nbColumns; i++) {
                int tile;               
                tile = Character.getNumericValue(tiles.charAt((j*nbColumns)+i));
                if (tile < 0 || tile > 9) { //Vérification que le charactère est un chiffre
                    throw new MapException(13);
                } else {
                    tMap[j][i] = tile;           //Remplit le tableau avec les valeurs du string
                    System.out.println("Case [" + (j+1) + ";" + (i+1) + "] : " + tMap[j][i]); //Affichage dans la console du résultat pour le debug }
                }
            }
        }
//</editor-fold>

        return tMap;
    }

    
    /**
     * Transformation d'un Integer[][] en String
     * @param tMap              Integer[][] à convertir en String
     * @throws MapException     Exception si le format du tableau est incorrect
     * @return sMap             String renvoyé si la conversion est correcte
     */  
    public static String tableToText(Integer[][] tMap) throws MapException {

        // <editor-fold defaultstate="collapsed" desc="4 premiers nombres du string">      
        int nbColumns = tMap.length;
        String sColumns;
        if (nbColumns < 10) {
            sColumns = "0" + nbColumns;
        } else {
            sColumns = "" + nbColumns;
        }

        int nbLines = tMap[0].length;
        String sLines;
        if (nbLines < 10) {
            sLines = "0" + nbLines;
        } else {
            sLines = "" + nbLines;
        }

        String sMap = sColumns + sLines;// </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Conversion du contenu des cases en String">
        String sTilesContent = "";
        for (int j = 0; j < tMap[0].length; j++) {
            for (int i = 0; i < tMap.length; i++) {
                if (tMap[i][j] < 0 || tMap[i][j] > 9) { //Vérification que la tile ne contient qu'un chiffre
                    throw new MapException(21);
                } else {
                    sTilesContent += tMap[i][j] + "";
                    System.out.println("Case [" + (i+1) + ";" + (j+1) + "] : " + tMap[i][j] + " écrite dans le String.");
                }
            }
        }
        
        sMap += sTilesContent;
        System.out.println("String écrit : " + sMap);
        //</editor-fold>
        
        return sMap;
    }
    
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
    public static BufferedImage[][] tilesToIcons(Tile[][] Tiles) {
        BufferedImage[][] iconMap = new BufferedImage[Tiles.length][Tiles[0].length];       //Définit les dimensions de la nouvelle table à partir des dimensions de la table d'Integer
        for (int i = 0; i < Tiles.length; i++) {
            for (int j = 0; j < Tiles[0].length; j++) {
                iconMap[i][j] = Tiles[i][j].getIcon();       //Définit la Tile à chaque case avec le constructeur
            }
        }
        return iconMap;
    }
}
