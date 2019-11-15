
package modelo;

import proveedorproducto.ProveedorProducto;
import usuario.Usuario;
import java.time.LocalTime;


public class Comprobante {
    private int id;
    private Usuario cliente;
    private ProveedorProducto comercio;
    private DetalleComprobante detalle;
    private LocalTime hora;
    

/** Constructor por defecto;
 * 
 */
    public Comprobante() {
    }
    
    
    
}
