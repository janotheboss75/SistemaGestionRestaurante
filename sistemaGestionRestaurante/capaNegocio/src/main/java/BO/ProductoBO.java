package BO;

import DAO.IngredienteProductoDAO;
import DTOs.IngredienteProductoDTO;
import DTOs.NuevoProductoDTO;
import DTOs.ProductoDTO;
import entidades.IngredienteProducto;
import entidades.Producto;
import enums.TipoProducto;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IIngredienteProductoDAO;
import interfaces.IProductoBO;
import interfaces.IProductoDAO;
import java.util.List;
import mappers.ProductoMapper;

/**
 *
 * @author janot
 */
public class ProductoBO implements IProductoBO{
    private IProductoDAO productoDAO;
    private IIngredienteProductoDAO ingredienteProductoDAO;

    public ProductoBO(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
        this.ingredienteProductoDAO = IngredienteProductoDAO.getInstanceDAO();
    }
    
    @Override
    public ProductoDTO agregarProductoAlMenu(NuevoProductoDTO nuevoProducto) throws NegocioException{
        Producto producto = ProductoMapper.toEntity(nuevoProducto);
            
        List<IngredienteProducto> ingredientesProducto = producto.getIngredientes();
        
        try {
            Producto productoRegistrado = productoDAO.agregarProductoAlMenu(producto);    
            for (IngredienteProductoDTO ingredienteProductoDTO : nuevoProducto.getIngredientesProductos()) {
                ingredientesProducto.add(new IngredienteProducto(productoRegistrado, ingredienteProductoDTO.getIngrediente(), ingredienteProductoDTO.getCantidad()));
            }
            
            try {
                for (IngredienteProducto ingredienteProducto : ingredientesProducto) {
                    ingredienteProductoDAO.asignarIngredienteAlProducto(productoRegistrado.getId(), ingredienteProducto.getIngrediente().getId(), ingredienteProducto.getCantidad());
                }
            } catch (PersistenciaException e) {
                throw new NegocioException(e.getMessage());
            }
            
            return ProductoMapper.toDTO(productoRegistrado);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error: No se pudo guardar el producto " + nuevoProducto.getNombre() + " a la BD", e);
        }       
    }

    @Override
    public List<Producto> consultarProductosHabilitados() throws NegocioException {
        try {
            return productoDAO.consultarProductosHabilitados();
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Producto> consultarTodosLosProductos()throws NegocioException{
        try {
            return productoDAO.consultarTodosLosProductos();
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Producto> busquedaProducto(TipoProducto tipo, String busqueda) throws NegocioException {
        try {
            return productoDAO.busquedaProductos(tipo, busqueda);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public boolean inhabilitarProductoDelMenu(Long idProducto) throws NegocioException {
        try {
            return productoDAO.inhabilitarProducto(idProducto);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error: No se pudo eliminar el producto con el id: " + idProducto,e);
        }
    }

    @Override
    public boolean habilitarProductoDelMenu(Long idProducto) throws NegocioException {
        try {
            return productoDAO.habilitarProducto(idProducto);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<IngredienteProducto> consultarIngredientesProducto(Long idProducto) throws NegocioException {
        try {
            return productoDAO.consultarIngredientesDelProducto(idProducto);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Producto consultarProductoPorId(Long idProducto) throws NegocioException {
        try {
            return productoDAO.consultarProductoPorId(idProducto);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Producto modificarProducto(ProductoDTO p) throws NegocioException {
        Producto producto = ProductoMapper.toEntity(p);
                
         List<IngredienteProducto> ingredientesProducto = producto.getIngredientes();
                
        
        try {
           Producto productoModificado = productoDAO.modificarProductoDelMenu(producto);
           
            for (IngredienteProductoDTO ingredienteProductoDTO : p.getIngredientes()) {
                IngredienteProducto ingredienteProducto = new IngredienteProducto(productoModificado, ingredienteProductoDTO.getIngrediente(), ingredienteProductoDTO.getCantidad());
                ingredienteProducto.setId(ingredienteProductoDTO.getId());
                
                ingredientesProducto.add(ingredienteProducto);
            }
            
            try {
                for (IngredienteProducto ingredienteProducto : ingredientesProducto) {
                    if(ingredienteProducto.getId() == null){
                        ingredienteProductoDAO.asignarIngredienteAlProducto(productoModificado.getId(), ingredienteProducto.getIngrediente().getId(), ingredienteProducto.getCantidad());
                    }
                }
            } catch (PersistenciaException e) {
                throw new NegocioException(e.getMessage());
            }
            
            return productoModificado;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }

    }
    
}
