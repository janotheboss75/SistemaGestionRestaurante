package interfaces;

import entidades.Cliente;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los metodos que tendra la Clase ClienteDAO
 * 
 * @author janot
 */
public interface IClienteDAO {
    
    /**
     * Agrega un nuevo producto a la bd.
     * 
     * @param producto Producto que se desea agregar a la bd.
     * @return Producto con su id.
     * @throws PersistenciaException Si no se logra la insercion o si el producto
     * ya existe en la base de datos.
     */
    public Cliente registrarCliente(Cliente cliente) throws PersistenciaException;
    
    /**
     * Elimina un registro de un cliente.
     * 
     * @param telefono es el identificador del cliente.
     * @return true si se elimino y false en caso contrario.
     * @throws PersistenciaException Si no se logra remover.
     */
    public boolean eliminarCliente(String telefono) throws PersistenciaException;
    
    /**
     * Actualiza un registro de un cliente.
     * 
     * @param cliente Cliente con los datos nuevos.
     * @return El cliente con los datos nuevos.
     * @throws PersistenciaException SI no se logra la modificacion del registro.
     */
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException;
    
    /**
     * Consulta los datos de un cliente mediante su numero de telefono.
     * 
     * @param telefono telefono del cliente que se desea consultar.
     * @return El cliente consultado.
     * @throws PersistenciaException Si no existe el cliente con ese telefono.
     */
    public Cliente consultarClientePorTelefono(String telefono) throws PersistenciaException;
    
    /**
     * Consulta todos los clientes registrados en la base de datos.
     * 
     * @return Una lista con todos los clientes registrados.
     * @throws PersistenciaException Si no se logra obtener los registros
     */
    public List<Cliente> consultarTodosLosClientes() throws PersistenciaException;
    
}
