
package modelo;

import proveedorproducto.ProveedorProducto;
import java.util.ArrayList;

public class Producto {
    private int id;
    private String nombre;
    private ProveedorProducto Comercio;
    private int cantidad;
    private ArrayList<Ingrediente> ingredientes;
    private boolean IngredientesSeleccionables;
    private double precio;

/** Constructor por defecto.
 * 
 */
    public Producto() {
    }
/** Constructor.
 * Parametros:
 * @param nombre
 * @param comercio
 * @param IngredientesSeleccionables
 * @param precio 
 */
    public Producto(String nombre, ProveedorProducto comercio, boolean IngredientesSeleccionables, double precio) {
        this.nombre = nombre;
        this.Comercio = comercio;
        this.IngredientesSeleccionables = IngredientesSeleccionables;
        this.precio = precio;
    }
/** Obtener el id del producto.
 * 
 * @return (int id)
 */
    public int getId() {
        return id;
    }
/** Obtener el nombre del producto.
 * 
 * @return (String nombre)
 */
    public String getNombre() {
        return nombre;
    }
/** Agregar un nombre al producto.
 * 
 * @param nombre 
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/** Obtener ingredientes.
 * 
 * @return lista de ingredientes
 */
    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }
/** Setear si los ingredientes son seleccionables.
 * Atributo para saber si se puede seleccionar los ingredientes de un producto
 * @return 
 */
    public boolean isIngredientesSeleccionables() {
        return IngredientesSeleccionables;
    }
/** Ingredientes seleccionables?.
 * Atributo para saber si se puede seleccionar los ingredientes de un producto.
 * @param IngredientesSeleccionables 
 */
    public void setIngredientesSeleccionables(boolean IngredientesSeleccionables) {
        this.IngredientesSeleccionables = IngredientesSeleccionables;
    }
/** Obtener el precio del producto.
 * 
 * @return 
 */
    public double getPrecio() {
        return precio;
    }
/** Agregar el precio al producto.
 * 
 * @param precio 
 */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
/** Agregar ingredientes al producto.
 * 
 * @param ingrediente 
 */
    public void agregarIngrediente(Ingrediente ingrediente){
        this.ingredientes.add(ingrediente);
    }
/** eliminar el ingrediente del producto.
 * 
 * @param ingrediente 
 */
    public void eliminarIngrediente(Ingrediente ingrediente){
        this.ingredientes.remove(ingrediente);
    }
/** Obtener el proveedor de productos.
 * 
 * @return (ProveedorProducto comercio)
 */
    public ProveedorProducto getComercio() {
        return Comercio;
    }
/** Agregar un proveedor de productos.
 * 
 * @param Comercio 
 */
    public void setComercio(ProveedorProducto Comercio) {
        this.Comercio = Comercio;
    }
/** Obtener la cantidad del producto.
 * Sirve para el pedido.
 * @return (int cantidad)
 */
    public int getCantidad() {
        return cantidad;
    }
/** Agregar una cantidad al producto.
 * Sirve para el pedido.
 * @param cantidad 
 */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
 
    
    
}
