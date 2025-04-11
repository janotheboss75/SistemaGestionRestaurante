package mappers;

import DTOs.ComandaDTO;
import DTOs.NuevaComandaDTO;
import DTOs.ProductoComandaDTO;
import entidades.Comanda;
import entidades.ProductoComanda;
import enums.EstadoComanda;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author janot
 */
public class ComandaMapper {
    public static Comanda toEntity(NuevaComandaDTO nuevaComanda){
        LocalDateTime ahora = LocalDateTime.now();

        // Convertir a Date (con zona horaria del sistema)
        ZonedDateTime zdt = ahora.atZone(ZoneId.of("America/Hermosillo"));
        Date date = Date.from(zdt.toInstant());

        //Primera parte Folio
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        String fechaFormateada = formato.format(date);
        String folio = "OB-"+fechaFormateada;
        
        // Segunda parte: número aleatorio formateado
        int numeroRandom = ThreadLocalRandom.current().nextInt(1, 1000);
        String numeroFormateado = String.format("%03d", numeroRandom); // convierte 7 en "007", etc.

        folio = "OB-" + fechaFormateada + "-" + numeroFormateado;
        
        
        return new Comanda(folio, date, EstadoComanda.ABIERTA, nuevaComanda.getTotal(), nuevaComanda.getCliente(), nuevaComanda.getMesa());
    }
    
    public static ComandaDTO toDTO(Comanda comanda){  
        List<ProductoComandaDTO> productosComanda = new ArrayList<>();
        for (ProductoComanda producto : comanda.getProductos()) {
            productosComanda.add(new ProductoComandaDTO(producto.getProducto(), producto.getPrecioActual(), producto.getComentario(), (int)producto.getCantidad(), producto.getImporte()));
        }

        
        return new ComandaDTO(comanda.getId(), comanda.getFolio(), comanda.getFechaComanda(), comanda.getEstado(), comanda.getTotal(), comanda.getCliente(), comanda.getMesa(), productosComanda);
    }
    
    
    public static Comanda toEntity(ComandaDTO comandaDTO){
        Comanda c = new Comanda(comandaDTO.getFolio(), comandaDTO.getFechaComanda(), comandaDTO.getEstado(), comandaDTO.getTotal(), comandaDTO.getCliente(), comandaDTO.getMesa());
        c.setId(comandaDTO.getId());
        
        return c;
    }
    
    
}