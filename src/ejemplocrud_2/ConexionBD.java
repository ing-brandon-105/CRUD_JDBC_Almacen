// Paquete donde se encuentra la clase
package ejemplocrud_2;

// Importación de las clases necesarias para manejar la conexión a la base de datos
import java.sql.Connection; // Representa la conexión a la base de datos
import java.sql.DriverManager; // Se encarga de gestionar la conexión con el driver JDBC
import java.sql.SQLException; // Maneja excepciones relacionadas con SQL

// Definición de la clase encargada de gestionar la conexión a la base de datos
public class ConexionBD {
    
    // Constante que almacena la URL de conexión a la base de datos MySQL
    // La URL incluye el nombre de la base de datos y parámetros de configuración
    private static final String URL = "jdbc:mysql://localhost:3306/inventario_db?useUnicode=true&characterEncoding=UTF-8";
    
    // Usuario de MySQL con permisos para acceder a la base de datos
    private static final String USUARIO = "root";
    
    // Contraseña del usuario de MySQL
    private static final String PASSWORD = "ingbrandon105";

    // Método estático que establece y devuelve una conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        // Se usa DriverManager para obtener una conexión con los parámetros definidos
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}
