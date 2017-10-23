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
public class Contenido {
    private boolean danios=false;
    private double cantidadAsegurada;
    private double franquicia;

    //** tendremos dos constructores, en uno se le podra pasar o los daños que cubre el seguro y en el otro no y por defecto lo dejamos en false **//
    public Contenido(boolean danios, double cantidadAsegurada, double franquicia) {
        this.danios = danios;
        this.cantidadAsegurada = cantidadAsegurada;
        this.franquicia = franquicia;
    }
    
    public Contenido(double cantidadAsegurada, double franquicia) {
        this.cantidadAsegurada = cantidadAsegurada;
        this.franquicia = franquicia;
    }

    public Contenido(){
        
    }
    
    public boolean getDanios() {
        return danios;
    }

    public void setDanios(boolean danios) {
        this.danios = danios;
    }

    public double getCantidadAsegurada() {
        return cantidadAsegurada;
    }

    public void setCantidadAsegurada(double cantidadAsegurada) {
        this.cantidadAsegurada = cantidadAsegurada;
    }

    public double getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(double franquicia) {
        this.franquicia = franquicia;
    }

    @Override
    public String toString() {
        return "Contenido{" + "danios=" + danios + ", cantidadAsegurada=" + cantidadAsegurada + ", franquicia=" + franquicia + '}';
    }
    
    
}
