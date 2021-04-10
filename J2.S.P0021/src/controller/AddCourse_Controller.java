/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Object.Course;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.AddCoursesGUI;

/**
 *
 * @author admin
 */
public class AddCourse_Controller {

    //Declare
    CourseManagement_Controller courseManagement_Controller;
    //Input By TextField
    JTextField CodeTextField;
    JTextField NameTextField;
    JTextField CreditTextField;

    //Button 
    JButton AddButton;
    JButton ClearButton;

    //GUI
    AddCoursesGUI addCoursesGUI;

    //Action Button
    ActionListener AddListener;
    ActionListener ClearListener;
    //

    ArrayList<Course> courses;
    public AddCourse_Controller() {
        
    }

    AddCourse_Controller(ArrayList<Course> ListCourse) {
        courses = ListCourse;
        initComponents();
    }

    private void initComponents() {
        addCoursesGUI = new AddCoursesGUI();
        CodeTextField = addCoursesGUI.getCodeTextField();
        NameTextField = addCoursesGUI.getNameTextField();
        CreditTextField = addCoursesGUI.getCreditTextField();
        AddButton = addCoursesGUI.getAddButton();
        ClearButton = addCoursesGUI.getClearButton();

        AddListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddButton();
            }
        };
        AddButton.addActionListener(AddListener);

    }

    private void AddButton() {
        if (checkTextFieldEmpty()) {
            JOptionPane.showMessageDialog(addCoursesGUI, "You must Enter Data", "Notification", JOptionPane.ERROR_MESSAGE);
        } else {
            addCourseToList();
        }
        clearTextField();
    }

    private boolean checkTextFieldEmpty() {
        if (CodeTextField.getText().isEmpty()
                || NameTextField.getText().isEmpty()
                || CreditTextField.getText().isEmpty()) {
            return true;
        }
        return false;
    }


    private void clearTextField() {
        CodeTextField.setText(null);
        NameTextField.setText(null);
        CreditTextField.setText(null);
    }

    private void addCourseToList() {
//        courses.add(new Course(Code, Name, 0));
    }

    void show() {
        addCoursesGUI.setVisible(true);
    }

}
