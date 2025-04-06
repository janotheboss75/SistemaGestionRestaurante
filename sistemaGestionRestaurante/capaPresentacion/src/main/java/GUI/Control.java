package GUI;

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

    public void cerrarPantalla(JFrame ventana){
        ventana.dispose();
    }
}
