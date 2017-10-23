/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.models.CalcularCuota;
import es.albarregas.pojos.Contenido;
import es.albarregas.pojos.Eleccion;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author shirone
 */
@WebServlet(name = "contenido", urlPatterns = {"/contenido"})
public class contenido extends HttpServlet {
    
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        Contenido contenidoBean = new Contenido();
        //** rellenamos el objeto del pojo Contenido con los parametros del formulario **//
        BeanUtils.populate(contenidoBean, request.getParameterMap());
        
        HttpSession sesion = request.getSession(false);
        sesion.setAttribute("contenido", contenidoBean);
        
        Eleccion eleccion = (Eleccion) sesion.getAttribute("eleccion");
        
        if(eleccion.getEdificio()){//** si pasamos por aqui significa que esta relleno nuestro modelo CalcularCuota con los datos de edificio  y recalculamos ambos**//
            CalcularCuota calculado = (CalcularCuota) sesion.getAttribute("calcularcuota");//** evitamos utilizar la clase Edificio usando la clase calcularCuota que si que esta permitida en nuestro diagrama **//
            
            //** usamos el atributo edificio del calcularcuota de la sesion y los datos del objeto contenidoBean, para llamar a calcularcuota y que nos devuelva el total a pagar de ambos y el especifico de contenido **//
            CalcularCuota calcularAmbos = new CalcularCuota(calculado.getEdificio(),contenidoBean);
            sesion.setAttribute("total", calcularAmbos.getTotal());
            sesion.setAttribute("totalcontenido", calcularAmbos.getContenidoCalculado());
        }
        else{//** si no hemos pasado por edificio, calculamos la cuota la metemos y la metemos en sesion **//
           CalcularCuota calculado = new CalcularCuota(contenidoBean);
           sesion.setAttribute("total", calculado.getTotal());
           sesion.setAttribute("totalcontenido", calculado.getContenidoCalculado());
        }
        request.getRequestDispatcher("JSP/jspEstandar/visualizar.jsp").forward(request, response);
        
    } catch (IllegalAccessException ex) {
        Logger.getLogger(contenido.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvocationTargetException ex) {
        Logger.getLogger(contenido.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
