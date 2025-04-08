package DTOs;

import entidades.IngredienteProducto;
import enums.EstadoProducto;
import enums.TipoProducto;
import java.util.List;

/**
 *
 * @author janot
 */
public class ProductoDTO {
    private Long id;

    private String nombre;
    
    private double precio;
    
    private TipoProducto tipo;
    
    private List<IngredienteProductoDTO> ingredientes;
    
    private EstadoProducto estado;

    public ProductoDTO(Long id, String nombre, double precio, TipoProducto tipo, EstadoProducto estado, List<IngredienteProductoDTO> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.estado = estado;
        this.ingredientes = ingredientes;
    }
    
}
