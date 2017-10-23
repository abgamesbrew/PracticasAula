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
public class Divisor {
    public int Dividir(int operador1,int operador2){
        int resultado=0;
        try{
            resultado=operador1/operador2;
        }catch(Exception e){
           if(operador2 == 0){
               resultado=Integer.MAX_VALUE;
           }
        }
    return resultado;
    }
}
