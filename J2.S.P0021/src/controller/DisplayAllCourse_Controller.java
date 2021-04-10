/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Object.Course;
import java.util.ArrayList;
import javax.swing.JTextArea;
import view.ListCourseGUI;

/**
 *
 * @author admin
 */
public class DisplayAllCourse_Controller {

    static void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //Declare 

    // GUI
    ListCourseGUI listCourseGUI;

    //text Area
    JTextArea listCourseTextArea;

    public DisplayAllCourse_Controller() {
        initComponent();
        listCourseGUI.setVisible(true);
        listCourseGUI.setDefaultCloseOperation(listCourseGUI.DISPOSE_ON_CLOSE);
    }

    DisplayAllCourse_Controller(ArrayList<Course> ListCourse) {
    }

    //initComponent
    public void initComponent() {
        listCourseGUI = new ListCourseGUI();
        listCourseTextArea = listCourseGUI.getLOACTextArea();
    }

    public static void main(String[] args) {
        DisplayAllCourse_Controller c = new DisplayAllCourse_Controller();
    }
}
