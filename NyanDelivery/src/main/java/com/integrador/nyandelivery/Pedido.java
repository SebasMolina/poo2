
package com.integrador.nyandelivery;

public class Pedido {
    private int id;
    private Producto[] productos;
    private int cant;

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    
    
}
