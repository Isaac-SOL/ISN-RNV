/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Game.Tile;
import RNV.Network;
import Tools.*;
import static Tools.MapTranslator.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Isaac
 */
public class JFrameChosenMap extends javax.swing.JFrame {

    /**
     * Creates new form JFrameChosenMap
     */
    public JFrameChosenMap() {
        initComponents();
    }
    
    /**
     * Second constructeur qui utilise un tableau de Integer pour créer la Table avec
     * @param map Integer[][] qui sert à créer la map
     */
    public JFrameChosenMap(Integer[][] map) {
        initComponents();
        this.map = map;
        initTable(intToTiles(map));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooserNetwork = new javax.swing.JFileChooser();
        JButtonBack = new javax.swing.JButton();
        jButtonSavedNetwork = new javax.swing.JButton();
        jButtonNewNetwork = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jFileChooserNetwork.setAcceptAllFileFilterUsed(false);
        jFileChooserNetwork.setApproveButtonText("Ouvrir");
        jFileChooserNetwork.setApproveButtonToolTipText("Jouer sur cette map avec ce réseau");
        jFileChooserNetwork.setCurrentDirectory(jFileChooserNetwork.getFileSystemView().getDefaultDirectory());
        jFileChooserNetwork.setFileFilter(FileIO.NetworkFilter);
        jFileChooserNetwork.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(SystemInfo.getScreenDimension.width/2-400, SystemInfo.getScreenDimension.height/2-300);
        setResizable(false);

        JButtonBack.setText("Retour");
        JButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WindowBack(evt);
            }
        });

        jButtonSavedNetwork.setText("Lancer avec un réseau préexistant");
        jButtonSavedNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSavedNetworkActionPerformed(evt);
            }
        });

        jButtonNewNetwork.setText("Lancer avec un nouveau réseau");
        jButtonNewNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewNetworkActionPerformed(evt);
            }
        });

        jButton1.setText("Jouer avec un réseau");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Play(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JButtonBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)))
                .addComponent(jButtonSavedNetwork)
                .addGap(242, 242, 242))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(582, Short.MAX_VALUE)
                    .addComponent(jButtonNewNetwork)
                    .addGap(22, 22, 22)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(514, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JButtonBack)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSavedNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(23, 23, 23))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(514, Short.MAX_VALUE)
                    .addComponent(jButtonNewNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WindowBack(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WindowBack
        new JFrameMainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_WindowBack

    private void jButtonSavedNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSavedNetworkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSavedNetworkActionPerformed

    private void jButtonNewNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewNetworkActionPerformed
        new JFrameRNV(intToTiles(map)).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonNewNetworkActionPerformed

    private void Play(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Play
        int returnVal = jFileChooserNetwork.showOpenDialog(null);                            //Ouvre jFileChooserNetwork et regarde sur quel bouton il a appuyé
        if (returnVal == JFileChooser.APPROVE_OPTION) {                                                             //Vérifie qe l'utilisateur ait appuyé sur ok
            File chosenNetwork = jFileChooserNetwork.getSelectedFile();                                //Récupère le fichier choisi par l'utilisateur
            try {
                Network net = FileIO.readNetworkFile(chosenNetwork); //Transformation du Fichier en tableau d'Integer[][]
                new JFrameRNVGame(map,net).setVisible(true);  //Ouverture de la map choisie + 
                this.dispose();                             //Fermeture de la fenètre de menu
            } catch (IOException ex) {
                System.out.println("Problème lors de l'accès au fichier "+chosenNetwork.getAbsolutePath() + "Erreur : " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("Erreur de classe du fichier : " + ex.getMessage());
            }
        } else {
            System.out.println("Accès au fichier annulé.");
        }
    }//GEN-LAST:event_Play

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
            java.util.logging.Logger.getLogger(JFrameChosenMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameChosenMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameChosenMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameChosenMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameChosenMap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonNewNetwork;
    private javax.swing.JButton jButtonSavedNetwork;
    private javax.swing.JFileChooser jFileChooserNetwork;
    // End of variables declaration//GEN-END:variables
    
    //Variables utilisées pour créer la Table.
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMap;
    
    private Integer[][] map;
    
    /**
     * Méthode appelée par le second constructeur. Utilise un tableau de Integer pour créer et remplir une Table, qui est ensuite affichée.
     * @param map Integer[][] à afficher à l'écran
     */
    private void initTable(Tile[][] map) {
        
        int nbLines = map.length;
        int nbColumns = map[0].length;
        
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMap = new javax.swing.JTable() {
            @Override       //On override getColumnClass pour pouvoir afficher des ImageIcons
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };

        //Initialise la Table avec la map pour la remplir, ainsi qu'un String[] qui fait le titre des colonnes.
        jTableMap.setModel(new DefaultTableModelImpl(
            tilesToScaledIcons(map, 788 / nbColumns),
            new String [nbColumns]
        ));
        jTableMap.setTableHeader(null);
        
        if (nbLines < 30) {
            //Initialise la Table avec la map pour la remplir, ainsi qu'un String[] qui fait le titre des colonnes.
            jTableMap.setModel(new DefaultTableModelImpl(
                tilesToIcons(map),
                new String [nbColumns]
            ){
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) { //Rend les cellules non modifiables par double clic dessus
                    return false;
                }
            });

            //<editor-fold defaultstate="collapsed" desc="Code du Scroller, copié du générateur auto de NetBeans">
            jScrollPane2.setViewportView(jTableMap);
        
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, nbColumns*16+6, nbColumns*16+6, nbColumns*16+6)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, nbLines*16, nbLines*16, nbLines*16+6)
                    .addContainerGap(82, Short.MAX_VALUE))
            );
            //</editor-fold>
            
        } else {
            //Initialise la Table avec la map pour la remplir, ainsi qu'un String[] qui fait le titre des colonnes.
            jTableMap.setModel(new DefaultTableModelImpl(
                tilesToScaledIcons(map, 788 / nbColumns),
                new String [nbColumns]
            ){
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) { //Rend les cellules non modifiables par double clic dessus
                    return false;
                }
            });

            //<editor-fold defaultstate="collapsed" desc="Code du Scroller, copié du générateur auto de NetBeans">
            jScrollPane2.setViewportView(jTableMap);
        
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(82, Short.MAX_VALUE))
            );
            //</editor-fold>

            jTableMap.setRowHeight(788 / nbColumns);
        }
        
    }

    private static class DefaultTableModelImpl extends DefaultTableModel {

        public DefaultTableModelImpl(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }
    }
}
