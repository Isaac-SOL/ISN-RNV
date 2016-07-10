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
        System.out.println("Create : " + inputId + ", " + type + ", " + dest[0]);
        
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

        int choice = (int) (Math.random()*9);
        switch  (choice) { 
            case 0 :
            case 1 :
            case 8 :
                System.out.println("Suppression");
                int indexId = (int) (Math.random()*idList.length);
                int id = idList[indexId];
                firstNet.deleteNeuron(id); break;               


            case 2 : // permet d'avoir 3 chance sur 7 "ajoute un neurone senseur" 
            case 3 :
            case 4 :
                System.out.println("Neurone senseur");
                //Créé un input de tile aléatoire (différent de l'emplacement du jeton)
                int inputIdTile;
                do {
                     inputIdTile = (int) (Math.random()*25);
                 } while(inputIdTile == 13);

                //Choisit un type aléatoire entre plein (2) et vide (1)
                int type = (int) (Math.random()*2+1);

                //Choisis une destination de synapase aléatoire
                int[] destTile;
                int randomTile = (int) (Math.random()*(idList.length+4));
                if (randomTile < idList.length) {
                    destTile = new int[] {idList[randomTile]}; //Attribution à un autre neurone
                } else destTile = new int[] {randomTile - (idList.length-1)}; //Attribution à un bouton

                if (choice == 3) { firstNet.newNeuronFromTile(inputIdTile, type, destTile, true); }// créer un nouveau neurone avec des caractéristiques tirées au hasard et le rajoute dans firstNet
                else { firstNet.newNeuronFromTile(inputIdTile, type, destTile, false); }

                break;


            case 5 :// permet d'avoir 3 chance sur 7 "ajoute un neurone non-senseur" 
            case 6 :
            case 7 :
                System.out.println("Neurone non-senseur");
                //génére aléatoirement un id d'input et d'output différent
                int inputIdNeuron = idList[(int) (Math.random()*firstNet.getNetwork().length)];
                int[] destNeuron;
                do {
                    int randomNeuron = (int) (Math.random()*(idList.length+4));
                    if (randomNeuron < idList.length) {
                        destNeuron = new int[] {idList[randomNeuron]};
                    } else destNeuron = new int[] {randomNeuron - (idList.length-1)}; //Attribution à un bouton
                } while(destNeuron[0] == inputIdNeuron);

                //En créé un neurone inhibiteur (1/3) ou activateur (2/3)
                if (choice == 6) {
                    firstNet.newNeuronFromNeuron(inputIdNeuron, destNeuron, true);
                }
                else {
                    firstNet.newNeuronFromNeuron(inputIdNeuron, destNeuron, false);
                }

                break;


            default : System.out.println("Erreur de mutate ! Choix aléatoire introuvable."); break;
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
        
        //Change les ID s'ils existent déjà dans l'autre réseau
        for (int i = 0; i < net1.getNetwork().length; i++) {
            boolean alreadyTakenId;				
            do {
                alreadyTakenId = false;
                for (int j = 0; j < net2.getNetwork().length; j++) {
                    if (net1.getNetwork()[i].id == net2.getNetwork()[j].id) {
                        alreadyTakenId = true;
                        System.out.println("net1 = net2 : " + i + " / " + j);
                    }
                }
                for (int j = 0; j < net1.getNetwork().length; j++) {
                    if ((net1.getNetwork()[i].id == net1.getNetwork()[j].id) && (i != j)) {
                        System.out.println("net1 = net1 : " + net1.getNetwork()[i].id + " / " + net1.getNetwork()[j].id);
                        alreadyTakenId = true;
                    }
                }
                System.out.println("AlreadyTakenId : " + alreadyTakenId);
                if (alreadyTakenId == true) {
                    net1.setNewId(i, (int)(Math.random()*2000000000+5));
                }
            }while (alreadyTakenId == true);
        }


        //Rajoute les neurones, sauf les doublons de neurones senseurs
        HashSet<Neuron> combinedNetworksSet = new HashSet<>();
        HashSet<Neuron> neuronsSensorWithoutId = new HashSet<>();

        for (int i = 0; i < net1.getNetwork().length; i++) {
            Neuron n = net1.getNetwork()[i];
            if (n.isSensor) {
                int id = n.id;
                n.id = -1;
                boolean added = neuronsSensorWithoutId.add(n);
                n.id = id;
                if (added) {
                    combinedNetworksSet.add(n);
                }
            }else { combinedNetworksSet.add(n); }
        }
        for (int i = 0; i < net2.getNetwork().length; i++) {
            Neuron n = net2.getNetwork()[i];
            if (n.isSensor) {
                int id = n.id;
                n.id = -1;
                boolean added = neuronsSensorWithoutId.add(n);
                n.id = id;
                if (added) {
                    combinedNetworksSet.add(n);
                }
            }else { combinedNetworksSet.add(n); }
        }

        Neuron[] combinedNetworks = combinedNetworksSet.toArray(new Neuron[combinedNetworksSet.size()]);
        Network combinedNetwork = new Network(combinedNetworks);

        return combinedNetwork;
                
    }

}
