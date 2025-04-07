package interfaces;

import DTOs.ComandaDTO;
import DTOs.NuevaComandaDTO;
import DTOs.ProductoComandaDTO;
import entidades.ProductoComanda;
import excepciones.NegocioException;

/**
 *
 * @author janot
 */
public interface IComandaBO {
    
    public NuevaComandaDTO crearComanda(NuevaComandaDTO comandaNueva) throws NegocioException;
    
    public boolean eliminarComanda(Long id) throws NegocioException ;
    
    public ComandaDTO modificarComanda(ComandaDTO comanda) throws NegocioException;
    
    public ProductoComanda agregarProductoAcomanda(ProductoComandaDTO productoComandaDTO) throws NegocioException;
    
}
