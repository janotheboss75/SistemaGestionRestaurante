package interfaces;

import entidades.Cliente;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IClienteBO {
    public List<Cliente> consultarTodosLosClientes() throws NegocioException;
    
}
