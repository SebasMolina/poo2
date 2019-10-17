
package com.integrador.nyandelivery;

public class Persona {
    private int id;
    private String mail;
    private String contraseña;

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

    
}
