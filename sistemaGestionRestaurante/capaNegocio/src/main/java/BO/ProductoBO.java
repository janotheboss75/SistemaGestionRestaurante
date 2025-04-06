package BO;

import DTOs.NuevoProductoDTO;
import interfaces.IProductoBO;
import interfaces.IProductoDAO;

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
    public NuevoProductoDTO agregarProductoAlMenu(NuevoProductoDTO nuevoProducto) {
        return null;
    }
    
}
