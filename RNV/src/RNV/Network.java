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

public class Network implements Serializable{
    
    //Constructeurs
    
    public Network() {
        network = new Neuron[0];
        randomizeNextId();
    }
    
    public Network(String n) {
        name = n;
        randomizeNextId(); 
    }
    
    public Network(Neuron[] net) {
        network = net;
        randomizeNextId(); 
    }
    
    public Network(String n, Neuron[] net, int s) {
        name = n;
        network = net;
        score  = s;
        randomizeNextId(); 
    }
    
    //Méthodes
    
    /**
     * Crée un nouveau neurone qui est activé par la Tile spécifiée.
     * @param inputId Numéro de la case à laquelle le neurone réagit
     * @param type Type, en int, de la case lorsqu'elle active le neurone
     * @param dest Liste des ids des neurones activés par le nouveau neurone
     * @param inhib Liste des ids des neurones que ce neurone désactivera de force
     * @return L'ID du nouveau neurone
     */ 
    public void newNeuronFromTile(int inputId, int type, int[] dest, boolean inhib) {
        Neuron[] newNetwork = new Neuron[network.length + 1];
        System.arraycopy(network, 0, newNetwork, 0, network.length);
        newNetwork[network.length] = new Neuron(nextId, inputId, type, dest, inhib);
        randomizeNextId();
        network = newNetwork;
    }
    
    /**
     * Crée un nouveau neurone qui est activé par un neurone existant.
     * @param sourceId Identifiant du neurone activant le nouveau neurone
     * @param dest Liste des ids des neurones activés par le nouveau neurone
     * @param inhib Liste des ids des neurones que ce neurone désactivera de force
     * @return L'ID du nouveau neurone
     */
    public void newNeuronFromNeuron(Integer sourceId, int[] dest, boolean inhib) {
        Neuron[] newNetwork = new Neuron[network.length + 1];
        System.arraycopy(network, 0, newNetwork, 0, network.length);
        newNetwork[network.length] = new Neuron(nextId, dest, inhib);
        if (sourceId != null) {
            newNetwork[getNeuronIndexFromId(sourceId)].newSynapse(nextId);
        }
        randomizeNextId();
        network = newNetwork;
    }
    
    /**
     * Rajoute un neurone préexistant avec un id correspondant au réseau
     * @param neuron Neurone à rajouter
     */
    public void addNeuronWithNewId(Neuron neuron) {
        Neuron[] newNetwork = new Neuron[network.length + 1];
        System.arraycopy(network, 0, newNetwork, 0, network.length);
        neuron.id = nextId;
        newNetwork[network.length] = neuron;
        randomizeNextId();
        network = newNetwork;
    }
    
    /**
     * Supprime un neurone du réseau. TODO /!\ Pas testé
     * @param id Identifiant du neurone à supprimer
     */
    public void deleteNeuron(int id) {
        Neuron[] newNetwork = new Neuron[network.length - 1];
        
//        int index = getNeuronIndexFromId(id);
//      
//Code abandonné
//        System.arraycopy(network, 0, newNetwork, 0, index);
//        System.arraycopy(network, index + 2, newNetwork, index + 1, newNetwork.length - (index+1));
        
        int i;
        //On supprimme le neurone cherché
        for (i = 0; i < network.length; i++) {
            if (network[i].id != id) {
                newNetwork[i] = network[i];
            } else { break; }
        }
        if (i != network.length) {
            for (i++; i < network.length; i++) {
                newNetwork[i-1] = network[i];
            }
        }
        //On supprime les synapses liées
        for (i = 0; i < newNetwork.length; i++) {
            newNetwork[i].removeSynapse(id);
        }
        
        network = newNetwork;
       
        System.out.println("Neurone supprimé à l'ID " + id);
    }
    
    /**
     * Crée une nouvelle synapse entre deux neurones.
     * @param sourceId Identifiant du neurone activateur
     * @param destId Identifiant du neurone activé
     */
    public void newSynapse(int sourceId, int destId) {
        network[getNeuronIndexFromId(sourceId)].newSynapse(destId);
    }
    
    /**
     * Fixe un score à ce réseau.
     * @param s Score à fixer
     */
    public void setScore(int s) {
        score = s;
    }
    
    public void setNewId(int index, int newId) {
	//Garde l'ancien ID en mémoire, puis le remplace par le nouveau
	int oldId = network[index].id;
	network[index].id = newId;
	
	//Va modifier toutes les synapses pointant vers l'ancien ID
	for (int i = 0; i < network.length; i++) {
            for (int j = 0; j < network[i].getSynapses().length; j++) {
                if (network[i].getSynapses()[j] == oldId) {
                    network[i].removeSynapse(oldId);
                    network[i].newSynapse(newId);
		}
            }
	}		
    }
    
    private void randomizeNextId() {
        boolean alreadyTakenId;
        nextId = 5;
        do {
            alreadyTakenId = false;
            for (Neuron n : network) {
                if (n.id == nextId) {
                    alreadyTakenId = true;
                }
            }
            if (alreadyTakenId) {
                nextId = (int) (Math.random()*2000000000 + 5);
            }
        } while(alreadyTakenId);
    }
    
    /**
     * Récupère les données du neurone selon son identifiant dans le réseau.
     * @param id Identifiant du neurone à trouver
     * @return Les données du neurone trouvé
     */
    public Neuron getNeuron(int id) {
        return network[getNeuronIndexFromId(id)];
    }
    
    /**
     * Rècupère l'index d'un neurone dans la liste de neurones, selon son identifiant dans le réseau.
     * @param id Identifiant du neurone à trouver
     * @return L'index du neurone trouvé dans la liste de neurones
     */
    public int getNeuronIndexFromId(int id) {
        int index = 0;
        for (int i = 0; i < network.length; i++) {
            if (network[i].id == id) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    /**
     * Renvoie la liste des identifiants des neurones contenus dans le réseau.
     * @return Indentifiants des neurones contenus dans le réseau
     */
    public int[] getIdList() {
        int[] idList = new int[network.length];
        for(int i = 0; i < idList.length; i++) {
            idList[i] = network[i].id;
        }
        return idList;
    }
    
    /**
     * Renvoie la liste des neurones activés par une certaine Tile
     * @param tileId Identifiant de la Tile activatrice
     * @param type Type de la tile, en int
     * @return Liste des neurones activés par tileId.
     */
    public int[] getNeuronsActivatedBy(int tileId, int type) {
        int[] idList = new int[0];
        
        for (int i = 0; i < network.length; i++) {      //On regarde chaque neurone de network
            if (network[i].isSensor && network[i].synIn == tileId && network[i].activatedByType == type) {      //On vérifie que le neurone soit activé par cette case
                int[] newIdList = new int[idList.length + 1];
                System.arraycopy(idList, 0, newIdList, 0, idList.length);
                newIdList[idList.length] = network[i].id;        //Rajoute le nouvel identifiant
                idList = newIdList;
            }
        }
        
        return idList;
    }
    
    public int getScore() {
        return score;
    }
    
    public String getName() {
        return name;
    }
    
    public Neuron[] getNetwork() {
        return network;
    }
    
    //Variables
    
    private Neuron[] network;
    private int score;
    private String name;
    private int nextId;     //Utilisé pour définir l'ID assigné au prochain neurone créé
    
}
