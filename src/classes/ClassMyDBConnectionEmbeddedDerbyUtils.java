/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author egrubellano
 */
public class ClassMyDBConnectionEmbeddedDerbyUtils {

    public ClassMyDBConnectionEmbeddedDerbyUtils() {
        //empty constructor -- helper class
    }

    public static boolean tableAlreadyExists(SQLException e) {
        boolean exists;
        exists = e.getSQLState().equals("X0Y32");
        return exists;
    }

    public static boolean uniqueAlreadyExists(SQLException e) {
        boolean exists = false;
        if(e.getSQLState().equals("23505") && e.getErrorCode() == 30000){
            exists = true;
        }
        return exists;
    }

}
