/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Guillaume
 */
public class FileIO {
    
    /**
     * Fonction pour transformer un fichier texte en string avec son chemin et son encodage
     * @param path          Chemin du fichier texte
     * @param encoding      Charset du fichier texte
     * @return String       String retourné après conversion
     * @throws IOException  Exception thrown si il y a un problème avec le fichier
     */
    public static String readTextFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}
