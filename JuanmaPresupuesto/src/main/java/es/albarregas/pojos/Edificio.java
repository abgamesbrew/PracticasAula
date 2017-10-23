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
public class Edificio {
   private String tipoEdificio;
   private int numHab;
   private  int anioConstruccion;
   private String tipoConstruccion;
   private double valorMercado;

    public Edificio(String tipoEdificio, int numHab, int anioConstruccion, String tipoConstruccion, double valorMercado) {
        this.tipoEdificio = tipoEdificio;
        this.numHab = numHab;
        this.anioConstruccion = anioConstruccion;
        this.tipoConstruccion = tipoConstruccion;
        this.valorMercado = valorMercado;
    }

    public int getAnioConstruccion() {
        return anioConstruccion;
    }

    public void setAnioConstruccion(int anioConstruccion) {
        this.anioConstruccion = anioConstruccion;
    }

   public Edificio(){
       
   }
   
   public String getTipoEdificio() {
        return tipoEdificio;
    }

    public void setTipoEdificio(String tipoEdificio) {
        this.tipoEdificio = tipoEdificio;
    }

    public int getNumHab() {
        return numHab;
    }

    public void setNumHab(int numHab) {
        this.numHab = numHab;
    }



    public String getTipoConstruccion() {
        return tipoConstruccion;
    }

    public void setTipoConstruccion(String tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion;
    }

    public double getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(double valorMercado) {
        this.valorMercado = valorMercado;
    }

    @Override
    public String toString() {
        return "Edificio{" + "tipoEdificio=" + tipoEdificio + ", numHab=" + numHab + ", anioConstruccion=" + anioConstruccion + ", tipoConstruccion=" + tipoConstruccion + ", valorMercado=" + valorMercado + '}';
    }
   
   

}
