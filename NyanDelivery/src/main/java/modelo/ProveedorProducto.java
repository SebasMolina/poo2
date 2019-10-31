
package modelo;


import java.time.LocalTime;
import java.util.ArrayList;
/** Es la clase para el comercio.
 * 
 * 
 */
public class ProveedorProducto extends Persona{
    
    
    private String Ciudad;
    private String razonSocial;
    private Direccion direccion;
    private ArrayList<Producto> productos;
    private LocalTime horaInicio;
    private LocalTime horaCierre;
    private ArrayList<Opinion> opiniones;
    
    /** Constructor por defecto.
     * 
     */
    public ProveedorProducto() {
        this.productos = new ArrayList<>();
        this.opiniones = new ArrayList<>();
    }
    
    public ProveedorProducto(String mail, String contraseña, String nombre, String apellido) {
        super.setMail(mail);
        super.setContraseña(contraseña);
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.productos = new ArrayList<>();
        this.opiniones = new ArrayList<>();
    }
/** Obtener la ciudad.
 * 
 * @return (String ciudad)
 */
    public String getCiudad() {
        return Ciudad;
    }
/** Agregar una ciudad.
 * 
 * @param Ciudad 
 */
    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }
/** Obtener razon social.
 * 
 * @return (String razonSocial)
 */
    public String getRazonSocial() {
        return razonSocial;
    }
/** Agregar razon social.
 * 
 * @param razonSocial 
 */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
/** Obtener direccion.
 * 
 * @return (direccion)
 */
    public Direccion getDireccion() {
        return direccion;
    }
/** Agregar una direccion.
 * 
 * @param direccion 
 */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
/** Obtener listado de productos.
 * 
 * @return (lista productos)
 */
    public ArrayList<Producto> getProductos() {
        return productos;
    }
/**Obtener un horario de inicio.
 * 
 * @return (horario de inicio)
 */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }
/** Agregar un horario de inicio.
 * 
 * @param horaInicio 
 */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
/** Obtener horario de cierre.
 * 
 * @return 
 */
    public LocalTime getHoraCierre() {
        return horaCierre;
    }
/** Agregar un horario de cierre.
 * 
 * @param horaFin 
 */
    public void setHoraCierre(LocalTime horaFin) {
        this.horaCierre = horaFin;
    }

    public ArrayList<Opinion> getOpiniones() {
        return opiniones;
    }
    
    public void AgregarProducto(Producto producto){
        this.productos.add(producto);
    }

    public void eliminarProducto(Producto producto){
        this.productos.remove(producto);
    }
}