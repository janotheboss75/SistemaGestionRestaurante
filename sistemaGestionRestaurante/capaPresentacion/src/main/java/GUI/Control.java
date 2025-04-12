package GUI;

import entidades.Ingrediente;
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
    
    public Control() {
    }
    
    //Metodo que muestra la pantalla Escoger rol (Soy Mesero, administrador)
    public void mostrarPantallaEscogerRol(){
        VentanaEscogerRol pantallaEscogerRol = new VentanaEscogerRol();
        pantallaEscogerRol.setResizable(false);
        pantallaEscogerRol.setVisible(true);
    }
    
    //Metodo que muestra la pantalla del menu admin
    public void mostrarPantallaMenuAdmin(){
        VentanaMenuAdmin pantallaMenuAdmin = new VentanaMenuAdmin();
        pantallaMenuAdmin.setResizable(false);
        pantallaMenuAdmin.setVisible(true);
    }

    //Metodo que muestra la pantalla de historial comandas
    public void mostrarPantallaHistorialComandas(){
        VentanaHistorialComandas pantallaHistorialComandas = new VentanaHistorialComandas();
        pantallaHistorialComandas.setResizable(false);
        pantallaHistorialComandas.setVisible(true);
    }
    
    //Metodo que muestra la pantalla de productos existentes
    public void mostrarPantallaProductos(){
        VentanaProductos pantallaVentanaProductos = new VentanaProductos();
        pantallaVentanaProductos.setResizable(false);
        pantallaVentanaProductos.setLocationRelativeTo(null);
        pantallaVentanaProductos.setVisible(true);
    }
    
    //Metodo que muestra la pantalla(JDialog) de agregar producto nuevo al menu
    //Tiene como parametros ventanaProductos y un modal(true) para que se bloquee el jDialog
    //Depende totalmente de VentanaProductos
    public void mostrarPantallaProductoNuevo(VentanaProductos ventana, boolean modal){
        VentanaProductoNuevo pantallaProductoNuevo = new VentanaProductoNuevo(ventana, modal);
        pantallaProductoNuevo.setLocationRelativeTo(ventana);
        pantallaProductoNuevo.setResizable(false);
        pantallaProductoNuevo.setVisible(true);
    }
    
    //Metodo que muestra la pantalla de agregarIngredienteAProducto 
    //Es otro JDialog el cual depende totalmente de VentanaProductoNuevo
    public void mostrarPantallaAgregarIngredienteAProducto(VentanaProductoNuevo ventana, boolean modal){
        VentanaAgregarIngredienteAProducto pantallaAgregarIngredienteAProducto = new VentanaAgregarIngredienteAProducto(ventana,modal);
        pantallaAgregarIngredienteAProducto.setLocationRelativeTo(ventana);
        pantallaAgregarIngredienteAProducto.setResizable(false);
        pantallaAgregarIngredienteAProducto.setVisible(true);
        
    }
    //Metodo que muestra la pantalla de crear nueva comanda
    //Es un JDialog que dependetotal,ente de VentanaComandasPendientes, y aqui se comporta 
    // como un modificador de comanda
    public void mostrarPantallaComandaNueva(VentanaComandasPendientes ventana, boolean modal){
        VentanaComandaNueva pantallaComandaNueva = new VentanaComandaNueva(ventana, modal);
        pantallaComandaNueva.setLocationRelativeTo(ventana);
        pantallaComandaNueva.setResizable(false);
        pantallaComandaNueva.setVisible(true);
    }
    
    //Metodo que muestra la pantalla de agregarProductoAComanda, esta se abre dentro de VentanaComandaNueva,
    //y es la encargada de agregar productos a una comanda nueva, es un JDIALOG
    public void mostrarPantallaAgregarProductoAComanda(VentanaComandaNueva ventana, boolean modal){
        VentanaAgregarProductoAComanda pantallaAgregarProductoAComanda = new VentanaAgregarProductoAComanda(ventana, modal);
        pantallaAgregarProductoAComanda.setLocationRelativeTo(ventana);
        pantallaAgregarProductoAComanda.setResizable(false);
        pantallaAgregarProductoAComanda.setVisible(true);
   }
    
    //Esta ventana se abre dentro de VentanaProductos y es la que muestra una tabla con todos los ingredientes
   // de un producto seleccionado en la tabla
    public void mostrarPantallaIngredienteDeProducto(VentanaProductos ventana, boolean modal){
        VentanaIngredientesDeProducto pantallaIngredientesDeProducto = new VentanaIngredientesDeProducto(ventana, modal);
        pantallaIngredientesDeProducto.setLocationRelativeTo(ventana);
        pantallaIngredientesDeProducto.setResizable(false);
        pantallaIngredientesDeProducto.setVisible(true);
    }
    
    //Metodo que adapta una pantallaProductoNuevo a una pantalla para modificar un producto
    //Pide como parametro VentanaProductos, por que de ahi carga datos que seran modificados en la 
    //pantalla modificada
    public void mostrarPantallaModificarProducto(VentanaProductos ventana, boolean modal){
        VentanaProductoNuevo pantallaProductoNuevo = new VentanaProductoNuevo(ventana, modal);
        pantallaProductoNuevo.jLabelProductoNuevo1.setText("Modificar");
        pantallaProductoNuevo.jLabelProductoNuevo2.setText("Producto");
        pantallaProductoNuevo.setLocationRelativeTo(ventana);
        pantallaProductoNuevo.setResizable(false);
        pantallaProductoNuevo.setVisible(true);
    }
    
    //Metodo que muestra la pantalla que muestra todas las comandas que estan pendientes, en esta pantalla
    //se podran seguir agregando productos
    public void mostrarPantallaComandasPendientes(){
        VentanaComandasPendientes pantallaComandasPendientes = new VentanaComandasPendientes();
        pantallaComandasPendientes.setLocationRelativeTo(null);
        pantallaComandasPendientes.setResizable(false);
        pantallaComandasPendientes.setVisible(true);
    }
    
    //Este metodo muestra uja pantallaComandaNueva pero adaptada para modificar una comanda,
    //Esta se abre en VentanaComandasPendientes
    public void mostrarPantallaModificarComanda(VentanaComandasPendientes ventana, boolean modal){
        VentanaComandaNueva pantallaComandaNueva = new VentanaComandaNueva(ventana, modal);
        pantallaComandaNueva.jLabelProductoNuevo1.setText("Modificar");
        pantallaComandaNueva.jLabelProductoNuevo2.setText("Comanda");
        pantallaComandaNueva.jLabelCrear.setText("Guardar");
        pantallaComandaNueva.setLocationRelativeTo(ventana);
        pantallaComandaNueva.setResizable(false);
        pantallaComandaNueva.setVisible(true);
    }
    
    //Esta pantalla muestra las opciones que nomas puede hacer un mesero
    public void mostrarPantallaMenuMesero(){
        VentanaMenuMesero pantallaMenuMesero = new VentanaMenuMesero();
        pantallaMenuMesero.setLocationRelativeTo(null);
        pantallaMenuMesero.setResizable(false);
        pantallaMenuMesero.setVisible(true);
    }
    
    //Esta pantalla lo que hace es adaptar la VentanaHistorialComandas para que 
    //Cuando regrese al menu, esta se dirija hacia el menu de mesero y no al menu
    //del admin
    public void mostrarHistorialComandasConPermisosDeMesero(){
        VentanaHistorialComandas pantallaHistorialComandas = new VentanaHistorialComandas();
        pantallaHistorialComandas.setEsAdmin(false);
        pantallaHistorialComandas.setResizable(false);
        pantallaHistorialComandas.setVisible(true);
    }
    
    //Esta pantalla lo que hace es adaptar la VentanaComandasPendientes para que 
    //Cuando regrese al menu, esta se redirija hacia el menu de mesero y no al menu
    //del admin
    public void mostrarComandasPendientesConPermisosDeMesero(){
        VentanaComandasPendientes pantallaComandasPendientes = new VentanaComandasPendientes();
        pantallaComandasPendientes.setEsAdmin(false);
        pantallaComandasPendientes.setLocationRelativeTo(null);
        pantallaComandasPendientes.setResizable(false);
        pantallaComandasPendientes.setVisible(true);
    }
    
    //Este metodo abre la pantallaIngredientes la cual muestra todos los ingredienres que hay en la 
    //base de datos
    public void mostrarPantallaIngredientes(){
        VentanaIngredientes pantallaIngredientes = new VentanaIngredientes();
        pantallaIngredientes.setLocationRelativeTo(null);
        pantallaIngredientes.setResizable(false);
        pantallaIngredientes.setVisible(true);
    }
    
    //Este metodo lo que hace es abrir una pantalla para agregar un ingrediente nuevo
    public void mostrarPantallaIngredienteNuevo(VentanaIngredientes ventana, boolean modal){
        VentanaIngredienteNuevo pantallaIngredienteNuevo = new VentanaIngredienteNuevo(ventana, modal);
        pantallaIngredienteNuevo.setLocationRelativeTo(null);
        pantallaIngredienteNuevo.setResizable(false);
        pantallaIngredienteNuevo.setVisible(true);
    }
    
    //Este metodo te muestra una pantalla para subirle el stock a un producto seleccionado en la tabla
    //DEPENDE TOTALMENTE DE VentanaIngredientes
    public void mostrarPantallaIncrementarStockIngrediente(VentanaIngredientes ventana, boolean modal, Ingrediente ingrediente){
        VentanaIncrementarStockIngrediente pantallaIncrementarStockIngrediente = new VentanaIncrementarStockIngrediente(ventana, modal, ingrediente);
        pantallaIncrementarStockIngrediente.setLocationRelativeTo(null);
        pantallaIncrementarStockIngrediente.setResizable(false);
        pantallaIncrementarStockIngrediente.setVisible(true);
    }
    
    //Este metodo te muestra una pantalla para bajarle el stock a un producto seleccionado en la tabla
    //DEPENDE TOTALMENTE DE VentanaIngredientes
    public void mostrarPantallaDecrementarStockIngrediente(VentanaIngredientes ventana, boolean modal, Ingrediente ingrediente){
        VentanaDecrementarStockIngrediente pantallaDecrementarStockIngrediente = new VentanaDecrementarStockIngrediente(ventana, modal, ingrediente);
        pantallaDecrementarStockIngrediente.setLocationRelativeTo(null);
        pantallaDecrementarStockIngrediente.setResizable(false);
        pantallaDecrementarStockIngrediente.setVisible(true);
    }
    
    //Este metodo cierrra JFrames
    public void cerrarPantalla(JFrame ventana){
        ventana.dispose();
    }
    
    //Este metodo cierra jDialogs
    public void cerrarDialogo(JDialog ventana){
        ventana.dispose();
    }  
    
}
