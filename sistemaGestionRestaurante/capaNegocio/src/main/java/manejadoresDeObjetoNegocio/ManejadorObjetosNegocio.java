package manejadoresDeObjetoNegocio;

import BO.ClienteBO;
import BO.ComandaBO;
import BO.MesaBO;
import BO.ProductoBO;
import DAO.ClienteDAO;
import DAO.ComandaDAO;
import DAO.MesaDAO;
import DAO.ProductoDAO;
import interfaces.IClienteBO;
import interfaces.IClienteDAO;
import interfaces.IComandaBO;
import interfaces.IComandaDAO;
import interfaces.IMesaBO;
import interfaces.IMesaDAO;
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
    
    public static IMesaBO crearMesaBO(){
        IMesaDAO mesaDAO = MesaDAO.getInstanceDAO();
        
        IMesaBO mesaBO = new MesaBO(mesaDAO);
        
        return mesaBO;
    }
    
    public static IClienteBO crearClienteBO(){
        IClienteDAO clienteDAO = ClienteDAO.getInstanceDAO();
        
        IClienteBO clienteBO = new ClienteBO(clienteDAO);
        
        return clienteBO;
    }
    
    public static IComandaBO crearComandaBO(){
        IComandaDAO comandaDAO = ComandaDAO.getInstanceDAO();
        
        IComandaBO comandaBO = new ComandaBO(comandaDAO);
        
        return comandaBO;
    } 
}
