package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Clase abstracta que representa un cliente.
 * 
 * <p>Esta entidad se almacena en la base de datos en la tabla "Clientes".
 * Se utiliza la estrategia de herencia "JOINED" para permitir la extensión
 * de la clase en futuras subclases.</p>
 * 
 * @author janot
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "Clientes")
public abstract class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * Número de teléfono del cliente. Se utiliza como clave primaria.
     */
    @Id
    @Column(name = "telefono", nullable = false, length = 250)
    private String telefono;
    
    /**
     * Nombre del cliente.
     */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    /**
     * Apellido paterno del cliente.
     */
    @Column(name = "apellidoPaterno", nullable = false, length = 100)
    private String apellidoPaterno;
    
    /**
     * Apellido materno del cliente. Puede ser nulo.
     */
    @Column(name = "apellidoMaterno", length = 100)
    private String apellidoMaterno;
    
    /**
     * Correo electrónico del cliente. Puede ser nulo.
     */
    @Column(name = "correoElectronico", length = 200)
    private String correoElectronico;
    
    /**
     * Fecha de registro del cliente en la base de datos.
     */
    @Column(name = "fechaRegistro", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private LocalDate fechaRegistro;
    
    /**
     * Lista de comandas asociadas al cliente.
     * Relacion uno a muchos, bidireccional, la entidad Comanda es la dueña
     * de la relacion.
     */
    @OneToMany(mappedBy = "cliente")
    private List<Comanda> comandas = new ArrayList<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Cliente() {}

    /**
     * Constructor con parámetros.
     * 
     * @param telefono Número de teléfono del cliente.
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente (puede ser nulo).
     * @param correoElectronico Correo electrónico del cliente (puede ser nulo).
     * @param fechaRegistro Fecha de registro del cliente.
     */
    public Cliente(String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, LocalDate fechaRegistro) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.fechaRegistro = fechaRegistro;
    }

    // Métodos Getters y Setters con documentación
    
    /**
     * Obtiene el número de teléfono del cliente.
     * 
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del cliente.
     * 
     * @param telefono Teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre Nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     * 
     * @return Apellido paterno del cliente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del cliente.
     * 
     * @param apellidoPaterno Apellido paterno del cliente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     * 
     * @return Apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del cliente.
     * 
     * @param apellidoMaterno Apellido materno del cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     * 
     * @return Correo electrónico del cliente.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el correo electrónico del cliente.
     * 
     * @param correoElectronico Correo electrónico del cliente.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene la fecha de registro del cliente.
     * 
     * @return Fecha de registro.
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece la fecha de registro del cliente.
     * 
     * @param fechaRegistro Fecha de registro.
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene la lista de comandas asociadas al cliente.
     * 
     * @return Lista de comandas.
     */
    public List<Comanda> getComandas() {
        return comandas;
    }

    /**
     * Establece la lista de comandas asociadas al cliente.
     * 
     * @param comandas Lista de comandas.
     */
    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }

    /**
     * Representación en cadena del objeto Cliente.
     * 
     * @return Cadena con los datos del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" + "telefono=" + telefono + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", correoElectronico=" + correoElectronico + ", fechaRegistro=" + fechaRegistro + ", comandas=" + comandas + '}';
    }
}
