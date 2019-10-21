
package com.integrador.nyandelivery;

public class Direccion {
    
    private int id;
    private String calle;
    private int numero;
    private int codigoPostal;
    private String piso;
    private String departamento;

/** Constructor por defecto.

*/
    public Direccion() {
    }
/** Constructor.
 * Parametros:
 * @param calle
 * @param numero
 * @param codigoPostal
 * @param piso
 * @param departamento
 */
    public Direccion(String calle, int numero, int codigoPostal, String piso, String departamento) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.piso = piso;
        this.departamento = departamento;
    }
/** Obtener el id.
 * 
 * @return (int id)
 */
    public int getId() {
        return id;
    }
/** Obtener la calle de la direccion.
 * 
 * @return (String calle)
 */
    public String getCalle() {
        return calle;
    }
/** Agregar calle a direccion.
 * 
 * @param calle 
 */
    public void setCalle(String calle) {
        this.calle = calle;
    }
/** Obtener el numero de la direccion.
 * 
 * @return (int numero)
 */
    public int getNumero() {
        return numero;
    }
/** Agregar numero a direccion.
 * 
 * @param numero 
 */
    public void setNumero(int numero) {
        this.numero = numero;
    }
/** Obtener el codigo postal de la direccion.
 * 
 * @return (int codigoPostal)
 */
    public int getCodigoPostal() {
        return codigoPostal;
    }
/** Agregar codigo postal a direccion.
 * 
 * @param codigoPostal 
 */
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
/** Obtener el piso de la direccion.
 * 
 * @return (String piso)
 */
    public String getPiso() {
        return piso;
    }
/** Agregar piso a direccion.
 * agregar solo si en la misma direccion hay muchos pisos.
 * @param piso 
 */
    public void setPiso(String piso) {
        this.piso = piso;
    }
/** Obtener el departamento de la direccion.
 * 
 * @return (String Departamento)
 */
    public String getDepartamento() {
        return departamento;
    }
/** Agregar calle a direccion.
 * agregar solo si en la misma direccion hay muchos departamentos.
 * @param departamento 
 */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    
}
