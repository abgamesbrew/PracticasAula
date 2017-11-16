/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "Controlajstl", urlPatterns = {"/Controlajstl"})
public class Controlajstl extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        String url="";
        if(request.getParameter("aleatorio") != null){
            int aleatorio= (int) (Math.random()*10+1);
            request.setAttribute("numeroaleat", aleatorio);
            url="JSP/JSTL/JSTL1.jsp";
        }else if(request.getParameter("fecha") != null){
            Date fecha = new java.util.Date();
            sesion.setAttribute("fecha", fecha);
            url="JSP/JSTL/JSTLFMT.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
