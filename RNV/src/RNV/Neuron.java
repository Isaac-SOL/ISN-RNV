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
        isSensor = false;
    }
    
    public Neuron(int id, int source, int type, int[] dest) {
        synIn = source;
        synOut = dest;
        this.id = id;
        type = activatedByType;
        isSensor = true;
    }
    
    //Méthodes
    
    /**
     * Crée une nouvelle synapse, pointant vers un nouveau neurone à activer.
     * @param dest Identifiant du neurone à activer
     */
        
    public void newSynapse(int dest) {
        int[] newSynOut = new int[synOut.length + 1];
        System.arraycopy(synOut, 0, newSynOut, 0, synOut.length);       //Copie le contenu de synOut vers newSynOut
        newSynOut[synOut.length + 1] = dest;
        synOut = newSynOut;
    }
    
    /**
     * Supprimme une synapse.
     * @param rm Identifiant du neurone qui ne sera plus activé
     */
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
    
    /**
     * Active de force le neurone.
     * @return Liste des identifiants des neurones activés par ce neurone
     */
    public int[] activate() {
        return synOut;
    }
    
    /**
     * Fait réagir le neurone à un type d'input. Ne fonctionnera que si le neurone est senseur.
     * @param type Type auquel on tente de faire réagir le neurone
     * @return Liste des identifiants des neurones activés par ce neurone, dans ces conditions
     */
    public int[] activateFromType(int type) {
        int[] output = null;
        if (isSensor && type == activatedByType) {
            output = synOut;
        }
        return output;
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
    boolean isSensor;
    int activatedByType;
    
}