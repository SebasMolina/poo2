
package com.integrador.nyandelivery;

public class Persona {
    private int id;
    private String mail;
    private String contraseña;
    private String nombre;
    private String apellido;

    public Persona() {
    }

    /** Obtener id.
     * se usa para obtener el id de la persona.
    
    */
    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
}
