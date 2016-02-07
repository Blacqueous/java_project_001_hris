/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src_class;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author egrubellano
 */
public class ClassCipherVigenere {
    
    static ArrayList letter = new ArrayList();
    
    public static void insertLetters(){
        letter.add(0, "A");
        letter.add(1, "B");
        letter.add(2, "C");
        letter.add(3, "D");
        letter.add(4, "E");
        letter.add(5, "F");
        letter.add(6, "G");
        letter.add(7, "H");
        letter.add(8, "I");
        letter.add(9, "J");
        letter.add(10, "K");
        letter.add(11, "L");
        letter.add(12, "M");
        letter.add(13, "N");
        letter.add(14, "O");
        letter.add(15, "P");
        letter.add(16, "Q");
        letter.add(17, "R");
        letter.add(18, "S");
        letter.add(19, "T");
        letter.add(20, "U");
        letter.add(21, "V");
        letter.add(22, "W");
        letter.add(23, "X");
        letter.add(24, "Y");
        letter.add(25, "Z");
    }
    
    public static String getLetter(int number) {
        if(number < 0) {
            number = number * -1;
        }
        return letter.get(number).toString();
    }
    
    public static int getNumber(String alphabet) {
        return letter.indexOf(alphabet.toUpperCase());
    }
    
    public static String encrypt(String pwd, String key){
        
        // Check strings
        if(pwd.isEmpty() || key.isEmpty()) {
            return "";
        }
        
        // Setup letters
        insertLetters();
        
        int keyCount = 0;
        char[] stringToReturn = new char[pwd.length()];
        
        for (int i = 0; i < pwd.length(); i++) {
            
            if(!Character.isLetter(key.charAt(keyCount))) {
                if((key.length()-1) == keyCount) {
                    keyCount = 0;
                } else {
                    while(!Character.isLetter(key.charAt(keyCount))) {
                        if((key.length()-1) == keyCount) {
                            keyCount = 0;
                        } else {
                            keyCount++;
                        }
                    }
                }
            }
            
            int pwdInt = getNumber(Character.toString(pwd.toUpperCase().charAt(i)));
            int keyInt = getNumber(Character.toString(key.toUpperCase().charAt(keyCount)));
            
            if((key.length()-1) == keyCount) {
                keyCount = 0;
            } else {
                keyCount++;
            }
            
            int total = (pwdInt + keyInt) % 26;
            String result = getLetter(total);
            
            if(isUpperCase(pwd.charAt(i))) {
                stringToReturn[i] = result.toUpperCase().charAt(0);
            } else if(isLowerCase(pwd.charAt(i))) {
                stringToReturn[i] = result.toLowerCase().charAt(0);
            } else {
                stringToReturn[i] = pwd.charAt(i);
            }
            
        }
        
        return new String(stringToReturn);
    }
    
    public static String decrypt(String pwd, String key){
        
        // Check strings
        if(pwd.isEmpty() || key.isEmpty()) {
            return "";
        }
        
        // Setup letters
        insertLetters();
        
        int keyCount = 0;
        char[] stringToReturn = new char[pwd.length()];
        
        for (int i = 0; i < pwd.length(); i++) {
            
            if(!Character.isLetter(key.charAt(keyCount))) {
                if((key.length()-1) == keyCount) {
                    keyCount = 0;
                } else {
                    while(!Character.isLetter(key.charAt(keyCount))) {
                        if((key.length()-1) == keyCount) {
                            keyCount = 0;
                        } else {
                            keyCount++;
                        }
                    }
                }
            }
            
            int pwdInt = getNumber(Character.toString(pwd.toUpperCase().charAt(i)));
            int keyInt = getNumber(Character.toString(key.toUpperCase().charAt(keyCount)));
            
            int total = (pwdInt - keyInt) % 26;
            
            if(keyInt > pwdInt) {
                total = 26 - (keyInt - pwdInt);
            }
            
            String result = getLetter(total);
            
            if(isUpperCase(pwd.charAt(i))) {
                stringToReturn[i] = result.toUpperCase().charAt(0);
            } else if(isLowerCase(pwd.charAt(i))) {
                stringToReturn[i] = result.toLowerCase().charAt(0);
            } else {
                stringToReturn[i] = pwd.charAt(i);
            }
            
            if((key.length()-1) == keyCount) {
                keyCount = 0;
            } else {
                keyCount++;
            }
            
        }
        
        return new String(stringToReturn);
    }
    
    static boolean isLowerCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    static boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
    
    public static void main(String[] args) {
        
        final JTextField txtfldStr = new JTextField();
        final JTextField txtfldKey = new JTextField();
        final JTextField txtfldRes = new JTextField();
        txtfldRes.setEditable(false);
        
        Object[] message = {
            "Text to Hide:", txtfldStr,
            "Text Key:", txtfldKey,
            "Result:", txtfldRes
        };
        
        JButton btnEncrpyt = new JButton("Encrypt");
        JButton btnDecrpyt = new JButton("Decrpyt");
        
        btnEncrpyt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtfldRes.setText(encrypt(txtfldStr.getText(), txtfldKey.getText()));
            }
        });
        
        btnDecrpyt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtfldRes.setText(decrypt(txtfldStr.getText(), txtfldKey.getText()));
            }
        });
        
        JOptionPane.showOptionDialog( null,
                                      message,
                                      "Vigenère Cipher",
                                      JOptionPane.YES_NO_OPTION,
                                      JOptionPane.WARNING_MESSAGE,
                                      null,
                                      new Object[]{btnEncrpyt, btnDecrpyt},
                                      btnEncrpyt
                                    );
        
    }

}
