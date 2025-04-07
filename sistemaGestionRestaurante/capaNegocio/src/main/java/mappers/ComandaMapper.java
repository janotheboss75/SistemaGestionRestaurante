package mappers;

import DTOs.NuevaComandaDTO;
import DTOs.ProductoComandaDTO;
import entidades.Comanda;
import enums.EstadoComanda;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janot
 */
public class ComandaMapper {
    public static Comanda toEntity(NuevaComandaDTO nuevaComanda){
        //fechaComanda
        Date fechaActual = new Date();
        
        //Primera parte Folio
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        String fechaFormateada = formato.format(fechaActual);
        String folio = "OB-"+fechaFormateada;
        
        return new Comanda(folio, fechaActual, EstadoComanda.ABIERTA, nuevaComanda.getTotal(), nuevaComanda.getCliente(), nuevaComanda.getMesa());
    }
}
