/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */
package Game;

import java.awt.image.BufferedImage;

/**
 *
 * @author Isaac
 */
public class RunningGame {
    
    //Constructeurs
    
    public RunningGame() {
        
    }
    
    //TODO Peut-être qu'il faudra caler tout ça dans un Tool? Le MapTranslator peut-être?
    public RunningGame(Integer[][] map) {
        currentMap = new Tile[map.length][map[0].length];       //Définit les dimensions de la nouvelle table à partir des dimensions de la table d'Integer
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                currentMap[i][j] = new Tile(map[i][j],map.length,map[0].length);        //Définit la Tile à chaque case avec le constructeur
                currentMap[i][j].setIcon(currentMap[i][j].getType());       //Définit l'icône de cette Tile grâce à son type. TODO on peut pas faire ça automatiquement?
            }
        }
    }
    
    //Méthodes
        //Input
    
    public void goLeft() {
        //TODO flèche gauche
    }
    
    public void goRight() {
        //TODO flèche droite
    }
    
    public void goUp() {
        //TODO flèche haut
    }
    
    public void goDown() {
        //TODO flèche bas
    }
    
        //Output
    
    public int getScore() {
        return score;
    }
    
    public Tile[][] getRawMap() {
        return currentMap;
    }
    
    public void getIconMap() {   //remplacer "void" par "BufferedImage[][]" TODO renvoyer la carte sous forme d'images. Faisable dans Tools?
   
    }
    
    public void getIntMap() {   //remplacer "void" par "Integer[][]" TODO renvoyer la carte sous forme d'Integers. Faisable dans Tools?
        
    }
    
    public void getViewRadius() {   //Contiendra une table de 5x5 qui représentera la "vue" du Token. Sera utilisée notamment par le RNV.
        
    }
    
    //Variables
    
    Tile[][] currentMap;
    int score;
}
