/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//TODO supprimer cette JFrame et la rendre interne à MainMenu

package UserInterface;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Isaac
 */
public class JFrameMapDirectories extends javax.swing.JFrame {

    /**
     * Creates new form JFrameMapDirectories
     */
    public JFrameMapDirectories() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Choisir une Map");
        setResizable(false);

        jFileChooserMap.setAcceptAllFileFilterUsed(false);
        jFileChooserMap.setApproveButtonText("Ouvrir");
        jFileChooserMap.setApproveButtonToolTipText("Utiliser cette map pour les tests");
        jFileChooserMap.setCurrentDirectory(new java.io.File(System.getProperty("user.home")+"/Documents"));
        jFileChooserMap.setDialogTitle("Ouvrir une map");
        jFileChooserMap.setFileFilter(TxtFilter);
        jFileChooserMap.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        jFileChooserMap.setSelectedFile(new java.io.File("D:\\logiciel\\NetBeans\\NetBeans 8.0.2\\TestingMap"));
        jFileChooserMap.setToolTipText("");
        jFileChooserMap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jFileChooserMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMap(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooserMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooserMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenMap(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMap
        //Empty space
    }//GEN-LAST:event_OpenMap

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
            java.util.logging.Logger.getLogger(JFrameMapDirectories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMapDirectories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMapDirectories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMapDirectories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMapDirectories().setVisible(true);
            }
        });
    }
    
    //Crée un filtre pour les fichiers .txt.  TODO changer l'extension?
    FileFilter TxtFilter = new FileNameExtensionFilter("Fichier Texte","txt");

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JFileChooser jFileChooserMap;
    // End of variables declaration//GEN-END:variables
}
