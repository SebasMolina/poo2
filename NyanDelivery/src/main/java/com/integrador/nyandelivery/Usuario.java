
package com.integrador.nyandelivery;

import java.util.ArrayList;

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

/** Agrega una opinion al proveedor de productos.
 * Debe especificar una valoracion y una descripcion.
 * @return una opinion
 */    
    public Opinion agregarOpinion(){
        Opinion unaOpinion = new Opinion();
        
        return unaOpinion;
    }
    
}
