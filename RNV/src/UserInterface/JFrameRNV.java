/*
 * Projet de fin d'année d'ISN
 * RNV, par Isaac, Dironiil, Viviou1325
 */
package UserInterface;

import Game.*;
import RNV.*;
import static Tools.MapTranslator.*;
import Tools.SystemInfo;
import java.util.List;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Viviou
 */

public class JFrameRNV extends javax.swing.JFrame {

    /**
     * Creates new form JFrameRNV
     */
    public JFrameRNV() {
        initComponents();
    }
    
    public JFrameRNV(Tile[][] map) {
        initComponents();
        initTable(map);
        this.map = map;
    }
    
    public JFrameRNV(Tile[][] map, Network net) {
        initComponents();
        initTable(map);
        this.map = map;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameName = new javax.swing.JFrame();
        jButtonBack1 = new javax.swing.JButton();
        jTextFieldName = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();
        jButtonRun = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jLabelScoreMax = new javax.swing.JLabel();
        jLabelScoreMaxGen = new javax.swing.JLabel();
        jLabelNumGen = new javax.swing.JLabel();

        jFrameName.setTitle("Nouvelle map");
        jFrameName.setLocation(SystemInfo.getScreenDimension.width/2-100, SystemInfo.getScreenDimension.height/2-60);
        jFrameName.setResizable(false);
        jFrameName.setSize(new java.awt.Dimension(236, 144));

        jButtonBack1.setText("Retour");
        jButtonBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackToRNV(evt);
            }
        });

        jLabelName.setFont(new java.awt.Font("DejaVu Sans", 0, 13)); // NOI18N
        jLabelName.setText("Nom");

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkSizeOk(evt);
            }
        });

        javax.swing.GroupLayout jFrameNameLayout = new javax.swing.GroupLayout(jFrameName.getContentPane());
        jFrameName.getContentPane().setLayout(jFrameNameLayout);
        jFrameNameLayout.setHorizontalGroup(
            jFrameNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameNameLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jFrameNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrameNameLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabelName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(jFrameNameLayout.createSequentialGroup()
                        .addComponent(jButtonBack1)
                        .addGap(83, 83, 83)
                        .addComponent(jButtonOk)))
                .addGap(25, 25, 25))
        );
        jFrameNameLayout.setVerticalGroup(
            jFrameNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameNameLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jFrameNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelName))
                .addGap(18, 18, 18)
                .addGroup(jFrameNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBack1)
                    .addComponent(jButtonOk))
                .addGap(18, 18, 18))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(SystemInfo.getScreenDimension.width/2-400,SystemInfo.getScreenDimension.height/2-300);
        setResizable(false);

        jButtonRun.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButtonRun.setText("Lancer réseau");
        jButtonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunRNV(evt);
            }
        });

        jButtonBack.setText("Retour");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back(evt);
            }
        });

        jLabelScoreMax.setText("Score Max ");

        jLabelScoreMaxGen.setText("Score Max génération");

        jLabelNumGen.setText("Numéro de génération");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonBack)
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelScoreMax, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelScoreMaxGen, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabelNumGen, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(499, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonBack)
                        .addComponent(jLabelScoreMaxGen)
                        .addComponent(jLabelNumGen))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelScoreMax)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Back(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back
        new JFrameChosenMap(tilesToInt(map)).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Back

    private void RunRNV(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunRNV
        jFrameName.setVisible(true);
    }//GEN-LAST:event_RunRNV

    private void jButtonBackToRNV(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackToRNV
        jFrameName.setVisible(false);
        System.out.println("Lancement annulé par l'utilisateur");
    }//GEN-LAST:event_jButtonBackToRNV

    private void jButtonOkSizeOk(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkSizeOk
        jLabelNumGen.setText("lolololololololol");
        jFrameName.setVisible(false);
        
        SwingWorker worker = new SwingWorker<Void, Integer[]>() {
            
            @Override
            protected Void doInBackground() throws Exception {
                
                System.out.println("RNV lancé !\n\n\n\n\n");
                Manager manageRNV = new Manager(jTextFieldName.getText(), map);
                
                while (manageRNV.scoreMaxRnv < manageRNV.scoreMax && manageRNV.numeroGen < 150) { //Lance les tests tant que les meilleur score atteint n'est pas le meilleurs score possible
                    Integer[] data = {manageRNV.numeroGen,manageRNV.scoreMaxRnv};
                    publish(data);
                    manageRNV.launch();
                }
                
            return null;
            }
            
            @Override
            protected void process(List<Integer[]> dataChunk) {
                for(Integer[] data : dataChunk) {
                        jLabelNumGen.setText("Numéro de génération : " + Integer.toString(data[0]));
                        jLabelScoreMaxGen.setText("Score max génération : " + Integer.toString(data[1]));
                }
            }
        };
        worker.execute();
    }//GEN-LAST:event_jButtonOkSizeOk

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
            java.util.logging.Logger.getLogger(JFrameRNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameRNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameRNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameRNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameRNV().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonBack1;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonRun;
    private javax.swing.JFrame jFrameName;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNumGen;
    private javax.swing.JLabel jLabelScoreMax;
    private javax.swing.JLabel jLabelScoreMaxGen;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables

    //Variables utilisées pour créer la Table.
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMap;
    
    private Tile[][] map;
    
    
private void initTable(Tile[][] map) {
        
        int nbLines = map.length;
        int nbColumns = map[0].length;
        
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMap = new javax.swing.JTable() {
            @Override       //Override getColumnClass pour pouvoir afficher des ImageIcons
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
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
            jScrollPane1.setViewportView(jTableMap);
        
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, nbColumns*16+6, nbColumns*16+6, nbColumns*16+6)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, nbLines*16, nbLines*16, nbLines*16+6)
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
            jScrollPane1.setViewportView(jTableMap);
        
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
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