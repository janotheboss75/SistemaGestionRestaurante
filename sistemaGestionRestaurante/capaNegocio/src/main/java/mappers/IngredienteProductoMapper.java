package mappers;

import DTOs.IngredienteProductoDTO;
import entidades.IngredienteProducto;

/**
 *
 * @author janot
 */
public class IngredienteProductoMapper {
    public static IngredienteProducto toEntity(IngredienteProductoDTO ingredienteProductoDTO){
        return new IngredienteProducto(null, ingredienteProductoDTO.getIngrediente(), ingredienteProductoDTO.getCantidad());
    }
    
    public static IngredienteProductoDTO toDTO(IngredienteProducto ingredienteProducto){
        IngredienteProductoDTO ingredienteProductoDTO = new IngredienteProductoDTO(ingredienteProducto.getIngrediente(), ingredienteProducto.getCantidad());
        ingredienteProductoDTO.setId(ingredienteProducto.getId());
        return ingredienteProductoDTO;  
    }
    
}
