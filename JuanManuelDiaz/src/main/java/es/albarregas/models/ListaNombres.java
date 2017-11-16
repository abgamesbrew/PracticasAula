/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

/**
 *
 * @author shirone
 */
public class ListaNombres {
    private String[] lista;

    public ListaNombres() {
        this.lista = new String[5];
        lista[0]="pedro";
        lista[1]="ramon";
        lista[2]="juan";
        lista[3]="antonio";
        lista[4]="miguel";
    }

    public String[] getLista() {
        return lista;
    }
    
    
    
}
