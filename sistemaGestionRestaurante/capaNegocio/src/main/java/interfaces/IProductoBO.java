package interfaces;

import DTOs.NuevoProductoDTO;
import DTOs.ProductoDTO;
import entidades.Producto;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IProductoBO {
    public ProductoDTO agregarProductoAlMenu(NuevoProductoDTO nuevoProducto) throws NegocioException;
    
    public List<Producto> consultarProductosHabilitados() throws NegocioException;
   
}
