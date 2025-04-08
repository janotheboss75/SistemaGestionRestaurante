package interfaces;

import entidades.Ingrediente;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IIngredienteBO {
    public List<Ingrediente> consultarTodosLosIngredientes() throws NegocioException;
}
