/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFrameEddytor.java
 */

package UserInterface;

import Tools.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Isaac, Dironiil, Viviou
 */
public class JFrameEddytor extends javax.swing.JFrame {

    /** Crée un nouveau JFrameEddytor */
    public JFrameEddytor() {
        initComponents();
        blockValue = 2;
        path = null;
    }
    /**
     * Créé un nouveau JFrameEddytor avec une map pré-entrée
     * @param map La map à éditer
     * @param mapPath Le chemin de la map actuelle
     */
    public JFrameEddytor(Integer[][] map, String mapPath) {
        initComponents();
        editTable(map);
        blockValue = 1; //Initialise le block actuel à "vide"
        path = mapPath; //initialise le chemin de fichier de la map donnée
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jFrameSize = new javax.swing.JFrame();
        jLabelWidth = new javax.swing.JLabel();
        jLabelHeight = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jTextFieldWidth = new javax.swing.JTextField();
        jTextFieldHeight = new javax.swing.JTextField();
        jFileChooserMap = new javax.swing.JFileChooser();
        jFileSaverMap = new javax.swing.JFileChooser();
        JMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemSaveAs = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemMenu = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuTile = new javax.swing.JMenu();
        jMenuItemTileBlock = new javax.swing.JMenuItem();
        jMenuItemTileEmpty = new javax.swing.JMenuItem();
        jMenuItemTileBeginning = new javax.swing.JMenuItem();

        jFrameSize.setTitle("Taille");
        jFrameSize.setAlwaysOnTop(true);
        jFrameSize.setLocation(SystemInfo.getScreenDimension.width/2-62, SystemInfo.getScreenDimension.height/2-110);
        jFrameSize.setPreferredSize(new java.awt.Dimension(220, 155));
        jFrameSize.setResizable(false);
        jFrameSize.setSize(new java.awt.Dimension(220, 155));
        jFrameSize.setType(java.awt.Window.Type.UTILITY);

        jLabelWidth.setText("Largeur");

        jLabelHeight.setText("Hauteur");

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SizeOk(evt);
            }
        });

        jButtonBack.setText("Retour");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToEddytor(evt);
            }
        });

        javax.swing.GroupLayout jFrameSizeLayout = new javax.swing.GroupLayout(jFrameSize.getContentPane());
        jFrameSize.getContentPane().setLayout(jFrameSizeLayout);
        jFrameSizeLayout.setHorizontalGroup(
            jFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameSizeLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonBack)
                    .addGroup(jFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelHeight)
                        .addComponent(jLabelWidth)))
                .addGroup(jFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrameSizeLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldWidth)
                            .addComponent(jTextFieldHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameSizeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOk)
                        .addGap(30, 30, 30))))
        );
        jFrameSizeLayout.setVerticalGroup(
            jFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameSizeLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHeight)
                    .addComponent(jTextFieldHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelWidth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrameSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBack)
                    .addComponent(jButtonOk))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jFileChooserMap.setAcceptAllFileFilterUsed(false);
        jFileChooserMap.setApproveButtonText("Ouvrir");
        jFileChooserMap.setApproveButtonToolTipText("Utiliser cette map pour les tests");
        jFileChooserMap.setCurrentDirectory(new java.io.File(System.getProperty("user.home")+"/Documents"));
        jFileChooserMap.setDialogTitle("Ouvrir une map");
        jFileChooserMap.setFileFilter(FileIO.MapFilter);
        jFileChooserMap.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        jFileChooserMap.setToolTipText("");
        jFileChooserMap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jFileSaverMap.setAcceptAllFileFilterUsed(false);
        jFileSaverMap.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jFileSaverMap.setApproveButtonToolTipText("Enregistrer la Map avec ce fichier");
        jFileSaverMap.setCurrentDirectory(new java.io.File(System.getProperty("user.home")+"/Documents"));
        jFileSaverMap.setDialogTitle("Enregistrer une map");
        jFileSaverMap.setFileFilter(FileIO.MapFilter);
        jFileSaverMap.setToolTipText("");
        jFileSaverMap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMap(evt);
            }
        });
        jMenuFile.add(jMenuItemOpen);
        jMenuFile.add(jSeparator1);

        jMenuItemSave.setText("Enregistrer");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveMap(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);

        jMenuItemSaveAs.setText("Enregistrer sous...");
        jMenuItemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveMapAs(evt);
            }
        });
        jMenuFile.add(jMenuItemSaveAs);
        jMenuFile.add(jSeparator2);

        jMenuItemMenu.setText("Menu principal");
        jMenuItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToMenu(evt);
            }
        });
        jMenuFile.add(jMenuItemMenu);

        JMenuBar.add(jMenuFile);

        jMenuEdit.setText("Editer");

        jMenuTile.setText("Cases");

        jMenuItemTileBlock.setText("Bloc");
        jMenuItemTileBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlockTile(evt);
            }
        });
        jMenuTile.add(jMenuItemTileBlock);

        jMenuItemTileEmpty.setText("Vide");
        jMenuItemTileEmpty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmptyTile(evt);
            }
        });
        jMenuTile.add(jMenuItemTileEmpty);

        jMenuItemTileBeginning.setText("Départ");
        jMenuItemTileBeginning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartingTile(evt);
            }
        });
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
    }// </editor-fold>                        

    private void OpenNewMap(java.awt.event.ActionEvent evt) {                            
        jFrameSize.setVisible(true); //Affiche la sous fenètre pour choisir la taille de la map
    }                           

    private void BackToMenu(java.awt.event.ActionEvent evt) {                            
        new JFrameMainMenu().setVisible(true);
        this.dispose();
    }                           

    private void BackToEddytor(java.awt.event.ActionEvent evt) {                               
        jFrameSize.setVisible(false);
    }                              

    private void SizeOk(java.awt.event.ActionEvent evt) {                        
        try {
            //récupére largeur et hauteur entrées par l'utilisateur
            int width = Integer.parseInt(jTextFieldWidth.getText());
            int height = Integer.parseInt(jTextFieldHeight.getText());
            
            //crée et initialise une map avec des "cases vides" avec ces valeurs
            Integer[][] map = new Integer[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    map[i][j] = 1;
                }
            }
            
            if (gMap != null) { //Si il y a déjà une map ouverte, ouvre une nouvelle instance pour afficher la nouvelle et ferme l'actuelle
                new JFrameEddytor(map, null).setVisible(true);
                this.dispose();
            } else { //Sinon affiche la nouvelle map dans la fenètre actuelle 
                editTable(map);
            }     
            
            jFrameSize.setVisible(false); //referme la fenètre
            
        }catch (NumberFormatException e) {
            System.out.println("Erreur dans la création de map : " + e.getMessage());
            //TODO afficher ça graphiquement, en demandant de réentrer.
        }        
    }                       
    
    //<editor-fold defaultstate="collapsed" desc="Events de changement de bloc actuel">
    private void BlockTile(java.awt.event.ActionEvent evt) {                           
        blockValue = 2;
    }                          

    private void EmptyTile(java.awt.event.ActionEvent evt) {                           
        blockValue = 1;
    }                          

    private void StartingTile(java.awt.event.ActionEvent evt) {                              
        blockValue = 0;
    }                             
    //</editor-fold>
    
    private void OpenMap(java.awt.event.ActionEvent evt) {                         
        int returnVal = jFileChooserMap.showOpenDialog(null);   //Ouvre jFileChooserMap et regarde sur quel bouton il a appuyé
        if (returnVal == JFileChooser.APPROVE_OPTION) {         //Vérifie qe l'utilisateur ait appuyé sur ok
            File chosenMap = jFileChooserMap.getSelectedFile(); //Récupère le fichier choisi par l'utilisateur
            try {
                Integer[][] map = FileIO.readIntegerArrayFile(chosenMap); //Lecture du fichier .map
                path = chosenMap.getAbsolutePath(); //Mise en mémoire du path du fichier
                
                if (gMap != null) { //Si il y a déjà une map ouverte, ouvre une nouvelle instance pour afficher la nouvelle et ferme l'actuelle
                    new JFrameEddytor(map, path).setVisible(true);
                this.dispose();
                } else { //Sinon affiche la nouvelle map dans la fenètre actuelle 
                    editTable(map);
                }
                
            } catch (IOException ex) {
                System.out.println("Problème lors de l'accès au fichier " + chosenMap.getAbsolutePath() + "Erreur : " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("Erreur de classe du fichier sérialisé : " + ex.getMessage());
            }
            
        } else {
            System.out.println("Accès au fichier annulé.");
        }
    }                        

    private void SaveMap(java.awt.event.ActionEvent evt) {                         
        if (path != null && gMap != null) {
            try {
                FileIO.writeIntegerArrayFile(gMap, path);
            } catch (IOException ex) {
                System.out.println("Erreur lors de l'écriture : " + ex.getMessage());
            }
        }
    }                        

    private void SaveMapAs(java.awt.event.ActionEvent evt) {                           
        int returnVal = jFileSaverMap.showSaveDialog(null);   //Ouvre jFileSaverMap et regarde sur quel bouton il a appuyé
        if (returnVal == JFileChooser.APPROVE_OPTION) {         //Vérifie qe l'utilisateur ait appuyé sur ok
            File chosenMap = jFileSaverMap.getSelectedFile(); //Récupère le fichier choisi par l'utilisateur
            if (gMap != null) {
                try {
                    path = chosenMap.getAbsolutePath();
                    if (!".map".equals(path.substring(path.length()-4))) {
                        path += ".map";
                    }
                    FileIO.writeIntegerArrayFile(gMap, path);
                } catch (IOException ex) {
                    System.out.println("Erreur lors de l'écriture : " + ex.getMessage());
                }
            } else {
                System.out.println("Il n'y a rien à enregistrer.");
            }
            
        } else {
            System.out.println("Accès au fichier annulé.");
        }
    }                          

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

    // Variables declaration - do not modify                     
    private javax.swing.JMenuBar JMenuBar;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JFileChooser jFileChooserMap;
    private javax.swing.JFileChooser jFileSaverMap;
    private javax.swing.JFrame jFrameSize;
    private javax.swing.JLabel jLabelHeight;
    private javax.swing.JLabel jLabelWidth;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemMenu;
    private javax.swing.JMenuItem jMenuItemNew;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenuItem jMenuItemSaveAs;
    private javax.swing.JMenuItem jMenuItemTileBeginning;
    private javax.swing.JMenuItem jMenuItemTileBlock;
    private javax.swing.JMenuItem jMenuItemTileEmpty;
    private javax.swing.JMenu jMenuTile;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField jTextFieldHeight;
    private javax.swing.JTextField jTextFieldWidth;
    // End of variables declaration                   
    
    //Map utilisée
    private Integer[][] gMap;

    //Path du fichier édité
    private String path;
    
    //Variable utilisée pour éditer les blocs
    private int blockValue;
    
    //Variables utilisées pour créer la Table.
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEditedMap;
    
    /**
     * Méthode qui utilise un tableau de Integer pour créer et remplir une Table, qui est ensuite affichée pour être modifiée.
     * @param map Integer[][] à afficher à l'écran
     */
    private void editTable(Integer[][] map) {
        
        gMap = map;
        
        int nbLines = map.length;
        int nbColumns = map[0].length;
        
        boolean[] canEdit = new boolean [nbColumns];
        for(int i = 0; i < canEdit.length; i++) {
            canEdit[i] = false;
        }
        
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEditedMap = new javax.swing.JTable();

        //Initialise la Table avec la map pour la remplir, ainsi qu'un String[] qui fait le titre des colonnes.
        jTableEditedMap.setModel(new JFrameEddytor.DefaultTableModelImpl(
            map,
            new String [nbColumns]
        ){
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        
        //<editor-fold defaultstate="collapsed" desc="Code du Scroller, copié du générateur auto de NetBeans">
        jScrollPane2.setViewportView(jTableEditedMap);
        
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
        
        //<editor-fold defaultstate="collapsed" desc="Code de modification lors d'un clic sur une cellule du tableau">
        jTableEditedMap.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                int line = jTableEditedMap.rowAtPoint(evt.getPoint());
                int column = jTableEditedMap.columnAtPoint(evt.getPoint());
                if (line >= 0 && column >= 0) {
                    map[line][column] = blockValue;
                    gMap = map;
                    System.out.println("Click : " + map[line][column] + " en " + (line+1) + ", " + (column+1));
                    jTableEditedMap.setModel(new JFrameEddytor.DefaultTableModelImpl(
                        map,
                        new String [nbColumns]
                    ){
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        }
                    });
                }
            }
        });
        //</editor-fold>
        
    }
    
    private static class DefaultTableModelImpl extends DefaultTableModel {

        public DefaultTableModelImpl(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }
    }
}
