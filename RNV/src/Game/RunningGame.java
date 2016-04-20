/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */

package Game;

import static Tools.MapTranslator.intToTiles; //TODO rendre ces imports plus propres, je sais plus comment on fait
import static Tools.MapTranslator.tilesToIcons;
import static Tools.MapTranslator.tilesToInt;
import javax.swing.ImageIcon;

/**
 *
 * @author Isaac
 */

public class RunningGame {
    
    //Constructeurs
    
    public RunningGame() {
        
    }
    
    public RunningGame(Integer[][] map) {
        currentMap = intToTiles(map);
        intStartingMap = map;
        System.out.println("Token en [" + (getTokenXPos()+1) + ";" + (getTokenYPos()+1) + "]");
    }
    
    public RunningGame(Tile[][] map) {
        currentMap = map;
        intStartingMap = tilesToInt(map);
        System.out.println("Token en [" + (getTokenXPos()+1) + ";" + (getTokenYPos()+1) + "]");
    }
    
    //Méthodes
        //Input
    
    //Les méthodes utilisées ici sont limitées au besoin du projet. On pourrait faire un truc plus complexe mais plus simple à étendre.
    public void goLeft() {
        int txpos = getTokenXPos();
        int typos = getTokenYPos();
        if (!"Obstacle".equals(getViewRadius(1)[1][0].type)) {
            currentMap[txpos][typos].setType("Empty");
            currentMap[txpos][typos - 1].setType("Token");
        }
        update();
    }
    
    public void goRight() {
        int txpos = getTokenXPos();
        int typos = getTokenYPos();
        if (!"Obstacle".equals(getViewRadius(1)[1][2].type)) {
            currentMap[txpos][typos].setType("Empty");
            currentMap[txpos][typos + 1].setType("Token");
        }
        update();
    }
    
    public void goUp() {
        int txpos = getTokenXPos();
        int typos = getTokenYPos();
        if (!"Obstacle".equals(getViewRadius(1)[0][1].type)) {
            currentMap[txpos][typos].setType("Empty");
            currentMap[txpos - 1][typos].setType("Token");
        }
        update();
    }
    
    public void goDown() {
        int txpos = getTokenXPos();
        int typos = getTokenYPos();
        if (!"Obstacle".equals(getViewRadius(1)[2][1].type)) {
            currentMap[txpos][typos].setType("Empty");
            currentMap[txpos + 1][typos].setType("Token");
        }
        update();
    }
    
    //Reset la map, et renvoie la map après reset TODO Rendre ce commentaire propre (Dironiil)
    public Tile[][] reset() {
        currentMap = intToTiles(intStartingMap);
        score = getTokenYPos();
        update();
        return currentMap;
    }
    
    //A chaque modif du RunningGame, fait cette mise à jour. TODO Rendre ce commentaire propre (Dironiil)
    private void update() {
        System.out.println("Token en [" + (getTokenXPos()+1) + ";" + (getTokenYPos()+1) + "]");
        if (getTokenYPos() > score) { score = getTokenYPos(); }
    }
    
        //Output
    
    public int getScore() {
        return score;
    }
    
    public Tile[][] getRawMap() {
        return currentMap;
    }
    
    public ImageIcon[][] getIconMap() {
        return tilesToIcons(currentMap);
    }
    
    public Integer[][] getIntMap() {
        return tilesToInt(currentMap);
    }
    
    //Choper la coordonnée X du Token. TODO Rajouter des exceptions, rendre ce commentaire propre (Dironiil)
    public int getTokenXPos() {
        int txpos = 0;
        for (int i = 0; i < currentMap.length; i++) {
            for (int j = 0; j < currentMap[0].length; j++) {
                if ("Token".equals(currentMap[i][j].type)) {
                    txpos = i;
                }
            }
        }
        return txpos;
    }
    
    //Choper la coordonnée Y du Token. TODO Rajouter des exceptions, rendre ce commentaire propre (Dironiil)
    public int getTokenYPos() {
        int typos = 0;
        for (int i = 0; i < currentMap.length; i++) {
            for (int j = 0; j < currentMap[0].length; j++) {
                if ("Token".equals(currentMap[i][j].type)) {
                    typos = j;
                }
            }
        }
        return typos;
    }
    
    //Contiendra une table qui représentera la "vue" du Token, dans un certain rayon. Sera utilisée notamment par le RNV. TODO Rendre ce commentaire propre (Dironiil)
    public Tile[][] getViewRadius(int r) {
        Tile[][] viewRadius = new Tile[2*r + 1][2*r + 1];       //Fixe la taille de la table de vision selon le rayon choisi
        for (int i = 0; i <= 2*r; i++) {
            for (int j = 0; j <= 2*r; j++) {
                int viewXPos = getTokenXPos()+i-r;
                int viewYPos = getTokenYPos()+j-r;
                if (viewXPos >= 0 && viewXPos < currentMap.length && viewYPos >= 0 && viewYPos < currentMap[0].length) {      //Vérifie que les coordonnées soient bien dans la table
                    viewRadius[i][j] = currentMap[viewXPos][viewYPos];      //Si elles sont dedans, copie la Tile aux coordonées correspondantes
                } else {
                    viewRadius[i][j] = new Tile("Obstacle");        //Sinon, remplace le vide par un obstacle
                }
            }
        }
        return viewRadius;
    }
    
    //Variables
    
    Tile[][] currentMap;
    Integer[][] intStartingMap;
    int score = 0;
}
