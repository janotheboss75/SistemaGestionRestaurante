package BO;

import DAO.ProductoComandaDAO;
import DTOs.ComandaDTO;
import DTOs.NuevaComandaDTO;
import DTOs.ProductoComandaDTO;
import entidades.Comanda;
import entidades.ProductoComanda;
import excepciones.NegocioException;
import interfaces.IComandaBO;
import interfaces.IComandaDAO;
import interfaces.IProductoComandaDAO;
import java.util.ArrayList;
import java.util.List;
import mappers.ComandaMapper;
import mappers.ProductoComandaMapper;

/**
 *
 * @author janot
 */
public class ComandaBO implements IComandaBO{
    IComandaDAO comandaDAO;
    IProductoComandaDAO productoComandaDAO;

    public ComandaBO(IComandaDAO comandaDAO) {
        this.comandaDAO = comandaDAO;
        this.productoComandaDAO = ProductoComandaDAO.getInstanceDAO();
    }
    
    @Override
    public NuevaComandaDTO crearComanda(NuevaComandaDTO comandaNueva) throws NegocioException {
        Comanda comanda = ComandaMapper.toEntity(comandaNueva);
        Comanda comandaCreada = null;
              
        try {
           comandaCreada =  comandaDAO.crearComanda(comanda);    
           
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
        
        //Asignar productos a la comanda
        List<ProductoComandaDTO> productosComandaDTO = comandaNueva.getProductosComanda();
        List<ProductoComanda> productosComanda = new ArrayList<>();
        for (ProductoComandaDTO productoComandaDTO : productosComandaDTO) {
            ProductoComanda productoComanda = ProductoComandaMapper.toEntity(productoComandaDTO);
            productoComanda.setComanda(comandaCreada);
            productosComanda.add(productoComanda);
        }
        
        try {
            for (ProductoComanda productoComanda : productosComanda) {
                productoComandaDAO.agregarProductoAcomanda(productoComanda);
            }
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
        
        return comandaNueva;
    }

    @Override
    public boolean eliminarComanda(Long id) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ComandaDTO modificarComanda(ComandaDTO comanda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoComanda agregarProductoAcomanda(ProductoComandaDTO productoComandaDTO) throws NegocioException {
        ProductoComanda productoComanda = ProductoComandaMapper.toEntity(productoComandaDTO);
        
        try {
            return productoComandaDAO.agregarProductoAcomanda(productoComanda);
        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
}
