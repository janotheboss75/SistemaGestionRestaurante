package DTOs;

import entidades.Cliente;
import entidades.Mesa;
import enums.EstadoComanda;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janot
 */
public class ComandaDTO {
    private Long id;
    
    private String folio;
    
    private Date fechaComanda;
            
    private EstadoComanda estado;
    
    private double total;
    
    private Cliente cliente;
    
    private Mesa mesa;
    
    private List<ProductoComandaDTO> productos;

    public ComandaDTO(Long id, String folio, Date fechaComanda, EstadoComanda estado, double total, Cliente cliente, Mesa mesa, List<ProductoComandaDTO> productos) {
        this.id = id;
        this.folio = folio;
        this.fechaComanda = fechaComanda;
        this.estado = estado;
        this.total = total;
        this.cliente = cliente;
        this.mesa = mesa;
        this.productos = productos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Date getFechaComanda() {
        return fechaComanda;
    }

    public void setFechaComanda(Date fechaComanda) {
        this.fechaComanda = fechaComanda;
    }

    public EstadoComanda getEstado() {
        return estado;
    }

    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<ProductoComandaDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoComandaDTO> productos) {
        this.productos = productos;
    }
    
}
