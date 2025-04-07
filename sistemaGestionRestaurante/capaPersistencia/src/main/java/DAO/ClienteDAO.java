package DAO;

import conexion.Conexion;
import entidades.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClienteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author alfre
 */
/**
 * Implementacion de la interfaz IClienteDAO que proporciona acceso a los datos
 * de los clientes usando JPA. Esta clase sigue el patron Singleton para asegurar
 * que solo exista una instancia de ClienteDAO durante la ejecucion.
 * 
 * Proporciona metodos para registrar, eliminar, actualizar y consultar clientes
 * en la base de datos.
 */
public class ClienteDAO implements IClienteDAO {

    /**
     * Instancia unica de ClienteDAO.
     */
    private static ClienteDAO instance;

    /**
     * Constructor privado para aplicar el patron Singleton.
     */
    private ClienteDAO() {
    }

    /**
     * Obtiene la instancia unica de ClienteDAO.
     * 
     * @return La instancia de ClienteDAO.
     */
    public static ClienteDAO getInstanceDAO() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    /**
     * Registra un nuevo cliente en la base de datos.
     * 
     * @param cliente Cliente que se desea registrar.
     * @return El cliente registrado con sus datos completos.
     * @throws PersistenciaException Si no se pudo registrar el cliente o si ya existe
     * un cliente con el mismo telefono.
     */
    @Override
    public Cliente registrarCliente(Cliente cliente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        if (em == null) {
            throw new PersistenciaException("No se pudo crear la conexion.");
        }

        try {
            // Verificar si ya existe un cliente con ese telefono
            Cliente existente = consultarClientePorTelefono(cliente.getTelefono());
            if (existente != null) {
                throw new PersistenciaException("Ya existe un cliente con ese telefono.");
            }

            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return cliente;
        } catch (PersistenciaException e) {
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar cliente: " + e.getMessage(), e);
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    /**
     * Elimina un cliente de la base de datos mediante su telefono.
     * 
     * @param telefono Telefono del cliente que se desea eliminar.
     * @return true si el cliente fue eliminado, false si no se encontro.
     * @throws PersistenciaException Si ocurre un error durante la eliminacion.
     */
    @Override
    public boolean eliminarCliente(String telefono) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        if (em == null) {
            throw new PersistenciaException("No se pudo crear la conexion.");
        }

        try {
            Cliente cliente = consultarClientePorTelefono(telefono);
            if (cliente == null) return false;

            em.getTransaction().begin();
            Cliente clienteRef = em.merge(cliente);
            em.remove(clienteRef);
            em.getTransaction().commit();
            return true;
        } catch (PersistenciaException e) {
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar cliente: " + e.getMessage(), e);
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    /**
     * Actualiza los datos de un cliente en la base de datos.
     * 
     * @param cliente Cliente con los datos nuevos.
     * @return El cliente actualizado.
     * @throws PersistenciaException Si ocurre un error durante la actualizacion.
     */
    @Override
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        if (em == null) {
            throw new PersistenciaException("No se pudo crear la conexion.");
        }

        try {
            em.getTransaction().begin();
            Cliente actualizado = em.merge(cliente);
            em.getTransaction().commit();
            return actualizado;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al actualizar cliente: " + e.getMessage(), e);
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    /**
     * Consulta un cliente por su numero de telefono.
     * 
     * @param telefono Numero de telefono del cliente a buscar.
     * @return El cliente encontrado o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public Cliente consultarClientePorTelefono(String telefono) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        if (em == null) {
            throw new PersistenciaException("No se pudo crear la conexion.");
        }

        try {
            TypedQuery<Cliente> query = em.createQuery(
                "SELECT c FROM Cliente c WHERE c.telefono = :telefono", Cliente.class);
            query.setParameter("telefono", telefono);
            List<Cliente> resultados = query.getResultList();
            return resultados.isEmpty() ? null : resultados.get(0);
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar cliente por telefono: " + e.getMessage(), e);
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    /**
     * Consulta todos los clientes registrados en la base de datos.
     * 
     * @return Lista de todos los clientes.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Cliente> consultarTodosLosClientes() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        if (em == null) {
            throw new PersistenciaException("No se pudo crear la conexion.");
        }

        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar todos los clientes: " + e.getMessage(), e);
        } finally {
            if (em.isOpen()) em.close();
        }
    }
}
