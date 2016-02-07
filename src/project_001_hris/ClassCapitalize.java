/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_001_hris;

import javax.swing.JTextField;

/**
 *
 * @author egrubellano
 */
public class ClassCapitalize {
    
    public void Capitalize(JTextField txtFld, String strClr) {
        
        String str = txtFld.getText().trim();
        StringBuilder result = new StringBuilder(str.length());    
        String words[] = str.split("\\s+"); // all space found then split it  
        
        if(!str.equals("")) {
        
            for(int i = 0; i < words.length; i++) {
                
                if (i > 0)
                    result.append(" ");
                                
                if(words[i].charAt(0) != ' ')
                    result.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1));
                
            }

            txtFld.setText(strClr);
            txtFld.replaceSelection(result.toString());

        }
                
    }
    
}
