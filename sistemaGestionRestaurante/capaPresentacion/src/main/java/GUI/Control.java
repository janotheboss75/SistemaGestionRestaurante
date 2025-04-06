package GUI;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author janot
 */
public class Control {
    public Control() {
    }
    
    public void mostrarPantallaEscogerRol(){
        VentanaEscogerRol pantallaEscogerRol = new VentanaEscogerRol();
        pantallaEscogerRol.setVisible(true);
    }
    
    public void mostrarPantallaMenuAdmin(){
        VentanaMenuAdmin pantallaMenuAdmin = new VentanaMenuAdmin();
        pantallaMenuAdmin.setVisible(true);
    }

    public void mostrarPantallaHistorialComandas(){
        VentanaHistorialComandas pantallaHistorialComandas = new VentanaHistorialComandas();
        pantallaHistorialComandas.setVisible(true);
    }
    
    public void mostrarPantallaProductos(){
        VentanaProductos pantallaVentanaProductos = new VentanaProductos();
        pantallaVentanaProductos.setVisible(true);
    }
    
    public void mostrarPantallaProductoNuevo(JFrame ventana, boolean modal){
        VentanaProductoNuevo pantallaProductoNuevo = new VentanaProductoNuevo(ventana, modal);
        pantallaProductoNuevo.setLocationRelativeTo(ventana);
        pantallaProductoNuevo.setVisible(true);
    }
    
    public void mostrarPantallaAgregarIngredienteAProducto(JDialog ventana, boolean modal){
        VentanaAgregarIngredienteAProducto pantallaAgregarIngredienteAProducto = new VentanaAgregarIngredienteAProducto(ventana,modal);
        pantallaAgregarIngredienteAProducto.setLocationRelativeTo(ventana);
        pantallaAgregarIngredienteAProducto.setVisible(true);
        
    }
    
    public void mostrarPantallaComandaNueva(JFrame ventana, boolean modal){
        VentanaComandaNueva pantallaComandaNueva = new VentanaComandaNueva(ventana, modal);
        pantallaComandaNueva.setLocationRelativeTo(ventana);
        pantallaComandaNueva.setVisible(true);
    }
    
    public void cerrarPantalla(JFrame ventana){
        ventana.dispose();
    }
    
    public void cerrarDialogo(JDialog ventana){
        ventana.dispose();
    }
}
