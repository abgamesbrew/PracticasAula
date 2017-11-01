<%-- 
    Document   : index
    Created on : 01-nov-2017, 2:08:06
    Author     : shirone
--%>

<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% 
                String nombre="";
                Cookie[] cookies = request.getCookies();
                //** en este bucle for buscamos la cookie nombre, y si tiene un nombre se le añadira al nombre, si no tiene nombre, el nombre se deja vacio **// 
                for(int i=0;i<cookies.length;i++){
                    if(cookies[i].getName().equals("nombrecookie")){
                          nombre=URLDecoder.decode(cookies[i].getValue(), "UTF-8");; 
                        }
                }
            %>
        <h1>Página de avistamientos</h1>
        <form method="post" action="<%=request.getContextPath()%>/controladorAnillas">
            <table>
                <tr>
                    <% if(!nombre.equals("")){      
             %>
                <td><%= nombre %></td>
                <input type="hidden" name="nombre" value="">
              <%  
                }else{
%>
                <td><label>Nombre y apellidos: </label></td>
                <td><input type="text" name="nombre" ></td>
            <%
               }
            %>                        
                </tr>
              <tr>
                  <td><label>Identificador de la anilla: </label></td>
                  <td><input type="text" name="anilla" ></td>
              </tr>
              <tr>
                  <td><input type="submit" value="Buscar" name="buscar"></td>
                  <td><input type="reset" value="Limpiar"></td>
              </tr>
            </table>
        </form>
        
    </body>
</html>
