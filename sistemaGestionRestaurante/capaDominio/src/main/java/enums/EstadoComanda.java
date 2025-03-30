package enums;

/**
 * Representa los posibles estados de una comanda en el sistema.
 * @author janot
 */
public enum EstadoComanda {
    /**
     * La comanda está activa y puede recibir modificaciones.
     */
    ABIERTA, 

    /**
     * La comanda ha sido procesada y entregada al cliente.
     */
    ENTREGADA, 

    /**
     * La comanda ha sido anulada y no será procesada.
     */
    CANCELADA
}
