package interfaces;

import entidades.Ingrediente;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define los metodos que tendra la Clase IngredienteDAO
 * 
 * @author janot
 */
public interface IIngredienteDAO {
    
    /**
     * Agrega un nuevo ingrediente a la bd.
     * 
     * @return Ingrediente con su id asignado.
     * @throws PersistenciaException Si no se logra la insercion.
     */
    public Ingrediente agregarIngredienteAlInventario() throws PersistenciaException;
    
    /**
     * Modifica un ingrediente de la bd.
     * 
     * @param ingrediente Ingrediente con los datos nuevos.
     * @param idIngrediente Id del ingrediente que se modificara.
     * @return Ingrediente con los datos nuevos y su id.
     * @throws PersistenciaException Si no encuentra el ingrediente a modificar
     */
    public Ingrediente modificarIngrediente(Ingrediente ingrediente, Long idIngrediente) throws PersistenciaException;
    
    /**
     * Elimina un ingrediente de la bd.
     * @param idIngrediente Identificador del ingrediente que se desea eliminar.
     * @return true si se logra eliminar y false en caso contrario.
     * @throws PersistenciaException Si no encuentra el ingrediente a eliminar.
     */
    public boolean eliminarIngrediente(Long idIngrediente) throws PersistenciaException;
    
    /**
     * Consulta todos los ingredientes de la bd.
     * 
     * @return Lista con todos los ingredientes registrados.
     * @throws PersistenciaException Si no se logra hacer la consulta.
     */
    public List<Ingrediente> consultarTodosLosIngredientes() throws PersistenciaException;
    
    /**
     * Consulta un ingrediente por su id.
     * 
     * @param idIngrediente Identificador del ingrediente que se desea consultar.
     * @return El ingrediente.
     * @throws PersistenciaException Si el id del ingrediente no existe.
     */
    public Ingrediente consultarIngredientePorId(Long idIngrediente) throws PersistenciaException;
}
