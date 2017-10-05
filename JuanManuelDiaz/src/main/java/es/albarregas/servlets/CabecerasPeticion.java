/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shirone
 */
@WebServlet(name = "CabecerasPeticion", urlPatterns = {"/CabecerasPeticion"})
public class CabecerasPeticion extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Enumeration<String> cabeceras=request.getHeaderNames();//** obtenemos el nombre de las cabeceras **//
        PrintWriter out = response.getWriter();//** nos permite escribir código html **//
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"CSS/Holamundo.css\"/>");
            out.println("<title>Servlet Holamundo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"todo\">");
            out.println("<h1> Métodos de Petición</h1>");
            while(cabeceras.hasMoreElements()){
                String cabecera=cabeceras.nextElement();
                out.println("<p><strong>"+cabecera+"</strong>: "+request.getHeader(cabecera)+".</p>");//** obtenemos el valor asociado a cada una de las cabeceras **//
            }
            out.println("<p><a href=\"index.html\">volver al inicio!</a></p>");
            out.println("<div>");
            out.println("</body>");
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    public String getServletInfo() {
        return "Short description";
    }

}
