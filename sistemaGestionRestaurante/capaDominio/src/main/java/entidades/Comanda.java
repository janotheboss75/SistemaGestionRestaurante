package entidades;

import enums.EstadoComanda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Entidad que representa una comanda en el sistema.
 * Una comanda es una orden realizada por un cliente e incluye
 * información sobre productos, estado y fecha de la orden.
 * 
 * @author janot
 */
@Entity
@Table(name = "comandas")
public class Comanda implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /** Identificador único de Comanda. */
    @Id
    @Column(name = "idComanda")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /** 
     * Folio generado
     */
    @Column(name = "folio", nullable = false, length = 20)
    private String folio;
    
    /** 
     * Fecha en la que se creó la comanda 
     */
    @Column(name = "fechaComanda", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaComanda;
    
    /** 
     * Estado actual de la comanda 
     */
    @Column(name = "estado", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EstadoComanda estado;

    /** 
     * Total a pagar por la comanda 
     */
    @Column(name = "total", nullable = false)
    private double total;
    
    /** 
     * Cliente asociado a la comanda 
     * Relacion muchos a uno, bidireccional, esta clase es la dueña 
     * de la relacion
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente", nullable = true)
    private Cliente cliente;
    
    /** 
     * Lista de productos incluidos en la comanda
     * Relacion uno a muchos, bidireccional, la entidad ProductoComanda 
     * es la dueña de la relacion.
     */
    @OneToMany(mappedBy = "comanda", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private List<ProductoComanda> productos = new ArrayList<>();
    
    /**
     * Mesa que se le asigna a la comanda
     * Relacion muchos a uno, no es bidireccional
     */
    @ManyToOne()
    @JoinColumn(name = "Idmesa", nullable = false)
    private Mesa mesa;
    
    /**
     * Constructor por defecto.
     */
    public Comanda() {
    }

    /**
     * Constructor que inicializa todos los atributos de la comanda.
     * 
     * @param folio Identificador único de la comanda.
     * @param fechaComanda Fecha en la que se creó la comanda.
     * @param estado Estado actual de la comanda.
     * @param total Monto total de la comanda.
     * @param cliente Cliente que realizó la comanda.
     * @param mesa Mesa que se le asignara a la comanda.
     */
    public Comanda(String folio, Date fechaComanda, EstadoComanda estado, double total, Cliente cliente, Mesa mesa) {
        this.folio = folio;
        this.fechaComanda = fechaComanda;
        this.estado = estado;
        this.total = total;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    /**
    * Obtiene el folio de la comanda.
    * 
    * @return El folio de la comanda.
    */
   public String getFolio() {
       return folio;
   }

   /**
    * Establece el folio de la comanda.
    * 
    * @param folio El folio a asignar.
    */
   public void setFolio(String folio) {
       this.folio = folio;
   }

   /**
    * Obtiene la fecha de la comanda.
    * 
    * @return La fecha de la comanda.
    */
   public Date getFechaComanda() {
       return fechaComanda;
   }

   /**
    * Establece la fecha de la comanda.
    * 
    * @param fechaComanda La fecha a asignar.
    */
   public void setFechaComanda(Date fechaComanda) {
       this.fechaComanda = fechaComanda;
   }

   /**
    * Obtiene el estado de la comanda.
    * 
    * @return El estado de la comanda.
    */
   public EstadoComanda getEstado() {
       return estado;
   }

   /**
    * Establece el estado de la comanda.
    * 
    * @param estado El estado a asignar.
    */
   public void setEstado(EstadoComanda estado) {
       this.estado = estado;
   }

   /**
    * Obtiene el total de la comanda.
    * 
    * @return El total de la comanda.
    */
   public double getTotal() {
       return total;
   }

   /**
    * Establece el total de la comanda.
    * 
    * @param total El total a asignar.
    */
   public void setTotal(double total) {
       this.total = total;
   }

   /**
    * Obtiene el cliente asociado a la comanda.
    * 
    * @return El cliente de la comanda.
    */
   public Cliente getCliente() {
       return cliente;
   }

   /**
    * Establece el cliente de la comanda.
    * 
    * @param cliente El cliente a asignar.
    */
   public void setCliente(Cliente cliente) {
       this.cliente = cliente;
   }

   /**
    * Obtiene la lista de productos asociados a la comanda.
    * 
    * @return Lista de productos de la comanda.
    */
   public List<ProductoComanda> getProductos() {
       return productos;
   }

   /**
    * Establece la lista de productos de la comanda.
    * 
    * @param productos Lista de productos a asignar.
    */
   public void setProductos(List<ProductoComanda> productos) {
       this.productos = productos;
   }

   /**
    * Obtiene el identificador único de la comanda.
    * 
    * @return ID de la comanda.
    */
   public Long getId() {
       return id;
   }

   /**
    * Establece el identificador único de la comanda.
    * 
    * @param id El identificador a asignar.
    */
   public void setId(Long id) {
       this.id = id;
   }

   /**
    * Obtiene la mesa asociada a la comanda.
    * 
    * @return La mesa de la comanda.
    */
   public Mesa getMesa() {
       return mesa;
   }

   /**
    * Establece la mesa de la comanda.
    * 
    * @param mesa La mesa a asignar.
    */
   public void setMesa(Mesa mesa) {
       this.mesa = mesa;
   }

   /**
    * Retorna una representación en cadena de la comanda.
    * 
    * @return Cadena que representa la comanda.
    */
   @Override
   public String toString() {
       return "Comanda{" + "folio=" + folio + ", fechaComanda=" + fechaComanda + ", estado=" + estado + ", total=" + total + ", mesa=" + mesa.getNumeroMesa() + '}';
   }

}
