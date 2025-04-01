package com.carniceria.capapersistencia;

import DAO.IngredienteProductoDAO;
import DAO.ProductoDAO;
import conexion.Conexion;
import entidades.Ingrediente;
import entidades.IngredienteProducto;
import entidades.Producto;
import enums.TipoProducto;
import enums.UnidadDeMedida;
import excepciones.PersistenciaException;
import javax.persistence.EntityManager;


/**
 *
 * @author janot
 */
public class CapaPersistencia {

    public static void main(String[] args) {
        ProductoDAO productoDAO = ProductoDAO.getInstanceDAO();
        IngredienteProductoDAO ingredienteProductoDAO = IngredienteProductoDAO.getInstanceDAO();
        EntityManager em = Conexion.crearConexion();
        
        try {
            System.out.println(productoDAO.consultarIngredientesDelProducto(1L));
        } catch (PersistenciaException ex) {
            ex.printStackTrace();
        }
    }
}
