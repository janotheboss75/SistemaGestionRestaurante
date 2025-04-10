package DTOs;

import entidades.Ingrediente;

/**
 *
 * @author janot
 */
public class IngredienteProductoDTO {
    private Ingrediente ingrediente;
    private double cantidad;
    private Long id;

    public IngredienteProductoDTO(Ingrediente ingrediente, double cantidad) {
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
