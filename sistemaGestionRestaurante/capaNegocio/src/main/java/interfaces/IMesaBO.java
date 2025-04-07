package interfaces;

import entidades.Mesa;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IMesaBO {
    public boolean agregarMesas(int cantidadMesas) throws NegocioException;
    
    public List<Mesa> consultarMesas() throws NegocioException;
    
    public List<Mesa> consultarMesasDisponibles() throws NegocioException;
    
}
