package interfaces;

import DTOs.NuevoProductoDTO;
import DTOs.ProductoDTO;
import entidades.IngredienteProducto;
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
    
    public boolean inhabilitarProductoDelMenu(Long idProducto) throws NegocioException;
    
    public boolean habilitarProductoDelMenu(Long idProducto) throws NegocioException;
    
    public List<IngredienteProducto> consultarIngredientesProducto(Long idProducto) throws NegocioException;
    
    public List<Producto> consultarProductosHabilitados() throws NegocioException;
    
    public List<Producto> consultarTodosLosProductos() throws NegocioException;
    
    public List<Producto> busquedaProducto(TipoProducto tipo, String busqueda) throws NegocioException;
   
}
