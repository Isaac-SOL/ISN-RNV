/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 * Classe d'exception : erreur dans le format de la Map
 * @author Dironiil
 */
public class MapFormatException extends Exception{
    public MapFormatException() {
        System.out.println("Format de map incorrect.");
    }
    
    public MapFormatException(int erreur) {
        switch (erreur) {
            case 1 : System.out.println("String invalide à la conversion en int[][] : caractères de taille du tableau non numériques.");
                    break;
            case 2 : System.out.println("String invalide à la conversion en Integer[][] : nombre incorrect de tiles.");
                    break;
            case 3 : System.out.println("String invalide à la conversion en Integer[][] : caractère de tile non numérique");
                    break;
            case 4 : System.out.println("Integer[][] invalide à la conversion en String : nombre négatif / avec plus de deux chiffres");
                    break;
            default : System.out.println("Erreur non identifiée sur le format de la map.");
                    break;
        }
    }
}
