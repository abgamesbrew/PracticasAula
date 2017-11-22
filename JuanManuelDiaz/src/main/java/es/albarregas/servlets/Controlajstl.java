/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession sesion = request.getSession(true);
            ArrayList<String> paises = new ArrayList<String>();
            ArrayList<String> localizaciones = new ArrayList<String>();
            
            Locale locales[]= SimpleDateFormat.getAvailableLocales();
            for(int i=0;i<=locales.length-1;i++){
                if(locales[i].toLanguageTag().length() == 5){
                  paises.add(locales[i].toLanguageTag());
                  localizaciones.add(locales[i].getDisplayCountry());
                }
            }
            sesion.setAttribute("paises", paises);
            sesion.setAttribute("localizaciones", localizaciones);
            request.getRequestDispatcher("JSP/JSTL/paises.jsp").forward(request, response);
    }

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
        }else if(request.getParameter("listapaises") != null){
            String localeynombre = request.getParameter("paiselegido");
            String[] localeynombres=localeynombre.split("/");
            Date fecha = new Date();
            request.setAttribute("fecha", fecha);
            request.setAttribute("nombrepais", localeynombres[1]);
            request.setAttribute("localepais", localeynombres[0]);
            url="JSP/JSTL/resultadopaises.jsp";
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
