// Definimos el paquete donde se encuentra la clase
package ejemplocrud_2;

// Importamos las clases necesarias para la conexión y manipulación de la base de datos
import java.sql.*; // Contiene Connection, PreparedStatement, ResultSet, Statement, SQLException
import java.util.ArrayList;
import java.util.List;

/*
 * DAO = Data Access Object
 * Esta clase contiene todas las operaciones CRUD
 * sobre la tabla almacen
 */
public class AlmacenDAO {
    
    // Método para insertar un nuevo almacen en la base de datos
    public void crearAlmacen(Almacen almacen) {
        // Definimos la consulta SQL para insertar un nuevo almacen, con parámetros (?) para prevenir inyección SQL
        String sql = "INSERT INTO almacen (nombre, descripcion) VALUES (?, ?)";
        
        // Uso de try-with-resources para garantizar el cierre de la conexión y los recursos
        try (Connection conn = ConexionBD.getConnection(); // Obtener conexión a la base de datos
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar la consulta SQL con parámetros
            
            // Asignamos valores a los parámetros de la consulta
            pstmt.setString(1, almacen.getNombre()); // Primer parámetro: Nombre del almacen
            pstmt.setString(2, almacen.getDescripcion()); // Segundo parámetro: de almacen
            
            // Ejecutamos la consulta para insertar el registro
            pstmt.executeUpdate();
            System.out.println("✅ Almacen agregado exitosamente.");
            
        } catch (SQLException e) {
            // Captura cualquier error de SQL y lo muestra en la consola
            e.printStackTrace();
        }
    }

    // Método para obtener todos los almacenes de la base de datos
    public List<Almacen> obtenerAlmacenes() {
        List<Almacen> lista = new ArrayList<>(); // Lista donde se almacenarán los almacenes obtenidos
        
        // Definimos la consulta SQL para seleccionar todos los registros de la tabla "almacen"
        String sql = "SELECT * FROM almacen";

        // Uso de try-with-resources para gestionar los recursos de conexión
        try (Connection conn = ConexionBD.getConnection(); // Obtener conexión
             Statement stmt = conn.createStatement(); // Crear un objeto Statement para ejecutar la consulta
             ResultSet rs = stmt.executeQuery(sql)) { // Ejecutar la consulta y almacenar los resultados en ResultSet

            // Recorremos los resultados fila por fila
            while (rs.next()) {
                // Creamos un objeto Almacen con los datos obtenidos de la base de datos
                Almacen almacen = new Almacen(
                        rs.getInt("id_almacen"), // Obtener el ID del almacen
                        rs.getString("nombre"), // Obtener el nombre del almacen
                        rs.getString("descripcion") // Obtener la descripcion del almacen
                );
                lista.add(almacen); // Agregamos el artista a la lista
            }
        } catch (SQLException e) {
            // Captura cualquier error de SQL y lo muestra en la consola
            e.printStackTrace();
        }
        
        return lista; // Retornamos la lista con todos los almacenes obtenidos
    }

    // Método para actualizar un alamcen en la base de datos por su ID
    public void actualizarAlmacen(int id, String nombre, String descripcion) {
        // Definimos la consulta SQL para actualizar un almacen, utilizando parámetros (?) para mayor seguridad
        String sql = "UPDATE almacen SET nombre = ?, descripcion = ? WHERE id_almacen = ?";
        
        // Uso de try-with-resources para gestionar la conexión y recursos
        try (Connection conn = ConexionBD.getConnection(); // Obtener conexión
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar la consulta SQL
            
            // Asignamos los valores a los parámetros de la consulta
            pstmt.setString(1, nombre); // Primer parámetro: Nuevo nombre del almacen
            pstmt.setString(2, descripcion); // Segundo parámetro: descripcion del almacen
            pstmt.setInt(3, id); // Tercer parámetro: ID del almacen que queremos actualizar
            
            // Ejecutamos la consulta y obtenemos el número de filas afectadas
            int filasActualizadas = pstmt.executeUpdate();

            // Verificamos si se realizó la actualización correctamente
            if (filasActualizadas > 0) {
                System.out.println("✅ Almacen actualizado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el almacen con ID: " + id);
            }
        } catch (SQLException e) {
            // Captura cualquier error de SQL y lo muestra en la consola
            e.printStackTrace();
        }
    }

    // Método para eliminar un almacen de la base de datos por su ID
    public void eliminarAlmacen(int id) {
        // Definimos la consulta SQL para eliminar un almacen con el ID especificado
        String sql = "DELETE FROM almacen WHERE id_almacen = ?";
        
        // Uso de try-with-resources para gestionar la conexión y los recursos
        try (Connection conn = ConexionBD.getConnection(); // Obtener conexión
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar la consulta SQL
            
            // Asignamos el valor del ID al parámetro de la consulta
            pstmt.setInt(1, id);

            // Ejecutamos la consulta y obtenemos el número de filas eliminadas
            int filasEliminadas = pstmt.executeUpdate();

            // Verificamos si se realizó la eliminación correctamente
            if (filasEliminadas > 0) {
                System.out.println("✅ Almacen eliminado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el almacen con el ID: " + id);
            }
        } catch (SQLException e) {
            // Captura cualquier error de SQL y lo muestra en la consola
            e.printStackTrace();
        }
    }
}
