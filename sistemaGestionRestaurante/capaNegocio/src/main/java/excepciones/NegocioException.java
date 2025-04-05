package excepciones;

/**
 * Clase NegocioException
 * 
 * @author janot
 */
public class NegocioException extends Exception{

    /**
     * Constructor para mandar un mensaje de la excepcion
     * @param message Mensaje que se va a mostrar
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * Constructor para mandar mensaje y causa
     * @param message Mensaje que se va a mostrar
     * @param cause Causa de la excepcion
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
