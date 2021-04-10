/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import view.ClockGUI;

/**
 *
 * @author admin
 */
public class controller_Clock {

    //declare
    //GUI
    ClockGUI clockGUI;
    //lable
    JLabel ClockLabel;
    //Current Date
    Date dateCurrent;
    //date format
    //Thread time
    Thread t1;
    SimpleDateFormat dateFormat;
    //format of Date
    final String formatDateString = "hh:mm:ss";

    public controller_Clock() {
        initComponents();
        clockGUI.setVisible(true);
        runTime();
    }

    private void initComponents() {
        //connect to GUI
        clockGUI = new ClockGUI();
        ClockLabel = clockGUI.getClockLable();
        // declare form Date
    }

    private void runTime() {
        dateFormat = new SimpleDateFormat(formatDateString);
        t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    dateCurrent = new Date();
                    String dateOutString = null;
                    try {
                        dateOutString = dateFormat.format(dateCurrent);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(clockGUI, "Can't not parse date String");
                    }
                    ClockLabel.setText(dateOutString);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }

        };
        t1.run();
    }

}
