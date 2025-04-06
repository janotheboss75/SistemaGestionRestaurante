package manejadoresDeObjetoNegocio;

import BO.ProductoBO;
import DAO.ProductoDAO;
import interfaces.IProductoBO;
import interfaces.IProductoDAO;

/**
 *
 * @author janot
 */
public class ManejadorObjetosNegocio {
    public static IProductoBO crearProductoBO(){
        IProductoDAO productoDAO = ProductoDAO.getInstanceDAO();
        
        IProductoBO productoBO = new ProductoBO(productoDAO);
        
        return productoBO;
    }
}
