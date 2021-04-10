/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author admin
 */
public class BookRenderer extends JPanel implements ListCellRenderer<Book> {

    private final JLabel NameLabel = new JLabel();
    private final JLabel AuthorLabel = new JLabel();
    private final JLabel YEARLabel = new JLabel();

    public BookRenderer() {
        setLayout(new BorderLayout(5, 5));
        JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(NameLabel);
        panelText.add(AuthorLabel);
        panelText.add(YEARLabel);
        add(NameLabel, BorderLayout.EAST);
        add(AuthorLabel, BorderLayout.WEST);
        add(YEARLabel, BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Book> list, Book value, int index, boolean isSelected, boolean cellHasFocus) {
        NameLabel.setText(value.getName());
        AuthorLabel.setText(value.getAuthor());
        AuthorLabel.setForeground(Color.blue);
        YEARLabel.setText(value.getYEAR()+"");
        NameLabel.setOpaque(true);
        AuthorLabel.setOpaque(true);
        if (isSelected) {
            NameLabel.setBackground(list.getSelectionBackground());
            YEARLabel.setBackground(list.getSelectionBackground());
            AuthorLabel.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else {
            NameLabel.setBackground(list.getBackground());
            AuthorLabel.setBackground(list.getBackground());
            YEARLabel.setBackground(list.getSelectionBackground());
            setBackground(list.getBackground());
        }
        return this;

    }

}
