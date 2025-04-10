package mappers;

import DTOs.ProductoComandaDTO;
import entidades.ProductoComanda;

/**
 *
 * @author janot
 */
public class ProductoComandaMapper {
    public static ProductoComanda toEntity(ProductoComandaDTO productoComandaDTO){
        return new ProductoComanda( null, productoComandaDTO.getProducto(), productoComandaDTO.getPrecioActual(), productoComandaDTO.getComentario(), productoComandaDTO.getCantidad(), productoComandaDTO.getImporte());
    }
    
    public static ProductoComandaDTO toDTO(ProductoComanda productoComanda){
        return new ProductoComandaDTO(productoComanda.getProducto(), productoComanda.getPrecioActual(), productoComanda.getComentario(),(int)productoComanda.getCantidad(), productoComanda.getImporte());
    }
}
