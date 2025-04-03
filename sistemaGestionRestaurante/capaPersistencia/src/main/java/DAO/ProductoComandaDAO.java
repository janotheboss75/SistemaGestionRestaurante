package DAO;

import conexion.Conexion;
import entidades.IngredienteProducto;
import entidades.Producto;
import entidades.ProductoComanda;
import excepciones.PersistenciaException;
import interfaces.IProductoComandaDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author janot
 */
public class ProductoComandaDAO implements IProductoComandaDAO{

    private static ProductoComandaDAO instanceProductoComandaDAO;
    
    /**
     * Constructor privado para evitar instancias múltiples.
     */
    private ProductoComandaDAO() {
    }
    
    /**
     * Método para obtener la única instancia de ProductoComandaDAO.
     *
     * @return Instancia de ProductoComandaDAO.
     */
    public static ProductoComandaDAO getInstanceDAO() {
        if (instanceProductoComandaDAO == null) {
            instanceProductoComandaDAO = new ProductoComandaDAO();
        }
        return instanceProductoComandaDAO;
    }
    
    /**
     * Metodo para asignar un producto a una comanda.
     *
     * @param productoComanda productoComanda que se va agregar
     * @return ProductoComanda con todos los datos, id y folio generados
     * @throws PersistenciaException Si no existe el id de la comanda o el id del producto
     */
    @Override
    public ProductoComanda agregarProductoAcomanda(ProductoComanda productoComanda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        try {
            em.getTransaction().begin();
            em.persist(productoComanda);
            em.getTransaction().commit();
            
            if (productoComanda.getId() == null) {
                throw new PersistenciaException("Error: No se generó un ID para el productoComanda.");
            }
            return productoComanda;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo registrar el productoComanda: ", e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * Elimina el ProductoComanda de la bd.
     * 
     * @param idProductoComanda Id de ProductoComanda que se desea eliminar
     * @return true si se logra eliminar y false en caso contrario.
     * @throws PersistenciaException Si el id de ProductoComanda no existe.
     */
    @Override
    public boolean quitarProductoDecomanda(Long idProductoComanda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        ProductoComanda prodCom = em.find(ProductoComanda.class, idProductoComanda);
        
        if(prodCom == null){
            throw new PersistenciaException("Error: El id de productoComanda no existe");
        }
        
        try {
            em.getTransaction().begin();
            em.remove(prodCom);
            em.getTransaction().commit();
            
            return true;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo eliminar el ProductoComanda: " + e.getMessage());
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * Modificar ProductoComanda en la bd
     *
     * @param productoComanda productoComanda con los datos a
     * @return ProductoComanda actualizada
     * @throws PersistenciaException Si el id de ProductoComanda no existe o el idProducto no existe
     */
    @Override
    public ProductoComanda modificarProductoDeComanda(ProductoComanda productoComanda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        try {
            em.getTransaction().begin();
            ProductoComanda actualizado = em.merge(productoComanda);
            em.getTransaction().commit();
            
            return actualizado;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            
            throw new PersistenciaException("No se pudo actualizar el productoComanda " + e.getMessage());
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}
