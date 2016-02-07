/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project_001_hris;

import java.sql.*;
import javax.swing.JOptionPane;

public class ClassMyDBConnectionSQL {

     private static Connection myConnection;

    public ClassMyDBConnectionSQL() {}

    public static void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            myConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hris","root", "root"
            );
        }
        catch(ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static Connection getMyConnection() {
        return myConnection;
    }

    public static void close(ResultSet rs) {
        if( rs !=null ) {
            try {
               rs.close();
            }
            catch(Exception e) {}
        }
    }

     public void close(java.sql.Statement stmt){
        if( stmt !=null ){
            try {
               stmt.close();
            }
            catch(Exception e) {}
        }
    }

    public void destroy() {
        if ( myConnection!=null ) {
            try {
                myConnection.close();
            }
            catch(Exception e) {}
        }
    }
}
