package DTOs;

import entidades.Producto;

/**
 *
 * @author janot
 */
public class ProductoComandaDTO {
    private Producto producto;
    private double precioActual;
    private String comentario;
    private Integer cantidad;
    private double importe;

    public ProductoComandaDTO(Producto producto, double precioActual, String comentario, Integer cantidad, double importe) {
        this.producto = producto;
        this.precioActual = precioActual;
        this.comentario = comentario;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public Producto getProducto() {
        return producto;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public String getComentario() {
        return comentario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public double getImporte() {
        return importe;
    }

    @Override
    public String toString() {
        return "ProductoComandaDTO{" + "producto=" + producto + ", precioActual=" + precioActual + ", comentario=" + comentario + ", cantidad=" + cantidad + ", importe=" + importe + '}';
    }

    
}
