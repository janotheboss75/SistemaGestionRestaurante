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
    
    private Long idCliente;
    
    private Long idMesa;

    public NuevaComandaDTO(String folio, Date fechaComanda, EstadoComanda estado, double total, Long idCliente, Long idMesa) {
        this.folio = folio;
        this.fechaComanda = fechaComanda;
        this.estado = estado;
        this.total = total;
        this.idCliente = idCliente;
        this.idMesa = idMesa;
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

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

}
