/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
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
@WebServlet(name = "MetodosPeticion", urlPatterns = {"/MetodosPeticion"})
public class MetodosPeticion extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Enumeration<String> parametros=request.getParameterNames();
        PrintWriter out = response.getWriter();//** nos permite escribir código html **//
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"CSS/Holamundo.css\"/>");
            out.println("<title>Servlet MetodosPeticion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"todo\">");
            out.println("<h1> Métodos de Petición</h1>");
            out.println("<p>Content path: <strong>"+request.getContextPath()+"</strong><p>");
            out.println("<p>Method: <strong>"+request.getMethod()+"</strong><p>");
            Date date=new Date(request.getDateHeader("If-Modified-Since"));
            long lastModifiedFromBrowser = request.getDateHeader("If-Modified-Since");
            ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.of(2017, 10, 3,15, 49, 20),ZoneId.of("GMT"));
            long modificadoservidor =zdt.toInstant().toEpochMilli();
            response.addDateHeader("Last-Modified", modificadoservidor);
            out.println("<p>Date Header: <strong>"+date.toString()+"</strong><p>");
            out.println("<p>Path Info: <strong>"+request.getPathInfo()+"</strong><p>");
            out.println("<p>Remote User: <strong>"+request.getRemoteUser()+"</strong><p>");
            out.println("<p>Requested session id: <strong>"+request.getRequestedSessionId()+"</strong><p>");
            out.println("<p>Request Uri: <strong>"+request.getRequestURI()+"</strong><p>");
            out.println("<p>Request URL:<strong>"+request.getRequestURL()+"</strong><p>");
            out.println("<p>Servlet Path:<strong>"+request.getServletPath()+"</strong><p>");
            while(parametros.hasMoreElements()){
             String parametro= parametros.nextElement();
             out.println("<p>Parametro introducido:<strong>\""+parametro+"\" y su valor es... "+request.getParameter(parametro)+"</strong><p>");   
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