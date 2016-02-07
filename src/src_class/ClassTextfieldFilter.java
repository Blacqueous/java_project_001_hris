/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src_class;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Web Dev
 */
public class ClassTextfieldFilter extends DocumentFilter {

    DocumentFilter TextFieldFilterString = new DocumentFilter() {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isLetter(c) || c == ' ') {
                    super.replace(fb, i, i1, String.valueOf(c), as);
                } else if (Character.isAlphabetic(c) || c == '`') {
                    super.replace(fb, i, i1, String.valueOf(""), as);
                }
            }
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

    DocumentFilter TextFieldFilterInteger = new DocumentFilter() {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isDigit(c) || c == ' ') {
                    super.replace(fb, i, i1, String.valueOf(c), as);
                } else if (Character.isAlphabetic(c) || c == '`') {
                    super.replace(fb, i, i1, String.valueOf(""), as);
                }
            }
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

    DocumentFilter TextFieldFilterStringAndInteger = new DocumentFilter() {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isLetterOrDigit(c)) {
                    super.replace(fb, i, i1, String.valueOf(c).toUpperCase(), as);
                } else if (Character.isLetterOrDigit(c) || c != '`') {
                    super.replace(fb, i, i1, String.valueOf("").toUpperCase(), as);
                }
            }
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

    DocumentFilter TextFieldFilterStringIntegerAndSpace = new DocumentFilter() {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isLetterOrDigit(c) || c == ' ') {
                    super.replace(fb, i, i1, String.valueOf(c).toUpperCase(), as);
                } else if (Character.isLetterOrDigit(c) || c != '`') {
                    super.replace(fb, i, i1, String.valueOf("").toUpperCase(), as);
                }
            }
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
