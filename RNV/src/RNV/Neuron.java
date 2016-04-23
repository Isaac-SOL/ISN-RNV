/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */

package RNV;

/**
 *
 * @author Isaac
 */

public class Neuron {
    
    //Constructeurs
    
    public Neuron() {
        
    }
    
    public Neuron(int id, int[] dest) {
        synOut = dest;
        this.id = id;
    }
    
    public Neuron(int id, int source, int[] dest) {
        synIn = source;
        synOut = dest;
        this.id = id;
    }
    
    //Méthodes
    
    public void newSynapse(int dest) {
        int[] newSynOut = new int[synOut.length + 1];
        System.arraycopy(synOut, 0, newSynOut, 0, synOut.length);       //Copie le contenu de synOut vers newSynOut
        newSynOut[synOut.length + 1] = dest;
        synOut = newSynOut;
    }
    
    public void removeSynapse(int rm) {
        int[] newSynOut = new int[synOut.length - 1];
        int i;
        for (i = 0; i < synOut.length; i++) {
            if (synOut[i] != rm) {
                newSynOut[i] = synOut[i];
            } else { break; }
        }
        if (i != synOut.length) {
            for (i++; i < synOut.length; i++) {
                newSynOut[i-1] = synOut[i];
            }
        }
        synOut = newSynOut;
    }
    
    public int[] getActivatedSons() {
        return synOut;
    }
    
    public int getSonNumber() {
        return synOut.length;
    }
    
    public int getActivatorTile() {
        return synIn;
    }
    
    //Variables
    
    int[] synOut;
    int synIn;
    int id;
    
}
