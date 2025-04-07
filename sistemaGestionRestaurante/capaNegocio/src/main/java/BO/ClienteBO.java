package BO;

import DAO.ClienteDAO;
import entidades.Cliente;
import excepciones.NegocioException;
import interfaces.IClienteBO;
import interfaces.IClienteDAO;
import java.util.List;

/**
 *
 * @author janot
 */
public class ClienteBO implements IClienteBO{
    IClienteDAO clienteDAO;

    public ClienteBO(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    
    @Override
    public List<Cliente> consultarTodosLosClientes() throws NegocioException {
        try {
           return clienteDAO.consultarTodosLosClientes();
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
}
