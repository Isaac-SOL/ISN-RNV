/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Isaac
 */


public class SystemInfo {
    //Variable statique donnant la dimension de l'écran de l'utilisateur
        public static Dimension getScreenDimension = Toolkit.getDefaultToolkit().getScreenSize();
}
