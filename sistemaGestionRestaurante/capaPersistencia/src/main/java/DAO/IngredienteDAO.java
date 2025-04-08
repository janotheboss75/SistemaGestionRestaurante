package DAO;

import conexion.Conexion;
import entidades.Ingrediente;
import excepciones.PersistenciaException;
import interfaces.IIngredienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author janot
 */
public class IngredienteDAO implements IIngredienteDAO{

    private static IngredienteDAO instanceIngredienteDAO;
    
    /**
     * Constructor privado para evitar instancias múltiples.
     */
    private IngredienteDAO(){
    }
    
    /**
     * Método para obtener la única instancia de IngredienteDAO.
     *
     * @return Instancia de IngredienteDAO.
     */
    public static IngredienteDAO getInstanceDAO() {
        if (instanceIngredienteDAO == null) {
            instanceIngredienteDAO = new IngredienteDAO();
        }
        return instanceIngredienteDAO;
        
        
    }    

    @Override
    public Ingrediente agregarIngredienteAlInventario(Ingrediente ingrediente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ingrediente modificarIngrediente(Ingrediente ingrediente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Ingrediente> consultarTodosLosIngredientes() throws PersistenciaException {
        List<Ingrediente> ingredientes = new ArrayList<>();
        EntityManager em = Conexion.crearConexion();
        
        try {
            ingredientes = em.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class).getResultList();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar a todos los productos", e);
            
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
        return ingredientes;
    }

    @Override
    public Ingrediente consultarIngredientePorId(Long idIngrediente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
