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

    public static Network create() {
        Network network = new Network();

        for (int i = 0; i < 2; i++) {
            int inputId;
            do {
                inputId = (int) (Math.random()*25);
            } while(inputId == 13);

            int type = (int) (Math.random()*2+1);
            int[] dest = {(int) (Math.random()*4)};

            network.newNeuronFromTile(inputId, type, dest);
        }

        return network;
    }

    public static Network mutate(Network firstNet) {
        int[] idList = firstNet.getIdList();
        int indexId = (int) (Math.random()*idList.length) ;
        int id = idList[indexId];

        int choice = (int) (Math.random()*2);
        switch  (choice){
            case 0 : firstNet.deleteNeuron(id); break;
            case 1 : //TODO Rajouter le case
        }

        return firstNet;
    }

    public static Network assemble(Network net1, Network net2) {
        Network combinedNetwork = new Network();
        //TODO Faire la méthode
        return combinedNetwork;
    }

}
