/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src_class;

import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author egrubellano
 */
public class ClassDateFormatValue {

    public String formatDateToString(JDateChooser datechooser) {
        
        if (datechooser.getDate() == null) {
            return "";
        }
        
        java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = fmt.format(datechooser.getDate());
        
        if (!formattedDate.isEmpty()) {
            return formattedDate;
        } else {
            return "";
        }
        
    }

    public String formatDateToString(Date date, String format) {
        
        java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat(format);
        String formattedDate = fmt.format(date);
        
        if (!formattedDate.isEmpty()) {
            return formattedDate;
        } else {
            return "";
        }
        
    }
    
    public Date formatStringToDate(String dateString) {
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
        Date startDate;
        
        try {
            startDate = df.parse(dateString);
        } catch (ParseException e) {
//            System.out.println(e.getMessage());
            startDate = null;
        }
        
        return startDate;
        
    }

}
