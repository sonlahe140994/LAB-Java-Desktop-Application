/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Object.Book;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author admin
 */
public class BookRenderer extends JPanel implements ListCellRenderer<Book> {

    ManageBookController manageBookController = new ManageBookController();

    private final JLabel CodeLable = new JLabel();
    private final JLabel Name = new JLabel();
    private final JLabel Author = new JLabel();
    private final JLabel Publisher = new JLabel();
    private final JComboBox PublishedYEARComboBox = new JComboBox();
    private final JCheckBox RentCheckBox = new JCheckBox();

    public BookRenderer() {
        JPanel Panel = new JPanel(new GridLayout(0, 1));
        Panel.add(CodeLable);
        add(CodeLable, BorderLayout.WEST);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Book> list, Book value, int index, boolean isSelected, boolean cellHasFocus) {
        Name.setText(value.getName());
        Name.setForeground(Color.red);
        if (isSelected) {
            Name.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
            /*manageBookController.CodeBookTextField.setText(value.getCode());
            manageBookController.NameTextField.setText(value.getName());
            manageBookController.AuthorTextField.setText(value.getAuthor());
            manageBookController.PublisherTextField.setText(value.getPublisher());
            manageBookController.PublishedYEARComboBox
             */
        } else {
            Name.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }
        return this;
    }

}
