/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFrameEddytor.java
 *
 * Created on 11 avr. 2016, 15:04:20
 */

package UserInterface;

import Tools.*;

/**
 *
 * @author Isaac, Dironiil, Viviou
 */
public class JFrameEddytor extends javax.swing.JFrame {

    /** Creates new form JFrameEddytor */
    public JFrameEddytor() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrameSize = new javax.swing.JInternalFrame();
        jTextFieldWidth = new javax.swing.JTextField();
        jTextFieldHeight = new javax.swing.JTextField();
        jLabelWidth = new javax.swing.JLabel();
        jLabelHeight = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        JMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemSaveAs = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuTile = new javax.swing.JMenu();
        jMenuItemTileBlock = new javax.swing.JMenuItem();
        jMenuItemTileEmpty = new javax.swing.JMenuItem();
        jMenuItemTileBeginning = new javax.swing.JMenuItem();

        jInternalFrameSize.setResizable(true);
        jInternalFrameSize.setTitle("Taille");
        jInternalFrameSize.setVisible(true);

        jTextFieldWidth.setText("jTextField1");

        jTextFieldHeight.setText("jTextField1");

        jLabelWidth.setFont(new java.awt.Font("DejaVu Sans", 0, 13)); // NOI18N
        jLabelWidth.setText("Largeur");

        jLabelHeight.setText("Hauteur");

        jButtonOk.setText("Ok");

        jButtonBack.setText("Retour");

        javax.swing.GroupLayout jInternalFrameSizeLayout = new javax.swing.GroupLayout(jInternalFrameSize.getContentPane());
        jInternalFrameSize.getContentPane().setLayout(jInternalFrameSizeLayout);
        jInternalFrameSizeLayout.setHorizontalGroup(
            jInternalFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameSizeLayout.createSequentialGroup()
                .addGroup(jInternalFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrameSizeLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jInternalFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelWidth)
                            .addComponent(jLabelHeight))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrameSizeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(jButtonOk)))
                .addContainerGap())
        );
        jInternalFrameSizeLayout.setVerticalGroup(
            jInternalFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameSizeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelWidth))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHeight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonBack))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(SystemInfo.getScreenDimension.width/2-400, SystemInfo.getScreenDimension.height/2-300);

        jMenuFile.setText("Fichier");

        jMenuItemNew.setText("Nouveau");
        jMenuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenNewMap(evt);
            }
        });
        jMenuFile.add(jMenuItemNew);

        jMenuItemOpen.setText("Ouvrir...");
        jMenuFile.add(jMenuItemOpen);

        jMenuItemSave.setText("Enregistrer");
        jMenuFile.add(jMenuItemSave);

        jMenuItemSaveAs.setText("Enregistrer sous...");
        jMenuFile.add(jMenuItemSaveAs);

        JMenuBar.add(jMenuFile);

        jMenuEdit.setText("Editer");

        jMenuTile.setText("Cases");

        jMenuItemTileBlock.setText("Bloc");
        jMenuTile.add(jMenuItemTileBlock);

        jMenuItemTileEmpty.setText("Vide");
        jMenuTile.add(jMenuItemTileEmpty);

        jMenuItemTileBeginning.setText("Départ");
        jMenuTile.add(jMenuItemTileBeginning);

        jMenuEdit.add(jMenuTile);

        JMenuBar.add(jMenuEdit);

        setJMenuBar(JMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenNewMap(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenNewMap
        // TODO Ouvreur de nouvelle map dans l'éditeur
    }//GEN-LAST:event_OpenNewMap

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameEddytor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar JMenuBar;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JInternalFrame jInternalFrameSize;
    private javax.swing.JLabel jLabelHeight;
    private javax.swing.JLabel jLabelWidth;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemNew;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenuItem jMenuItemSaveAs;
    private javax.swing.JMenuItem jMenuItemTileBeginning;
    private javax.swing.JMenuItem jMenuItemTileBlock;
    private javax.swing.JMenuItem jMenuItemTileEmpty;
    private javax.swing.JMenu jMenuTile;
    private javax.swing.JTextField jTextFieldHeight;
    private javax.swing.JTextField jTextFieldWidth;
    // End of variables declaration//GEN-END:variables

}