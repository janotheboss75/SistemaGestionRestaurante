package interfaces;

import entidades.IngredienteProducto;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IIngredienteProductoDAO {
    
    /**
     * Metodo que asigna un ingrediente al producto
     * 
     * @param IdProducto Identificador del producto al que se le agregara un ingrediente
     * @param idIngrediente Id del ingrediente que se desea agregar.
     * @param cantidad Cantidad de ingrediente que sera utilizado en un producto.
     * @return IngredienteProducto con su id.
     * @throws PersistenciaException Si el producto o el ingrediente no existen,
     * y Si no se logro la insercion en la base de datos.
     */
    public IngredienteProducto asignarIngredienteAlProducto(Long idProducto, Long idIngrediente, double cantidad) throws PersistenciaException;
    
    /**
     * Metodo para Asignar un ingrediente al producto
     * 
     * @param idIngredienteProducto Identificador del IngredienteProducto que se desea eliminar.
     * @return true si se logra quitar el ingrediente y false en caso contrario.
     * @throws PersistenciaException Si el id del ingredienteProducto no existe.
     */
    public boolean quitarIngredienteAlProducto(Long idIngredienteProducto) throws PersistenciaException;
    
    /**
     * Metodo que modifica la cantidad de ingredienteProducto
     * 
     * @param idIngredienteProducto Identificador del IngredienteProducto que se desea modificar
     * @param cantidad Cantidad nueva.
     * @return IngredienteProducto con la cantidad nueva.
     */
    public IngredienteProducto modificarCantidadIngredieneAlProducto(Long idIngredienteProducto, double cantidad) throws PersistenciaException;
    
}
