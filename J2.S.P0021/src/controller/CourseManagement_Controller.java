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
import view.CourseManagementGUI;

/**
 *
 * @author admin
 */
public class CourseManagement_Controller {

    //Screen
    AddCourse_Controller addCourse_Controller;
    DisplayAllCourse_Controller displayAllCourse_Controller;
    SearchCourse_Controller searchCourse_Controller;

    //Declare
    //Button
    JButton AddButton;
    JButton DisplayButton;
    JButton SearchButton;
    JButton ExitButton;

    //GUI
    CourseManagementGUI courseManagementGUI;

    //Event 
    ActionListener ExitsEvent;
    ActionListener AddsEvent;
    ActionListener DisplayEvent;
    ActionListener SearchEvent;

    // List of Course
    ArrayList<Course> ListCourse;

    //Contructor
    public CourseManagement_Controller() {
        ListCourse = new ArrayList<>();
        addCourse_Controller = new AddCourse_Controller(ListCourse);
//        displayAllCourse_Controller = new DisplayAllCourse_Controller(ListCourse);
//        searchCourse_Controller = new SearchCourse_Controller(ListCourse);

        initComponents();
        initEventButton();
        courseManagementGUI.setVisible(true);
       
    }

    public void initEventButton() {
        ExitsEvent = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        //AddButton Function
        AddsEvent = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCourse_Controller.show();
            }
        };
        //Display Button Function
        DisplayEvent = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        //Search Button Function
        SearchEvent = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchCourse_Controller = new SearchCourse_Controller();
            }
        };
        //Add Event into Button
        ExitButton.addActionListener(ExitsEvent);
        AddButton.addActionListener(AddsEvent);
        DisplayButton.addActionListener(DisplayEvent);
        SearchButton.addActionListener(SearchEvent);

    }

    public void initComponents() {
        courseManagementGUI = new CourseManagementGUI();
        AddButton = courseManagementGUI.getAddButton();
        DisplayButton = courseManagementGUI.getDisplayAllButton();
        SearchButton = courseManagementGUI.getSearchCoursebyCodeButton();
        ExitButton = courseManagementGUI.getExitButton();
    }

}
