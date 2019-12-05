
package modelo;
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
/** Contructor que se usa para listar.
 * @param id
 * @param nombre
 * @param apellido
 * @param mail
 * @param contraseña
 * @param nombreUsuario
 * @param telefono
 * @param calle
 * @param dpto
 * @param cp
 * @param numero
 * @param piso
 */ 
    public Usuario(int id, String nombre, String apellido, String mail, String contraseña, 
            String nombreUsuario, String telefono,
            String calle, int numero, String cp, String piso, String dpto) {
        super.setTipoPersona(1);
        super.setMail(mail);
        super.setContraseña(contraseña);
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        this.setDireccion(new Direccion(calle, numero, cp, piso, dpto));
    }
//el de arriba se usa para crear y obtener
/** Contructor que se usa para listar.
 * @param id
 * @param nombre
 * @param apellido
 * @param nombreUsuario
 * @param telefono
 * @param calle
 * @param dpto
 * @param cp
 * @param numero
 * @param piso
 */ 
    public Usuario(int id, String nombre, String apellido, String nombreUsuario, String telefono,
            String calle, int numero, String cp, String piso, String dpto) {
        super.setTipoPersona(1);
        super.setId(id);
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        this.setDireccion(new Direccion(calle, numero, cp, piso, dpto));
    }
//******************************************************************************
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
