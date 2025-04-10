package mappers;

import DTOs.NuevaComandaDTO;
import DTOs.ProductoComandaDTO;
import entidades.Comanda;
import enums.EstadoComanda;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janot
 */
public class ComandaMapper {
    public static Comanda toEntity(NuevaComandaDTO nuevaComanda){
        LocalDateTime ahora = LocalDateTime.now();

        // Convertir a Date (con zona horaria del sistema)
        ZonedDateTime zdt = ahora.atZone(ZoneId.systemDefault());
        Date date = Date.from(zdt.toInstant());

        System.out.println("LocalDateTime: " + ahora);
        System.out.println("Date: " + date);
        
        //Primera parte Folio
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        String fechaFormateada = formato.format(date);
        String folio = "OB-"+fechaFormateada;
        
        return new Comanda(folio, date, EstadoComanda.ABIERTA, nuevaComanda.getTotal(), nuevaComanda.getCliente(), nuevaComanda.getMesa());
    }
}
