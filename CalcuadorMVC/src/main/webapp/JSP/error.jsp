<%-- 
    Document   : error
    Created on : 17-oct-2017, 16:48:14
    Author     : shirone
--%>

<%@page import="es.albarregas.models.Calculado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/conjunto.css"/>
        <title>Error</title>
    </head>
    <body>
        <div id="calculadora">
            <img src="<%= request.getContextPath() %>/IMAGE/calculadora.png"/>
            <p>&nbsp;</p>
           <% Calculado calculador = (Calculado) request.getAttribute("calculo"); %>
        <p><%= calculador.getErrormsg() %></p>
        <input type="button" onclick=" location.href='<%= request.getContextPath() %>/JSP/calculadora.jsp' " value="Volver" name="boton" /> 
        </div>
        
    </body>
</html>
