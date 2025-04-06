package BO;

import DTOs.ProductoDTO;
import entidades.Producto;
import static entidades.ProductoComanda_.producto;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IProductoBO;
import interfaces.IProductoDAO;
import mappers.ProductoMapper;

/**
 *
 * @author janot
 */
public class ProductoBO implements IProductoBO{
    private IProductoDAO productoDAO;

    public ProductoBO(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }
    
    @Override
    public ProductoDTO agregarProductoAlMenu(ProductoDTO nuevoProducto) throws NegocioException{
        Producto producto = ProductoMapper.toEntity(nuevoProducto);
        
        try {
            Producto productoRegistrado = productoDAO.agregarProductoAlMenu(producto);
            return ProductoMapper.toDTO(productoRegistrado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error: No se pudo guardar el producto " + nuevoProducto.getNombre() + " a la BD", e);
        }
        
    }
    
}
