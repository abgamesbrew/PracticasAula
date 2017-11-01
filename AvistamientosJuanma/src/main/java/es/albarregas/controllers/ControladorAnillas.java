/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author shirone
 */
@WebServlet(name = "ControladorAnillas", urlPatterns = {"/controladorAnillas"})
public class ControladorAnillas extends HttpServlet {
    @Resource(name=" java:comp/env/jdbc/poolavistamientos") 
    DataSource data;

    public void init(ServletConfig config)  throws ServletException{
       try{
           Context initialContext = new InitialContext();
           data= (DataSource)initialContext.lookup("java:comp/env/jdbc/poolavistamientos");
       }catch(NamingException e){
           System.out.println("Problemas al crear el datasource");
           e.printStackTrace();
       }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            Connection conexion = null;
            PreparedStatement preparada = null;
            ResultSet resultado = null;
            String url = " ";
            ArrayList<ArrayList<String>> registros = null;
            
            //** Creamos una cookie predefinida que tendra un nombre vacío y para que tenga los espacios en nuestra cookie utilizamos la propiedad urlencoder**//
            Cookie cookie = new Cookie("nombrecookie",URLEncoder.encode("", "UTF-8"));
            
            Cookie[] cookies = request.getCookies();
            
            //** Si existen cookies se busca el nombre y se le asigna el valor a nuestra cookie auxiliar **//
            if(cookies != null){
               for(int i=0;i<=cookies.length-1;i++){
                  if(cookies[i].getName().equals("nombrecookie")){
                      cookie=cookies[i];
                  }
                }
            }
            //** Pasaremos a rellenar la cookie auxiliar con el parametro solo cuando al haber recorrido las cookies no se haya encontrado nombre y el parametro nombre del formulario venga relleno **//
            if(cookie.getValue().equals("") && !request.getParameter("nombre").equals("")){
               cookie=new Cookie("nombrecookie",URLEncoder.encode(request.getParameter("nombre"), "UTF-8"));
            }
            
            //** si no hay cookie anterior rellena ni se ha podido rellenar con el parametro añadimos una cookie con el valor vacio para evitar errores **//
            cookie.setMaxAge(50);
            request.setAttribute("nombre", cookie.getValue());
            response.addCookie(cookie);
            
            try{
                conexion = data.getConnection();
                
                if(request.getParameter("buscar") != null){
                    String error;
                    try{
                        String anilla=request.getParameter("anilla");
                        preparada=conexion.prepareStatement("SELECT especie,fecha,lugar FROM avistamientos WHERE anilla = "+anilla);
                        resultado=preparada.executeQuery();
                        
                        //** definimos el arraylist que contiene un arraylist auxiliar para guardar todas las columnas de cada fila. **//
                        registros = new ArrayList<ArrayList<String>>();
                        
                        while(resultado.next()){
                            ArrayList<String> aux = new ArrayList<String>();
                            aux.add(resultado.getString(1));
                            aux.add(resultado.getString(2));
                            aux.add(resultado.getString(3));
                            registros.add(aux); // añadimos el arraylist auxiliar a la coleccion de arrays auxiliares 
                        }
                        
                        request.setAttribute("registros", registros); // añadimos al request el arraylist que contiene la informacion de la consulta
                        url="JSP/variosRegistros.jsp";
                        
                        if(registros.size()<1){ //si la consulta devuelve 0 valores pero no da error, la catalogaremos como si se tratara de un error
                           url="JSP/error.jsp";  
                        }
                        
                    }catch(SQLException e){
                        error="no hay ningún ave para esa anilla";
                        url="JSP/error.jsp";
                    }finally{//** cerramos todas las conexiones abiertas **//
                        if(conexion != null){
                          conexion.close();
                        }
                        if(preparada != null){
                          preparada.close();
                        }
                        if(resultado != null){
                          resultado.close();
                        }
                    }
                }
                request.getRequestDispatcher(url).forward(request, response);
                
            }catch(SQLException e){
                System.out.println("Ha ocurrido un error con el DataSource");
            }
    }
}
