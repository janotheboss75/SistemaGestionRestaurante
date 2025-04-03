package com.carniceria.capapersistencia;

import DAO.ComandaDAO;
import DAO.IngredienteProductoDAO;
import DAO.ProductoComandaDAO;
import DAO.ProductoDAO;
import conexion.Conexion;
import entidades.Cliente;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import entidades.Ingrediente;
import entidades.IngredienteProducto;
import entidades.Mesa;
import entidades.Producto;
import entidades.ProductoComanda;
import enums.EstadoComanda;
import enums.TipoProducto;
import enums.UnidadDeMedida;
import excepciones.PersistenciaException;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author janot
 */
public class CapaPersistencia {

    public static void main(String[] args) throws PersistenciaException {

        ComandaDAO comandaDAO = ComandaDAO.getInstanceDAO();
        EntityManager em = Conexion.crearConexion();
        Comanda comanda = new Comanda("47483djdj", new Date(), EstadoComanda.ENTREGADA, 0, null, em.find(Mesa.class, 1L));
        
        try {
            System.out.println(comandaDAO.consultarTodosLosProductosDeComanda(1L));
        } catch (PersistenciaException ex) {
            ex.printStackTrace();
        }
    }
}
