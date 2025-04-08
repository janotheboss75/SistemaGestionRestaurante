package DTOs;

import enums.EstadoProducto;
import enums.TipoProducto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janot
 */
public class NuevoProductoDTO {
    
    private EstadoProducto estado;
    
    private String nombre;
    
    private double precio;
    
    private TipoProducto tipoProducto;
    
    private List<IngredienteProductoDTO> ingredientesProductos;

    public NuevoProductoDTO(EstadoProducto estado, String nombre, double precio, TipoProducto tipoProducto, List<IngredienteProductoDTO> ingredientesProductos) {
        this.estado = estado;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.ingredientesProductos = ingredientesProductos;
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

    public List<IngredienteProductoDTO> getIngredientesProductos() {
        return ingredientesProductos;
    }
    
    
    
}
