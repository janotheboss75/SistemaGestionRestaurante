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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public List<IngredienteProductoDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteProductoDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }
    
    
    
}
