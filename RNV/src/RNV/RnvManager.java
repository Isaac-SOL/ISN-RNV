/*
 * Projet de fin d'ann�e d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */
package RNV;

/**
 *
 * @author Guillaume
 */
public class RnvManager {
    
    //Constructeurs avec et sans réseau de base
    
    public RnvManager(Integer[][] map) { 
        
        netArray = new Network[10][15];
        for (int i = 0; i < netArray.length; i++) {
            for (int j = 0; j < netArray[0].length; j++) {
                netArray[i][j] = RnvGenerator.create();
            }
        }       
    }
    
    public RnvManager(Network network, Integer[][] mapUsed) { 
        
        netArray = new Network[10][15];
        for (int i = 0; i < netArray.length; i++) {
            for (int j = 0; j < netArray[0].length; j++) {
                netArray[i][j] = RnvGenerator.mutate(network);
            }
        }  
        
        map = mapUsed;
    }
 
    
    //Méthodes d'utilisation
    
    public void launch() {
        
        int scoreMax = map[0].length;
        int scoreMaxRnv = 0;
        
        while (scoreMaxRnv < scoreMax) {
            
            int[] scoreMaxFamily = new int[map.length];
            int[] bestNetworkFamily= new int[netArray[0].length];
            
            for (int i = 0; i < netArray.length; i++) {
                
                scoreMaxFamily[i] = 0;
                bestNetworkFamily[i] = 0;
                
                for (int j = 0; j < netArray[0].length; j++) {
                    netArray[i][j].play(map);

                    if (netArray[i][j].getScore() > scoreMaxFamily[i]) {
                        scoreMaxFamily[i] = netArray[i][j].getScore();
                        bestNetworkFamily[i] = j;
                    }
                    if (scoreMaxFamily[i] > scoreMaxRnv) {
                        scoreMaxRnv = scoreMaxFamily[i];
                    }
                }
            }
            
            Network[][] newNetArray = new Network[10][15];
            
            for (int i = 0; i < newNetArray.length; i++) {
                for (int j = 0; j < newNetArray[0].length; j++) {
                    newNetArray[i][j] = RnvGenerator.mutate(RnvGenerator.assemble(netArray[i][bestNetworkFamily[i]], netArray[9-i][bestNetworkFamily[9-i]]));
                }
            }
            
            System.arraycopy(newNetArray, 0, netArray, 0, newNetArray.length);
        }
    }

    
    //Variables de classe
    
    private Network[][] netArray;
    private Integer[][] map;
    
}
