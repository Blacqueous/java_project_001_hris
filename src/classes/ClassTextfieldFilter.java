/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Web Dev
 */
public class ClassTextfieldFilter extends DocumentFilter {

    public DocumentFilter filterText = new DocumentFilter() {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            String text = "";
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isLetter(c) || Character.isWhitespace(c)) {
                    text += c;
                } else if (c == '`') {
                    super.replace(fb, i, i1, String.valueOf(""), as); // Clear string
                }
            }
            super.replace(fb, i, i1, String.valueOf(text), as);
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int i, int i1) throws BadLocationException {
            super.remove(fb, i, i1);
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(fb, i, string, as);
        }

    };

    public DocumentFilter filterTextToUppercase = new DocumentFilter() {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            String text = "";
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isLetter(c) || Character.isWhitespace(c)) {
                    text += String.valueOf(c).toUpperCase();
                } else if (c == '`') {
                    super.replace(fb, i, i1, String.valueOf(""), as);
                }
            }
            super.replace(fb, i, i1, String.valueOf(text), as);
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int i, int i1) throws BadLocationException {
            super.remove(fb, i, i1);
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(fb, i, string, as);
        }

    };

    public DocumentFilter filterTextToLowercase = new DocumentFilter() {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            String text = "";
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isLetter(c) || Character.isWhitespace(c)) {
                    text += String.valueOf(c).toLowerCase();
                } else if (c == '`') {
                    super.replace(fb, i, i1, String.valueOf(""), as);
                }
            }
            super.replace(fb, i, i1, String.valueOf(text), as);
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int i, int i1) throws BadLocationException {
            super.remove(fb, i, i1);
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(fb, i, string, as);
        }

    };

    public DocumentFilter filterTextToUppercaseAndDigit = new DocumentFilter() {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            String text = "";
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)) {
                    text += String.valueOf(c).toUpperCase();
                } else if (c != '`') {
                    super.replace(fb, i, i1, String.valueOf(""), as);
                }
            }
            super.replace(fb, i, i1, String.valueOf(text), as);
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int i, int i1) throws BadLocationException {
            super.remove(fb, i, i1);
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(fb, i, string, as);
        }

    };

    public DocumentFilter filterTextToUppercaseAndDigitOnly = new DocumentFilter() {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            String text = "";
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isLetterOrDigit(c)) {
                    text += String.valueOf(c).toUpperCase();
                } else if (c != '`') {
                    super.replace(fb, i, i1, String.valueOf(""), as);
                }
            }
            super.replace(fb, i, i1, String.valueOf(text), as);
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int i, int i1) throws BadLocationException {
            super.remove(fb, i, i1);
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(fb, i, string, as);
        }

    };

    public DocumentFilter filterDigit = new DocumentFilter() {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            String text = "";
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isDigit(c) || Character.isWhitespace(c)) {
                    text += String.valueOf(c);
                } else if (c == '`') {
                    super.replace(fb, i, i1, String.valueOf(""), as);
                }
            }
            super.replace(fb, i, i1, String.valueOf(text), as);
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int i, int i1) throws BadLocationException {
            super.remove(fb, i, i1);
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(fb, i, string, as);
        }

    };

    public DocumentFilter filterDigitOnly = new DocumentFilter() {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            String text = "";
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isDigit(c)) {
                    text += String.valueOf(c);
                } else if (c == '`') {
                    super.replace(fb, i, i1, String.valueOf(""), as);
                }
            }
            super.replace(fb, i, i1, String.valueOf(text), as);
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int i, int i1) throws BadLocationException {
            super.remove(fb, i, i1);
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(fb, i, string, as);
        }

    };

    public DocumentFilter filterWordsToCapital = new DocumentFilter() {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            String old_ = fb.getDocument().getText(0, fb.getDocument().getLength());
            String new_ = "";
            boolean first = true;
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isLetterOrDigit(c) || Character.isWhitespace(c) || c == '.') {
                    if(i == 0) {
                        // Uppercase first letter.
                        new_ += String.valueOf(c).toUpperCase();
                    } else {
                        if(Character.isWhitespace(old_.charAt(old_.length()-1)) && first) {
                            // Uppercase letters after a space.
                            new_ += String.valueOf(c).toUpperCase();
                            first = false;
                        } else {
                            // Lowercase the rest.
                            new_ += String.valueOf(c).toLowerCase();
                        }
                    }
                } else if (c != '`') {
                    super.replace(fb, i, i1, String.valueOf(""), as);
                }
            }
            super.replace(fb, i, i1, String.valueOf(new_), as);
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int i, int i1) throws BadLocationException {
            super.remove(fb, i, i1);
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(fb, i, string, as);
        }

    };

}
