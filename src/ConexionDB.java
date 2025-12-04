import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Clase de conexión a la base de datos
public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/formas_db";
    private static final String USER = "Gabo";
    private static final String PASSWORD = "2301VgA!";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error conectando a la base de datos", e);
        }
    }
}
