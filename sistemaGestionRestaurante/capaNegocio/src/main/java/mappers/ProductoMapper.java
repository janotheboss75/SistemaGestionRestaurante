package mappers;

import DTOs.IngredienteProductoDTO;
import DTOs.NuevoProductoDTO;
import DTOs.ProductoDTO;
import entidades.IngredienteProducto;
import entidades.IngredienteProducto_;
import entidades.Producto;
import enums.EstadoProducto;
import enums.TipoProducto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janot
 */
public class ProductoMapper {
    public static Producto toEntity(NuevoProductoDTO nuevoProductoDTO){

        Producto producto = new Producto(nuevoProductoDTO.getNombre(), 
                            nuevoProductoDTO.getPrecio(), 
                            nuevoProductoDTO.getTipoProducto(), 
                            nuevoProductoDTO.getEstado());
        
        return producto;
    }
    
    public static ProductoDTO toDTO(Producto producto){  
        List<IngredienteProductoDTO> ingredientesProducto = new ArrayList<>();
        for (IngredienteProductoDTO ingredienteProductoDTO : ingredientesProducto) {
            for (IngredienteProducto ingrediente : producto.getIngredientes()) {
                ingredientesProducto.add(new IngredienteProductoDTO(ingrediente.getIngrediente(), ingrediente.getCantidad()));
            }
        }
        
        return new ProductoDTO(producto.getId(),
                            producto.getNombre(), 
                            producto.getPrecio(), 
                              producto.getTipo(),
                            producto.getEstado(), 
                        ingredientesProducto);
    }
}
