/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rnv;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;

/**
 *
 * @author Pierre
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

        jButtonOpenMap = new javax.swing.JButton();
        jButtonCreateMap = new javax.swing.JButton();
        jButtonGenerateMap = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NEAT");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jButtonOpenMap.setText("Ouvrir une map");
        jButtonOpenMap.setToolTipText("Choisir une map pour effectuer les tests dessus.");
        jButtonOpenMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMap(evt);
            }
        });

        jButtonCreateMap.setText("Créer une map (?)");
        jButtonCreateMap.setToolTipText("Créer une map avec l'outil.");
        jButtonCreateMap.addActionListener(new java.awt.event.ActionListener() {
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
                            .addComponent(jButtonCreateMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jButtonCreateMap, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGenerateMap, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButtonClose)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //méthode quand on appuie sur le bouton. Oubre un fichier texte et affiche son contenu.
    private void OpenMap(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMap
        int returnVal = new JFrameMapDirectories().jFileChooserMap.showOpenDialog(null);                            //Ouvre jFileChooserMap et regarde sur quel bouton il a appuyé
        if (returnVal == JFileChooser.APPROVE_OPTION) {                                                             //Vérifie qe l'utilisateur ait appuyé sur ok
            File chosenMap = JFrameMapDirectories.jFileChooserMap.getSelectedFile();                                //Récupère le fichier choisi par l'utilisateur
            try {
                new JFrameChosenMap().setVisible(true);
                this.dispose();
                JFrameChosenMap.jTextArea1.setText(readFile(chosenMap.getAbsolutePath(),StandardCharsets.UTF_8));   //Utilise la fonction décrite plus bas pour transformer le fichier (écrit en UTF-8) en String
            } catch (IOException ex) {
              System.out.println("Problème lors de l'accès au fichier "+chosenMap.getAbsolutePath());
            }
        } else {
            System.out.println("Accès annulé par l'utilisateur.");
        }
    }//GEN-LAST:event_OpenMap

    private void OpenMapCreator(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMapCreator
        // TODO add your handling code here:
    }//GEN-LAST:event_OpenMapCreator

    private void OpenMapGenerator(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMapGenerator
        // TODO add your handling code here:
    }//GEN-LAST:event_OpenMapGenerator

    private void CloseProgram(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseProgram
        this.dispose();
    }//GEN-LAST:event_CloseProgram

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
    
    //Fonction pour transformer un fichier texte en string avec son chemin et son encodage
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonCreateMap;
    private javax.swing.JButton jButtonGenerateMap;
    private javax.swing.JButton jButtonOpenMap;
    // End of variables declaration//GEN-END:variables
}
