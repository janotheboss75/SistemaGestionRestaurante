package interfaces;

import entidades.Mesa;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IMesaDAO {
    public boolean agregarMesas(int cantidadMesas) throws PersistenciaException;
    
    public List<Mesa> consultarMesas() throws PersistenciaException;
    
    public List<Mesa> consultarMesasDisponibles() throws PersistenciaException;
}
