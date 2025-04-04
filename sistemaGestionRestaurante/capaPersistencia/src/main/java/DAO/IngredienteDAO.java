package DAO;

/**
 *
 * @author janot
 */
public class IngredienteDAO {

    private static IngredienteDAO instanceIngredienteDAO;
    
    /**
     * Constructor privado para evitar instancias múltiples.
     */
    private IngredienteDAO() {
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
}
