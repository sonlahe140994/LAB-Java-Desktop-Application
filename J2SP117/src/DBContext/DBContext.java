/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBContext;

/**
 *
 * @author admin
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    /*Insert your other code right after this comment*/
 /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "DESKTOP-T36V0QP\\LEANHSON";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "12345678";

    public static void main(String[] args) throws Exception {
        DBContext db = new DBContext();

        Connection c = db.getConnection();
        if (c != null) {
            System.out.println("Win");
            c.close();
            if (c != null) {
                System.out.println("Da Dong Connection");
            } else {
                System.out.println("Chua dong Connection");
            }
        } else {
            System.out.println("Lose");
        }

    }
}
