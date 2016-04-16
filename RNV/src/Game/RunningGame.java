/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */
package Game;

/**
 *
 * @author Isaac
 */
public class RunningGame {
    
    //Constructeurs
    
    public RunningGame() {
        
    }
    
    public RunningGame(Integer[][] map) {
        currentMap = new Tile[map.length][map[0].length];       //Définit les dimensions de la nouvelle table à partir des dimensions de la table d'Integer
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                currentMap[i][j] = new Tile(map[i][j],map.length,map[0].length);        //Définit la Tile à chaque case avec le constructeur
                currentMap[i][j].setIcon(currentMap[i][j].getType());       //Définit l'icône de cette Tile grâce à son type. TODO on peut pas faire ça automatiquement?
            }
        }
    }
    
    //Variables
    
    Tile[][] currentMap;
    int score;
}
