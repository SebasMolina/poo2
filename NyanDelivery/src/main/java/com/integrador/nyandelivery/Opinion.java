
package com.integrador.nyandelivery;

public class Opinion {

    private int id;
    private ProveedorProducto proveedor;
    private int valoracion;
    private String descripcion;

/** Constructor por defecto.
 *  
 */    
    public Opinion() {
    }
/** Constructor.
 * Parametros:
 * @param proveedor
 * @param valoracion
 * @param descripcion 
 */
    public Opinion(ProveedorProducto proveedor, int valoracion, String descripcion) {
        this.proveedor = proveedor;
        this.valoracion = valoracion;
        this.descripcion = descripcion;
    }
/** Obtener el id de la valoracion.
 * 
 * @return 
 */
    public int getId() {
        return id;
    }
/** Obtener el proveedor de productos de la opinion.
 *  
 * @return 
 */    
    public ProveedorProducto getProveedor() {
        return proveedor;
    }
/** Agregar un proveedor de productos a la opinion.
 * 
 * @param proveedor 
 */
    public void setProveedor(ProveedorProducto proveedor) {
        this.proveedor = proveedor;
    }
/** Obtener la valoracion.
 * Valor máximo 5. Valor minimo 1.
 * @return (int valoracion)
 */
    public int getValoracion() {
        return valoracion;
    }
/** Agregar una valoracion a la opinion.
 * Valor máximo 5. Valor minimo 1.
 * @param valoracion 
 */
    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
/** Obtener la descripcion de la opinion.
 * Una Opinion puede ser de cualquier cosa referida al proveedor de productos.
 * @return 
 */
    public String getDescripcion() {
        return descripcion;
    }
/** Agregar la descripcion.
 * Una Opinion puede ser de cualquier cosa referida al proveedor de productos.
 * @param descripcion 
 */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

}
