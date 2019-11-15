
package proveedorproducto;


import producto.Producto;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.Direccion;
import modelo.Opinion;
import modelo.Persona;

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

    ProveedorProducto(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
/** Obtener listado de productos.
 * 
 * @return (lista productos)
 */
    public ArrayList<Producto> getProductos() {
        return productos;
    }
/** Obtener lista de opiniones.
 * 
 * @return lista opiniones
 */
    public ArrayList<Opinion> getOpiniones() {
        return opiniones;
    }
/** Agregar un nuevo producto.
 * 
 * @param producto 
 */
    public void AgregarProducto(Producto producto){
        this.productos.add(producto);
    }
/** Eliminar un producto.
 * 
 * @param producto 
 */
    public void eliminarProducto(Producto producto){
        this.productos.remove(producto);
    }
/** Agregar una nueva opinion.
 * 
 * @param opinion 
 */
    public void AgregarOpinion(Opinion opinion){
        this.opiniones.add(opinion);
    }
/** Eliminar una opinion.
 * 
 * @param opinion 
 */
    private void eliminarOpinion(Opinion opinion){
         this.opiniones.remove(opinion);
    }
}
