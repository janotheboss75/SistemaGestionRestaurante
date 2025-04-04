package entidades;

import enums.EstadoProducto;
import enums.TipoProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Entidad Producto que representa un producto en el sistema.
 * Contiene información sobre su nombre, precio, tipo y sus ingredientes.
 * 
 * @author janot
 */
@Entity
@Table(name = "Productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /** Identificador único del producto. */
    @Id
    @Column(name = "idProducto")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * Identificador único del producto
     */
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
    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private List<IngredienteProducto> ingredientes = new ArrayList<>();
    
    /**
     * Estado del producto
     * Se utiliza un enum que tiene como tipo(HABILITADO, INHABILITADO)
     */
    @Column(name = "estado", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EstadoProducto estado;
    
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
     * @param estado Indica si un producto esta habilitado o inhabilitado
     */
    public Producto(String nombre, double precio, TipoProducto tipo, EstadoProducto estado) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.estado = estado;
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
     * Devuelve el identificador único de la entidad.
     * 
     * @return El identificador de la entidad.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la entidad.
     * 
     * @param id El identificador a asignar.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve un enum que tiene como tipo(HABILITADO, INHABILITADO)
     * @return 
     */
    public EstadoProducto estado() {
        return estado;
    }

    /**
     * Establece si esta habilitado o inhabilitado
     * 
     * Se utiliza un enum que tiene como tipo(HABILITADO, INHABILITADO)
     * @param habilitado 
     */
    public void setEstado(EstadoProducto habilitado) {
        this.estado = habilitado;
    }
    
    /**
     * Representación en cadena de la entidad Producto.
     * 
     * @return Cadena con los atributos del producto
     */
    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", ingredientes=" + ingredientes + ", estado=" + estado + '}';
    }
}
