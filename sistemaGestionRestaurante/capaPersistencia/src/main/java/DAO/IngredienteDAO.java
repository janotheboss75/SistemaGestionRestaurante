package DAO;

import entidades.Ingrediente;
import excepciones.PersistenciaException;
import interfaces.IIngredienteDAO;
import java.util.List;

/**
 *
 * @author janot
 */
public class IngredienteDAO implements IIngredienteDAO{

    /**
     * Agrega un nuevo ingrediente a la bd.
     * 
     * @return Ingrediente con su id asignado.
     * @throws PersistenciaException Si no se logra la insercion.
     */
    @Override
    public Ingrediente agregarIngredienteAlInventario() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Modifica un ingrediente de la bd.
     * 
     * @param ingrediente Ingrediente con los datos nuevos.
     * @param idIngrediente Id del ingrediente que se modificara.
     * @return Ingrediente con los datos nuevos y su id.
     * @throws PersistenciaException Si no encuentra el ingrediente a modificar
     */
    @Override
    public Ingrediente modificarIngrediente(Ingrediente ingrediente, Long idIngrediente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //METODO IGNORADO HASTA SABER DUDAS
    /*
    @Override
    public boolean eliminarIngrediente(Long idIngrediente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/

    /**
     * Consulta todos los ingredientes de la bd.
     * 
     * @return Lista con todos los ingredientes registrados.
     * @throws PersistenciaException Si no se logra hacer la consulta.
     */
    @Override
    public List<Ingrediente> consultarTodosLosIngredientes() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Consulta un ingrediente por su id.
     * 
     * @param idIngrediente Identificador del ingrediente que se desea consultar.
     * @return El ingrediente.
     * @throws PersistenciaException Si el id del ingrediente no existe.
     */
    @Override
    public Ingrediente consultarIngredientePorId(Long idIngrediente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
