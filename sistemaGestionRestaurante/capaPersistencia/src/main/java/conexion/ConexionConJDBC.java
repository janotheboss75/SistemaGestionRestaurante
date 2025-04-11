package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author janot
 */
public class ConexionConJDBC {
    public static Connection obtenerConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/restaurante";
        String usuario = "root";
        String contraseña = "12345678";

        return DriverManager.getConnection(url, usuario, contraseña);
    }
}
