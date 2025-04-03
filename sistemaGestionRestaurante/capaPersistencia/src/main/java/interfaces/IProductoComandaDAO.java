package interfaces;

import entidades.ProductoComanda;
import excepciones.PersistenciaException;

/**
 *
 * @author janot
 */
public interface IProductoComandaDAO {
    
    /**
     * Metodo para asignar un producto a una comanda.
     *
     * @param productoComanda productoComanda que se va agregar
     * @return ProductoComanda con todos los datos, id y folio generados
     * @throws PersistenciaException Si no existe el id de la comanda o el id del producto
     */
    public ProductoComanda agregarProductoAcomanda(ProductoComanda productoComanda) throws PersistenciaException;
    
    /**
     * Elimina el ProductoComanda de la bd.
     * 
     * @param idProductoComanda Id de ProductoComanda que se desea eliminar
     * @return true si se logra eliminar y false en caso contrario.
     * @throws PersistenciaException Si el id de ProductoComanda no existe.
     */
    public boolean quitarProductoDecomanda(Long idProductoComanda) throws PersistenciaException;  
    
    /**
     * Modificar ProductoComanda en la bd
     *
     * @param productoComanda productoComanda con los datos a
     * @return ProductoComanda actualizada
     * @throws PersistenciaException Si el id de ProductoComanda no existe o el idProducto no existe
     */
    public ProductoComanda modificarProductoDeComanda(ProductoComanda productoComanda) throws PersistenciaException;
}
