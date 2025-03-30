package excepciones;

/**
 * Clase PersistenciaException
 * 
 * @author janot
 */
public class PersistenciaException extends Exception{

    /**
     * Constructor para mandar un mensaje de la excepcion
     * @param message Mensaje que se va a mostrar
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor para mandar mensaje y causa
     * @param message Mensaje que se va a mostrar
     * @param cause Causa de la excepcion
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
