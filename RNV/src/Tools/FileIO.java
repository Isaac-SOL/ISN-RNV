/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Isaac 
 */
public class FileIO {
    
    /**
     * Fonction pour lire un fichier texte et renvoyer le contenu dans un String
     * @param path          Chemin du fichier texte
     * @param encoding      Charset du fichier texte
     * @return String       String retourné après conversion
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static String readTextFile(String path, Charset encoding) throws IOException, FileNotFoundException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
    /**
     * Fonction pour lire un fichier d'Integer[][] sérialisé et en renvoyer le contenu
     * @param f             Fichier sérialisé à lire
     * @return Integer[][]  Tableau retourné après lecture
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public static Integer[][] readIntegerArrayFile(File f) throws IOException, FileNotFoundException, ClassNotFoundException {
        Integer[][] map;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            map = (Integer[][]) ois.readObject();
        }
        return map;
    }
    
    /**
     * Fonction pour lire un fichier d'Integer[][] sérialisé et en renvoyer le contenu
     * @param map   Tableau à sérialiser
     * @param path  Chemin du fichier à créer
     * @throws IOException
     */
    public static void writeIntegerArrayFile(Integer[][] map, String path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)))) {
            oos.writeObject(map);
        }        
    }

}
