
package modelo;

import java.time.LocalTime;
import modelo.ProveedorProducto;
import modelo.Usuario;


public class Comprobante {
    private int id;
    private Usuario cliente;
    private ProveedorProducto proveedor;
    private DetalleComprobante detalle;
    private LocalTime hora;
    

/** Constructor por defecto;
 * 
 */
    public Comprobante() {
    }

    public Comprobante(Usuario cliente, 
    ProveedorProducto proveedor, DetalleComprobante detalle, LocalTime hora) {
        this.cliente = cliente;
        this.proveedor = proveedor;
    }
    public Comprobante(int comprobanteid, int proveedorid, 
            int usuarioid, LocalTime hora, int detalleid, Double total, int pedidoid) {
        this.id = comprobanteid;
        this.proveedor.setId(proveedorid);
        this.cliente.setId(usuarioid);
        this.hora = hora;
        this.detalle.setId(detalleid);
        this.detalle.setTotal(total);
        this.detalle.setPedido(new Pedido(pedidoid));
    }

    public void setId(int id) {
        this.id = id;
    }
    
/** Obtener el id.
 * 
 * @return 
 */
    public int getId() {
        return id;
    }
/** Agregar un Usuario.
 * 
 * @param cliente 
 */
    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
/** Obtener el cliente.
 * 
 * @return 
 */
    public Usuario getCliente() {
        return cliente;
    }
/** Agregar un proveedor.
 * 
 * @param proveedor 
 */
    public void setProveedor(ProveedorProducto proveedor) {
        this.proveedor = proveedor;
    }
/** Obtener el proveedorProductos.
 * 
 * @return 
 */
    public ProveedorProducto getProveedor() {
        return proveedor;
    }
/** Obtener detalle de comprobante.
 * 
 * @return 
 */
    public DetalleComprobante getDetalle() {
        return detalle;
    }
/** Agregar detalle de comprobante.
 * 
 * @param detalle 
 */
    public void setDetalle(DetalleComprobante detalle) {
        this.detalle = detalle;
    }
/** Obtener la hora.
 * 
 * @return 
 */
    public LocalTime getHora() {
        return hora;
    }
    
    
    
}
