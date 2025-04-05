package DTOs;

import entidades.Cliente;
import enums.EstadoComanda;
import java.util.Date;

/**
 *
 * @author janot
 */
public class NuevaComandaDTO {
    
    private String folio;
    
    private Date fechaComanda;
            
    private EstadoComanda estado;
    
    private double total;
    
    private Cliente cliente;
    
    private Integer mesa;

    public NuevaComandaDTO(String folio, Date fechaComanda, EstadoComanda estado, double total, Cliente cliente, Integer mesa) {
        this.folio = folio;
        this.fechaComanda = fechaComanda;
        this.estado = estado;
        this.total = total;
        this.cliente = cliente;
        this.mesa = mesa;
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

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }
   
}
