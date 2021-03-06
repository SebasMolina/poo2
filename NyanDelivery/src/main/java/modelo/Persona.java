
package modelo;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/** Clase abstracta persona.
 * Sirve para guardar el id, mail, contraseña, nombre y apellido.
 * 
 */
public abstract class Persona {
    private int id;
    private String mail;
    private String contraseña;
    private String nombre;
    private String apellido;
    private Direccion direccion;
    private int tipoPersona;

    /**Constructor por defecto.
     * 
     */
    public Persona() {
    }
    
/** Obtener id.
 * @return (int id)
 */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
/** Obtener mail.
 * @return (String mail)
 */
    public String getMail() {
        return mail;
    }
/** Agregar un mail.
 * @param mail
 */
    public void setMail(String mail) {
        this.mail = mail;
    }
/** Obtener contraseña.
 * @return (String contraseña)
 */
    public String getContraseña() {
        return contraseña;
    }
    /** Agregar una contraseña.
     * @param contraseña 
     */
    public void setContraseña(String contraseña) {
        this.contraseña= getMD5(getMD5(contraseña));
    }
    /** Obtener nombre.
     * @return (String nombre)
     */
    public String getNombre() {
        return nombre;
    }
/** Agregar un nombre.
     * @param nombre 
*/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/** Obtener apellido.
     * @return (String apellido)
*/
    public String getApellido() {
        return apellido;
    }
/**Agregar un apellido.
     * @param apellido 
*/
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
/** Obtener la direccion.
 * 
 * @return Direccion
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
/** Obtener el tipo de persona.
 * 
 * @return 
 */
    public int getTipoPersona() {
        return tipoPersona;
    }
/** Agregar que tipo de persona es.
 * 
 * @param tipoPersona 
 */
    public void setTipoPersona(int tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    
    private String getMD5(String clave) {
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(clave.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);

        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
 }
    
}
