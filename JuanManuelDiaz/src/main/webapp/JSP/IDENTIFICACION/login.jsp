<%-- 
    Document   : login
    Created on : 10-oct-2017, 17:21:44
    Author     : shirone
--%>

<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.IOException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/PracticasAula/CSS/conjunto.css"/>
        <title>Página login</title>
    </head>
    <body>
        <%  String mensajeerror = null;
            Cookie[] cookies; 
            cookies = request.getCookies();
            Cookie fecha = null;
            Cookie nombre = null;
            HttpSession sesion=request.getSession(false);
            if(sesion != null){ //** si hay alguna sesion la vamos a invalidar por si se entra directamente al menu y no se pasa por loginIN.jsp**//
                sesion.invalidate();
            }
               if (cookies != null ){//** recorremos todas las cookies y guardamos la cookie fecha y nombre **//
                     for(int i=0;i<=cookies.length-1;i++){
                       if(cookies[i].getName().equals("fecha")){
                        fecha=cookies[i];   
                       }
                       if(cookies[i].getName().equals("nombre")){
                        nombre=cookies[i];
                       }
                    }   
               } 
               
        %>
        <div id="identificacion">
            <h1>Proceso de identificacion</h1>
            <% if(fecha != null){//** si la fecha no es nula, le daremos el valor **//%>
<%-- NO VISUALIZAS LA FECHA ACTUAL EN EL CASO DE QUE NO EXISTA LA COOKIE --%>
            <p><strong>La fecha del ultimo acceso fue: </strong><%= fecha.getValue() %></p>
            <%}%>
            <% if(request.getParameter("error") != null){//** leeremos el parametro error y dependiendo del error mostraremos un mensaje u otro **//
               if(request.getParameter("error").equals("2")){
                   %><h3>El nombre de usuario o contraseña no es correcto</h3>     
                   <%}else if(request.getParameter("error").equals("1")){%>       
               <h3>Debes de iniciar sesion antes de entrar al menu!</h3>
                <%}} %>
            <form method="post" action="loginIN.jsp">
                <% if(nombre != null){ //** si la cookie nombre esta recordada, le asignamos el valor a este input **//%>
                <label>Usuario: </label><input type="text" name="usuario" value="<%= nombre.getValue() %>"/><br/><br/>
                <%}else{%>
                <label>Usuario: </label><input type="text" name="usuario"/><br/><br/>
                <%}%>
                <label>Contraseña: </label><input type="text" name="contrasena"/><br/><br/>
                <label>Recordar usuario</label><input type="checkbox" name="recordada" value="recordada"/><br/><br/>
                <input type="submit" name="enviar" value="enviar" />
                <input type="button" onclick=" location.href='../../index.html' " value="Menu inicio" name="boton" /> 
            </form>
        </div>  
    </body>
</html>
