package DTOs;

import entidades.Cliente;
import entidades.Mesa;
import enums.EstadoComanda;
import java.util.Date;

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
}
