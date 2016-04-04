/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Guillaume
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sTest = "0305012340123401234";
        int columns = Integer.parseInt(sTest.substring(0,2));
        int lines = Integer.parseInt(sTest.substring(2,4));
        
        System.out.println ("nb l : " + lines + ", nb c : " + columns);
        System.out.println(sTest.substring(4));
        
        int[][] tTest;
        tTest = textToTable(sTest);
        
        sTest = "fatboy";
        
        sTest = tableToText(tTest);
        
        System.out.println(sTest);
        
        
    }
    
    
    //Transformation du String en Tableau
    public static int[][] textToTable(String sMap) {

       int nbColumns = Integer.parseInt(sMap.substring(0,2));
       int nbLines = Integer.parseInt(sMap.substring(2,4));
       String tiles = sMap.substring(4);

       int[][] tMap = new int[nbColumns][nbLines];      //Création du tableau avec lignes et colonnes

        for(int j = 0; j < nbLines; j++) {
            for(int i = 0; i < nbColumns; i++) {
                tMap[i][j] = Character.getNumericValue(tiles.charAt((j*nbColumns)+i));        //Remplit le tableau avec les valeurs du string
                System.out.println("Colonne " + (i+1) + ", ligne " + (j+1) + ": " + tMap[i][j]);
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
        
        // <editor-fold defaultstate="collapsed" desc="Conversion du contenu des cases en String">
        String sTilesContent = "";
        for (int j = 0; j < tMap[0].length; j++) {
            for (int i = 0; i < tMap.length; i++) {
                sTilesContent += tMap[i][j] + "";
            }
        }
        
        sMap += sTilesContent; //</editor-fold>

        return sMap;
    }
    
}
