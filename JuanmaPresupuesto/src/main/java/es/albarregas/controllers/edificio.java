/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.models.CalcularCuota;
import es.albarregas.pojos.Edificio;
import es.albarregas.pojos.Eleccion;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
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
@WebServlet(name = "edificio", urlPatterns = {"/edificio"})
public class edificio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //** rellenamos la clase edificio con los valores del formulario **//
            Map<String,String[]> parametros = request.getParameterMap();
            Edificio edificio = new Edificio();
            BeanUtils.populate(edificio, parametros);
            
            //** obtenemos la sesion y añadimos el objeto edificio con los atributos del formulario del index **//
            HttpSession sesion = request.getSession(false);
            Eleccion eleccion = (Eleccion) sesion.getAttribute("eleccion");
            
            //** como estamos en edificio y puede que no hayamos seleccionado más calcularemos la cuota en base al edificio **//
            CalcularCuota calcular = new CalcularCuota(edificio);
            
            //** añadimos a la sesion el edificio para operar con el si es necesario, el total del edificio para tenerlo a mano y el objeto calcularcuota que contendra informacion de las operaciones **//
            sesion.setAttribute("edificio", edificio);
            sesion.setAttribute("totaledificio", calcular.getEdificioCalculado());
            sesion.setAttribute("calcularcuota", calcular);
            
            if(eleccion.getContenido()){//** si en la elección escogimos el seguro de contenido iremos al jsp de contenido cargando en el request una bandera**//
                request.getRequestDispatcher("JSP/jspEstandar/contenido.jsp").forward(request, response);
                
            }else{//** si no hay seguro de contenido elegido, calculamos la cuota del edificio, la añadimos a la sesion y vamos a la página que lo mostrará **//
                sesion.setAttribute("total", calcular.getTotal());
                request.getRequestDispatcher("JSP/jspEstandar/visualizar.jsp").forward(request, response);
            }
        } catch (IllegalAccessException ex) {
            Logger.getLogger(edificio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(edificio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
