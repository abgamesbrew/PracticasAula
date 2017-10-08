/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shirone
 */
@WebServlet(name = "Config", urlPatterns = {"/Config"}, initParams = {
    @WebInitParam(name = "Comprar", value = "Si")
    , @WebInitParam(name = "Vender", value = "No")
    ,    @WebInitParam(name = "Tercero", value = "Tambien")})
public class Config extends HttpServlet {
    
    private  Map<String,String> valores;

    public Config() {
        this.valores= new HashMap<String,String>();
    }

    public void init(ServletConfig config){
        Enumeration<String> parametros= config.getInitParameterNames();
        while (parametros.hasMoreElements()){
            String parametro=parametros.nextElement();
            valores.put(parametro, config.getInitParameter(parametro));
        }
       
   }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Config</title>"); 
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\">");
            out.println("<link rel=\"stylesheet\" href=\"CSS/conjunto.css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"centroconfig\">");
            out.println("<h1>Parametros recibidos</h1>");
            Set s = valores.keySet();
            Iterator it = s.iterator();
            while(it.hasNext()){
                String parametro= (String) it.next();
                out.print("El parametro "+parametro+"tiene el valor: "+valores.get(parametro)+"<br/><br/>");
            }
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
