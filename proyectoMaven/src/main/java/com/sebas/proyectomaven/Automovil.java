/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebas.proyectomaven;

/**
 *
 * @author sebas
 */
public class Automovil {
    
    /**
     * po
     */
    private int potencia;
    private int velocidad;
    private String marca;
    private String modelo;
/**
 * 
 * @param potencia
 * @param marca
 * @param modelo 
 */
    public Automovil(int potencia, String marca, String modelo) {
        this.velocidad=0;
        this.potencia = potencia;
        this.marca = marca;
        this.modelo = modelo;
    }
    /*
frenar() : que decrementa la velocidad, tomando el valor actual de velocidad
diviendolo por 2.
 toString() : que imprime la marca, modelo y velocidad del automóvil.
    */

    public int getPotencia() {
        return potencia;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void acelerar(){
        this.velocidad =this.getVelocidad()+this.getPotencia();
        
    }
    
    public void frenar(){
        
        this.setVelocidad(this.getVelocidad()/2);
        
    }
/** 
 * La representacion en texto de un automovil   * @return un string
 */
    @Override
    public String toString() {
        return "marca=" + marca + ", modelo=" + modelo + ", velocidad=" + velocidad;
    }
    

}
