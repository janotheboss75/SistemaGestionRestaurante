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
        VentanaProductoNuevo pantallaProductoNuevo = new VentanaProductoNuevo(ventana, true);
        pantallaProductoNuevo.setLocationRelativeTo(ventana);
        pantallaProductoNuevo.setVisible(true);
    }
    
    public void cerrarPantalla(JFrame ventana){
        ventana.dispose();
    }
    
    public void cerrarDialogo(JDialog ventana){
        ventana.dispose();
    }
}
