
package modelo;

import java.util.ArrayList;
import modelo.Direccion;
import modelo.Persona;
/** Clase para el usuario que va a pedir productos.
 * 
 * 
 */
public class Usuario extends Persona{
    
    private String nombreUsuario;
    private String telefono;
/**Constructor por defecto.
 * 
 */
    public Usuario() {
        super.setTipoPersona(1);    //Sirve para diferenciar.  
    }
/** * Contructor.Parametros:
 * @param mail
 * @param contraseña
 * @param nombre
 * @param apellido
 * @param nombreUsuario
 * @param telefono
 * @param direccion
 */
    public Usuario(String mail, String contraseña, String nombre, String apellido, String nombreUsuario, String telefono, Direccion direccion) {
        super.setTipoPersona(1);
        super.setMail(mail);
        super.setContraseña(contraseña);
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        super.setDireccion(direccion);
    }

   public Usuario(int aInt, String nombre, String apellido) {
        super.setNombre(nombre);
        super.setApellido(apellido);
   }
/** agregar una direccion.
 * @param direccion 
 * agrega una direccion al usuario.
 */


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
