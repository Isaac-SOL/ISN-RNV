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
    }
    
    //Méthodes
        //Input
    
    //Les méthodes utilisées ici sont limitées au besoin du projet. On pourrait faire un truc plus complexe mais plus simple à étendre.
    public void goLeft() {
        if (!"Obstacle".equals(currentMap[getTokenXPos()][getTokenYPos() - 1].type)) {
            currentMap[getTokenXPos()][getTokenYPos()].setType("Empty");
            currentMap[getTokenXPos()][getTokenYPos() - 1].setType("Token");
        }
    }
    
    public void goRight() {
        if (!"Obstacle".equals(currentMap[getTokenXPos()][getTokenYPos() + 1].type)) {
            currentMap[getTokenXPos()][getTokenYPos()].setType("Empty");
            currentMap[getTokenXPos()][getTokenYPos() + 1].setType("Token");
        }
    }
    
    public void goUp() {
        if (!"Obstacle".equals(currentMap[getTokenXPos() - 1][getTokenYPos()].type)) {
            currentMap[getTokenXPos()][getTokenYPos()].setType("Empty");
            currentMap[getTokenXPos() - 1][getTokenYPos()].setType("Token");
        }
    }
    
    public void goDown() {
        if (!"Obstacle".equals(currentMap[getTokenXPos() + 1][getTokenYPos()].type)) {
            currentMap[getTokenXPos()][getTokenYPos()].setType("Empty");
            currentMap[getTokenXPos() + 1][getTokenYPos()].setType("Token");
        }
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
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
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
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
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
        for (int i = -r; i <= r; i++) {
            for (int j = -r; j <= r; j++) {
                int viewXPos = getTokenXPos()+i;
                int viewYPos = getTokenYPos()+j;
                if (viewXPos >= 0 && viewXPos <= currentMap.length && viewYPos >= 0 && viewYPos <= currentMap[0].length) {      //Vérifie que les coordonnées soient bien dans la table
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
    int score;
}
