/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

import java.io.Serializable;

/**
 *
 * @author shirone
 */
public class Robot implements Serializable {

    public Robot(String titulo, int cantidad) {
        this.titulo = titulo;
        this.cantidad = cantidad;
    }
    
    private String titulo;
    private int cantidad;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
