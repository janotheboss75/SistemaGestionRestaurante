package interfaces;

import DTOs.NuevoProductoDTO;
import DTOs.ProductoDTO;
import entidades.Producto;
import enums.TipoProducto;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IProductoBO {
    public ProductoDTO agregarProductoAlMenu(NuevoProductoDTO nuevoProducto) throws NegocioException;
    
    public List<Producto> consultarProductosHabilitados() throws NegocioException;
    
    public List<Producto> consultarTodosLosProductos() throws NegocioException;
    
    public List<Producto> busquedaProducto(TipoProducto tipo, String busqueda) throws NegocioException;
   
}
