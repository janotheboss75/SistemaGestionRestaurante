package interfaces;

import DTOs.ProductoDTO;
import entidades.Producto;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IProductoBO {
    public ProductoDTO agregarProductoAlMenu(ProductoDTO nuevoProducto) throws NegocioException;
    
    public List<Producto> consultarProductosHabilitados() throws NegocioException;
   
}
