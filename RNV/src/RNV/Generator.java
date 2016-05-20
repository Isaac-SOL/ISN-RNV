/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RNV;

import java.util.HashSet;

/**
 *
 * @author Dironiil
 */
public class Generator {
    
    /**
     * Génére un réseau avec un neurone aléatoire (forcément un senseur vers un bouton)
     * @return Réseau généré
     */
    public static Network create() {
        Network network = new Network();

        int inputId;
        do {
            inputId = (int) (Math.random()*25);
        } while(inputId == 13);

        int type = (int) (Math.random()*2+1);
        int[] dest = {(int) (Math.random()*4)+1};

        network.newNeuronFromTile(inputId, type, dest, false);                     

        return network;
    }
    
    /**
     * Mute un réseau existant en ajoutant ou supprimant des neurones
     * @param firstNet Réseau à muter
     * @return Réseau muté
     */
    public static Network mutate(Network firstNet) {
        System.out.println("Mutate lancé.");
        int[] idList = firstNet.getIdList();
        for (int i = 0; i < idList.length; i++) {
            System.out.println(idList[i]);
        }

        int choice = (int) (Math.random()*8);
        switch  (choice) {
            case 0 :
            case 1 : int indexId = (int) (Math.random()*idList.length);
                int id = idList[indexId];
                firstNet.deleteNeuron(id); break;
                
                
            case 2 : // permet d'avoir 3 chance sur 7 "ajoute un neurone senseur" 
            case 3 :
            case 4 :
                int inputIdTile; 
                do {
                     inputIdTile = (int) (Math.random()*25);
                 } while(inputIdTile == 13);
                
                int type = (int) (Math.random()*2+1);
                
                int[] destTile;
                int randomTile = (int) (Math.random()*firstNet.getNetwork().length+4);
                if (randomTile < firstNet.getNetwork().length) {
                    destTile = new int[] {idList[randomTile]}; //Attribution à un autre neurone
                } else destTile = new int[] {randomTile - firstNet.getNetwork().length}; //Attribution à un bouton
                
                if (choice == 3) firstNet.newNeuronFromTile(inputIdTile, type, destTile, true); // créer un nouveau neurone avec des caractéristiques tirées au hasard et le rajoute dans firstNet
                else firstNet.newNeuronFromTile(inputIdTile, type, destTile, false);
                
                break;
                
                
            case 5 :// permet d'avoir 3 chance sur 7 "ajoute un neurone non-senseur" 
            case 6 :
            case 7 :
                int inputIdNeuron = idList[(int) (Math.random()*firstNet.getNetwork().length)];
                int[] destNeuron;
                do {
                    int RandomNeuron = (int) (Math.random()*firstNet.getNetwork().length+4);
                    if (RandomNeuron < firstNet.getNetwork().length) {
                        destNeuron = new int[] {idList[RandomNeuron]};
                    } else destNeuron = new int[] {RandomNeuron - firstNet.getNetwork().length}; //Attribution à un bouton
                } while(destNeuron[0] == inputIdNeuron);
                
                if (choice == 6) firstNet.newNeuronFromNeuron(inputIdNeuron, destNeuron, true);
                else firstNet.newNeuronFromNeuron(inputIdNeuron, destNeuron, false);
                
                break;
        }   

        return firstNet;
    }
    
    /**
     * Fonction qui synthétise deux réseaux en un, en conservant tous les neurones.
     * @param net1 Premier réseau à combiner
     * @param net2 Deuxième réseau à combiner
     * @return Le réseau combiné
     */
    public static Network synthesis(Network net1, Network net2) {
	
        System.out.println("Synthesis lancé");        

        //<editor-fold defaultstate="collapsed" desc="Ancien code. Concervé au cas où. TODO Supprimer si ça marche">
        /*//Compte le nombre de neurone nécessaire dans le nouveau réseau pour éviter les doublons, précise lesquels doivent être ajoutés.
        boolean[] isAdded1 = new boolean[net1.getNetwork().length];
        for (int i = 0; i < isAdded1.length; i++) {
        isAdded1[i] = false;
        }
        boolean[] isAdded2 = new boolean[net2.getNetwork().length];
        for (int i = 0; i < isAdded2.length; i++) {
        isAdded2[i] = false;
        }
        
        //Well. Ce qui suit sert à ne voir comme "à ajouter" seulement les neurones qui n'ont pas déjà été vu.
        for (int i = 0; i < net1.getNetwork().length; i++) {
        boolean differentFromAll = true;
        for (int j = 0; j < net2.getNetwork().length; j++) {
        if (!(net1.getNetwork()[i].equalsTo(net2.getNetwork()[j])) && (i == 0)) {
        System.out.println("Synthesis : isAdded1[" + i + "] et isAdded2[" + j + "] sont vrais");
        isAdded1[i] = true;
        isAdded2[j] = true;
        } else if(net1.getNetwork()[i].equalsTo(net2.getNetwork()[j]) && i ==0) {
        System.out.println("Synthesis : isAdded1[" + i + "] est vrai isAdded2[" + j + "] est intouché");
        isAdded1[i] = true;
        } else if(net1.getNetwork()[i].equalsTo(net2.getNetwork()[j]) && i !=0) {
        differentFromAll = false;
        }
        }
        if (differentFromAll && i != 0) {
        System.out.println("Synthesis : isAdded1[" + i + "] est vrai isAdded2[] est intouché");
        isAdded1[i] = true;
        }
        }
        
        //Initialise le nouveau network
        Network combinedNetwork = new Network();
        
        int[][] synapses1 = new int[net1.getNetwork().length][];
        for (int i = 0; i < net1.getNetwork().length; i++) {
        for (int j = 0; j < net1.getNetwork()[i].getSynapses().length; j++) {
        synapses1[i] = net1.getNetwork()[i].getSynapses();
        }
        }
        int[][] synapses2;
        
        //Et rajoute tous les neurones qui ont été vu comme non doublon
        for (int i = 0; i < net1.getNetwork().length; i++) {
        if (isAdded1[i]) {
        if (net1.getNetwork()[i].isSensor) {
        combinedNetwork.newNeuronFromTile(net1.getNetwork()[i].synIn, net1.getNetwork()[i].activatedByType, null, net1.getNetwork()[i].inhibitor);
        }
        }
        }
        for (int i = 0; i < net2.getNetwork().length; i++) {
        if (isAdded2[i]) {
        combinedNetwork.addNeuronWithNewId(net2.getNetwork()[i]);
        }
        }
        
        return combinedNetwork;*/
//</editor-fold>
        
        //Change les ID s'ils existent déjà dans l'autre réseau
        for (int i = 0; i < net1.getNetwork().length; i++) {		
            boolean alreadyTakenId;				
            do {
		alreadyTakenId = false;
		for (int j = 0; j < net2.getNetwork().length; j++) {
                    if (net1.getNetwork()[i] == net2.getNetwork()[j]) {
                        alreadyTakenId = true;
                    }
		}
		for (int j = 0; j < net1.getNetwork().length; j++) {
                    if ((net1.getNetwork()[i] == net1.getNetwork()[j]) && (i != j)) {
			alreadyTakenId = true;
                    }
		}
		if (alreadyTakenId) {
                    net1.setNewId(i, (int)(Math.random()*2000000000+5));
		}
            }while (alreadyTakenId);
	}
        
        
        //Rajoute les neurones, sauf les doublons de neurones senseurs
        HashSet<Neuron> combinedNetworksSet = new HashSet<>();
        HashSet<Neuron> neuronsSensorWithoutId = new HashSet<>();
        
        for (Neuron n : net1.getNetwork()) {
            if (n.isSensor) {
                int id = n.id;
                n.id = -1;
                boolean added = neuronsSensorWithoutId.add(n.getWithoutId());
                n.id = id;
                if (added) {
                    combinedNetworksSet.add(n);
                }
            }else combinedNetworksSet.add(n);
        }
        for (Neuron n : net2.getNetwork()) {
            if (n.isSensor) {
                int id = n.id;
                n.id = -1;
                boolean added = neuronsSensorWithoutId.add(n.getWithoutId());
                n.id = id;
                if (added) {
                    combinedNetworksSet.add(n);
                }
            }else combinedNetworksSet.add(n);
        }
        
        Neuron[] combinedNetworks = combinedNetworksSet.toArray(new Neuron[combinedNetworksSet.size()]);
        
        Network combinedNetwork = new Network(combinedNetworks);
        
        return combinedNetwork;
                
    }

}
