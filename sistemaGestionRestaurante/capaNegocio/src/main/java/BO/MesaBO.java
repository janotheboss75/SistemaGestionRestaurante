package BO;

import entidades.Mesa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IMesaBO;
import interfaces.IMesaDAO;
import java.util.List;

/**
 *
 * @author janot
 */
public class MesaBO implements IMesaBO{
    private IMesaDAO mesaDAO;

    public MesaBO(IMesaDAO mesaDAO) {
        this.mesaDAO = mesaDAO;
    }

    @Override
    public boolean agregarMesas(int cantidadMesas) throws NegocioException{
        try {
            return mesaDAO.agregarMesas(cantidadMesas);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Mesa> consultarMesas() throws NegocioException {
        try {
           return mesaDAO.consultarMesas();
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Mesa> consultarMesasDisponibles() throws NegocioException {
        try {
           return mesaDAO.consultarMesasDisponibles();
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    
    
}
