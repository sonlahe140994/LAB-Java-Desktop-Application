/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author admin
 */
public class controller {

    JProgressBar jb;
    progessGUI gUI;
    JLabel jl;
    Thread t1, t2;
    ActionListener buttonExitEvent;
    JButton buttonExit;

    public controller() {
        innitcompoment();
        gUI.setVisible(true);
        iterate();
    }

    private void innitcompoment() {
        gUI = new progessGUI();
        jb = gUI.getjProgressBar1();
        jl = gUI.getjLabel4();
        jb.setStringPainted(true);
        buttonExit = gUI.getjButton1();

        buttonExitEvent = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.stop();
                t2.stop();
            }
        };
        buttonExit.addActionListener(buttonExitEvent);
    }

    private void iterate() {

        t1 = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (i <= 2200) {
                    jb.setValue(i);
                    i += 30;
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        JOptionPane.showMessageDialog(jb, e);
                    }
                }
            }
        };
        t2 = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (i <= 2200) {
                    i += 30;
                    String s = jb.getString();
                    jl.setText("Operation is " + s + "complete");
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }

}
