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
public class MapException extends Exception{
    
    /**
     * Procédure de base en cas d'exception dans le format de la map
     */
    public MapException() {
        System.out.println("Exception non spécifiée sur le format de la map.");
    }
    
    
    /**
     * Procédure surchargée avec gestion plus précise des messages d'erreurs
     * 1x : erreur String -> Integer[][]
     * 2x : erreur Integer[][] -> String
     * @param erreur Int envoyé en fonction de l'erreur obtenue
     */
    public MapException(int erreur) {
        switch (erreur) {
            case 11 : System.out.println("String invalide à la conversion en Integer[][] : caractères de taille du tableau non numériques.");
                    break; //Le String présente des caractères non numériques sur ses quatre premier caractères
            case 12 : System.out.println("String invalide à la conversion en Integer[][] : nombre incorrect de tiles.");
                    break; //Le String ne présente pas le bon nombre de tiles par rapport à la taille annoncée
            case 13 : System.out.println("String invalide à la conversion en Integer[][] : caractère de tile non numérique");
                    break; //Le String présente des caractères non numériques en contenu de tile
            case 21 : System.out.println("Integer[][] invalide à la conversion en String : nombre négatif / avec plus de deux chiffres");
                    break; //Le tableau d'Integer[][] présente des nombres qui ne sont pas transmissibles en un caractère
            default : System.out.println("Exception non identifiée sur le format de la map.");
                    break;
        }
    }
    
    /**
     * Message personnalisée d'erreur d'exception
     * @param erreur 
     */
    public MapException(String erreur) {
        System.out.println(erreur);
    }
}
