<%-- 
    Document   : menu
    Created on : 10-oct-2017, 17:25:53
    Author     : shirone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/PracticasAula/CSS/conjunto.css"/>
        <title>Menu</title>
    </head>
    <body>
        <%HttpSession sesionok = request.getSession(false);
          if(sesionok == null || !request.isRequestedSessionIdValid()){
          response.sendRedirect("login.jsp?error=1");
        }%>
        <div id="identificacion">
            <h1>Bienvenido al menu</h1>
            <p>Varias opciones</p>
            <form method="post" action="loginOUT.jsp">
                <input type="submit" value="cerrar sesion"/>   
            </form>   
        </div>
        
    </body>
</html>
