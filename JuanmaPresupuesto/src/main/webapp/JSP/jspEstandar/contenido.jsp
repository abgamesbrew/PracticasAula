<%-- 
    Document   : newjsp
    Created on : 20-oct-2017, 16:41:11
    Author     : shirone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/conjunto.css"/>
        <title>Contenido</title>
    </head>
    <body>
    <%@ include file="../../INCLUDES/cabecera.inc" %>
        <h1>Detalles de la póliza de contenidos</h1>
        <h2>Sírvase proporcionar información acerca de su contenido en el siguiente formulario, y a continuación, haga click en Enviar</h2>
        <form method="post" action="contenido">
            <label>Cubrir daños accidentales: </label><input type="checkbox" name="danios" value="true"><br><br>
            <label>Cantidad que requiere asegurar: </label>
            <select name="cantidadAsegurada">
                <optgroup>
                    <option value="10000">10.000</option>
                    <option value="20000">20.000</option>
                    <option value="30000">30.000</option>
                    <option value="50000">50.000</option>
                    <option value="100000">100.000</option>
                </optgroup>
            </select><br><br>
            <label>Franquicia: </label> 
            <input type="radio" name="franquicia" value="0" checked><label>ninguna</label>  
            <input type="radio" name="franquicia" value="500" checked/><label>500</label> 
            <input type="radio" name="franquicia" value="1000" checked/><label>1.000</label> <br><br>
            <input type="submit" name="contenidosub" value="Enviar">
        </form>
        <%@ include file="../../INCLUDES/footer.inc" %>
    </body>
</html>
