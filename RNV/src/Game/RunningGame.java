/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */
package Game;

import static Tools.MapTranslator.intToTiles; //TODO rendre ces imports plus propres, je sais plus comment on fait
import static Tools.MapTranslator.tilesToIcons;
import static Tools.MapTranslator.tilesToInt;
import java.awt.image.BufferedImage;


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
    
    public BufferedImage[][] getIconMap() {
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
        int XPos = getTokenXPos();
        int YPos = getTokenYPos();
        for (int i = -r; i <= r; i++) {
            for (int j = -r; j <= r; j++) {
                if (i >= 0 && i <= currentMap.length && j >= 0 && j <= currentMap[0].length) {      //Vérifie que les coordonnées soient bien dans la table
                    viewRadius[i][j] = currentMap[XPos+i][YPos+j];      //Si elles sont dedans, copie la Tile aux coordonées correspondantes
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
