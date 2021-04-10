/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import view.FindGUI;

/**
 *
 * @author admin
 */
class FindController {

    FindGUI findGUI;

    JButton findNextButton;
    JButton cancelButton;

    ButtonGroup buttonGroup;
    JTextArea textAreaFind;

    JCheckBox matchCaseCheckBox;

    JTextField findTextField;
    ButtonGroup bg;
    JRadioButton upRadioButton;
    JRadioButton downRadioButton;

    ActionListener findNextListener;
    ActionListener cancelListener;
    Thread thread;

    public FindController() {
    }

    public FindController(Frame parent, boolean model, JTextArea textArea) {
        initComponents(parent, model, textArea);
        initEvent();
        initThread();
        findGUI.setVisible(true);
    }

    private void initComponents(Frame parent, boolean model, JTextArea textArea) {
        findGUI = new FindGUI(parent, model);
        findNextButton = findGUI.getFindNextButton();
        cancelButton = findGUI.getCancelButton();
        textAreaFind = textArea;
        findTextField = findGUI.getFindWhatTextField();
        bg = new ButtonGroup();
        upRadioButton = findGUI.getUpRadiobutton();
        downRadioButton = findGUI.getDownRadibutton();
        bg.add(upRadioButton);
        bg.add(downRadioButton);
        upRadioButton.setSelected(true);
        matchCaseCheckBox = findGUI.getMatchCaseCheckBox();

    }

    private void initEvent() {
        findNextListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkInputWord()) {
                    findWord();
                } else {
                    JOptionPane.showMessageDialog(findGUI, "Please enter word you want to find");
                }
            }

            private boolean checkInputWord() {
                if (findTextField.getText().isEmpty()) {
                    return false;
                }
                return true;
            }

            private void findWord() {
                if (upRadioButton.isSelected()) {
                    findForUp();
                }
                if (downRadioButton.isSelected()) {
                    findForDown();
                }
            }

//adadadadadada
            private void findForDown() {
                String a = textAreaFind.getText().trim();
                String b = findTextField.getText().trim();
                int indexOfCurrent = textAreaFind.getSelectionEnd();
                int indexOfSearch = a.indexOf(b, indexOfCurrent);
                if (indexOfSearch != -1) {
                    textAreaFind.setSelectionStart(indexOfSearch);
                    textAreaFind.setSelectionEnd(indexOfSearch + b.length());
                } else {
                    JOptionPane.showMessageDialog(cancelButton, "Can not fint out " + b);
                }
            }

            private void findForUp() {
                try {
                    String b = findTextField.getText().trim();
                    int indexCurrent = textAreaFind.getSelectionStart();
                    String aSub = textAreaFind.getText(0, indexCurrent);
                    int indextSearch = aSub.lastIndexOf(b);
                    if (indextSearch != -1) {
                        textAreaFind.setSelectionStart(indextSearch);
                        textAreaFind.setSelectionEnd(indextSearch + b.length());
                    } else {
                        JOptionPane.showMessageDialog(cancelButton, "Can not fint out " + b);
                    }
                } catch (BadLocationException ex) {
                    JOptionPane.showMessageDialog(cancelButton, ex.getMessage());
                }

            }
        };
        cancelListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findGUI.setVisible(false);
            }
        };
        findNextButton.addActionListener(findNextListener);
        cancelButton.addActionListener(cancelListener);

    }

    private void initThread() {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (findTextField.getText().isEmpty()) {
                            findNextButton.setEnabled(false);
                        } else {
                            findNextButton.setEnabled(true);
                        }
                        Thread.sleep(500);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(findGUI, e.getMessage());
                }

            }

        };
        thread.start();
    }

}
