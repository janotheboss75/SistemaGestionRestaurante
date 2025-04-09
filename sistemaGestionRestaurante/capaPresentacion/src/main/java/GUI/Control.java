package GUI;

import entidades.Producto;
import excepciones.NegocioException;
import interfaces.IProductoBO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import manejadoresDeObjetoNegocio.ManejadorObjetosNegocio;

/**
 *
 * @author janot
 */
public class Control {
    private IProductoBO productoBO;
    
    public Control() {
        productoBO = ManejadorObjetosNegocio.crearProductoBO();
    }
    
    public void mostrarPantallaEscogerRol(){
        VentanaEscogerRol pantallaEscogerRol = new VentanaEscogerRol();
        pantallaEscogerRol.setResizable(false);
        pantallaEscogerRol.setVisible(true);
    }
    
    public void mostrarPantallaMenuAdmin(){
        VentanaMenuAdmin pantallaMenuAdmin = new VentanaMenuAdmin();
        pantallaMenuAdmin.setResizable(false);
        pantallaMenuAdmin.setVisible(true);
    }

    public void mostrarPantallaHistorialComandas(){
        VentanaHistorialComandas pantallaHistorialComandas = new VentanaHistorialComandas();
        pantallaHistorialComandas.setResizable(false);
        pantallaHistorialComandas.setVisible(true);
    }
    
    public void mostrarPantallaProductos(){
        VentanaProductos pantallaVentanaProductos = new VentanaProductos();
        pantallaVentanaProductos.setResizable(false);
        pantallaVentanaProductos.setLocationRelativeTo(null);
        pantallaVentanaProductos.setVisible(true);
    }
    
    public void mostrarPantallaProductoNuevo(VentanaProductos ventana, boolean modal){
        VentanaProductoNuevo pantallaProductoNuevo = new VentanaProductoNuevo(ventana, modal);
        pantallaProductoNuevo.setLocationRelativeTo(ventana);
        pantallaProductoNuevo.setResizable(false);
        pantallaProductoNuevo.setVisible(true);
    }
    
    public void mostrarPantallaAgregarIngredienteAProducto(VentanaProductoNuevo ventana, boolean modal){
        VentanaAgregarIngredienteAProducto pantallaAgregarIngredienteAProducto = new VentanaAgregarIngredienteAProducto(ventana,modal);
        pantallaAgregarIngredienteAProducto.setLocationRelativeTo(ventana);
        pantallaAgregarIngredienteAProducto.setResizable(false);
        pantallaAgregarIngredienteAProducto.setVisible(true);
        
    }
    
    public void mostrarPantallaComandaNueva(JFrame ventana, boolean modal){
        VentanaComandaNueva pantallaComandaNueva = new VentanaComandaNueva(ventana, modal);
        pantallaComandaNueva.setLocationRelativeTo(ventana);
        pantallaComandaNueva.setResizable(false);
        pantallaComandaNueva.setVisible(true);
    }
    
    public void mostrarPantallaAgregarProductoAComanda(VentanaComandaNueva ventana, boolean modal){
        VentanaAgregarProductoAComanda pantallaAgregarProductoAComanda = new VentanaAgregarProductoAComanda(ventana, modal);
        pantallaAgregarProductoAComanda.setLocationRelativeTo(ventana);
        pantallaAgregarProductoAComanda.setResizable(false);
        pantallaAgregarProductoAComanda.setVisible(true);
   }
    
    public void mostrarPantallaIngredienteDeProducto(VentanaProductos ventana, boolean modal){
        VentanaIngredientesDeProducto pantallaIngredientesDeProducto = new VentanaIngredientesDeProducto(ventana, modal);
        pantallaIngredientesDeProducto.setLocationRelativeTo(ventana);
        pantallaIngredientesDeProducto.setResizable(false);
        pantallaIngredientesDeProducto.setVisible(true);
    }
    
    public void cerrarPantalla(JFrame ventana){
        ventana.dispose();
    }
    
    public void cerrarDialogo(JDialog ventana){
        ventana.dispose();
    }  
    
}
