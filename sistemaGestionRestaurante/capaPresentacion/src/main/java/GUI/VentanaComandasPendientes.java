package GUI;

import entidades.Comanda;
import enums.EstadoComanda;
import excepciones.NegocioException;
import interfaces.IComandaBO;
import interfaces.IProductoBO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import manejadoresDeObjetoNegocio.ManejadorObjetosNegocio;

/**
 *
 * @author janot
 */
public class VentanaComandasPendientes extends javax.swing.JFrame {
    IComandaBO comandaBO;
    
    /**
     * Creates new form VentanaComandasPendientes
     */
    public VentanaComandasPendientes() {
        comandaBO = ManejadorObjetosNegocio.crearComandaBO();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelRegresar = new javax.swing.JLabel();
        jLabelComandas = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelHistorialComandas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableComandas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelRegresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegresarMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabelComandas.setFont(new java.awt.Font("Product Sans Infanity", 1, 66)); // NOI18N
        jLabelComandas.setForeground(new java.awt.Color(0, 0, 0));
        jLabelComandas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelComandas.setText("Comandas Pendientes");
        jPanel1.add(jLabelComandas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(69, 71, 75));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHistorialComandas.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
        jLabelHistorialComandas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHistorialComandas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelHistorialComandas.setText("Pendientes");
        jPanel2.add(jLabelHistorialComandas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 320, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 920, 40));

        jTableComandas.setBackground(new java.awt.Color(255, 255, 255));
        jTableComandas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Fecha", "Mesa", "Cliente", "Estado", "Productos", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableComandas);
        if (jTableComandas.getColumnModel().getColumnCount() > 0) {
            jTableComandas.getColumnModel().getColumn(0).setResizable(false);
            jTableComandas.getColumnModel().getColumn(1).setResizable(false);
            jTableComandas.getColumnModel().getColumn(3).setResizable(false);
            jTableComandas.getColumnModel().getColumn(4).setResizable(false);
            jTableComandas.getColumnModel().getColumn(5).setResizable(false);
            jTableComandas.getColumnModel().getColumn(6).setResizable(false);
            jTableComandas.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 920, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegresarMouseClicked

    }//GEN-LAST:event_jLabelRegresarMouseClicked

    
    private void cargarDatosTabla(){
        List<Comanda> comandas = new ArrayList<>();
        try {
            comandas = comandaBO.consultarComandasPendientes();
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelComandas;
    private javax.swing.JLabel jLabelHistorialComandas;
    private javax.swing.JLabel jLabelRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableComandas;
    // End of variables declaration//GEN-END:variables
}
