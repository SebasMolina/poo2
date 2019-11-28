/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.Pedido;
import modelo.Producto;


public class DetalleComprobante {
    
    private int id;
    private Pedido pedido;
    private Double total;

/** Constructor por defecto.
 * 
 */
    public DetalleComprobante() {
        
    }
/** Constructor.
 * Parametros:
 * @param pedidos 
 */
    public DetalleComprobante(Pedido pedidos) {
        
    }
/** Obtener el id del detalle de comprobante.
 * 
 * @return 
 */
    public int getId() {
        return id;
    }
    
/** Calcular el total del pedido.
 * Se multiplica la cantidad por el precio.
 * @return 
 */    
    private double CalcularTotalPedido(){
        Double precioPedido = 0.0;
        Producto producto = new Producto();
        
        for(int i=0; i<=pedido.getProductos().size(); i++){
            producto= (Producto)pedido.getProductos().toArray()[i];
            precioPedido = precioPedido + (producto.getPrecio()*producto.getCantidad());
        }
        return precioPedido;
    }

/** Obtener un pedido del comprobante.
     *
     * @param pedido
     */
    public Pedido getPedido() {    
        return pedido;
    }

/** Obtener el total del pedido.
     *
     * @return
     */
    public Double getTotal() {
        this.total= CalcularTotalPedido();
        return this.total;
    }
    
    
}
