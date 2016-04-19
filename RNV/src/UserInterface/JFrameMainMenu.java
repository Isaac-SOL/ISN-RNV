/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;


import Tools.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author Isaac
 */
public class JFrameMainMenu extends javax.swing.JFrame {

    /**
     * Creates new form JFrameMainMenu
     */
    public JFrameMainMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooserMap = new javax.swing.JFileChooser();
        jButtonOpenMap = new javax.swing.JButton();
        jButtonEditMap = new javax.swing.JButton();
        jButtonGenerateMap = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();

        jFileChooserMap.setAcceptAllFileFilterUsed(false);
        jFileChooserMap.setApproveButtonText("Ouvrir");
        jFileChooserMap.setApproveButtonToolTipText("Utiliser cette map pour les tests");
        jFileChooserMap.setCurrentDirectory(new java.io.File(System.getProperty("user.home")+"/Documents"));
        jFileChooserMap.setDialogTitle("Ouvrir une map");
        jFileChooserMap.setFileFilter(FileIO.TxtFilter);
        jFileChooserMap.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        jFileChooserMap.setToolTipText("");
        jFileChooserMap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jFileChooserMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooserMapOpenMap(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NEAT");
        setBackground(new java.awt.Color(153, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(SystemInfo.getScreenDimension.width/2-208, SystemInfo.getScreenDimension.height/2-157);
        setResizable(false);

        jButtonOpenMap.setText("Ouvrir une map");
        jButtonOpenMap.setToolTipText("Choisir une map pour effectuer les tests dessus.");
        jButtonOpenMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMap(evt);
            }
        });

        jButtonEditMap.setText("Éditer une map");
        jButtonEditMap.setToolTipText("Créer une map avec l'outil.");
        jButtonEditMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMapCreator(evt);
            }
        });

        jButtonGenerateMap.setText("Générer une map aléatoirement");
        jButtonGenerateMap.setToolTipText("Crée une map générée alétoirement et l'enregistre.");
        jButtonGenerateMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMapGenerator(evt);
            }
        });

        jButtonClose.setText("Fermer");
        jButtonClose.setToolTipText("Quitter le testeur.");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseProgram(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButtonGenerateMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEditMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonOpenMap, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonClose)))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jButtonOpenMap, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEditMap, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGenerateMap, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButtonClose)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * méthode quand on appuie sur le bouton. Ouvre une fenêtre pour choisir un fichier texte et affiche son contenu.
     * @param evt Auto-généré
     */
    private void OpenMap(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMap
        int returnVal = jFileChooserMap.showOpenDialog(null);                            //Ouvre jFileChooserMap et regarde sur quel bouton il a appuyé
        if (returnVal == JFileChooser.APPROVE_OPTION) {                                                             //Vérifie qe l'utilisateur ait appuyé sur ok
            File chosenMap = jFileChooserMap.getSelectedFile();                                //Récupère le fichier choisi par l'utilisateur
            try {
                Integer[][] map = FileIO.readIntegerArrayFile(chosenMap); //Transformation du Fichier en tableau d'Integer[][] TODO transformer ça en lecture directe du fichier .map
                new JFrameChosenMap(map).setVisible(true);  //Ouverture de la map choisie + 
                this.dispose();                             //Fermeture de la fenètre de menu               
            } catch (IOException ex) {
              System.out.println("Problème lors de l'accès au fichier "+chosenMap.getAbsolutePath() + "Erreur : " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("Erreur de class : " + ex.getMessage());
            }
        } else {
            System.out.println("Accès au fichier annulé.");
        }
    }//GEN-LAST:event_OpenMap

    private void OpenMapCreator(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMapCreator
        // TODO Ouvrir l'éditeur de maps
    }//GEN-LAST:event_OpenMapCreator

    private void OpenMapGenerator(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMapGenerator
        // TODO Ouvrir le générateur de maps (éventuellement?)
    }//GEN-LAST:event_OpenMapGenerator
    
    /**
     * Méthode quand on appuie sur le bouton Ferme. Quitte le programme définitivement.
     * @param evt Auto-généré
     */
    private void CloseProgram(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseProgram
        System.exit(0);
    }//GEN-LAST:event_CloseProgram

    private void jFileChooserMapOpenMap(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooserMapOpenMap
        //Empty space
    }//GEN-LAST:event_jFileChooserMapOpenMap

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMainMenu().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonEditMap;
    private javax.swing.JButton jButtonGenerateMap;
    private javax.swing.JButton jButtonOpenMap;
    private javax.swing.JFileChooser jFileChooserMap;
    // End of variables declaration//GEN-END:variables
}
