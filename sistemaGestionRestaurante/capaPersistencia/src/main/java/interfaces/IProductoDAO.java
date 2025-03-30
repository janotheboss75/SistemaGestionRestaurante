package interfaces;

import entidades.IngredienteProducto;
import entidades.Producto;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los metodos que tendra la Clase ProductoDAO
 * @author janot
 */
public interface IProductoDAO {
    /**
     * Agrega un nuevo producto a la bd.
     * 
     * @param producto Producto que se desea agregar a la bd.
     * @return Producto con su id.
     * @throws PersistenciaException Si no se logra la insercion,
     */
    public Producto agregarProductoAlMenu(Producto producto) throws PersistenciaException;
    
    /**
     * Modifica un producto de la bd
     * @param producto Producto con los datos nuevos
     * @param nombreProducto Identificador del producto que se desea modificar
     * @return Producto con los datos actualizados.
     * @throws PersistenciaException Si el producto que se desea modificar no existe.
     */
    public Producto modificarProductoDelMenu(Producto producto, String nombreProducto) throws PersistenciaException;
    
    /**
     * Asigna un ingrediente al producto
     * 
     * @param nombreProducto Identificador del producto al que se le agregara un ingrediente
     * @param idIngrediente Id del ingrediente que se desea agregar.
     * @return true si se logra agregar el ingrediente y false en caso contrario.
     * @throws PersistenciaException Si el producto o el ingrediente no existen.
     */
    public boolean asignarIngredienteAlProducto(String nombreProducto, Long idIngrediente) throws PersistenciaException;
    
    /**
     * Quita un ingrediente al producto
     * @param nombreProducto Identificador del producto al que se le quitara un ingrediente
     * @param idIngrediente Id del ingrediente que se desea quitar.
     * @return true si se logra quitar el ingrediente y false en caso contrario.
     * @throws PersistenciaException Si el producto o el ingrediente no existen.
     */
    public boolean quitarIngredienteAlProducto(String nombreProducto, Long idIngrediente) throws PersistenciaException;
    
    //public boolean eliminarProducto(String nombreProducto) throws PersistenciaException;
    
    /**
     * Consulta un producto por su nombre
     * @param nombreProducto Identificador del producto que se desea consultar
     * @return Producto sus datos
     * @throws PersistenciaException Si el producto no existe.
     */
    public Producto consultarProductoPorNombre(String nombreProducto) throws PersistenciaException;
    
    /**
     * Consulta todos los productos que hay registrados en la bd.
     * 
     * @return Lista con los productos.
     * @throws PersistenciaException Si no se logra hacer la consulta
     */
    public List<Producto> consultarTodosLosProductos() throws PersistenciaException;
    
    /**
     * Consulta los Ingredientes que tiene el producto
     * @param nombreProducto Identificador del producto al que se desea ver los ingredientes.
     * @return Lista con los ingredientes.
     * @throws PersistenciaException Si no se logra hacer la consulta.
     */
    public List<IngredienteProducto> consultarIngredientesDelProducto(String nombreProducto) throws PersistenciaException; 
    
}
