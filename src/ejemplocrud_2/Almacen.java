// Definición del paquete donde se encuentra la clase
package ejemplocrud_2;

/*
 * Clase modelo que representa la entidad "Almacen".
 * Cada objeto de esta clase corresponde a un registro
 * de la tabla almacen en la base de datos.
 */

public class Almacen {
    
    // Atributo que representa la columna id_almacen (clave primaria en la base de datos)
    private int id;
    
    // Atributo que representa la columna nombre
    private String nombre;
    
    // Atributo que representa la columna descripcion
    private String descripcion;

    // Constructor vacío (permite crear un objeto Artista sin inicializar atributos)
    public Almacen() {} 

    // Constructor con parámetros 
    public Almacen(int id, String nombre, String descripcion) {
        this.id = id; // Asigna el valor del ID
        this.nombre = nombre; // Asigna el nombre del almacen
        this.descripcion = descripcion; // Asigna descripcion del almacen
    }

    // Métodos Getters y Setters (encapsulación de los atributos)

    // Devuelve el ID del almacen
    public int getId() { return id; }
    
    // Asigna un nuevo valor al ID del almacen
    public void setId(int id) { this.id = id; }

    // Devuelve el nombre del almacen
    public String getNombre() { return nombre; }
    
    // Asigna un nuevo nombre al almacen
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Devuelve descripcion del almacen
    public String getDescripcion() { return descripcion; }
    
    // Asigna una nueva descripcion para almcen
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    // Método toString sobrescrito para mostrar la información del almacen de forma legible
    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Descripcion: " + descripcion;
    }
}
