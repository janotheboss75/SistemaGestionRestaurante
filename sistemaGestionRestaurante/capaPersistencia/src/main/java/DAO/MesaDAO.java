package DAO;

import conexion.Conexion;
import entidades.Comanda;
import entidades.Mesa;
import entidades.Producto;
import enums.EstadoMesa;
import excepciones.PersistenciaException;
import interfaces.IMesaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author janot
 */
public class MesaDAO implements IMesaDAO{
    private static MesaDAO instanceMesaDAO;
    
    /**
     * Constructor privado para evitar instancias múltiples.
     */
    private MesaDAO() {
    }
    
    /**
     * Método para obtener la única instancia de MesaDAO.
     *
     * @return Instancia de MesaDAO.
     */
    public static MesaDAO getInstanceDAO() {
        if (instanceMesaDAO == null) {
            instanceMesaDAO = new MesaDAO();
        }
        return instanceMesaDAO;
    }
    
    @Override
    public boolean agregarMesas(int cantidadMesas) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        try {
            em.getTransaction().begin();
            
            for (int i = 1; i <= cantidadMesas; i++) {
                em.persist(new Mesa(i, EstadoMesa.DISPONIBLE));
            }
            
            em.getTransaction().commit();
            
            return true;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudieron registrar las " + cantidadMesas + " mesas." + e.getMessage(), e);
        }
    }

    @Override
    public List<Mesa> consultarMesas() throws PersistenciaException {
        List<Mesa> mesas = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        try {
            mesas = em.createQuery("SELECT m FROM Mesa m", Mesa.class).getResultList();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar a todas las mesas", e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
        return mesas;
    }

    @Override
    public List<Mesa> consultarMesasDisponibles() throws PersistenciaException {
        List<Mesa> mesas = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        String jpql = "SELECT m FROM Mesa m WHERE m.estadoMesa= :estadoMesa";
        try {
            TypedQuery<Mesa> query = em.createQuery(jpql, Mesa.class);
            query.setParameter("estadoMesa", EstadoMesa.DISPONIBLE);
            mesas = query.getResultList();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar a todas las mesas", e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
        return mesas;
    }

    @Override
    public boolean cambiarEstadoDeMesa(Long idMesa, EstadoMesa estadoMesa) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        Mesa mesa = em.find(Mesa.class, idMesa);
        
        if(mesa == null){
            throw new PersistenciaException("Error: El id de la comanda no existe");
        }
        
        mesa.setEstadoMesa(estadoMesa);
        
        try {
            em.getTransaction().begin();
            em.merge(mesa);
            em.getTransaction().commit();
            
            return true;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo actualizar el estado de la mesa: " + e.getMessage());
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}
