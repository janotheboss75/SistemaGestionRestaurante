package entidades;

import enums.TipoProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 * Entidad Producto que representa un producto en el sistema.
 * Contiene información sobre su nombre, precio, tipo y sus ingredientes.
 * 
 * @author janot
 */
@Entity
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Identificador único del producto
     */
    @Id
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    
    /**
     * Precio del producto
     */
    @Column(name = "precio", nullable = false)
    private double precio;
    
    /**
     * Tipo del producto
     * Se utiliza un enum que tien como tipo(PLATILLO, BEBIDA, POSTRE)
     */
    @Column(name = "tipo", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoProducto tipo;
    
    /* Lista de Ingredientes para elaborar el producto
     * Relacion uno a muchos, bidireccional, la entidad IngredienteProducto 
     * es la dueña de la relacion.
     */
    @OneToMany(mappedBy = "producto")
    private List<IngredienteProducto> ingredientes = new ArrayList<>();
    
    /**
     * Constructor por defecto.
     */
    public Producto() {
    }

    /**
     * Constructor que inicializa los valores del producto.
     * 
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param tipo Tipo del producto
     */
    public Producto(String nombre, double precio, TipoProducto tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param nombre Nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     * 
     * @return Precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     * 
     * @param precio Precio a establecer
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el tipo de producto.
     * 
     * @return Tipo del producto
     */
    public TipoProducto getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de producto.
     * 
     * @param tipo Tipo de producto a establecer
     */
    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la lista de ingredientes del producto.
     * 
     * @return Lista de ingredientes del producto
     */
    public List<IngredienteProducto> getIngredientes() {
        return ingredientes;
    }

    /**
     * Establece la lista de ingredientes del producto.
     * 
     * @param ingredientes Lista de ingredientes a establecer
     */
    public void setIngredientes(List<IngredienteProducto> ingredientes) {
        this.ingredientes = ingredientes;
    }

    /**
     * Representación en cadena de la entidad Producto.
     * 
     * @return Cadena con los atributos del producto
     */
    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", ingredientes=" + ingredientes + '}';
    }
}
