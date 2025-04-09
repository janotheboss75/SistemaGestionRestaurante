package utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 *
 * @author janot
 */
public class IconCellRenderer extends DefaultTableCellRenderer {
    private Icon icon;

    public IconCellRenderer(Icon icon) {
        this.icon = icon;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
        
        JLabel label = new JLabel(icon);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        if (isSelected) {
            label.setBackground(table.getSelectionBackground());
            label.setOpaque(true);
        }
        
        return label;
    }
}

