package DAO;

import conexion.Conexion;
import entidades.Ingrediente;
import entidades.IngredienteProducto;
import entidades.Producto;
import entidades.ProductoComanda;
import excepciones.PersistenciaException;
import interfaces.IIngredienteProductoDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author janot
 */
public class IngredienteProductoDAO implements IIngredienteProductoDAO{
    private static IngredienteProductoDAO instanceIngredienteProductoDAO;

    private IngredienteProductoDAO() {
    }
    
    /**
     * Método para obtener la única instancia de IngredienteProductoDAO.
     *
     * @return Instancia de IngredienteProductoDAO.
     */
    public static IngredienteProductoDAO getInstanceDAO() {
        if (instanceIngredienteProductoDAO == null) {
            instanceIngredienteProductoDAO = new IngredienteProductoDAO();
        }
        return instanceIngredienteProductoDAO;
    }
    
    /**
     * Metodo para asignar un ingrediente al producto
     * 
     * @param IdProducto Identificador del producto al que se le agregara un ingrediente
     * @param idIngrediente Id del ingrediente que se desea agregar.
     * @param cantidad Cantidad de ingrediente que sera utilizado en un producto.
     * @return IngredienteProducto con su id.
     * @throws PersistenciaException Si el producto o el ingrediente no existen,
     * y Si no se logro la insercion en la base de datos.
     */
    @Override
    public IngredienteProducto asignarIngredienteAlProducto(Long idProducto, Long idIngrediente, double cantidad) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        Producto p = em.find(Producto.class, idProducto);
        Ingrediente i = em.find(Ingrediente.class, idIngrediente);
        
        if(p == null){
            throw new PersistenciaException("Error: El id del producto no existe");
        }
        
        if(i == null){
            throw new PersistenciaException("Error: El id del ingrediente no existe");
        }
        
        try {
            IngredienteProducto ingProd = new IngredienteProducto(p, i, cantidad);
            em.getTransaction().begin();
            em.persist(ingProd);
            em.getTransaction().commit();
            if (ingProd.getId() == null) {
                throw new PersistenciaException("Error: No se generó un ID para el IngredienteProducto.");
            }
            return ingProd;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo registrar el ingredienteProducto: " + e.getMessage(), e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * Quita un ingrediente al producto
     * 
     * @param idIngredienteProducto Identificador del IngredienteProducto que se desea eliminar.
     * @return true si se logra quitar el ingrediente y false en caso contrario.
     * @throws PersistenciaException Si el id del ingredienteProducto no existe.
     */
    @Override
    public boolean quitarIngredienteAlProducto(Long idIngredienteProducto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        IngredienteProducto ingProd = em.find(IngredienteProducto.class, idIngredienteProducto);
        
        if(ingProd == null){
            throw new PersistenciaException("Error: El id del ingredienteProducto no existe");
        }
        
        try {
            em.getTransaction().begin();
            em.remove(ingProd);
            em.getTransaction().commit();
            
            return true;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo eliminar el ingredienteProducto: " + e.getMessage());
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
    }

    /**
     * Metodo que modifica la cantidad de ingredienteProducto
     * 
     * @param idIngredienteProducto Identificador del IngredienteProducto que se desea modificar
     * @param cantidad Cantidad nueva.
     * @return IngredienteProducto con la cantidad nueva.
     */
    @Override
    public IngredienteProducto modificarCantidadIngredieneAlProducto(Long idIngredienteProducto, double cantidad) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        
        if (em == null) {
            throw new PersistenciaException("Error: No se pudo obtener la conexión con la base de datos.");
        }
        
        IngredienteProducto ingProd = em.find(IngredienteProducto.class, idIngredienteProducto);
        
        if(ingProd == null){
            throw new PersistenciaException("Error: El id del IngredienteProducto no existe");
        }
        
        ingProd.setCantidad(cantidad);
        try {
            em.getTransaction().begin();
            IngredienteProducto actualizado = em.merge(ingProd);
            em.getTransaction().commit();
            
            return actualizado;
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            
            throw new PersistenciaException("No se pudo actualizar el ingredienteProducto: " + e.getMessage());
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

}
