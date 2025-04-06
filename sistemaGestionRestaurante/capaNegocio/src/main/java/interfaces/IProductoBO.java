package interfaces;

import DTOs.ProductoDTO;
import excepciones.NegocioException;

/**
 *
 * @author janot
 */
public interface IProductoBO {
    public ProductoDTO agregarProductoAlMenu(ProductoDTO nuevoProducto) throws NegocioException;
   
}
