package interfaces;

import DTOs.ComandaDTO;
import DTOs.NuevaComandaDTO;
import DTOs.ProductoComandaDTO;
import entidades.Comanda;
import entidades.ProductoComanda;
import enums.EstadoComanda;
import excepciones.NegocioException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IComandaBO {
    
    public NuevaComandaDTO crearComanda(NuevaComandaDTO comandaNueva) throws NegocioException;
    
    public boolean eliminarComanda(Long id) throws NegocioException ;
    
    public ComandaDTO modificarComanda(ComandaDTO comanda) throws NegocioException;
    
    public ProductoComanda agregarProductoAcomanda(ProductoComandaDTO productoComandaDTO) throws NegocioException;
    
    public List<Comanda> buscadorComandas(EstadoComanda estadoComanda, Date desde, Date hasta) throws NegocioException;
    
    public List<Comanda> consultarComandasPendientes() throws NegocioException;
    
}
