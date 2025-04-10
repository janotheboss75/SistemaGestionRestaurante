package interfaces;

import entidades.Cliente;
import entidades.Comanda;
import entidades.ProductoComanda;
import enums.EstadoComanda;
import excepciones.PersistenciaException;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 * Interfaz que define los metodos que tendra la Clase ComandaDAO
 * @author janot
 */
public interface IComandaDAO {
    /**
     * Agrega una comanda nueva a la bd.
     * La comanda por defecto tiene el estado Abierto
     * 
     * @param comanda Comanda que se desea crear.
     * @return La comanda con su id y su folio generado.
     * @throws PersistenceException Si no se logra agregar una nueva comanda.
     */
    public Comanda crearComanda(Comanda comanda) throws PersistenciaException;
    
    /**
     * Elimina una comanda de la bd.
     * 
     * @param idComanda id de la comanda que se desea eliminar.
     * @return true si se logra eliminar y false en caso contrario.
     * @throws PersistenceException Si la comanda no existe.
     */
    public boolean eliminarComanda(Long idComanda) throws PersistenciaException;
    
    /**
     * Le asocia un cliente a la comanda.
     * 
     * @param idComandade id de la comanda a la cual se le asignara un cliente.
     * @param idCliente Id del cliente que se desea asignar a la comanda.
     * @return true si se logra asignar al cliente y false en caso contrario.
     * @throws PersistenciaException Si no se logra encontrar el idComanda o el idCliente.
     */
    public boolean asociarClienteAcomanda(Long idComanda, Long idCliente) throws PersistenciaException;
    
    /**
     * Actualiza los datos de una comanda.
     * 
     * @param Comanda con los datos nuevos.
     * @return La comanda actualizada .
     * @throws PersistenciaException Si no se logra modificar la comanda.
     */
    public Comanda actualizarComanda(Comanda comanda) throws PersistenciaException;
    
    /**
     * Cambia el estado de una comanda (Abierta, Entregada, Cancelada)
     * 
     * @param idComanda id de la comanda que se le cambiara el estado.
     * @param estado Estado que se le asignara a la comanda.
     * @return Comanda con el estado nuevo
     * @throws PersistenciaException Si no se logra encontrar la id de la comanda
     */
    public Comanda cambiarEstadoComanda(Long idComanda, EstadoComanda estado) throws PersistenciaException;
    
    /**
     * Consulta una comanda por su id
     * 
     * @param idComanda id de la comanda que se desea consultar
     * @return Comanda 
     * @throws PersistenciaException Si no encuentra la comanda.
     */
    public Comanda consultarComandaPorId(Long idComanda) throws PersistenciaException;
    
    /**
     * Consulta todas las comandas por estado
     * 
     * @param estado Estado del que se quieren obtener las comandas.
     * @return Lista con las comandas que tienen el estado asignado
     * @throws PersistenciaException Si no se logra la consulta.
     */
    public List<Comanda> consultarComandasPorEstado(EstadoComanda estado) throws PersistenciaException;
    
    
    /**
     * Consulta todas las comandas.
     * 
     * @return Lista con las comandas.
     * @throws PersistenciaException Si no se logra la consulta.
     */
    public List<Comanda> consultarTodasLasComandas() throws PersistenciaException;
    
    /**
     * Consulta todos los productos agregados en la comanda.
     * 
     * @param idComanda id de la comanda que se desea saber los productos.
     * @return Lista con la lista de productos agregados.
     * @throws PersistenciaException Si no se logra la consulta.
     */
    public List<ProductoComanda> consultarTodosLosProductosDeComanda(Long idComanda) throws PersistenciaException;
    
    /**
     * Consulta el cliente que esta asignado en la comanda.
     * 
     * @param idComanda id de la comanda que se desea saber el Cliente asignado.
     * @return Cliente si esta asignado y null en caso de que no haya cliente asignado.
     * @throws PersistenciaException Si no existe el id de la comanda
     */
    public Cliente consultarClienteDeComanda(Long idComanda) throws PersistenciaException;
    
    /**
     * Consulta las comandas por un rango de fechas
     * 
     * @param desde Desde que fecha
     * @param hasta Hasta que fecha
     * @return Lista con los 
     * @throws PersistenciaException 
     */
    public List<Comanda> consultarComandasPorFecha(Date desde, Date hasta) throws PersistenciaException;
    
    public List<Comanda> buscadorComandas(EstadoComanda estadoComanda, Date desde, Date hasta) throws PersistenciaException;
   

}
