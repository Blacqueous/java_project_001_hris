/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src_class;

import java.sql.*;

public class Class_myDBConnection {

     private static Connection myConnection;

    public Class_myDBConnection() {}

    public static void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            myConnection=DriverManager.getConnection(
                "jdbc:mysql://localhost:1527/project_001_hris","blacqueous", "rubellanoe"
            );
        }
        catch(ClassNotFoundException | SQLException e) {
            System.out.println("Failed to get connection");
            e.printStackTrace();
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
