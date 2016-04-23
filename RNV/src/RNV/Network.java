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
        newNetwork[getNeuronIndex(sourceId)].newSynapse(nextId);
        nextId++;
        network = newNetwork;
    }
    
    /**
     * Crée une nouvelle synapse entre deux neurones.
     * @param sourceId Identifiant du neurone activateur
     * @param destId Identifiant du neurone activé
     */
    public void newSynapse(int sourceId, int destId) {
        network[getNeuronIndex(sourceId)].newSynapse(destId);
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
        return network[getNeuronIndex(id)];
    }
    
    /**
     * Rècupère l'index d'un neurone dans la liste de neurones, selon son identifiant dans le réseau.
     * @param id Identifiant du neurone à trouver
     * @return L'index du neurone trouvé dans la liste de neurones
     */
    public int getNeuronIndex(int id) {
        int index = 0;
        for (int i = 0; i < network.length; i++) {
            if (network[i].id == id) {
                index = i;
                break;
            }
        }
        return index;
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
    int nextId = 1;     //Utilisé pour définir l'ID assigné au prochain neurone créé
    
}
