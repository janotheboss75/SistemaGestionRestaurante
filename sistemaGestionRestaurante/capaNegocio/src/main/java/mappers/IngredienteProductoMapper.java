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
}
