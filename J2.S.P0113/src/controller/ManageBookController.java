/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Object.Book;
import View.ManageBookGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class ManageBookController {

    //ArrayList hold book
    ArrayList<Book> bookArrList = new ArrayList<>();

    //GUI 
    ManageBookGUI manageBookGUI;

    //JTextField Input
    JTextField CodeBookTextField;
    JTextField NameTextField;
    JTextField AuthorTextField;
    JTextField PublisherTextField;

    //JButton
    JButton SaveButton;
    JButton RemoveButton;
    JButton ExitButton;

    //Listener
    ActionListener SaveButtonListener;
    ActionListener RemoveButtonListener;
    ActionListener ExitsButtonListener;

    //Notification String
    final String CODEBOOK_NOTIFICATION = "CODE: You must enter code";
    final String NAME_NOTIFICATION = "Name: You must enter name";
    final String AUTHOR_NOTIFICATION = "Author: You must enter Author";
    final String PUBLISHER_NOTIFICATION = "Publisher: You must enter Publisher";
    String ERROS_STRING = "";

    //ComboBox Input
    JComboBox<String> PublishedYEARComboBox;

    // JCheckBox
    JCheckBox RentCheckBox;

    //JList
    JList<Book> BookList;
    DefaultListModel<Book> BookModel = new DefaultListModel<>();

    //initComponents
    private void initComponents() {
        //Connect to GUI
        manageBookGUI = new ManageBookGUI();
        //JTextField
        CodeBookTextField = manageBookGUI.getCodeBookTextField();
        NameTextField = manageBookGUI.getNameTextField();
        AuthorTextField = manageBookGUI.getAuthorTextField();
        PublisherTextField = manageBookGUI.getPublisherTextField();

        //ComboBox
        PublishedYEARComboBox = manageBookGUI.getPushlishedYEARComboBox();
        //Check Box
        RentCheckBox = manageBookGUI.getForRentCheckBox();
        //Button
        SaveButton = manageBookGUI.getSaveButton();
        RemoveButton = manageBookGUI.getRemoveButton();
        ExitButton = manageBookGUI.getExitsButton();
        //JList 
        BookList = manageBookGUI.getBookList();

        SaveButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkInputIsEmpty()) {
                    NewBook();
                }
            }
        };

        ExitsButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkExitsProgram();
            }

        };
        RemoveButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBook();
            }

        };

        //Button Listener
        SaveButton.addActionListener(SaveButtonListener);
        RemoveButton.addActionListener(RemoveButtonListener);
        ExitButton.addActionListener(ExitsButtonListener);

        BookList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                selectEvent();
            }
        });
    }

    //Contructor
    public ManageBookController() {
        initComponents();
        getTimeComboBox(PublishedYEARComboBox);
        manageBookGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        manageBookGUI.setVisible(true);

    }

    //Check Input is Empty
    private boolean checkInputIsEmpty() {
        if (CodeBookTextField.getText().isEmpty()) {
            ERROS_STRING += CODEBOOK_NOTIFICATION + "\n";
        }
        if (NameTextField.getText().isEmpty()) {
            ERROS_STRING += NAME_NOTIFICATION + "\n";
        }
        if (AuthorTextField.getText().isEmpty()) {
            ERROS_STRING += AUTHOR_NOTIFICATION + "\n";
        }
        if (PublisherTextField.getText().isEmpty()) {
            ERROS_STRING += PUBLISHER_NOTIFICATION + "\n";
        }
        if (!ERROS_STRING.isEmpty()) {
            JOptionPane.showMessageDialog(manageBookGUI, ERROS_STRING, "Notification", JOptionPane.ERROR_MESSAGE);
            ERROS_STRING = "";
            return false;
        } else {
            return true;
        }
    }

    //Create Object Book
    private void NewBook() {
        Book b = createBook();
        if (b == null) {
            JOptionPane.showMessageDialog(manageBookGUI, "Code Book have exits", "Notification", JOptionPane.ERROR_MESSAGE);
        } else {
            bookArrList.add(b);
            BookModel.addElement(b);
            BookList.setModel(BookModel);
            JOptionPane.showMessageDialog(manageBookGUI, "New Book");
        }

    }
//Create Book

    private Book createBook() {
        String CodeString = CodeBookTextField.getText().trim();
        String NameString = NameTextField.getText().trim();
        String AuthorString = AuthorTextField.getText().trim();
        String PublisherString = PublisherTextField.getText().trim();
        int PublisherYEAR = Integer.parseInt(PublishedYEARComboBox.getSelectedItem().toString());
        boolean rent = RentCheckBox.isSelected();
        Book b = new Book(CodeString, NameString, AuthorString, PublisherString, PublisherYEAR, rent);
        if (!checkBookExits(b)) {
            return b;
        }
        return null;
    }

    //Reset Text Field
    private void setTextFieldEmpty() {
        CodeBookTextField.setText(null);
        NameTextField.setText(null);
        AuthorTextField.setText(null);
        PublisherTextField.setText(null);
        PublishedYEARComboBox.setSelectedIndex(0);

    }

    // Check Book exits
    private boolean checkBookExits(Book b) {
        for (Book book : bookArrList) {
            if (book.getCode().equalsIgnoreCase(b.getCode())) {
                return true;
            }
        }
        return false;
    }

    //Set Item for JCombo Box
    private void getTimeComboBox(JComboBox comboBox) {
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy");
        for (int i = Integer.parseInt(sd.format(date)); i > 1900; i--) {
            comboBox.addItem(String.valueOf(i));
        }
    }

    // Check Option Exits
    private void checkExitsProgram() {
        int Option = JOptionPane.showConfirmDialog(manageBookGUI, "Do you want to close this App ? ", "Notification", JOptionPane.OK_CANCEL_OPTION);
        if (Option == JOptionPane.OK_OPTION) {
            manageBookGUI.setVisible(false);
            System.exit(0);
        }
    }

    // Remove Book
    private void removeBook() {
        if (!BookModel.isEmpty()) {
            int i = BookList.getAnchorSelectionIndex();
            if (BookList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(manageBookGUI, "You must select one Course", "Notification", JOptionPane.ERROR_MESSAGE);
            } else {
                BookModel.remove(i);
                if (BookModel.getSize() == i) {
                    BookList.setSelectedIndex(0);
                } else {
                    BookList.setSelectedIndex(i);
                }
            }
        }
    }

    // Display Infor Item Selected
    private void selectEvent() {
        //check list is not empty
        if (!BookModel.isEmpty()) {
            Book b = BookList.getSelectedValue();
            int i = BookList.getSelectedIndex();
            //if book is null after change index,and check i is last index in list
            if (b == null) {
                if (BookModel.getSize() == i) {
                    //get book at first element 
                    b = BookModel.getElementAt(0);
                } else {
                    //get book at next element after remove
                    b = BookModel.getElementAt(i + 1);
                }
            }
            CodeBookTextField.setText(b.getCode());
            NameTextField.setText(b.getName());
            AuthorTextField.setText(b.getAuthor());
            setTimeCombobox(PublishedYEARComboBox, String.valueOf(b.getPublishYEAR()));
            if (b.getForRent() == true) {
                RentCheckBox.setSelected(true);
            } else {
                RentCheckBox.setSelected(false);
            }
        } else {
            CodeBookTextField.setText("");
            NameTextField.setText("");
            PublisherTextField.setText("");
            AuthorTextField.setText("");
            RentCheckBox.setSelected(false);
        }
    }

    //set time for JcomboBox when Object change
    private void setTimeCombobox(JComboBox<String> comboBox, String PublishedYEAR) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (PublishedYEAR.equalsIgnoreCase(comboBox.getItemAt(i))) {
                comboBox.setSelectedIndex(i);
            }
        }
    }
}
