    package DAO;

import conexion.Conexion;
import entidades.Cliente;
import entidades.Comanda;
import entidades.ProductoComanda;
import enums.EstadoComanda;
import excepciones.PersistenciaException;
import interfaces.IComandaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author janot
 */
public class ComandaDAO implements IComandaDAO{

     private static ComandaDAO instanceComandaDAO;
     
    /**
     * Constructor privado para evitar instancias múltiples.
     */
    private ComandaDAO() {
    }
    
    /**
     * Método para obtener la única instancia de ComandaDAO.
     *
     * @return Instancia de ComandaDAO.
     */
    public static ComandaDAO getInstanceDAO() {
        if (instanceComandaDAO == null) {
            instanceComandaDAO = new ComandaDAO();
        }
        return instanceComandaDAO;
    }
    
    /**
     * Agrega una comanda nueva a la bd.
     * La comanda por defecto tiene el estado Abierto
     * 
     * @param comanda Comanda que se desea crear.
     * @return La comanda con su id y su folio generado.
     * @throws PersistenciaException Si no se logra agregar una nueva comanda.
     */
    @Override
    public Comanda crearComanda(Comanda comanda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        try {
            em.getTransaction().begin();
            em.persist(comanda);
            em.getTransaction().commit();
            if (comanda.getId() == null) {
                throw new PersistenciaException("Error: No se generó un ID para la comanda.");
            }
            return comanda;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo registrar la comanda: " + e.getMessage(), e);
        }
    }

    /**
     * Elimina una comanda de la bd.
     * 
     * @param idComanda id de la comanda que se desea eliminar.
     * @return true si se logra eliminar y false en caso contrario.
     * @throws PersistenciaException Si la comanda no existe.
     */
    @Override
    public boolean eliminarComanda(Long idComanda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        Comanda c = em.find(Comanda.class, idComanda);
        
        if(c == null){
            throw new PersistenciaException("Error: El id de la comanda no existe");
        }
        
        try {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            
            return true;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo eliminar la Comanda: " + e.getMessage());
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * Le asocia un cliente a la comanda.
     * 
     * @param idComandade id de la comanda a la cual se le asignara un cliente.
     * @param idCliente Id del cliente que se desea asignar a la comanda.
     * @return true si se logra asignar al cliente y false en caso contrario.
     * @throws PersistenciaException Si no se logra encontrar el idComanda o el idCliente.
     */
    @Override
    public boolean asociarClienteAcomanda(Long idComanda, Long idCliente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        Comanda com = em.find(Comanda.class, idComanda);
        Cliente cli = em.find(Cliente.class, idCliente);
        
        if(com == null){
            throw new PersistenciaException("Error: El id de la comanda no existe");
        }
        if(cli == null){
            throw new PersistenciaException("Error: El id de el cliente no existe");
        }
        
        com.setCliente(cli);
        
        try {
            em.getTransaction().begin();
            em.merge(com);
            em.getTransaction().commit();
            
            return true;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo asignar el cliente a la comanda: " + e.getMessage());
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

        /**
     * Actualiza los datos de una comanda.
     * 
     * @param Comanda con los datos nuevos.
     * @return La comanda actualizada .
     * @throws PersistenciaException Si no se logra modificar la comanda.
     */
    @Override
    public Comanda actualizarComanda(Comanda comanda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        try {
            em.getTransaction().begin();
            Comanda actualizado = em.merge(comanda);
            em.getTransaction().commit();
            
            return actualizado;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo actualizar la comanda: " + e.getMessage());
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
    
    /**
     * Cambia el estado de una comanda (Abierta, Entregada, Cancelada)
     * 
     * @param idComanda id de la comanda que se le cambiara el estado.
     * @param estado Estado que se le asignara a la comanda.
     * @return Comanda con el estado nuevo
     * @throws PersistenciaException Si no se logra encontrar la id de la comanda
     */
    @Override
    public Comanda cambiarEstadoComanda(Long idComanda, EstadoComanda estado) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        Comanda c = em.find(Comanda.class, idComanda);
        
        if(c == null){
            throw new PersistenciaException("Error: El id de la comanda no existe");
        }
        
        c.setEstado(estado);
        
        try {
            em.getTransaction().begin();
            Comanda actualizado = em.merge(c);
            em.getTransaction().commit();
            
            return actualizado;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo actualizar el estado de la comanda: " + e.getMessage());
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }       
    }

    /**
     * Consulta una comanda por su id
     * 
     * @param idComanda id de la comanda que se desea consultar
     * @return Comanda 
     * @throws PersistenciaException Si no encuentra la comanda.
     */
    @Override
    public Comanda consultarComandaPorId(Long idComanda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        Comanda c = em.find(Comanda.class, idComanda);
        
        if (c == null) {
            throw new PersistenciaException("Error: el id de la comanda no existe");
        }
        
        return c;
    }

    /**
     * Consulta todas las comandas por estado
     * 
     * @return Lista con las comandas que tienen el estado asignado
     * @throws PersistenciaException Si no se logra la consulta.
     */
    @Override
    public List<Comanda> consultarComandasPorEstado(EstadoComanda estado) throws PersistenciaException {
        List<Comanda> comandas= new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        String jpql = "SELECT c FROM Comanda c WHERE c.estado= :estado";
        
        try {
            TypedQuery<Comanda> query = em.createQuery(jpql, Comanda.class);
            query.setParameter("estado", estado);
            comandas = query.getResultList();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar las comandas con el estado: " + estado, e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
        return comandas;
    }

    /**
     * Consulta todas las comandas.
     * 
     * @return Lista con las comandas.
     * @throws PersistenciaException Si no se logra la consulta.
     */
    @Override
    public List<Comanda> consultarTodasLasComandas() throws PersistenciaException {
        List<Comanda> comandas = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        try {
            comandas = em.createQuery("SELECT c FROM Comanda c", Comanda.class).getResultList();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar a todos las comandas", e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
        return comandas;
    }

    @Override
    public List<ProductoComanda> consultarTodosLosProductosDeComanda(Long idComanda) throws PersistenciaException {
        List<ProductoComanda> productosComanda = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        Comanda c = em.find(Comanda.class, idComanda);
        
        if (c == null) {
            throw new PersistenciaException("Error: el id de la comanda no existe");
        }
        
        String jpql = "SELECT prodCom FROM ProductoComanda prodCom INNER JOIN prodCom.comanda c WHERE prodCom.comanda.id = :idComanda";
        
        try {
            TypedQuery<ProductoComanda> query = em.createQuery(jpql, ProductoComanda.class);
            query.setParameter("idComanda", idComanda);
            productosComanda = query.getResultList();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los productos de la comanda con la id: " + idComanda, e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
        return productosComanda;
    }

    /**
     * Consulta el cliente que esta asignado en la comanda.
     * 
     * @param idComanda id de la comanda que se desea saber el Cliente asignado.
     * @return Cliente si esta asignado y null en caso de que no haya cliente asignado.
     * @throws PersistenciaException Si no existe el id de la comanda
     */
    @Override
    public Cliente consultarClienteDeComanda(Long idComanda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        Comanda c = em.find(Comanda.class, idComanda);
        
        if (c == null) {
            throw new PersistenciaException("Error: el id de la comanda no existe");
        }
        
        return c.getCliente();
    }

    /**
     * Consulta las comandas que esten en el rango de fechas
     * 
     * @param desde Desde que fecha se desean filtrar las comandas.
     * @param hasta Hasta que fecha se desea filtrar las comandas.
     * @return Una lista de comandas que esten entre el rango de fechas.
     * @throws PersistenciaException Error si no se logra hacer la consulta.
     */
    @Override
    public List<Comanda> consultarComandasPorFecha(Date desde, Date hasta) throws PersistenciaException {
        List<Comanda> comandas = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        String jpql = "SELECT c FROM Comanda c WHERE c.fechaComanda BETWEEN :desde AND :hasta";
        
        try {
            comandas = em.createQuery(jpql, Comanda.class)
                    .setParameter("desde", desde)
                    .setParameter("hasta", hasta)
                    .getResultList();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar a todos las comandas", e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
        return comandas;
    }

    @Override
    public List<Comanda> buscadorComandas(EstadoComanda estadoComanda, Date desde, Date hasta) throws PersistenciaException {
        List<Comanda> comandas = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        String jpql = "SELECT c FROM Comanda c " +
              "WHERE (:estadoComanda IS NULL OR c.estado = :estadoComanda) " +
              "AND (:fechaDesde IS NULL OR c.fechaComanda >= :fechaDesde)" +
              "AND (:fechaHasta IS NULL OR c.fechaComanda <= :fechaHasta)";


        try {
            TypedQuery<Comanda> query = em.createQuery(jpql, Comanda.class);
            query.setParameter("estadoComanda", estadoComanda);
            query.setParameter("fechaDesde", desde);
            query.setParameter("fechaHasta", hasta);
            
            return query.getResultList();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al realizar la consulta de busqueda", e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
    
}
