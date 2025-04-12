package GUI;

import entidades.Ingrediente;
import enums.UnidadDeMedida;
import excepciones.NegocioException;
import interfaces.IIngredienteBO;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import manejadoresDeObjetoNegocio.ManejadorObjetosNegocio;
import utils.SoloEnterosFilter;
import utils.SoloFiltroNumerico;

/**
 *
 * @author janot
 */
public class VentanaIngredienteNuevo extends javax.swing.JDialog {
    private Control control = new Control();
    private IIngredienteBO ingredienteBO;
    private VentanaIngredientes ventana;
    /**
     * Creates new form VentanaIngredienteNuevo
     */
    public VentanaIngredienteNuevo(VentanaIngredientes ventana, boolean modal) {
        super(ventana, modal);
        ingredienteBO = ManejadorObjetosNegocio.crearIngredienteBO();
        this.ventana = ventana;
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
        jLabelProductoNuevo2 = new javax.swing.JLabel();
        jLabelProductoNuevo3 = new javax.swing.JLabel();
        jLabelIconCerrar = new javax.swing.JLabel();
        jTextFieldStock = new javax.swing.JTextField();
        jComboBoxUnidadDeMedida = new javax.swing.JComboBox<>();
        jLabelProductoNuevo4 = new javax.swing.JLabel();
        jLabelProductoNuevo5 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelProductoNuevo6 = new javax.swing.JLabel();
        jPanelCrear = new GUI.PanelRound();
        jLabelCrear = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProductoNuevo2.setFont(new java.awt.Font("Product Sans Infanity", 0, 14)); // NOI18N
        jLabelProductoNuevo2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProductoNuevo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductoNuevo2.setText("Stock");
        jPanel1.add(jLabelProductoNuevo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jLabelProductoNuevo3.setFont(new java.awt.Font("Product Sans Infanity", 1, 36)); // NOI18N
        jLabelProductoNuevo3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProductoNuevo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductoNuevo3.setText("Ingrediente");
        jPanel1.add(jLabelProductoNuevo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 230, -1));

        jLabelIconCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cross-small.png"))); // NOI18N
        jLabelIconCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelIconCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconCerrarMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelIconCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 60, 50));

        jTextFieldStock.setBackground(new java.awt.Color(255, 255, 255));
        ((AbstractDocument) jTextFieldStock.getDocument()).setDocumentFilter(new SoloEnterosFilter());
        jPanel1.add(jTextFieldStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 170, 30));

        jComboBoxUnidadDeMedida.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxUnidadDeMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new UnidadDeMedida[] { UnidadDeMedida.PIEZAS, UnidadDeMedida.GRAMOS, UnidadDeMedida.MILILITROS}));
        jComboBoxUnidadDeMedida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxUnidadDeMedidaItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxUnidadDeMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 120, 30));

        jLabelProductoNuevo4.setFont(new java.awt.Font("Product Sans Infanity", 1, 36)); // NOI18N
        jLabelProductoNuevo4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProductoNuevo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductoNuevo4.setText("Nuevo");
        jPanel1.add(jLabelProductoNuevo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 230, -1));

        jLabelProductoNuevo5.setFont(new java.awt.Font("Product Sans Infanity", 0, 14)); // NOI18N
        jLabelProductoNuevo5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProductoNuevo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductoNuevo5.setText(" Nombre ");
        jPanel1.add(jLabelProductoNuevo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jTextFieldNombre.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 170, 30));

        jLabelProductoNuevo6.setFont(new java.awt.Font("Product Sans Infanity", 0, 14)); // NOI18N
        jLabelProductoNuevo6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProductoNuevo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductoNuevo6.setText("Unidad de Medida");
        jPanel1.add(jLabelProductoNuevo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jPanelCrear.setBackground(new java.awt.Color(44, 44, 44));
        jPanelCrear.setRoundBottomLeft(15);
        jPanelCrear.setRoundBottomRight(15);
        jPanelCrear.setRoundTopLeft(15);
        jPanelCrear.setRoundTopRight(15);
        jPanelCrear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCrear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCrear.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCrear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCrear.setText("Añadir");
        jLabelCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCrearMouseClicked(evt);
            }
        });
        jPanelCrear.add(jLabelCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 30));

        jPanel1.add(jPanelCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 404));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelIconCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconCerrarMouseClicked
        control.cerrarDialogo(this);
    }//GEN-LAST:event_jLabelIconCerrarMouseClicked

    private void jLabelCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCrearMouseClicked
        agregarIngrediente();
        ventana.asignarIngredientesALista();
        ventana.cargarDatosTabla();
    }//GEN-LAST:event_jLabelCrearMouseClicked

    private void jComboBoxUnidadDeMedidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxUnidadDeMedidaItemStateChanged
        cambiarEstadojTextFieldStock();
    }//GEN-LAST:event_jComboBoxUnidadDeMedidaItemStateChanged

    
    private void agregarIngrediente(){
        System.out.println(jTextFieldNombre.getText());
        if(jTextFieldNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo Nombre esta vacio");
        }
        else if(jTextFieldStock.getText().isEmpty() || jTextFieldStock.getText().trim() == "." ){
            JOptionPane.showMessageDialog(this, "Tienes que agregarle un stock");
        }
        else{
            String nombre = jTextFieldNombre.getText();
            UnidadDeMedida unidadDeMedida = (UnidadDeMedida) jComboBoxUnidadDeMedida.getSelectedItem();
            Double cantidad = Double.parseDouble(jTextFieldStock.getText());
           
            Long cantidadNombresRepetidos = 0L;
            
            try {
                cantidadNombresRepetidos = ingredienteBO.obtenerNombresRepetidosDeProducto(jTextFieldNombre.getText());
                if(cantidadNombresRepetidos == 0){
                    ingredienteBO.agregarIngredienteAlInventario(new Ingrediente(nombre, unidadDeMedida, cantidad));
                    control.cerrarDialogo(this);
                }
                else{
                    JOptionPane.showMessageDialog(this, "El ingrediene ya existe");
                }
                
            } catch (NegocioException | HeadlessException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        
    }
    
    public void cambiarEstadojTextFieldStock(){
        if(jComboBoxUnidadDeMedida.getSelectedItem().equals(UnidadDeMedida.GRAMOS) || jComboBoxUnidadDeMedida.getSelectedItem().equals(UnidadDeMedida.MILILITROS)){
            ((AbstractDocument) jTextFieldStock.getDocument()).setDocumentFilter(new SoloFiltroNumerico());
        }
        else{
            ((AbstractDocument) jTextFieldStock.getDocument()).setDocumentFilter(new SoloEnterosFilter());
        }
        jTextFieldStock.setText("0");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<UnidadDeMedida> jComboBoxUnidadDeMedida;
    public javax.swing.JLabel jLabelCrear;
    private javax.swing.JLabel jLabelGuardar;
    private javax.swing.JLabel jLabelGuardar1;
    private javax.swing.JLabel jLabelGuardar2;
    private javax.swing.JLabel jLabelIconCerrar;
    protected javax.swing.JLabel jLabelProductoNuevo2;
    protected javax.swing.JLabel jLabelProductoNuevo3;
    protected javax.swing.JLabel jLabelProductoNuevo4;
    protected javax.swing.JLabel jLabelProductoNuevo5;
    protected javax.swing.JLabel jLabelProductoNuevo6;
    private javax.swing.JPanel jPanel1;
    private GUI.PanelRound jPanelCrear;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldStock;
    // End of variables declaration//GEN-END:variables
}
