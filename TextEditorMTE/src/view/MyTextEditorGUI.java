package view;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyTextEditorGUI extends javax.swing.JFrame {

    public MyTextEditorGUI() {
        LookAndFeel();
        initComponents();
        
    }
    
    public void LookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyTextEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyTextEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyTextEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyTextEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public JFileChooser getFilleChoose() {
        return FilleChoose;
    }

    public void setFilleChoose(JFileChooser FilleChoose) {
        this.FilleChoose = FilleChoose;
    }

    public JMenuItem getChangeFontItem() {
        return changeFontItem;
    }

    public void setChangeFontItem(JMenuItem changeFontItem) {
        this.changeFontItem = changeFontItem;
    }

    public JMenuItem getCopyItem() {
        return copyItem;
    }

    public void setCopyItem(JMenuItem copyItem) {
        this.copyItem = copyItem;
    }

    public JMenuItem getCutItem() {
        return cutItem;
    }

    public void setCutItem(JMenuItem cutItem) {
        this.cutItem = cutItem;
    }

    public JMenuItem getExitItem() {
        return exitItem;
    }

    public void setExitItem(JMenuItem exitItem) {
        this.exitItem = exitItem;
    }

    public JMenuItem getFindItem() {
        return findItem;
    }

    public void setFindItem(JMenuItem findItem) {
        this.findItem = findItem;
    }

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public void setjMenu1(JMenu jMenu1) {
        this.jMenu1 = jMenu1;
    }

    public JMenu getjMenu2() {
        return jMenu2;
    }

    public void setjMenu2(JMenu jMenu2) {
        this.jMenu2 = jMenu2;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public JMenuItem getNewItem() {
        return newItem;
    }

    public void setNewItem(JMenuItem newItem) {
        this.newItem = newItem;
    }

    public JMenuItem getOpenItem() {
        return openItem;
    }

    public void setOpenItem(JMenuItem openItem) {
        this.openItem = openItem;
    }

    public JMenuItem getPasteItem() {
        return pasteItem;
    }

    public void setPasteItem(JMenuItem pasteItem) {
        this.pasteItem = pasteItem;
    }

    public JMenuItem getRedoItem() {
        return redoItem;
    }

    public void setRedoItem(JMenuItem redoItem) {
        this.redoItem = redoItem;
    }

    public JMenuItem getReplaceItem() {
        return replaceItem;
    }

    public void setReplaceItem(JMenuItem replaceItem) {
        this.replaceItem = replaceItem;
    }

    public JMenuItem getSaveAsItem() {
        return saveAsItem;
    }

    public void setSaveAsItem(JMenuItem saveAsItem) {
        this.saveAsItem = saveAsItem;
    }

    public JMenuItem getSaveItem() {
        return saveItem;
    }

    public void setSaveItem(JMenuItem saveItem) {
        this.saveItem = saveItem;
    }

    public JMenuItem getSlectAllItem() {
        return slectAllItem;
    }

    public void setSlectAllItem(JMenuItem slectAllItem) {
        this.slectAllItem = slectAllItem;
    }

    public JMenuItem getUndoItem() {
        return undoItem;
    }

    public void setUndoItem(JMenuItem undoItem) {
        this.undoItem = undoItem;
    }
    public static void main(String[] args) {
        new MyTextEditorGUI().setVisible(true);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FilleChoose = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newItem = new javax.swing.JMenuItem();
        openItem = new javax.swing.JMenuItem();
        saveItem = new javax.swing.JMenuItem();
        saveAsItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        slectAllItem = new javax.swing.JMenuItem();
        cutItem = new javax.swing.JMenuItem();
        copyItem = new javax.swing.JMenuItem();
        pasteItem = new javax.swing.JMenuItem();
        undoItem = new javax.swing.JMenuItem();
        redoItem = new javax.swing.JMenuItem();
        findItem = new javax.swing.JMenuItem();
        replaceItem = new javax.swing.JMenuItem();
        changeFontItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Text Editor(MTE)");
        setResizable(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jTextArea1.setSelectionColor(new java.awt.Color(255, 51, 51));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu1.setText("File");

        newItem.setText("New");
        jMenu1.add(newItem);

        openItem.setText("Open");
        jMenu1.add(openItem);

        saveItem.setText("Save");
        jMenu1.add(saveItem);

        saveAsItem.setText("Save as");
        jMenu1.add(saveAsItem);

        exitItem.setText("Exit");
        jMenu1.add(exitItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        slectAllItem.setText("Select all");
        jMenu2.add(slectAllItem);

        cutItem.setText("Cut");
        jMenu2.add(cutItem);

        copyItem.setText("Copy");
        jMenu2.add(copyItem);

        pasteItem.setText("Paste");
        jMenu2.add(pasteItem);

        undoItem.setText("Undo");
        jMenu2.add(undoItem);

        redoItem.setText("Redo");
        jMenu2.add(redoItem);

        findItem.setText("Find");
        jMenu2.add(findItem);

        replaceItem.setText("Replace");
        jMenu2.add(replaceItem);

        changeFontItem.setText("Change Font");
        jMenu2.add(changeFontItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FilleChoose;
    private javax.swing.JMenuItem changeFontItem;
    private javax.swing.JMenuItem copyItem;
    private javax.swing.JMenuItem cutItem;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenuItem findItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem newItem;
    private javax.swing.JMenuItem openItem;
    private javax.swing.JMenuItem pasteItem;
    private javax.swing.JMenuItem redoItem;
    private javax.swing.JMenuItem replaceItem;
    private javax.swing.JMenuItem saveAsItem;
    private javax.swing.JMenuItem saveItem;
    private javax.swing.JMenuItem slectAllItem;
    private javax.swing.JMenuItem undoItem;
    // End of variables declaration//GEN-END:variables
}
