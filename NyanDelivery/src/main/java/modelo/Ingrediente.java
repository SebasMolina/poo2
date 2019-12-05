
package modelo;

/** ingrediente: se debe especificar el nombre y la cantidad.
 * 
 * 
 */
public class Ingrediente {
    private int id;
    private String nombre;
    private int cantidad;

/** Constructor por defecto.
 * 
 */
    public Ingrediente() {
    }
/** Constructor
 * 
 * @param nombre 
 * @param cantidad
 */
    public Ingrediente(int id, String nombre, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
/** Agregar un id.
 * 
 * @param id 
 */
    public void setId(int id) {
        this.id = id;
    }
/** Obtener el id.
 * 
 * @return 
 */
    public int getId() {
        return id;
    }
/** Obtener el nombre del ingrediente.
 * 
 * @return (String nombre)
 */
    public String getNombre() {
        return nombre;
    }
/** Agregar un nombre al ingrediente.
 * 
 * @param nombre 
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/** Obtener la cantidad del ingrediente.
 * 
 * @return (int cantidad)
 */
    public int getCantidad() {
        return cantidad;
    }
/** Agregar una cantidad al ingrediente.
 * 
 * @param cantidad 
 */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
