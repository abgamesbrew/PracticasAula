/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.pojos.Eleccion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shirone
 */
@WebServlet(name = "eleccion", urlPatterns = {"/eleccion"})
public class eleccion extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Eleccion eleccion = new Eleccion();
        
        if(request.getParameter("edificios") == null && request.getParameter("contenido") == null){
            request.getRequestDispatcher("JSP/jspEstandar/index.jsp").forward(request, response);
        }
        if(request.getParameter("edificios") != null){
            eleccion.setEdificio(true);
        }
        if(request.getParameter("contenido") != null ){
            eleccion.setContenido(true);
        }
        
        //** cuando lleguemos a elegir algun seguro en el formulario creamos la sesion y le pasamos nuestra eleccion como atributo **//
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("eleccion", eleccion);
        
        if(eleccion.getEdificio()){//** Si hemos elegido la opcion Seguro de edificio vamos al jsp que contendrá la información requerida**//
          request.getRequestDispatcher("JSP/jspEstandar/edificio.jsp").forward(request, response);  
        }else{
          request.getRequestDispatcher("JSP/jspEstandar/contenido.jsp").forward(request, response);  
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
