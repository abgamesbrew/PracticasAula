<%-- 
    Document   : variosRegistros
    Created on : 31-oct-2017, 17:46:20
    Author     : shirone
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            String nombre = "";
            
            //** contendra toda la consulta y cada fila ira en un ArrayList<String> **//
            ArrayList<ArrayList<String>> resultados = (ArrayList<ArrayList<String>>) request.getAttribute("registros");
            
            //** ArrayList auxiliar del que recuperaremos las filas de la consulta**//
            ArrayList<String> resultado = new ArrayList<String>();
            
            //** Si el valor de la cookie no viene vacio significa que se ha podido rellenar y mostraremos el nombre y los apellidos **//
            if(!request.getAttribute("nombre").equals("")){
                nombre=(String)request.getAttribute("nombre");
            %>
            <h1>Nombre y apellidos: <%= nombre.replace("+", " ") %></h1>
        <%
            }
             %>
                <!-- mostramos el nombre de la especie que la tenemos recogida en en la columna 0 de la fila 0 -->
             <h1><%= resultados.get(0).get(0) %></h1>
             <ul>
                 <%  //** vamos sacando la consulta que tenemos en el primer ArrayList y guardamos sus filas 1 a 1 en su ArrayList auxiliar **//
                     for (int i=0; i<resultados.size(); i++) {
                         resultado = resultados.get(i);
                 %>   
                     <!-- Mostramos la columna dos y la columna 3 de nuestra consulta dado que la columna 0 contiene el nombre de la epecie -->
                 <li><%= resultados.get(i).get(1) %> <%= resultados.get(i).get(2)%></li>
                    
                   <% 
                    }
                    %>
            </ul>
            
            <input type="button" onclick=" location.href='JSP/index.jsp' " value="Volver" name="boton" />
    </body>
</html>
