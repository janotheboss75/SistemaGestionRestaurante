package utils;

import enums.EstadoProducto;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Esta clase se usa especificamente en ventanaProductos, y es para habilitar y deshabilitar
 * un producto y que su icono de la tabla cambia de imagen.
 * @author janot
 */
public class EstadoCellRenderer extends DefaultTableCellRenderer {
    private Icon iconoHabilitado;
    private Icon iconoInhabilitado;

    public EstadoCellRenderer(Icon iconoHabilitado, Icon iconoInhabilitado) {
        this.iconoHabilitado = iconoHabilitado;
        this.iconoInhabilitado = iconoInhabilitado;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        JLabel label = new JLabel();

        // Para mantener el fondo si se selecciona
        if (isSelected) {
            label.setOpaque(true);
            label.setBackground(table.getSelectionBackground());
        }

        // Revisa el estado del producto en esa fila
        Object estado = table.getModel().getValueAt(row, 4); // Columna del estado

        if (estado.equals(EstadoProducto.HABILITADO)) {
            label.setIcon(iconoHabilitado);
        } else if (estado.equals(EstadoProducto.INHABILITADO)) {
            label.setIcon(iconoInhabilitado);
        }

        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
}
