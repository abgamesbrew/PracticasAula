/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.albarregas.pojos.Sumador;
import es.albarregas.pojos.Restador;
import es.albarregas.pojos.Multiplicador;
import es.albarregas.pojos.Divisor;
import es.albarregas.models.Calculado;

/**
 *
 * @author shirone
 */
@WebServlet(name = "calculadora", urlPatterns = {"/calculadora"})
public class calculadora extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean error=false;
        String errormsg = null;
        Calculado calculo = new Calculado();
       if (!request.getParameter("operador1").equals("") && !request.getParameter("operador2").equals("")){
           try{
               int operador1=Integer.parseInt(request.getParameter("operador1"));
               int operador2=Integer.parseInt(request.getParameter("operador2"));
               int resultado=0;
               switch(request.getParameter("operador")){
                   case "+":
                       Sumador sumador = new Sumador();
                       resultado = sumador.Sumar(operador1, operador2);
                       break;
                   case "-":
                       Restador restador = new Restador();
                       resultado = restador.Restar(operador1, operador2);
                       break;  
                   case "*":
                       Multiplicador multiplicador = new Multiplicador();
                       resultado = multiplicador.Multiplicar(operador1, operador2);
                       break; 
                   case "/":
                       Divisor divisor = new Divisor();
                       resultado= divisor.Dividir(operador1, operador2);
                       if(resultado == Integer.MAX_VALUE){
                           error=true;
                           errormsg="No es posible dividir por cero!";
                       }
                       break;
               }
               calculo.setOperador1(operador1);
               calculo.setOperador2(operador2);
               calculo.setOperador(request.getParameter("operador"));
               calculo.setResultado(resultado);
           }catch(Exception e){
               error=true;
               errormsg="No se ha introducido un número válido en alguno de los dos campos";
           }
       }else{
           errormsg="No se han rellenado alguno de los dos parámetros";
           error=true;
       }
       request.setAttribute("calculo", calculo);
       if(error == true){
          calculo.setErrormsg(errormsg);
          request.getRequestDispatcher("JSP/error.jsp").forward(request, response);
       }else{
           request.getRequestDispatcher("JSP/completo.jsp").forward(request, response);
       }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
