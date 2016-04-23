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
    
    //TODO il est 2h du mat, j'arrête. Je continue demain
    
    //Variables
    
    Neuron[] network;
    int score;
    String name;
    
}
