<%-- 
    Document   : saludoJsp
    
    Author     : shirone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/PracticasAula/CSS/conjunto.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <% Calendar calendario = Calendar.getInstance();
           String sexo = request.getParameter("sexo");
           String saludo;
             if(request.getParameter("nombre") == null){
        %>
        <div id="saludojsp">
            <h1>Saludo en Jsp</h1>
            <form method="post" action="saludoJsp.jsp">
                <label>Nombre: </label> <input type="text" name="nombre"/><br/><br/>
                <label>Sexo:</label>
                <label>Hombre<label><input type="radio" name="sexo" value="Hombre" checked/>
                <label>Mujer<label><input type="radio" name="sexo" value="Mujer"/><br/><br/>
                        
                        <input type="submit" value="saludame"/><br/><br/>
            </form>        
            <a href="../index.html">Voler al inicio!</a>
        </div>
            <%} else{
                String nombre = request.getParameter("nombre");
                if(sexo.equals("Mujer")){
                    sexo="Señora";
                }else{
                    sexo="Señor";
                }
                if(calendario.get(Calendar.HOUR_OF_DAY) <= 12 && calendario.get(Calendar.HOUR_OF_DAY) >= 8 ){
                  saludo="Buenos dias ";
                }else if(calendario.get(Calendar.HOUR_OF_DAY) <= 21 && calendario.get(Calendar.HOUR_OF_DAY) >= 12 ){
                          saludo="Buenas tardes ";  
                }else{
                    saludo="Buenas noches ";
                }
                %>    
            <div id="saludojsp">
                <h1><%= saludo %> <%= sexo %> <%= nombre %></h1>  
                <a href="../index.html">Voler al inicio!</a>
            </div>
          <%}%>
    </body>
</html>
