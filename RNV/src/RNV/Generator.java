/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RNV;

/**
 *
 * @author ubuntu
 */
public class Generator {
    
    /**
     * Génére un réseau avec deux neurones aléatoire
     * @return Réseau généré
     */
    public static Network create() {
        Network network = new Network();

        for (int i = 0; i < 2; i++) {
            int inputId;
            do {
                inputId = (int) (Math.random()*25);
            } while(inputId == 13);

            int type = (int) (Math.random()*2+1);
            int[] dest = {(int) (Math.random()*4)+1};

            network.newNeuronFromTile(inputId, type, dest);                     
        }

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
        int indexId = (int) (Math.random()*idList.length);
        int id = idList[indexId];

        int choice = (int) (Math.random()*3);
        switch  (choice){
            case 0 : firstNet.deleteNeuron(id); break;
            case 2 : // permet d'avoir 2 chance sur 3 "ajoute un neurone" 
            case 1 :
                int inputId; 
                do {
                     inputId = (int) (Math.random()*25);
                 } while(inputId == 13);
                
                int type = (int) (Math.random()*2+1);
                int[] dest = {(int) (Math.random()*4)};
                
                firstNet.newNeuronFromTile(inputId, type, dest); break ; // créer un nouveau neurone avec des caractéristiques tirées au hasard et le rajoute dans firstNet
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
        
	//Compte le nombre de neurone nécessaire dans le nouveau réseau pour éviter les doublons, précise lesquels doivent être ajoutés. TODO rajouter la méthode getNeuronWithoutId à la classe Neuron (Je peux le faire - Dironiil) 
	boolean[] isAdded1 = new boolean[net1.getNetwork().length];
	for (int i = 0; i < isAdded1.length; i++) {
            isAdded1[i] = false;
	}
	boolean[] isAdded2 = new boolean[net2.getNetwork().length];
	for (int i = 0; i < isAdded1.length; i++) {
            isAdded1[i] = false;
	}
		
	//Well. Ce qui suit sert à ne voir comme "à ajouter" seulement les neurones qui n'ont pas déjà été vu.
	for (int i = 0; i < net1.getNetwork().length; i++) {
            boolean differentFromAll = true;
            for (int j = 0; j < net2.getNetwork().length; j++) {
                if (net1.getNetwork()[i].getNeuronWithoutId() != net2.getNetwork()[j].getNeuronWithoutId() && i == 0) {
                    isAdded1[i] = true;
                    isAdded2[j] = true;
		} else if(net1.getNetwork()[i].getNeuronWithoutId() == net2.getNetwork()[j].getNeuronWithoutId() && i ==0) {
                    isAdded1[i] = true;
                } else if(net1.getNetwork()[i].getNeuronWithoutId() == net2.getNetwork()[j].getNeuronWithoutId() && i !=0) {
                    differentFromAll = false;
		}
            }
            if (differentFromAll && i != 0) {
		isAdded1[i] = true;
            }
	}
		
	//Initialise le nouveau network
        Network combinedNetwork = new Network();
		
	//Et rajoute tous les neurones qui ont été vu comme non doublon
	for (int i = 0; i < net1.getNetwork().length; i++) {
            if (isAdded1[i]) {
		combinedNetwork.addNeuronFromTileWithNewId(net1.getNetwork()[i]); //TODO Rajouter cette méthode dans la classe network (je peux le faire aussi - Dironiil)
            }
	}
	for (int i = 0; i < net2.getNetwork().length; i++) {
            if (isAdded2[i]) {
		combinedNetwork.addNeuronFromTileWithNewId(net2.getNetwork()[i]);
            }
	}
		
        return combinedNetwork;
    }

}
