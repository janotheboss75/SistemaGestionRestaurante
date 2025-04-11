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
    
    public Comanda modificarComanda(ComandaDTO comanda) throws NegocioException;
    
    public ProductoComanda agregarProductoAcomanda(ProductoComandaDTO productoComandaDTO) throws NegocioException;
    
    public List<Comanda> buscadorComandas(EstadoComanda estadoComanda, Date desde, Date hasta) throws NegocioException;
    
    public List<Comanda> consultarComandasPendientes() throws NegocioException;
    
    public Comanda cancelarComanda(Long idComanda) throws NegocioException;
    
    public Comanda finalizarComanda(Long idComanda) throws NegocioException;
    
    public Comanda consultarComandaPorID(Long idComanda) throws NegocioException;
    
    public boolean quitarProductoDecomanda(Long idProductoDeComanda) throws NegocioException;
    
    public List<ProductoComandaDTO> consultarProductosDeComanda(Long idComanda) throws NegocioException;
}
