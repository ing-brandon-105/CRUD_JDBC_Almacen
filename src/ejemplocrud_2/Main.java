1// Declaración del paquete donde se encuentra esta clase
package ejemplocrud_2;

// Importa las clases necesarias
import java.util.List; // Permite el uso de listas
import java.util.Scanner; // Permite la entrada de datos por consola

// Definición de la clase principal
public class Main {
    public static void main(String[] args) {
        // Crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Crea una instancia de AlmacenDAO, que maneja las operaciones CRUD
        AlmacenDAO almacenDAO = new AlmacenDAO();

        // Bucle infinito para mostrar el menú hasta que el usuario decida salir
        while (true) {
            // Muestra el menú de opciones en la consola
            System.out.println("\n=== CRUD de Almacenes ===");
            System.out.println("1. Agregar Almacen");
            System.out.println("2. Listar Almacen");
            System.out.println("3. Actualizar Almacen");
            System.out.println("4. Eliminar Almacen");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Lee la opción ingresada por el usuario
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer del scanner después de leer un número
            
            // Estructura switch para manejar la opción seleccionada
            switch (opcion) {
                case 1:
                    // Opción para agregar un artista
                    System.out.print("Ingrese el nombre del almacen: ");
                    String nombre = scanner.nextLine(); // Lee el nombre del almacen
                    System.out.print("Ingrese decripcion del almacen: ");
                    String descripcion = scanner.nextLine(); // Lee el descripcion almacen
                    // Crea un nuevo objeto Artista con los datos ingresados
                    Almacen almacen = new Almacen(0, nombre, descripcion);
                    // Llama al método para agregar el artista en la base de datos
                    almacenDAO.crearAlmacen(almacen);
                    break;
                
                case 2:
                    // Opción para listar los almacenes
                    List<Almacen> lista = almacenDAO.obtenerAlmacenes(); // Obtiene la lista de almacenes
                    System.out.println("\n=== Lista de Almacenes ===");
                    // Itera sobre la lista e imprime cada artista
                    for (Almacen a : lista) {
                        System.out.println(a);
                    }
                    break;

                case 3:
                    // Opción para actualizar los datos de un artista
                    System.out.print("Ingrese el ID del almacen a actualizar: ");
                    int idActualizar = scanner.nextInt(); // Lee el ID del almacen a actualizar
                    scanner.nextLine(); // Limpia el buffer del scanner
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine(); // Lee el nuevo nombre
                    System.out.print("Ingrese nueva descripcion: ");
                    String nuevoDescripcion = scanner.nextLine(); // Lee el nueva descripcion
                    // Llama al método para actualizar el almacen en la base de datos
                    almacenDAO.actualizarAlmacen(idActualizar, nuevoNombre, nuevoDescripcion);
                    break;

                case 4:
                    // Opción para eliminar un almacen
                    System.out.print("Ingrese el ID del almacen a eliminar: ");
                    int idEliminar = scanner.nextInt(); // Lee el ID del artista a eliminar
                    // Llama al método para eliminar el artista en la base de datos
                    almacenDAO.eliminarAlmacen(idEliminar);
                    break;

                case 5:
                    // Opción para salir del programa
                    System.out.println("Saliendo del sistema...");
                    scanner.close(); // Cierra el scanner antes de salir
                    return; // Sale del método main y finaliza el programa

                default:
                    // Mensaje en caso de que el usuario ingrese una opción no válida
                    System.out.println("⚠️ Opción no válida, intente nuevamente.");
            }
        }
    }
}
