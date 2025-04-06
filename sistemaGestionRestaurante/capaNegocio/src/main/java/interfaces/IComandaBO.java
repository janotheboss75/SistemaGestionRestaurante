package interfaces;

import DTOs.ComandaDTO;
import DTOs.NuevaComandaDTO;
import excepciones.NegocioException;

/**
 *
 * @author janot
 */
public interface IComandaBO {
    
    public NuevaComandaDTO crearComanda(NuevaComandaDTO comandaNueva) throws NegocioException;
    
    public boolean eliminarComanda(Long id) throws NegocioException;
    
    public ComandaDTO modificarComanda(ComandaDTO comanda);
    
}
