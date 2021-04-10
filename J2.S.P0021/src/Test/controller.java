/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class controller {

    Frame1 f1;
    Frame2 f2;
    WindowListener wl;

    public controller() {
        Run();
    }

    public void Run() {
        f1 = new Frame1();
        f2 = new Frame2();
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
        f1.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f2.setVisible(true);
            }
        });
        f2.getjButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(false);
            }
        });
        wl = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f1.getText1().setText("Win");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                f1.getText1().setText("Win");
            }

        };
        f2.addWindowListener(wl);
    }
}
