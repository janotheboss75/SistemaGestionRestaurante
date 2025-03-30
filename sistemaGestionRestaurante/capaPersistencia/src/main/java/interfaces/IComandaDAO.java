package interfaces;

import entidades.Cliente;
import entidades.Comanda;
import entidades.ProductoComanda;
import enums.EstadoComanda;
import excepciones.PersistenciaException;
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
     * @return La comanda con su folio generado.
     * @throws PersistenceException Si no se logra agregar una nueva comanda.
     */
    public Comanda crearComanda(Comanda comanda) throws PersistenceException;
    
    /**
     * Elimina una comanda de la bd.
     * 
     * @param folio Folio de la comanda que se desea eliminar.
     * @return true si se logra eliminar y false en caso contrario.
     * @throws PersistenceException Si la comanda no existe.
     */
    public boolean eliminarComanda(String folio) throws PersistenceException;
    
    /**
     * Agrega un producto a la comanda.
     * 
     * @param folio Folio de la comanda.
     * @param nombreProducto Nombre del producto que se desea agregar.
     * @return true si se logra agregar el producto y false en caso contrario.
     * @throws PersistenciaException Si no se logra encontrar el folio o el producto.
     */
    public boolean agregarProductoAcomanda(String folio, String nombreProducto) throws PersistenciaException;
    
    /**
     * Quita un producto a la comanda.
     * 
     * @param folio Folio de la comanda a la cual se le quitara el producto.
     * @param nombreProducto Nombre del producto que se desea eliminar.
     * @return true si se logra quitar y false en caso contrario.
     * @throws PersistenciaException Si no se logra encontrar el folio o el producto.
     */
    public boolean quitarProductoDecomanda(String folio, String nombreProducto) throws PersistenciaException;  
    
    /**
     * Le asocia un cliente a la comanda.
     * 
     * @param folio Folio de la comanda a la cual se le asignara un cliente.
     * @param telefono Identificador del cliente que se desea agregar.
     * @return true si se logra asignar al cliente y false en caso contrario.
     * @throws PersistenciaException Si no se logra encontrar el folio o el cliente.
     */
    public boolean asociarClienteAcomanda(String folio, String telefono) throws PersistenciaException;
    
    /**
     * Actualiza los datos de una comanda.
     * 
     * @param folio Folio de la comanda que se desea actualizar
     * @return La comanda actualizada con el folio.
     * @throws PersistenciaException Si no se logra encontrar el folio.
     */
    public Comanda actualizarComanda(String folio) throws PersistenciaException;
    
    /**
     * Cambia el estado de una comanda (Abierta, Entregada, Cancelada)
     * 
     * @param folio Folio de la comanda que se le cambiara el estado.
     * @param estado Estado que se le asignara a la comanda.
     * @return Comanda con el estado nuevo y el folio
     * @throws PersistenciaException 
     */
    public Comanda cambiarEstadoComanda(String folio, EstadoComanda estado) throws PersistenciaException;
    
    /**
     * Consulta una comanda por su Folio.
     * 
     * @param folio Folio de la comanda que se desea consultar
     * @return Comanda con el folio.
     * @throws PersistenciaException Si no encuentra la comanda.
     */
    public Comanda consultarComandaPorFolio(String folio) throws PersistenciaException;
    
    /**
     * Consulta todas las comandas Canceladas.
     * 
     * @return Lista con las comandas con el estado Cancelada.
     * @throws PersistenciaException Si no se logra la consulta.
     */
    public List<Comanda> consultartTodasLasComandasCanceladas() throws PersistenciaException;
    
    /**
     * Consulta todas las comandas Abiertas.
     * 
     * @return Lista con las comandas con el estado Abierta.
     * @throws PersistenciaException Si no se logra la consulta.
     */
    public List<Comanda> consultartTodasLasComandasAbiertas() throws PersistenciaException;
    
    /**
     * Consulta todas las comandas Entregadas.
     * 
     * @return Lista con las comandas con el estado Entregada.
     * @throws PersistenciaException Si no se logra la consulta.
     */
    public List<Comanda> consultartTodasLasComandasEntregadas() throws PersistenciaException;
    
    /**
     * Consulta todas las comandas.
     * 
     * @return Lista con las comandas.
     * @throws PersistenciaException Si no se logra la consulta.
     */
    public List<Comanda> consultartTodasLasComandas() throws PersistenciaException;
    
    /**
     * Consulta todos los productos agregados en la comanda.
     * 
     * @param folio Folio de la comanda que se desea saber los productos.
     * @return Lista con la lista de productos agregados.
     * @throws PersistenciaException Si no se logra la consulta.
     */
    public List<ProductoComanda> consultartTodosLosProductosDeComanda(String folio) throws PersistenciaException;
    
    /**
     * Consulta el cliente que esta asignado en la comanda.
     * 
     * @param folio Folio de la comanda que se desea saber el Cliente asignado.
     * @return Cliente si esta asignado y null en caso de que no haya cliente asignado.
     * @throws PersistenciaException Si no existe el folio,
     */
    public Cliente consultarClienteDeComanda(String folio) throws PersistenciaException;

}
