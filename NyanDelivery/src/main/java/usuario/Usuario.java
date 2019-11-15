
package usuario;

import java.util.ArrayList;
import modelo.Direccion;
import modelo.Persona;
/** Clase para el usuario que va a pedir productos.
 * 
 * 
 */
public class Usuario extends Persona{
    
    private String nombreUsuario;
    private ArrayList<Direccion> direcciones;
    private String telefono;
/**Constructor por defecto.
 * 
 */
    public Usuario() {
        this.direcciones = new ArrayList<>();
        
    }
/**Contructor.
 * Parametros:
 * @param mail
 * @param contraseña
 * @param nombre
 * @param apellido
 * @param nombreUsuario
 * @param telefono
 */
    public Usuario(String mail, String contraseña, String nombre, String apellido, String nombreUsuario, String telefono) {
        super.setMail(mail);
        super.setContraseña(contraseña);
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        this.direcciones = new ArrayList<>();
    }

    Usuario(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/** agregar una direccion.
 * @param direccion 
 * agrega una direccion al usuario.
 */
    public void agregarDireccion(Direccion direccion){
        this.direcciones.add(direccion);
    }
/** eliminar una direccion.
 * @param direccion
 * elimina una direccion al usuario.
 */
    public void eliminarDireccion(Direccion direccion){
        this.direcciones.remove(direccion);
    }
/** Obtener el nombre de usuario.
 * 
 * @return (String nombreUsuario)
 */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
/** Asignar un nombre de usuario.
 * 
 * @param nombreUsuario 
 */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
/** Obtener las direcciones.
 * 
 * @return 
 */
    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }
/** Obtener telefono.
 * 
 * @return (String telefono)
 */
    public String getTelefono() {
        return telefono;
    }
/** Agregar telefono al usurio.
 * 
 * @param telefono 
 */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    
}
