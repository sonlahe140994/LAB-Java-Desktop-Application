/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class ReplaceGUI extends javax.swing.JDialog {

    /**
     * Creates new form ReplaceGUI
     */
    public ReplaceGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        findWhatTextField = new javax.swing.JTextField();
        replaceWithTextField = new javax.swing.JTextField();
        findNextButton = new javax.swing.JButton();
        replaceButton = new javax.swing.JButton();
        replaceAllButton1 = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        matchCaseChecKBox = new javax.swing.JCheckBox();
        wrapAroundCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Find what:");

        jLabel2.setText("Replace with:");

        findNextButton.setText("Find Next");

        replaceButton.setText("Replace");

        replaceAllButton1.setText("Replace All");

        cancelButton.setText("cancel");

        matchCaseChecKBox.setText("Match Case");

        wrapAroundCheckBox.setText("Wrap around");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(findWhatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(replaceWithTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(wrapAroundCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matchCaseChecKBox, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(findNextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(replaceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(replaceAllButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findWhatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findNextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(replaceWithTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(replaceButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(matchCaseChecKBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(wrapAroundCheckBox))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(replaceAllButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JButton getFindNextButton() {
        return findNextButton;
    }

    public void setFindNextButton(JButton findNextButton) {
        this.findNextButton = findNextButton;
    }

    public JTextField getFindWhatTextField() {
        return findWhatTextField;
    }

    public void setFindWhatTextField(JTextField findWhatTextField) {
        this.findWhatTextField = findWhatTextField;
    }

    public JCheckBox getMatchCaseChecKBox() {
        return matchCaseChecKBox;
    }

    public void setMatchCaseChecKBox(JCheckBox matchCaseChecKBox) {
        this.matchCaseChecKBox = matchCaseChecKBox;
    }

    public JButton getReplaceAllButton1() {
        return replaceAllButton1;
    }

    public void setReplaceAllButton1(JButton replaceAllButton1) {
        this.replaceAllButton1 = replaceAllButton1;
    }

    public JButton getReplaceButton() {
        return replaceButton;
    }

    public void setReplaceButton(JButton replaceButton) {
        this.replaceButton = replaceButton;
    }

    public JTextField getReplaceWithTextField() {
        return replaceWithTextField;
    }

    public void setReplaceWithTextField(JTextField replaceWithTextField) {
        this.replaceWithTextField = replaceWithTextField;
    }

    public JCheckBox getWrapAroundCheckBox() {
        return wrapAroundCheckBox;
    }

    public void setWrapAroundCheckBox(JCheckBox wrapAroundCheckBox) {
        this.wrapAroundCheckBox = wrapAroundCheckBox;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton findNextButton;
    private javax.swing.JTextField findWhatTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JCheckBox matchCaseChecKBox;
    private javax.swing.JButton replaceAllButton1;
    private javax.swing.JButton replaceButton;
    private javax.swing.JTextField replaceWithTextField;
    private javax.swing.JCheckBox wrapAroundCheckBox;
    // End of variables declaration//GEN-END:variables
}
