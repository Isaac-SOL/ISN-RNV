/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */

package RNV;

/**
 *
 * @author Isaac
 */

public class Network {
    
    //Constructeurs
    
    public Network() {
        
    }
    
    public Network(String n) {
        name = n;
    }
    
    public Network(String n, Neuron[] net) {
        name = n;
        network = net;
    }
    
    public Network(String n, Neuron[] net, int s) {
        name = n;
        network = net;
        score  = s;
    }
    
    //Méthodes
    
    /**
     * Crée un nouveau neurone qui est activé par la Tile spécifiée.
     * @param inputId Numéro de la case à laquelle le neurone réagit
     * @param type Type, en int, de la case lorsqu'elle active le neurone
     * @param dest Liste des ids des neurones activés par le nouveau neurone
     */ 
    public void newNeuronFromTile(int inputId, int type, int[] dest) {
        Neuron[] newNetwork = new Neuron[network.length + 1];
        System.arraycopy(network, 0, newNetwork, 0, network.length);
        newNetwork[network.length] = new Neuron(nextId, inputId, type, dest);
        nextId++;
        network = newNetwork;
    }
    
    /**
     * Crée un nouveau neurone qui est activé par un neurone existant.
     * @param sourceId Identifiant du neurone activant le nouveau neurone
     * @param dest Liste des ids des neurones activés par le nouveau neurone
     */
    public void newNeuronFormNeuron(int sourceId, int[] dest) {
        Neuron[] newNetwork = new Neuron[network.length + 1];
        System.arraycopy(network, 0, newNetwork, 0, network.length);
        newNetwork[network.length] = new Neuron(nextId, dest);
        newNetwork[getNeuronIndexFromId(sourceId)].newSynapse(nextId);
        nextId++;
        network = newNetwork;
    }
    
    /**
     * Supprime un neurone du réseau. TODO /!\ Pas testé
     * @param id Identifiant du neurone à supprimer
     */
    public void deleteNeuron(int id) {
        Neuron[] newNetwork = new Neuron[network.length - 1];
        //TODO Sûrement simplifiable avec deux arraycopy()
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
        int i = 0;
        for(Neuron neuron : network) {
            idList[i] = neuron.id;
            i++;
        }
        return idList;
    }
    
    /**
     * Renvoie la liste des neurones activés par une certaine Tile
     * @param tileId Identifiant de la Tile activatrice
     * @return Liste des neurones activés par tileId.
     */
    public int[] getNeuronsActivatedBy(int tileId) { //TODO Je sais pas si c'est efficace, c'est une fonction appelée très souvent
        int[] idList = new int[0];
        
        for (Neuron n : network) {      //On regarde chaque neurone de network
            if (n.isSensor && n.synIn == tileId) {      //On vérifie que le neurone soit activé par cette case
                int[] newIdList = new int[idList.length + 1];
                System.arraycopy(idList, 0, newIdList, 0, idList.length);
                newIdList[idList.length] = n.id;        //Rajoute le nouvel identifiant
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
    
    Neuron[] network;
    int score;
    String name;
    int nextId = 5;     //Utilisé pour définir l'ID assigné au prochain neurone créé
    
}
