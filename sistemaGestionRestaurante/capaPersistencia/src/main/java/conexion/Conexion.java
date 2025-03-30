package conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase Conexion
 * Clase que contiene los metodos para crear y cerrar una conexion
 * 
 * @author janot
 */
public class Conexion {
    /**
     * Creacion del entityManagerFactory
     */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexionPU");
    
    /**
     * Metodo que crea un EntityManager y 
     * lo retorna
     * 
     * @return EntityManager
     */
    public static EntityManager crearConexion(){
        return emf.createEntityManager();
    }
    
    /**
     * Metodo que cierra la conexion del EntityManagerFactory
     */
    public static void cerrar(){
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
