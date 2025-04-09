package DAO;

import conexion.Conexion;
import entidades.IngredienteProducto;
import entidades.Producto;
import enums.EstadoProducto;
import enums.TipoProducto;
import excepciones.PersistenciaException;
import interfaces.IProductoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author janot
 */
public class ProductoDAO implements IProductoDAO{

    private static ProductoDAO instanceProductoDAO;
    
    /**
     * Constructor privado para evitar instancias múltiples.
     */
    private ProductoDAO() {
    }
    
    /**
     * Método para obtener la única instancia de ProductoDAO.
     *
     * @return Instancia de ProductoDAO.
     */
    public static ProductoDAO getInstanceDAO() {
        if (instanceProductoDAO == null) {
            instanceProductoDAO = new ProductoDAO();
        }
        return instanceProductoDAO;
    }
    
    /**
     * Agrega un nuevo producto a la bd.
     * 
     * @param producto Producto que se desea agregar a la bd.
     * @return Producto con su id.
     * @throws PersistenciaException Si no se logra la insercion, si no se pudo obtener la conexion, y si
     * no se pudo generar
     */
    @Override
    public Producto agregarProductoAlMenu(Producto producto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();

        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }

        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();

            if (producto.getId() == null) {
                throw new PersistenciaException("Error: No se generó un ID para el producto.");
            }
            return producto;

        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo registrar el producto: " + e.getMessage(), e);

        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }


    /**
     * Modifica un producto de la bd
     * @param producto Producto con los datos nuevos
     * @return Producto con los datos actualizados.
     * @throws PersistenciaException Si el producto que se desea modificar no existe, o si no se
     * pudo lograr la conexion
     */
    @Override
    public Producto modificarProductoDelMenu(Producto producto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        try {
            em.getTransaction().begin();
            Producto actualizado = em.merge(producto);
            em.getTransaction().commit();
            
            return actualizado;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            
            throw new PersistenciaException("No se pudo actualizar el producto: " + e.getMessage());
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * Consulta un producto por su nombre
     * @param idProducto Identificador del producto que se desea consultar
     * @return Producto con sus datos
     * @throws PersistenciaException Si el producto no existe.
     */
    @Override
    public Producto consultarProductoPorId(Long idProducto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        Producto p = em.find(Producto.class, idProducto);
        
        if (p == null) {
            throw new PersistenciaException("Error: el id del producto no existe");
        }
        
        return p;
    }
    /**
     * Consulta todos los productos que hay registrados en la bd.
     * 
     * @return Lista con los productos.
     * @throws PersistenciaException Si no se logra hacer la consulta
     */
    @Override
    public List<Producto> consultarTodosLosProductos() throws PersistenciaException {
        List<Producto> productos = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        try {
            productos = em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar a todos los productos", e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
        return productos;
    }

    /**
     * Consulta los Ingredientes que tiene el producto.
     * 
     * @param idProducto Identificador del producto al que se desea ver los ingredientes.
     * @return Lista con los ingredientes del producto.
     * @throws PersistenciaException Si no se logra hacer la consulta.
     */
    @Override
    public List<IngredienteProducto> consultarIngredientesDelProducto(Long idProducto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        Producto p = em.find(Producto.class, idProducto);
        
        if (p == null) {
            throw new PersistenciaException("Error: el id del producto no existe");
        }
        
        return p.getIngredientes();
    }

    /**
     * Inhabilita un Producto de la base de datos
     * 
     * @param idProducto Id del producto que se desea inhabilitar.
     * @return true si se logra inhabilitar el producto y false en caso contrario.
     * @throws PersistenciaException Si el producto no existe.
     */
    @Override
    public boolean inhabilitarProducto(Long idProducto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        Producto p = em.find(Producto.class, idProducto);
        
        if (p == null) {
            throw new PersistenciaException("Error: el id del producto no existe");
        }
        
        p.setEstado(EstadoProducto.INHABILITADO);
        
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            
            return true;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            
            throw new PersistenciaException("No se pudo inhabilitar el producto: " + e.getMessage());
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<Producto> consultarProductosHabilitados() throws PersistenciaException {
        List<Producto> productos = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        String jpql = "SELECT p FROM Producto p WHERE p.estado= :estado";
        try {
            TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
            query.setParameter("estado", EstadoProducto.HABILITADO);
            return query.getResultList();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar a todas los prodcutos habilitados", e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }

    }

    @Override
    public List<Producto> busquedaProductos(TipoProducto tipoProducto, String busqueda) throws PersistenciaException {
        List<Producto> productos = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        String jpql = "SELECT p FROM Producto p " +
              "WHERE (:tipoProducto IS NULL OR p.tipo = :tipoProducto) " +
              "AND (:nombre IS NULL OR p.nombre LIKE :nombre)";
        try {
            TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
            query.setParameter("tipoProducto", tipoProducto);
            query.setParameter("nombre", (busqueda == null || busqueda.isBlank()) ? null : "%" + busqueda + "%");

            return query.getResultList();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al realizar la consulta de busqueda", e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
    
    @Override
    public boolean habilitarProducto(Long idProducto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        Producto p = em.find(Producto.class, idProducto);
        
        if (p == null) {
            throw new PersistenciaException("Error: el id del producto no existe");
        }
        
        p.setEstado(EstadoProducto.HABILITADO);
        
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            
            return true;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            
            throw new PersistenciaException("No se pudo habilitar el producto: " + e.getMessage());
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}
