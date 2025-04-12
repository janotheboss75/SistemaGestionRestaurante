package utils;

import javax.swing.text.*;

/**
 * Lo que hace esta clase es hacer un bloque en jTextFields, para que nomas
 * reciba como entrada numeros enteros y no texto
 * @author janot
 */
public class SoloEnterosFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {
        if (string.matches("\\d+")) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs)
            throws BadLocationException {
        if (string.matches("\\d*")) {
            super.replace(fb, offset, length, string, attrs);
        }
    }
}

