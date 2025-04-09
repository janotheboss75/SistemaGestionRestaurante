package BO;

import DAO.IngredienteProductoDAO;
import DTOs.IngredienteProductoDTO;
import DTOs.NuevoProductoDTO;
import DTOs.ProductoDTO;
import entidades.IngredienteProducto;
import entidades.Producto;
import static entidades.ProductoComanda_.producto;
import enums.TipoProducto;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IIngredienteProductoDAO;
import interfaces.IProductoBO;
import interfaces.IProductoDAO;
import java.util.List;
import mappers.ProductoMapper;

/**
 *
 * @author janot
 */
public class ProductoBO implements IProductoBO{
    private IProductoDAO productoDAO;
    private IIngredienteProductoDAO ingredienteProductoDAO;

    public ProductoBO(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
        this.ingredienteProductoDAO = IngredienteProductoDAO.getInstanceDAO();
    }
    
    @Override
    public ProductoDTO agregarProductoAlMenu(NuevoProductoDTO nuevoProducto) throws NegocioException{
        Producto producto = ProductoMapper.toEntity(nuevoProducto);
            
        List<IngredienteProducto> ingredientesProducto = producto.getIngredientes();
        
        try {
            Producto productoRegistrado = productoDAO.agregarProductoAlMenu(producto);    
            for (IngredienteProductoDTO ingredienteProductoDTO : nuevoProducto.getIngredientesProductos()) {
                ingredientesProducto.add(new IngredienteProducto(productoRegistrado, ingredienteProductoDTO.getIngrediente(), ingredienteProductoDTO.getCantidad()));
            }
            
            try {
                for (IngredienteProducto ingredienteProducto : ingredientesProducto) {
                    ingredienteProductoDAO.asignarIngredienteAlProducto(productoRegistrado.getId(), ingredienteProducto.getIngrediente().getId(), ingredienteProducto.getCantidad());
                }
            } catch (PersistenciaException e) {
                throw new NegocioException(e.getMessage());
            }
            
            return ProductoMapper.toDTO(productoRegistrado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error: No se pudo guardar el producto " + nuevoProducto.getNombre() + " a la BD", e);
        }       
    }

    @Override
    public List<Producto> consultarProductosHabilitados() throws NegocioException {
        try {
            return productoDAO.consultarProductosHabilitados();
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Producto> consultarTodosLosProductos()throws NegocioException{
        try {
            return productoDAO.consultarTodosLosProductos();
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Producto> busquedaProducto(TipoProducto tipo, String busqueda) throws NegocioException {
        try {
            return productoDAO.busquedaProductos(tipo, busqueda);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
}
