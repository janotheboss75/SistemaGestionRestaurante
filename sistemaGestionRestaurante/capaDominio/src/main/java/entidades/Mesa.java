package entidades;

import enums.EstadoMesa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa una mesa de un restaurante
 * 
 * @author janot
 */
@Entity
@Table(name = "Mesas")
public class Mesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idMesa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "numeroMesa", nullable = false)
    private Integer numeroMesa;
    
    @Column(name = "estadoMesa", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EstadoMesa estadoMesa;

    public Mesa() {
    }

    public Mesa(Integer numeroMesa, EstadoMesa estadoMesa) {
        this.numeroMesa = numeroMesa;
        this.estadoMesa = estadoMesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public EstadoMesa getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(EstadoMesa estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    @Override
    public String toString() {
        return "Mesa: " + this.getNumeroMesa();
    }
    
}
