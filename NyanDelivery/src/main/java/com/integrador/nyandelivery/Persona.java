
package com.integrador.nyandelivery;

public abstract class Persona {
    private int id;
    private String mail;
    private String contraseña;
    private String nombre;
    private String apellido;

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
        this.contraseña = contraseña;
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
    
    
}
