package DTOs;

import entidades.Cliente;
import entidades.Comanda;
import entidades.Mesa;
import enums.EstadoComanda;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janot
 */
public class NuevaComandaDTO {
         
    private Comanda comanda;
    
    private double total;
    
    private Cliente Cliente;
    
    private Mesa mesa;
    
    private List<ProductoComandaDTO> productosComanda;

    public NuevaComandaDTO(double total, Cliente Cliente, Mesa mesa, List<ProductoComandaDTO> productosComanda) {
        this.total = total;
        this.Cliente = Cliente;
        this.mesa = mesa;
        this.productosComanda = productosComanda;
    }

    public double getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public List<ProductoComandaDTO> getProductosComanda() {
        return productosComanda;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

}
