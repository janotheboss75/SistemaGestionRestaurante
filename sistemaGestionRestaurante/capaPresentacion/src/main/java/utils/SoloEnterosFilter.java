package utils;

import javax.swing.text.*;

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

