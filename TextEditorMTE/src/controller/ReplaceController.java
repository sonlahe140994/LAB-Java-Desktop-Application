/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import view.MyTextEditorGUI;
import view.ReplaceGUI;

/**
 *
 * @author admin
 */
public class ReplaceController {

    ReplaceGUI replaceGUI;

    JButton cancelButton;
    JButton findNextButton;
    JButton replaceButton;
    JButton replaceAllButton;

    JCheckBox matchCaseCheckBox;
    JCheckBox wrapAroundCheckBox;

    JTextArea textAreaReplace;

    JTextField findWhatTextField;
    JTextField replaceWithTextField;

    ActionListener cancelActionListener;
    ActionListener findNextActionListener;
    ActionListener replaceActionListener;
    ActionListener replaceAllActionListener;

    int indexOfPos;
    Thread thread;

    public ReplaceController() {
    }

    ReplaceController(MyTextEditorGUI textEditorGUI, boolean b, JTextArea textArea) {
        initComponents(textEditorGUI, textArea);
        initThread();
        initEvent();
        replaceGUI.setVisible(true);
    }

    private void initComponents(MyTextEditorGUI textEditorGUI, JTextArea textArea) {
        replaceGUI = new ReplaceGUI(textEditorGUI, true);
        cancelButton = replaceGUI.getCancelButton();
        findNextButton = replaceGUI.getFindNextButton();
        replaceButton = replaceGUI.getReplaceButton();
        replaceAllButton = replaceGUI.getReplaceAllButton1();
        textAreaReplace = textArea;
        findWhatTextField = replaceGUI.getFindWhatTextField();
        replaceWithTextField = replaceGUI.getReplaceWithTextField();
        matchCaseCheckBox = replaceGUI.getMatchCaseChecKBox();
        wrapAroundCheckBox = replaceGUI.getWrapAroundCheckBox();
    }

    private void initEvent() {
        cancelActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceGUI.setVisible(false);
            }
        };
        findNextActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findNext();
            }

            private void findNext() {
                findForDown();
            }

        };
        replaceActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceIndex();
            }

            private void replaceIndex() {
                if (findForDown()) {
                    indexOfPos = textAreaReplace.getSelectionStart();
                    String findWhat = findWhatTextField.getText().trim();
                    String replaceWith = replaceWithTextField.getText().trim();
                    int sizeOfSubString = replaceWith.length();
                    textAreaReplace.replaceRange(replaceWith, indexOfPos, indexOfPos + sizeOfSubString);
                    textAreaReplace.setSelectionStart(indexOfPos);
                    textAreaReplace.setSelectionEnd(indexOfPos + sizeOfSubString);
                } else {
                    JOptionPane.showMessageDialog(replaceGUI, "Can't replace " + replaceWithTextField.getText().trim());
                }

            }
        };
        replaceAllActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceAll();
            }

            private void replaceAll() {
                String taString = textAreaReplace.getText().trim();
                String replaceWith = replaceWithTextField.getText().trim();
                String regexFind = findWhatTextField.getText().trim();
                if (matchCaseCheckBox.isSelected()) {
                    taString = taString.toLowerCase();
                    regexFind = regexFind.toLowerCase();
                }
                String afterReplace = taString.replaceAll(regexFind, replaceWith);
                textAreaReplace.setText(afterReplace);
            }
        };
        cancelButton.addActionListener(cancelActionListener);
        findNextButton.addActionListener(findNextActionListener);
        replaceButton.addActionListener(replaceActionListener);
        replaceAllButton.addActionListener(replaceAllActionListener);
    }

    private void initThread() {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (findWhatTextField.getText().isEmpty()) {
                            findNextButton.setEnabled(false);
                            replaceButton.setEnabled(false);
                            replaceAllButton.setEnabled(false);
                        } else {
                            findNextButton.setEnabled(true);
                            replaceButton.setEnabled(true);
                            replaceAllButton.setEnabled(true);
                        }
                        Thread.sleep(300);
                    }
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(replaceGUI, e.getMessage());
                }

            }
        };
        thread.start();
    }

    private boolean findForDown() {
        indexOfPos = textAreaReplace.getSelectionStart();
        String taString = textAreaReplace.getText().trim();
        String subTaString = findWhatTextField.getText();
        if (!matchCaseCheckBox.isSelected()) {
            taString = taString.toLowerCase();
            subTaString = subTaString.toLowerCase();
        }
        int sizeOfSub = subTaString.length();
        indexOfPos = taString.indexOf(subTaString, indexOfPos + 1);
        if (wrapAroundCheckBox.isSelected()) {
            if (indexOfPos == -1) {
                indexOfPos = taString.indexOf(subTaString);
            }
        } else {
            if (indexOfPos == -1) {
                JOptionPane.showMessageDialog(replaceGUI, "Can't not find out " + subTaString);
                return false;
            }
        }
        textAreaReplace.setSelectionStart(indexOfPos);
        textAreaReplace.setSelectionEnd(indexOfPos + sizeOfSub);
        return true;
    }
}
