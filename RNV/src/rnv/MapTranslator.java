/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rnv;

/**
 *
 * @author ubuntu
 */
public class MapTranslator {

        //Transformation du String en Tableau
    public static int[][] textToTable(String sMap) {

       int lines = Integer.parseInt(sMap.substring(0,1));
       int columns = Integer.parseInt(sMap.substring(2,3));
       String tiles = sMap.substring(4);

       int[][] tMap = new int[lines][columns];      //Création du tableau avec lignes et colonnes

        for(int j = 0; j <= columns - 1; j++) {
            for(int i = 0; i <= lines - 1; i++) {
                tMap[i][j] = tiles.charAt((j*lines)+1);        //Remplit le tableau avec les valeurs du string
                System.out.println("Ligne " + lines + ", colonne " + columns + ": " + tMap[i][j]);
            }
        }

        return tMap;
    }

        //Transformation du tableau en string
    public static String tableToText(int[][] tMap) {

        // <editor-fold defaultstate="collapsed" desc="4 premiers nombres du string">
        int lines = tMap.length;
        String sLines;
        if (lines < 10) {
            sLines = "0" + lines;
        } else {
            sLines = "" + lines;
        }

        int columns = tMap[0].length;
        String sColumns;
        if (columns < 10) {
            sColumns = "0" + columns;
        } else {
            sColumns = "" + columns;
        }

        String sMap = sLines + sColumns;// </editor-fold>

        return sMap;
    }
}
