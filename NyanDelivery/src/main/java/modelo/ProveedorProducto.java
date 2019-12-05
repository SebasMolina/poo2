
package modelo;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import modelo.Opinion;
import modelo.Persona;

/** Es la clase para el comercio.
 * 
 * 
 */
public class ProveedorProducto extends Persona{
    
    
    private String ciudad;
    private String razonSocial;
    private String telefono;
    private ArrayList<Producto> productos;
    private LocalTime horaInicio;
    private LocalTime horaCierre;
    private ArrayList<Opinion> opiniones;
    
/** Constructor por defecto.
     * 
*/
    public ProveedorProducto() {
        super.setTipoPersona(2);
        this.productos = new ArrayList<>();
        this.opiniones = new ArrayList<>();
    }
//-------------sirve para crear.    
    public ProveedorProducto(int proveedorId,String nombre, String apellido,
            String mail, String contraseña, String razonSocial, String telefono,
            String ciudad,
            String calle, int numero, String cp, String piso, String dpto,
            LocalTime horaInicio, LocalTime horaCierre) {
        super.setId(proveedorId);
        super.setNombre(nombre);
        super.setApellido(apellido);
        super.setMail(mail);
        super.setContraseña(contraseña);
        super.setTipoPersona(2);
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.horaInicio = horaInicio;
        this.horaCierre = horaCierre;
        this.ciudad = ciudad;
        super.setDireccion(new Direccion(calle, numero, cp, piso, dpto));
        this.productos = new ArrayList<>();
        this.opiniones = new ArrayList<>();
    }
//-------------sirve para listar.
    public ProveedorProducto(int proveedorId, String razonSocial, String telefono,
            String calle, int numero, String cp, String piso, String dpto,
            LocalTime horaInicio, LocalTime horaCierre) {
        super.setTipoPersona(2);
        super.setId(proveedorId);
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        super.setDireccion(new Direccion(calle, numero, cp, piso, dpto));
        this.horaInicio = horaInicio;
        this.horaCierre = horaCierre;
        this.productos = new ArrayList<>();
        this.opiniones = new ArrayList<>();
    }
    
/** Obtener la ciudad.
 * 
 * @return (String ciudad)
 */
    public String getCiudad() {
        return ciudad;
    }
/** Agregar una ciudad.
 * 
 * @param Ciudad 
 */
    public void setCiudad(String Ciudad) {
        this.ciudad = Ciudad;
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
/** Obtener el telefono.
 * 
 * @return 
 */
    public String getTelefono() {
        return telefono;
    }
/** Agregar un telefono.
 * 
 * @param telefono 
 */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
