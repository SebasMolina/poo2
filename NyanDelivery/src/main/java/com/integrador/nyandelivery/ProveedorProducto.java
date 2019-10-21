
package com.integrador.nyandelivery;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ProveedorProducto extends Persona{
    
    private String Ciudad;
    private String razonSocial;
    private Direccion direccion;
    private ArrayList<Producto> productos;
    private String horaInicio;
    private String horaFin;
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
    
    
}
