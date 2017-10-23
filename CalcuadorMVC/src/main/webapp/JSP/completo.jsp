<%-- 
    Document   : completo
    Created on : 17-oct-2017, 16:50:53
    Author     : shirone
--%>

<%@page import="es.albarregas.models.Calculado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"<link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/conjunto.css"/>
        <title>Calculadora</title>>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/conjunto.css"/>
        <title>Calculadora</title>
    </head>
    <body>
        
        <% Calculado calculador = (Calculado) request.getAttribute("calculo"); %>
        <div id="calculadora">
            <img src="<%= request.getContextPath() %>/IMAGE/calculadora.png"/>
            <p>El resultado de tu operacion es..</p>
            <p><%= calculador.getOperador1() %> <%= calculador.getOperador() %> <%= calculador.getOperador2() %> = <%= calculador.getResultado()  %> </p>
            <input type="button" onclick=" location.href='<%= request.getContextPath() %>/JSP/calculadora.jsp' " value="Volver" name="boton" /> 
        </div>
    </body>
</html>
