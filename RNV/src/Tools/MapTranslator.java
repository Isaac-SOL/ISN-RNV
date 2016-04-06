/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Exceptions.*;

/**
 *
 * @author Dironiil
 */


public class MapTranslator {   
    
    /**
     * Transformation d'un String en Integer[][]
     * @param sMap                  String à convertir en Integer[][]
     * @throws MapFormatException   Exception si le format du string est incorrect
     * @return tMap                 Integer[][] renvoyé si la conversion a été correct
     */    
    public static Integer[][] textToTable(String sMap) throws MapFormatException{
        
        // <editor-fold defaultstate="collapsed" desc="Récupération de nbColumns et nbLines + gestion des erreurs de format">
        int nbColumns, nbLines;
        String tiles = sMap.substring(4);
        
        try { //Bloc try / catch pour éviter les erreurs de conversion de parseInt
            nbColumns = Integer.parseInt(sMap.substring(0,2));
            nbLines = Integer.parseInt(sMap.substring(2,4));
        } catch (NumberFormatException e) {
            throw new MapFormatException(1);
        }
        
        if (tiles.length() != nbColumns*nbLines) { //Vérification qu'il y a le bon nombre de contenu de tiles
            throw new MapFormatException(2);
        }
        // </editor-fold>
       
        Integer[][] tMap = new Integer[nbColumns][nbLines];      //Création du tableau avec lignes et colonnes

        //<editor-fold defaultstate="collapsed" desc="Remplissage du tableau">
        for(int j = 0; j < nbLines; j++) {
            for(int i = 0; i < nbColumns; i++) {
                int tile = Character.getNumericValue(tiles.charAt((j*nbColumns)+i));
                if (tile < 0 || tile > 9) { //Vérification que le charactère est un chiffre
                    throw new MapFormatException(3);
                } else {
                    tMap[i][j] = tile;           //Remplit le tableau avec les valeurs du string
                    System.out.println("Case [" + (i+1) + ";" + (j+1) + "] : " + tMap[i][j]); //Affichage dans la console du résultat pour le debug
                }
            }
        }
//</editor-fold>

        return tMap;
    }

    
    /**
     * Transformation d'un Integer[][] en String
     * @param tMap                  Integer[][] à convertir en String
     * @throws MapFormatException   Exception si le format du tableau est incorrect
     * @return sMap                 String renvoyé si la conversion est correcte
     */  
    public static String tableToText(Integer[][] tMap) throws MapFormatException {

        // <editor-fold defaultstate="collapsed" desc="4 premiers nombres du string">
        int nbLines = tMap.length;
        String sLines;
        if (nbLines < 10) {
            sLines = "0" + nbLines;
        } else {
            sLines = "" + nbLines;
        }

        int nbColumns = tMap[0].length;
        String sColumns;
        if (nbColumns < 10) {
            sColumns = "0" + nbColumns;
        } else {
            sColumns = "" + nbColumns;
        }

        String sMap = sLines + sColumns;// </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Conversion du contenu des cases en String">
        String sTilesContent = "";
        for (int j = 0; j < tMap[0].length; j++) {
            for (int i = 0; i < tMap.length; i++) {
                if (tMap[i][j] < 0 || tMap[i][j] > 9) { //Vérification que la tile ne contient qu'un chiffre
                    throw new MapFormatException(4);
                } else {
                    sTilesContent += tMap[i][j] + "";
                    System.out.println("Case [" + (i+1) + ";" + (j+1) + "] : " + tMap[i][j] + " écrite dans le String.");
                }
            }
        }
        
        sMap += sTilesContent;
        //</editor-fold>

        return sMap;
    }
    
}
