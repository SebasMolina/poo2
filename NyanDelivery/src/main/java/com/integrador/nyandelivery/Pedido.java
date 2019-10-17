
package com.integrador.nyandelivery;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private ArrayList<Producto> productos;
    private String notas;
    
    public Pedido() {
        productos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    
    
    
}
