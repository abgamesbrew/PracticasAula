<%-- 
    Document   : contadorCookie
    Created on : 09-oct-2017, 20:36:59
    Author     : shirone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contador Cookies</title>
        <link rel="stylesheet" href="/PracticasAula/CSS/conjunto.css"/>
    </head>
    <body>
        <% 
           Cookie[] cookies; 
           cookies = request.getCookies();
           Cookie contador = null;
           if (cookies != null ){
                for(int i=0;i<=cookies.length-1;i++){
                  if(cookies[i].getName().equals("contador")){
                   contador=cookies[i];   
                  } 
               }   
           }
           if (request.getParameter("eliminar") != null){
            contador = null;   
           }
           if (request.getParameter("menu") != null){
                response.sendRedirect("../index.html");
           }
           if(contador == null){
            contador = new Cookie("contador", "1");
            contador.setMaxAge(24*60*60);
            response.addCookie(contador);
   %>
           <div id="contadorsesion">
               <h1>Has visitado la página <%= contador.getValue() %> veces</h1>
               <h2>Información de la cookie</h2>
               <p><strong>Caducidad: </strong><%= contador.getMaxAge() %></p>
               <p><strong>Nombre: </strong><%= contador.getName() %></p>
               <p><strong>Segura: </strong><%= contador.getSecure() %></p>
               <p><strong>Versión: </strong><%= contador.getVersion() %></p>
               <form method="post" action="contadorCookie.jsp">
                   <input type="submit" name="recargar" value="recargar"/>
                   <input type="submit" name="eliminar" value="eliminar"/>
                   <input type="submit" name="menu" value="menu"/>
               </form>
           </div>
               <% }else if(Integer.parseInt(contador.getValue()) >= 1 ){
             int cuentavueltas= Integer.parseInt(contador.getValue());
             contador.setValue(Integer.toString(cuentavueltas + 1));
            response.addCookie(contador);
%>         <div id="contadorsesion">
               <h1>Has visitado la página <%= contador.getValue() %> veces</h1>
               <form method="post" action="contadorCookie.jsp">
                   <input type="submit" name="recargar" value="recargar"/>
                   <input type="submit" name="eliminar" value="eliminar"/>
                   <input type="submit" name="menu" value="menu"/>
               </form>
           </div>
                <%}%>
    </body>
</html>
