package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representa la relación entre un producto y una comanda en el sistema.
 * Cada producto dentro de una comanda tiene un precio actual y un comentario opcional.
 * 
 * @author janot
 */
@Entity
@Table(name = "ProductosComandas")
public class ProductoComanda implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /** Identificador único del producto dentro de una comanda. */
    @Id
    @Column(name = "idProductoComanda")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /** 
     * Comanda a la que pertenece este producto. 
     * Relacion muchos a uno, bidireccional, esta clase es la dueña de la
     * relacion
     */
    @ManyToOne()
    @JoinColumn(name = "IdComanda", nullable = false)
    private Comanda comanda;
    
    /** 
     * Producto asociado a la comanda. 
     * Relacion muchos a uno.
     */
    @ManyToOne()
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;
    
    /** 
     * Precio actual del producto al momento de la compra. 
     */
    @Column(name = "precioActual", nullable = false)
    private double precioActual;
    
    /** 
     * Comentario opcional sobre la preparación o modificaciones del producto. 
     */
    @Column(name = "comentario", length = 200)
    private String comentario;
    
    /**
     * Cantidad del producto que se ordenara
     */
    @Column(name = "cantidad", nullable = false)
    private double cantidad;
    
    /**
     * Importe del producto
     */
    @Column(name = "importe", nullable = false)
    private double importe;

    /**
     * Constructor por defecto.
     */
    public ProductoComanda() {
    }

    /**
     * Constructor con parámetros para inicializar los atributos.
     * 
     * @param comanda Comanda a la que pertenece el producto.
     * @param producto Producto que se ordenó en la comanda.
     * @param precioActual Precio actual del producto en la comanda.
     * @param comentario Comentario opcional sobre el producto.
     * @param cantidad Cantidad del producto
     * @param importe importe total del producto
     */
    public ProductoComanda(Comanda comanda, Producto producto, double precioActual, String comentario, double cantidad, double importe) {    
        this.comanda = comanda;
        this.producto = producto;
        this.precioActual = precioActual;
        this.comentario = comentario;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    /**
     * Obtiene el identificador único del producto en la comanda.
     * 
     * @return ID del producto en la comanda.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del producto en la comanda.
     * 
     * @param id Nuevo ID del producto en la comanda.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la comanda a la que pertenece el producto.
     * 
     * @return Comanda asociada.
     */
    public Comanda getComanda() {
        return comanda;
    }

    /**
     * Establece la comanda a la que pertenece el producto.
     * 
     * @param comanda Nueva comanda asociada.
     */
    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    /**
     * Obtiene el producto asociado a la comanda.
     * 
     * @return Producto asociado.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto asociado a la comanda.
     * 
     * @param producto Nuevo producto asociado.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Obtiene el precio actual del producto en la comanda.
     * 
     * @return Precio actual del producto.
     */
    public double getPrecioActual() {
        return precioActual;
    }

    /**
     * Establece el precio actual del producto en la comanda.
     * 
     * @param precioActual Nuevo precio actual del producto.
     */
    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    /**
     * Obtiene el comentario sobre el producto en la comanda.
     * 
     * @return Comentario sobre el producto.
     */
    public String getComentario() {
        return comentario;
    }
   
    /**
     * Establece un comentario sobre el producto en la comanda.
     * 
     * @param comentario Nuevo comentario sobre el producto.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    /**
     * Obtiene la cantidad de producto en la comanda
     * 
     * @return Cantidad sobre el producto en la comanda
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto en la comanda
     * 
     * @param cantidad Nueva cantidad actual del producto
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el importe de producto en la comanda
     * 
     * @return Importe sobre el producto en la comanda
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Establece el importe  del producto en la comanda
     * 
     * @param importe Nuevo importe del producto
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "ProductoComanda{" + "id=" + id + ", comanda=" + comanda.getFolio() + ", producto=" + producto.getNombre() + ", precioActual=" + precioActual + ", comentario=" + comentario + ", cantidad=" + cantidad + ", importe=" + importe + '}';
    }
    
}
