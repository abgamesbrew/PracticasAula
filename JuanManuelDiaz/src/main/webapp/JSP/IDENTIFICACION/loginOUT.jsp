<%-- 
    Document   : loginOUT
    Created on : 10-oct-2017, 17:22:08
    Author     : shirone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%  HttpSession sesion = request.getSession(false);
            sesion.invalidate();
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
