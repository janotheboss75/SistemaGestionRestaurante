package com.carniceria.capapersistencia;

import DAO.ProductoDAO;
import entidades.Producto;
import enums.TipoProducto;
import excepciones.PersistenciaException;


/**
 *
 * @author janot
 */
public class CapaPersistencia {

    public static void main(String[] args) {
        ProductoDAO productoDAO = ProductoDAO.getInstanceDAO();
        Producto p1 = new Producto("Boneless", 130, TipoProducto.PLATILLO);
        
        try {
            System.out.println(productoDAO.agregarProductoAlMenu(p1));
        } catch (PersistenciaException ex) {
            ex.printStackTrace();
        }
    }
}
