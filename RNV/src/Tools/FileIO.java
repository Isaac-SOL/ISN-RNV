/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Isaac 
 */
public class FileIO {
    
    
    /**
     * Fonction pour lire un fichier d'Integer[][] sérialisé et en renvoyer le contenu
     * @param file              Fichier sérialisé à lire
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
    
    //Crée un filtre pour les fichiers .txt. TODO rendre ce commentaire propre (Dironiil)
    public static FileFilter TxtFilter = new FileNameExtensionFilter("Fichier Texte","txt");
    public static FileFilter MapFilter = new FileNameExtensionFilter("Fichier Map","map");

}
