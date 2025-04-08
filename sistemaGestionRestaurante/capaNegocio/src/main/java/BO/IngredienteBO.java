package BO;

import entidades.Ingrediente;
import excepciones.NegocioException;
import interfaces.IIngredienteBO;
import interfaces.IIngredienteDAO;
import interfaces.IProductoDAO;
import java.util.List;

/**
 *
 * @author janot
 */
public class IngredienteBO implements IIngredienteBO{
    IIngredienteDAO ingredienteDAO;

    public IngredienteBO(IIngredienteDAO ingredienteDAO) {
        this.ingredienteDAO= ingredienteDAO;
    }
    
    @Override
    public List<Ingrediente> consultarTodosLosIngredientes() throws NegocioException {
        try {
            return ingredienteDAO.consultarTodosLosIngredientes();
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
}
