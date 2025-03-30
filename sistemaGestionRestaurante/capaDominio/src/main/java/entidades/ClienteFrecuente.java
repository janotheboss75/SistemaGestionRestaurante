package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author janot
 */
@Entity
@Table(name = "ClienteFrecuente")
public class ClienteFrecuente extends Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    public ClienteFrecuente() {
        super();
    }

    public ClienteFrecuente(String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, Date fechaRegistro) {
        super(telefono, nombre, apellidoPaterno, apellidoMaterno, correoElectronico, fechaRegistro);
    }
    
}
