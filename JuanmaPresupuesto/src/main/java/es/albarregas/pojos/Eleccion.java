/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.pojos;

/**
 *
 * @author shirone
 */
public class Eleccion {
    private boolean edificio=false;
    private boolean contenido=false;
    
    public Eleccion(boolean edificio, boolean contenido) {
        this.edificio = edificio;
        this.contenido = contenido;
    }

    public Eleccion() {
        
    }
    
    public boolean getEdificio() {
        return edificio;
    }

    public void setEdificio(boolean edificio) {
        this.edificio = edificio;
    }

    public boolean getContenido() {
        return contenido;
    }

    public void setContenido(boolean contenido) {
        this.contenido = contenido;
    }
    
    
    
}
