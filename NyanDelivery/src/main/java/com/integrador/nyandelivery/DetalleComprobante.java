/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.integrador.nyandelivery;

import java.util.ArrayList;


public class DetalleComprobante {
    
    private int id;
    private ArrayList<Pedido> listaPedidos;

/** Constructor por defecto.
 * 
 */
    public DetalleComprobante() {
        this.listaPedidos = new ArrayList<>();
    }
/** Constructor.
 * Parametros:
 * @param listaPedidos 
 */
    public DetalleComprobante(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = new ArrayList<>();
        this.listaPedidos = listaPedidos;
    }
/** Calcular el total del pedido.
 * Se multiplica la cantida por el precio.
 * @return 
 */    
    public double CalcularTotalPedido(){
        Double precioPedido = 0.0;
        
        return precioPedido;
    }
/** Agregar un pedido a la lista de pedidos.
 * 
 * @param pedido 
 */
    public void agregarPedidos(Pedido pedido){
        this.listaPedidos.add(pedido);
    }
/** Eliminar un pedido de la lista de pedidos.
 * 
 * @param pedido 
 */
    public void eliminarPedidos(Pedido pedido){
        this.listaPedidos.remove(pedido);
    }
}
