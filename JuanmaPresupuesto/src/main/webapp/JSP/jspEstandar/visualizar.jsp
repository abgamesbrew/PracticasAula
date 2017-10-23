<%-- 
    Document   : visualizar.jsp
    Created on : 20-oct-2017, 17:24:31
    Author     : shirone
--%>


<%@page import="es.albarregas.models.CalcularCuota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/conjunto.css"/>
        <title>Ver cuotas</title>
    </head>
    <body>
        <%      
            HttpSession sesion = request.getSession(false);
            String seguros="";
            double totaledificio=0;//el resultado del calculo del seguro de edificio tendra muchos decimales y debe ser redondeado
            
            //** sacamos el total calculado que nos envian los controladores y lo redondeamos a dos cifras**//
            double redondeado = Math.round( (double)sesion.getAttribute("total") * 100.0 ) / 100.0;
            
            if(sesion.getAttribute("edificio") != null){//** si en la sesion existe el seguro de edificio **//
                totaledificio = Math.round( (double)sesion.getAttribute("totaledificio") * 100.0 ) / 100.0;   
            }
           
        %>
        <%@ include file="../../INCLUDES/cabecera.inc" %>
        <h1>Ya hemos terminado!</h1>
        <h3>Esperamos que los precios sean de su agrado</h3>
        <table>
            <% if(sesion.getAttribute("edificio") != null && sesion.getAttribute("contenido") != null){
            //** comprobamos si se marcaron en el index los dos seguros **//%>
            <tr>
                <td>Seguro de edificios:</td>
                <td><%= totaledificio %>€</td>
            </tr>
            <tr>
                <td>Seguro de contenido:</td>
                <td><%= sesion.getAttribute("totalcontenido") %>€</td>
            </tr>
            <tr>
                <td>Total: </td>
                <td><%= redondeado %>€</td>
            </tr>
            <%}else if(sesion.getAttribute("edificio") != null){
             //** comprobamos si se marco en el index el edificio **//%>
            <tr>
                <td>Seguro de edificios:</td>
                <td><%= totaledificio %>€</td>
            </tr>
            <tr>
                <td>Total: </td>
                <td><%= redondeado %>€</td>
            </tr>
            <%}else if(sesion.getAttribute("contenido") != null){
             //** comprobamos si se marco en el index el contenido **//%>
            <tr>
                <td>Seguro de contenido</td>
                <td><%= sesion.getAttribute("totalcontenido") %>€</td>
            </tr>
            <tr>
                <td>Total: </td>
                <td><%= redondeado %>€</td>
            </tr>    
            <%}
            //** invalidamos la sesión y habrá que empezar de nuevo por el index.html o index.jsp **//
            sesion.invalidate();%>
        </table>
        <input type="button" onclick=" location.href='<%= request.getContextPath() %>/index.html' " value="Volver al inicio" name="boton" /> 
        <%@ include file="../../INCLUDES/footer.inc" %>
        
    </body>
</html>
