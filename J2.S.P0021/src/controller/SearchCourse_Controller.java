/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Object.Course;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import view.SearchCourseGUI;

/**
 *
 * @author admin
 */
public class SearchCourse_Controller {

    //Declare
    JTextField CodeTextField;
    JTextField CourseNameTextField;
    JTextField CreditTextField;

    //GUI
    SearchCourseGUI searchCourseGUI;

    //Button
    JButton SearchButton;

    public SearchCourse_Controller() {
        initComponent();
        searchCourseGUI.setVisible(true);
        searchCourseGUI.setDefaultCloseOperation(searchCourseGUI.DISPOSE_ON_CLOSE);
    }

    SearchCourse_Controller(ArrayList<Course> ListCourse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //initComponent
    private void initComponent() {
        searchCourseGUI = new SearchCourseGUI();
        CodeTextField = searchCourseGUI.getCodeTextField();
        CourseNameTextField = searchCourseGUI.getCourseNameTextFIeld();
        CreditTextField = searchCourseGUI.getCreditTextField();
    }

    public static void main(String[] args) {
        SearchCourse_Controller c = new SearchCourse_Controller();
    }
}
