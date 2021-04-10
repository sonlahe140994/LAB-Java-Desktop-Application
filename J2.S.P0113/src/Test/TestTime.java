/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class TestTime {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy");
        String format = sd.format(date);
        System.out.println(format + " and " + 1900);
        for (int i = 1900; i <= Integer.parseInt(format) ; i++) {
            System.out.println(i+"\t");
        }
    }
}
