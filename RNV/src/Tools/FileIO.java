/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import RNV.Network;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Isaac 
 */
public class FileIO {
    
    
    /**
     * Fonction pour lire un fichier d'Integer[][] sérialisé et en renvoyer le contenu
     * @param file Fichier sérialisé à lire
     * @return Integer[][] retourné après lecture
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public static Integer[][] readIntegerArrayFile(File file) throws IOException, FileNotFoundException, ClassNotFoundException {
        Integer[][] map;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            map = (Integer[][]) ois.readObject();
        }
        return map;
    }
    
    /**
     * Procédure pour transformer un Integer[][] en fichier
     * @param map   Tableau à sérialiser
     * @param path  Chemin du fichier à créer
     * @throws IOException
     */
    public static void writeIntegerArrayFile(Integer[][] map, String path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)))) {
            oos.writeObject(map);
        }        
    }
    
    /**
     * Fonction pour lire un fichier Network sérialisé et en renvoyer le contenu
     * @param file Fichier sérialisé à lire
     * @return Network retourné après lecture
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public static Network readNetworkFile(File file) throws IOException, FileNotFoundException, ClassNotFoundException {
        Network network;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            network = (Network) ois.readObject();
        }
        return network;
    }
    
    /**
     * Procédure pour transformer un Network en fichier
     * @param network   Réseau à sérialiser
     * @param path  Chemin du fichier à créer
     * @throws IOException
     */
    public static void writeNetworkFile(Network network, String path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)))) {
            oos.writeObject(network);
        }        
    }
    
    //Filtres pour fichiers texte ou map
    public static FileFilter MapFilter = new FileNameExtensionFilter("Fichier Map","map");
    public static FileFilter networkFilter = new FileNameExtensionFilter("Fichier Network","ntw");

}
