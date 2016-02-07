/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src_class;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author egrubellano
 */
public class Class_combobox_get_value {

    private int rtrn = 0;

    public Integer getId(String table, String where) {
        
        try {
            Class_myDBConnectionEmbeddedDerby.initDB();
            Connection conn = Class_myDBConnectionEmbeddedDerby.getMyConnection();
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id FROM " + table + " WHERE upper(name) = '" + where.toUpperCase().trim() + "'");
            ResultSetMetaData rsm = rs.getMetaData();
            
            while (rs.next()) {
                rtrn = rs.getInt(1);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        return rtrn;
        
    }
    
}
