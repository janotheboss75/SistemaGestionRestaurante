package DTOs;

import enums.EstadoProducto;
import enums.TipoProducto;

/**
 *
 * @author janot
 */
public class ProductoDTO {
    
    private EstadoProducto estado;
    
    private String nombre;
    
    private double precio;
    
    private TipoProducto tipoProducto;

    public ProductoDTO(EstadoProducto estado, String nombre, double precio, TipoProducto tipoProducto) {
        this.estado = estado;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }
    
}
