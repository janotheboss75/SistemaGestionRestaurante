package DTOs;

import enums.EstadoProducto;
import enums.TipoProducto;

/**
 *
 * @author janot
 */
public class NuevoProductoDTO {
    
    private EstadoProducto estado;
    
    private String nombre;
    
    private double precio;
    
    private TipoProducto tipoProducto;

    public NuevoProductoDTO(EstadoProducto estado, String nombre, double precio, TipoProducto tipoProducto) {
        this.estado = estado;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }
    
    
}
