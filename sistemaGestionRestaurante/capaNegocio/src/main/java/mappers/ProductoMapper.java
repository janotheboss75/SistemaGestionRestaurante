package mappers;

import DTOs.ProductoDTO;
import entidades.Producto;
import enums.EstadoProducto;
import enums.TipoProducto;

/**
 *
 * @author janot
 */
public class ProductoMapper {
    public static Producto toEntity(ProductoDTO productoDTO){
        return new Producto(productoDTO.getNombre(), 
                            productoDTO.getPrecio(), 
                            productoDTO.getTipoProducto(), 
                            productoDTO.getEstado());
    }
    
    public static ProductoDTO toDTO(Producto producto){
        return new ProductoDTO(producto.getEstado(), 
                               producto.getNombre(), 
                               producto.getPrecio(), 
                           producto.getTipo());
    }
}
