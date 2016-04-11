/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import static Tools.SystemInfo.getScreenDimension;
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
        initTable(map);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JButtonBack = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(getScreenDimension.width/2-400, getScreenDimension.height/2-300);
        setResizable(false);

        JButtonBack.setText("Retour");
        JButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WindowBack(evt);
            }
        });

        jButton1.setText("Lancer avec un nouveau réseau");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JButtonBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 509, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(524, 524, 524)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JButtonBack))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WindowBack(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WindowBack
        new JFrameMainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_WindowBack

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
    // End of variables declaration//GEN-END:variables
    
    //Variables utilisées pour créer la Table.
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMap;
    
    /**
     * Méthode appelée par le second constructeur. Utilise un tableau de Integer pour créer et remplir une Table, qui est ensuite affichée.
     * @param map Integer[][] à afficher à l'écran
     */
    private void initTable(Integer[][] map) {
        
        int nbLines = map.length;
        int nbColumns = map[0].length;
        
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMap = new javax.swing.JTable();

        //Initialise la Table avec la map pour la remplir, ainsi qu'un String[] qui fait le titre des colonnes.
        jTableMap.setModel(new DefaultTableModelImpl(
            map,
            new String [nbColumns]
        ));
        
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
        
    }

    private static class DefaultTableModelImpl extends DefaultTableModel {

        public DefaultTableModelImpl(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }
    }
}
