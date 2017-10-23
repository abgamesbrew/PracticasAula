<%-- 
    Document   : index.jsp
    Created on : 20-oct-2017, 17:24:23
    Author     : shirone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Seguros</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/conjunto.css"/>
    </head>
    <body>
        <%@ include file="../../INCLUDES/cabecera.inc" %>
        <h1> ¡ Elija su seguro !</h1>
        <h2>Por favor, elegir seguro de los edificios, seguro de contenido, o ambos, marcando las casillas de abajo.</h2>
        <p>¿Que tipo de seguro quiere?</p>
        <form method="post" action="eleccion">
            <input type="checkbox" name="edificios"/><label>Seguro de edificios</label><br><br>
            <input type="checkbox" name="contenido"/><label>Seguro de contenido</label><br><br>
            <input type="submit" value="Enviar"/>
        </form>  
        <%@ include file="../../INCLUDES/footer.inc" %>   
    </body>
</html>
    