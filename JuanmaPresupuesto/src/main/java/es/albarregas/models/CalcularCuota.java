/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

import es.albarregas.pojos.Contenido;
import es.albarregas.pojos.Edificio;

/**
 *
 * @author shirone
 */
public class CalcularCuota {
    private Edificio edificio;
    private Contenido contenido;
    private double edificioCalculado=0.0;
    private double contenidoCalculado=0.0;
    private double total;

    public double getTotal() {
        return total;
    }
    
    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public double getEdificioCalculado() {
        return edificioCalculado;
    }

    public void setEdificioCalculado(double edificioCalculado) {
        this.edificioCalculado = edificioCalculado;
    }

    public double getContenidoCalculado() {
        return contenidoCalculado;
    }

    public void setContenidoCalculado(double contenidoCalculado) {
        this.contenidoCalculado = contenidoCalculado;
    }

    
    
    public CalcularCuota(Edificio edificio, Contenido contenido) {
        this.edificio = edificio;
        this.contenido = contenido;
        this.edificioCalculado= calcularEdificio();
        this.contenidoCalculado=calcularContenido();
        this.total=totalResultado();
    }
    
    public CalcularCuota(Edificio edificio) {
        this.edificio = edificio;
        this.edificioCalculado= calcularEdificio();
        this.total=totalResultado();
    }
    
    public CalcularCuota(Contenido contenido) {
        this.contenido = contenido;
        this.contenidoCalculado=calcularContenido();
        this.total=totalResultado();
    }
    
    
    private double totalResultado(){
        return this.edificioCalculado+this.contenidoCalculado;
    }
    
   private double calcularEdificio(){
      double prima = edificio.getValorMercado()*0.005;
      switch(edificio.getTipoEdificio()){
          case "piso":
              prima*=0.95;
              break;
          case "casa":
              prima*=1.00;
              break;
          case "adosado":
              prima*=1.05;
              break;
          case "duplex":
              prima*=1.10;
              break;
          case "chalet":
              prima*=1.20;
              break;
      }
      prima+=(prima/100)*edificio.getNumHab();
      switch(edificio.getAnioConstruccion()){
          case 1949:
              prima+=prima*0.09;
              break;
          case 1950:
              prima+=prima*0.06;
              break;
          case 1991:
              prima+=prima*0.04;
              break;
          case 2006:
              prima+=prima*0.02;
              break;
          case 2016:
              prima+=prima*0.01;
              break;
      }
      if(edificio.getTipoConstruccion().equals("madera")){
          prima+=prima*0.1;
      }
      
      return prima;
   }
   
   private double calcularContenido(){
       double prima = contenido.getCantidadAsegurada()*0.008;
       if(contenido.getDanios()){
           prima*=1.25;
       }
       switch((int) contenido.getFranquicia()){
           case 0:
               break;
           case 500:
               prima-=prima*0.1;
               break;
           case 1000:
               prima-=prima*0.2;
               break;
       }
       
       return prima;
   }
}
