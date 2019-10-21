
package com.integrador.nyandelivery;

import java.util.ArrayList;

public class Pedido {
    
    private int id;
    private ArrayList<Producto> productos;
    private String notas;
    
/** Constructor por defecto.
 * 
 */    
    public Pedido() {
        productos = new ArrayList<>();
    }
/** Constructor.
 * Parametros:
 * @param productos
 * @param notas 
 */
    public Pedido(ArrayList<Producto> productos, String notas) {
        this.productos = productos;
        this.notas = notas;
    }
/** Obtener el id del pedido.
 * 
 * @return 
 */
    public int getId() {
        return id;
    }
/** Obtener lista productos del pedido.
 * 
 * @return lista de productos.
 */
    public ArrayList<Producto> getProductos() {
        return productos;
    }
/** Obtener las notas del pedido.
 * Una nota sirve para explicar algo de importancia en el pedido.
 * @return (String notas)
 */
    public String getNotas() {
        return notas;
    }
/** Agregar una nota al pedido.
 * 
 * @param notas 
 */
    public void setNotas(String notas) {
        this.notas = notas;
    }
/** Agregar un producto al pedido.
 * 
 * @param producto 
 */
    public void agregarProductos(Producto producto){
        this.productos.add(producto);
    }
/** Eliminar un producto del pedido.
 * 
 * @param producto 
 */    
    public void eliminarProductos(Producto producto){
        this.productos.remove(producto);
    }
    
}
