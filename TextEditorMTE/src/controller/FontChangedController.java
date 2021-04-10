/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import view.FontChanged;
import view.MyTextEditorGUI;

/**
 *
 * @author admin
 */
public class FontChangedController {

    final String[] font = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    final String[] style = {"Plain", "Italic", "Bold", "Bold Italic"};

    FontChanged fontChangedGUI;

    JTextField fontTextField;
    JTextField styleTextField;
    JTextField sizeTextField;

    JLabel sampleLabel;
    JButton okButton;
    JButton cancelButton;

    JComboBox<String> scriptComboBox;

    JList<String> fontList;
    JList<String> styleList;
    JList<String> sizeList;

    MouseAdapter mouseFontEvent;
    MouseAdapter mouseStyleEvent;
    MouseAdapter mouseSizeEvent;

    ActionListener okActionListener;
    ActionListener cancelActionListener;

    JTextArea textAreaFont;

    public FontChangedController(MyTextEditorGUI GUI, JTextArea textAre) {
        initComponents(GUI, textAre);
        initListActionPerform();
        fontChangedGUI.setVisible(true);
    }

    private void initComponents(MyTextEditorGUI GUI, JTextArea textArea) {
        fontChangedGUI = new FontChanged(GUI, true);

        fontTextField = fontChangedGUI.getFontTextField();
        styleTextField = fontChangedGUI.getStyeTextField();
        sizeTextField = fontChangedGUI.getSizeTextField();

        fontList = fontChangedGUI.getFontList();
        styleList = fontChangedGUI.getStyleList();
        sizeList = fontChangedGUI.getSizeList();
        sampleLabel = fontChangedGUI.getSampleLabel();
        scriptComboBox = fontChangedGUI.getScriptComBoBox();
        okButton = fontChangedGUI.getOkButton();
        cancelButton = fontChangedGUI.getCancelButton();
        textAreaFont = textArea;

        okActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFont();
            }

            private void changeFont() {
                Font f = sampleLabel.getFont();
                textAreaFont.setFont(f);
                cancelButton.doClick();
            }
        };
        cancelActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontChangedGUI.setVisible(false);
            }
        };
        okButton.addActionListener(okActionListener);
        cancelButton.addActionListener(cancelActionListener);
    }

    private void initListActionPerform() {
        fontList.setListData(font);
        styleList.setListData(style);
        sizeList.setListData(getSize());

        mouseFontEvent = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String values = fontList.getSelectedValue();
                fontTextField.setText(values);
                styleList.setFont(new Font(values, Font.PLAIN, 13));
                sampleLabel.setFont(new Font(values, Font.PLAIN, 13));
            }
        };
        mouseStyleEvent = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String Fontvalues = fontList.getSelectedValue();
                int styleFont = parseStyle(styleList.getSelectedValue());
                styleTextField.setText(styleList.getSelectedValue());
                sampleLabel.setFont(new Font(Fontvalues, styleFont, 13));
            }
        };
        mouseSizeEvent = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String Fontvalues = fontList.getSelectedValue();
                int styleFont = parseStyle(styleList.getSelectedValue());
                String sizeValues = sizeList.getSelectedValue();
                sizeTextField.setText(sizeValues);
                sampleLabel.setFont(new Font(Fontvalues, styleFont, parseSize(sizeValues)));
            }

        };
        fontList.addMouseListener(mouseFontEvent);
        styleList.addMouseListener(mouseStyleEvent);
        sizeList.addMouseListener(mouseSizeEvent);

        fontTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fintFont();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fintFont();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                fintFont();
            }

            private void fintFont() {
                String nameOfFont = fontTextField.getText().trim();
                if (!nameOfFont.isEmpty()) {
                    for (String s : font) {
                        if (nameOfFont.equalsIgnoreCase(s) || s.toLowerCase().contains(nameOfFont.toLowerCase())) {
                            fontList.setSelectedValue(s, true);
                        } else {
                            fontList.setSelectedIndex(-1);
                        }
                    }
                }

            }
        });

    }

    private int parseStyle(String styeValues) {
        if (styeValues.equalsIgnoreCase("plain")) {
            return Font.PLAIN;
        }
        if (styeValues.equalsIgnoreCase("italic")) {
            return Font.ITALIC;
        }
        if (styeValues.equalsIgnoreCase("bold")) {
            return Font.BOLD;
        }
        if (styeValues.equalsIgnoreCase("Bold Italic")) {
            return Font.BOLD + Font.ITALIC;
        }
        return 0;

    }

    private int parseSize(String sizeName) {
        try {
            int size = Integer.parseInt(sizeName);
            if (size > 0) {
                return size;
            } else {
                return 8;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(fontChangedGUI, "You must input number in size");
        }
        return 0;
    }

    private String[] getSize() {
        String[] size = new String[72];
        for (int i = 8; i < 72; i++) {
            size[i - 7] = i + "";
        }
        return size;
    }

}
