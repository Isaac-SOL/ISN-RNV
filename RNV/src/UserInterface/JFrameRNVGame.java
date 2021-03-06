/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface;

import Game.*;
import RNV.Interpreter;
import RNV.Network;
import static Tools.MapTranslator.*;
import Tools.SystemInfo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Isaac
 */

public class JFrameRNVGame extends javax.swing.JFrame {

    /**
     * Creates new form JFramePlayableGame
     */
    public JFrameRNVGame() {
        initComponents();
    }
    
    /**
     * Second constructeur qui utilise un tableau de Integer pour créer la Table avec
     * @param map Integer[][] qui sert à créer la map
     * @param net Réseau qui "jouera" sur la map
     */
    public JFrameRNVGame(Integer[][] map, Network net) {
        
        nbLines = map.length;
        nbColumns = map[0].length;
        
        initComponents();
        initTable(intToTiles(map));
        game = new RunningGame(map);
        network = net;
        
        initViewRadius(game.getViewRadius(2),2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameViewRadius = new javax.swing.JFrame();
        jButtonBack = new javax.swing.JButton();
        jButtonLeft = new javax.swing.JButton();
        jButtonRight = new javax.swing.JButton();
        jButtonUp = new javax.swing.JButton();
        jButtonDown = new javax.swing.JButton();
        jButtonRun = new javax.swing.JButton();
        jLabelScore = new javax.swing.JLabel();

        jFrameViewRadius.setAlwaysOnTop(true);
        jFrameViewRadius.setLocation(SystemInfo.getScreenDimension.width/2+400, SystemInfo.getScreenDimension.height/2-300);
        jFrameViewRadius.setResizable(false);
        jFrameViewRadius.setSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout jFrameViewRadiusLayout = new javax.swing.GroupLayout(jFrameViewRadius.getContentPane());
        jFrameViewRadius.getContentPane().setLayout(jFrameViewRadiusLayout);
        jFrameViewRadiusLayout.setHorizontalGroup(
            jFrameViewRadiusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );
        jFrameViewRadiusLayout.setVerticalGroup(
            jFrameViewRadiusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        jButtonBack.setText("Retour");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WindowBack(evt);
            }
        });

        jButtonLeft.setText("<");

        jButtonRight.setText(">");

        jButtonUp.setText("^");

        jButtonDown.setText("v");

        jButtonRun.setText("Lancer Réseau");
        jButtonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Run(evt);
            }
        });

        jLabelScore.setText("Score = 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonUp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                        .addComponent(jLabelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButtonRun)
                        .addGap(28, 28, 28)
                        .addComponent(jButtonLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDown, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRight, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(469, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonUp, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonBack, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonRight, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonDown, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelScore)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Fait jouer le jeu au réseau
    private void Run(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Run
        game.reset();
        
        Runnable inter = () -> {
            try {
                Interpreter.interpreteWith(network, game, 750);
            } catch (InterruptedException ex) {
                Logger.getLogger(JFrameRNVGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        
        Thread tInter = new Thread(inter);
        
        Runnable swing = () -> {
            while (tInter.getState() != Thread.State.TERMINATED){
                jTableMap.setModel(new JFrameRNVGame.DefaultTableModelImpl(game.getIconMap(), new String [nbColumns]));
                jTableViewRadius.setModel(new JFrameRNVGame.DefaultTableModelImpl(tilesToIcons(game.getViewRadius(2)), new String [5]));
                jLabelScore.setText("Score = " + game.getScore());
                try {
                    Thread.sleep(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JFrameRNVGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        Thread tSwing = new Thread(swing);
        tInter.start(); tSwing.start();
    }//GEN-LAST:event_Run

    private void WindowBack(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WindowBack
        new JFrameMainMenu().setVisible(true);
        this.dispose();
        jFrameViewRadius.dispose();
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
            java.util.logging.Logger.getLogger(JFrameRNVGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameRNVGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameRNVGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameRNVGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameRNVGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonDown;
    private javax.swing.JButton jButtonLeft;
    private javax.swing.JButton jButtonRight;
    private javax.swing.JButton jButtonRun;
    private javax.swing.JButton jButtonUp;
    private javax.swing.JFrame jFrameViewRadius;
    private javax.swing.JLabel jLabelScore;
    // End of variables declaration//GEN-END:variables

    //Variables utilisées pour créer la Table.
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMap;
    int nbLines;
    int nbColumns;
    
    //Jeu en cours en fond.
    RunningGame game;
    
    //Réseau qui jouera au jeu.
    Network network;
    
    //Variables utilisées pour créer le ViewRadius.
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableViewRadius;
    
    /**
     * Méthode appelée par le second constructeur. Utilise un tableau de Integer pour créer et remplir une Table, qui est ensuite affichée.
     * @param map Integer[][] à afficher à l'écran
     */
    private void initTable(Tile[][] map) {
        
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
            jTableMap.setModel(new JFrameRNVGame.DefaultTableModelImpl(
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
            layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, nbColumns*16+6, nbColumns*16+6, nbColumns*16+6)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jButtonUp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonBack)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(jButtonLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonDown, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonRight, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, nbLines*16, nbLines*16, nbLines*16+6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonUp, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonBack, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonRight, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonDown, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap())
            );
            //</editor-fold>
            
        } else {
            //Initialise la Table avec la map pour la remplir, ainsi qu'un String[] qui fait le titre des colonnes.
            jTableMap.setModel(new JFrameRNVGame.DefaultTableModelImpl(
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
            layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jButtonUp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonBack)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(jButtonLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonDown, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonRight, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonUp, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonBack, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonRight, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonDown, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap())
            );
            //</editor-fold>

            jTableMap.setRowHeight(788 / nbColumns);
        }
        
    }
    
    private void initViewRadius(Tile[][] view, int radius) {
        
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableViewRadius = new javax.swing.JTable() {
            @Override       //Override getColumnClass pour pouvoir afficher des ImageIcons
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        jTableViewRadius.setTableHeader(null);

        //Initialise la Table avec la map pour la remplir, ainsi qu'un String[] qui fait le titre des colonnes.
        jTableViewRadius.setModel(new JFrameRNVGame.DefaultTableModelImpl(
            tilesToIcons(view),
            new String [2*radius + 1]
        ){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) { //Rend les cellules non modifiables par double clic dessus
                return false;
            }
        });
        
        //<editor-fold defaultstate="collapsed" desc="Code du Scroller, copié du générateur auto de NetBeans">
        jScrollPane2.setViewportView(jTableViewRadius);
        
        javax.swing.GroupLayout jFrameViewRadiusLayout = new javax.swing.GroupLayout(jFrameViewRadius.getContentPane());
        jFrameViewRadius.getContentPane().setLayout(jFrameViewRadiusLayout);
        jFrameViewRadiusLayout.setHorizontalGroup(
                jFrameViewRadiusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jFrameViewRadiusLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, radius*32+32, radius*32+32, radius*32+32)
                                .addContainerGap())
        );
        jFrameViewRadiusLayout.setVerticalGroup(
                jFrameViewRadiusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jFrameViewRadiusLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, radius*32+22, radius*32+22, radius*32+22)
                                .addContainerGap())
        );
        //</editor-fold>
        
        jFrameViewRadius.setVisible(true);
    }
    
    private static class DefaultTableModelImpl extends DefaultTableModel {

        public DefaultTableModelImpl(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }
    }
}
