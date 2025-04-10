package interfaces;

import DTOs.IngredienteProductoDTO;
import entidades.Ingrediente;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IIngredienteBO {
    public List<Ingrediente> consultarTodosLosIngredientes() throws NegocioException;
    
    public boolean quitarIngredienteAlProducto(Long idIngredienteProducto) throws NegocioException;
    
}
