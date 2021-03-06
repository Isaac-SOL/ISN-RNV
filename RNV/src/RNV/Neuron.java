/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */

package RNV;

import java.io.Serializable;

/**
 *
 * @author Isaac
 */

public class Neuron implements Serializable{
    
    //Constructeurs
    
    public Neuron() {
        
    }
    
    public Neuron(int id, int[] dest, boolean inhib) {
        synOut = dest;
        synIn = null;
        this.id = id;
        isSensor = false;
        inhibitor = inhib;
    }
    
    public Neuron(int id, int source, int type, int[] dest, boolean inhib) {
        synIn = source;
        synOut = dest;
        this.id = id;
        type = activatedByType;
        isSensor = true;
        inhibitor = inhib;
    }
    
    //Méthodes
    
    /**
     * Crée une nouvelle synapse, pointant vers un neurone à activer.
     * @param dest Identifiant du neurone à activer
     */
    public void newSynapse(int dest) {
        int[] newSynOut = new int[synOut.length + 1];
        System.arraycopy(synOut, 0, newSynOut, 0, synOut.length);       //Copie le contenu de synOut vers newSynOut
        newSynOut[synOut.length] = dest;
        synOut = newSynOut;
    }
    
    /**
     * Supprimme une synapse.
     * @param rm Identifiant du neurone qui ne sera plus activé
     */
    public void removeSynapse(int rm) {
        if (synOut.length > 0) {
            int[] newSynOut = new int[synOut.length - 1];
            
//Code abandonné
//            int rmIndex = 0;
//            
//            for (int i = 0; i < synOut.length; i++) {
//                if (synOut[i] == rm) {
//                    rmIndex = i;
//                    break;
//                }
//            }
//            
//            System.arraycopy(synOut, 0, newSynOut, 0, rmIndex);
//            System.arraycopy(synOut, rmIndex + 2, newSynOut, rmIndex + 1, newSynOut.length - (rmIndex+1));
            
            int i;
            for (i = 0; i < newSynOut.length; i++) {
                if (synOut[i] != rm) {
                    newSynOut[i] = synOut[i];
                } else { break; }
            }
            if (i != synOut.length-1) {
                for (i++; i < synOut.length; i++) {
                    newSynOut[i-1] = synOut[i];
                }
            }
            synOut = newSynOut;
            
        }
    }
    
    /**
     * Liste les neurones activés par ce neurone.
     * @return Liste des identifiants des neurones activés par ce neurone
     */
    public int[] getSynapses() {
        return synOut;
    }
    
    public Neuron getWithoutId() {
        Neuron neuron = new Neuron();
        neuron = this;
        neuron.id = -1;
        return neuron;
    }
    
    public boolean isInhibitor() {
        return inhibitor;
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

    public int getSynNumber() {
        return synOut.length;
    }
    
    public int getActivatorTile() {
        return synIn;
    }
    
    public boolean equalsTo(Neuron neuron) {
        return (this.synOut == neuron.synOut)
                && (this.synIn == neuron.synIn)
                && (this.isSensor == neuron.isSensor)
                && (this.inhibitor == neuron.inhibitor)
                && (this.activatedByType == neuron.activatedByType);
    }
    //Variables
    
    int[] synOut;
    Integer synIn;
    int id;
    boolean isSensor;
    boolean inhibitor;
    int activatedByType;
    
}
