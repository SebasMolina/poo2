
package com.integrador.tarea3;

public abstract class Frutas {
    
    private int id;
    private String nombre;

    public Frutas(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Frutas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int puntuarFruta(){
        int puntos=0;
        
        return puntos;
    }
}
