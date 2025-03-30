package DTOs;

/**
 *
 * @author janot
 */
public class ClienteNuevoDTO {
    private String telefono;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correoElectronico;
    private String fechaRegistro;

    public ClienteNuevoDTO() {
    }

    public ClienteNuevoDTO(String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, String fechaRegistro) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.fechaRegistro = fechaRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

}
