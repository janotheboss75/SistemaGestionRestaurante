package BO;

import DAO.IngredienteProductoDAO;
import entidades.Ingrediente;
import excepciones.NegocioException;
import interfaces.IIngredienteBO;
import interfaces.IIngredienteDAO;
import interfaces.IIngredienteProductoDAO;
import interfaces.IProductoDAO;
import java.util.List;

/**
 *
 * @author janot
 */
public class IngredienteBO implements IIngredienteBO{
    IIngredienteDAO ingredienteDAO;
    IIngredienteProductoDAO ingredienteProductoDAO;

    public IngredienteBO(IIngredienteDAO ingredienteDAO) {
        this.ingredienteDAO = ingredienteDAO;
        this.ingredienteProductoDAO = IngredienteProductoDAO.getInstanceDAO();
    }
    
    @Override
    public List<Ingrediente> consultarTodosLosIngredientes() throws NegocioException {
        try {
            return ingredienteDAO.consultarTodosLosIngredientes();
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }    

    @Override
    public boolean quitarIngredienteAlProducto(Long idIngredienteProducto) throws NegocioException {
        try {
            return ingredienteProductoDAO.quitarIngredienteAlProducto(idIngredienteProducto);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
}
