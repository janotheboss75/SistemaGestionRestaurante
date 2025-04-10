package BO;

import DAO.MesaDAO;
import DAO.ProductoComandaDAO;
import DTOs.ComandaDTO;
import DTOs.NuevaComandaDTO;
import DTOs.ProductoComandaDTO;
import entidades.Comanda;
import entidades.ProductoComanda;
import enums.EstadoComanda;
import enums.EstadoMesa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IComandaBO;
import interfaces.IComandaDAO;
import interfaces.IMesaDAO;
import interfaces.IProductoComandaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mappers.ComandaMapper;
import mappers.ProductoComandaMapper;

/**
 *
 * @author janot
 */
public class ComandaBO implements IComandaBO{
    IComandaDAO comandaDAO;
    IMesaDAO mesaDAO;
    IProductoComandaDAO productoComandaDAO;

    public ComandaBO(IComandaDAO comandaDAO) {
        this.comandaDAO = comandaDAO;
        this.mesaDAO = MesaDAO.getInstanceDAO();
        this.productoComandaDAO = ProductoComandaDAO.getInstanceDAO();
    }
    
    @Override
    public NuevaComandaDTO crearComanda(NuevaComandaDTO comandaNueva) throws NegocioException {
        Comanda comanda = ComandaMapper.toEntity(comandaNueva);
        Comanda comandaCreada = null;
              
        try {
           comandaCreada =  comandaDAO.crearComanda(comanda);   
           mesaDAO.cambiarEstadoDeMesa(comandaCreada.getMesa().getId(), EstadoMesa.OCUPADA);
           
        } catch (PersistenciaException e) {
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
        } catch (PersistenciaException e) {
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
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Comanda> buscadorComandas(EstadoComanda estadoComanda, Date desde, Date hasta) throws NegocioException {
        try {
            return comandaDAO.buscadorComandas(estadoComanda, desde, hasta);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<Comanda> consultarComandasPendientes() throws NegocioException {
        try {
           return comandaDAO.consultarComandasPorEstado(EstadoComanda.ABIERTA);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Comanda cancelarComanda(Long idComanda) throws NegocioException {
        try {
            return comandaDAO.cambiarEstadoComanda(idComanda, EstadoComanda.CANCELADA);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public Comanda finalizarComanda(Long idComanda) throws NegocioException {
        try {
            return comandaDAO.cambiarEstadoComanda(idComanda, EstadoComanda.ENTREGADA);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
}
