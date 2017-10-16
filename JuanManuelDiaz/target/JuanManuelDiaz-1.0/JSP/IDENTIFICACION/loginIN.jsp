<%-- 
    Document   : loginIN
    Created on : 10-oct-2017, 17:21:53
    Author     : shirone
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%   
        if(!request.getParameter("usuario").equals("juanma")){//** comprobamos que el nombre de usuario sea juanma**//
            response.sendRedirect("login.jsp?error=2");
        }
        else if(!request.getParameter("contrasena").equals("1234")){//** comprobamos que la password sea 1234 **//
            response.sendRedirect("login.jsp?error=2"); 
        }else{
           if(request.getParameter("recordada") != null){ //** comprobamos el checkbox de recordada para asignarle a la cookie nombre el valor de usuario**//
               String nombreusu = request.getParameter("usuario");
               Cookie nombre = new Cookie("nombre",nombreusu);
               nombre.setMaxAge(24*60*60);
              response.addCookie(nombre);
           }else{//** si no esta checkeado recordada asignamos un valor vacio a la cookie **//
               Cookie nombre = new Cookie("nombre","");
               nombre.setMaxAge(24*60*60);
              response.addCookie(nombre);
           }
           Date fecha = new Date();
           DateFormat formato = new SimpleDateFormat("dd/MMMM/yyyy--HH:mm:ss-a");//** formateamos para que no haya espacios dentro de la cookie **//
           String formatillo = formato.format(fecha); //** asignamos a un string la fecha formateada **//
           HttpSession sesion = request.getSession(true); //** creamos una sesion **//
           Cookie fechacookie = new Cookie("fecha",formatillo); //** asignamos el valor de la fecha formateada a la cookie fecha **//
           response.addCookie(fechacookie);
           response.sendRedirect("menu.jsp");//** redireccionamos a menu.jsp porque hasta aqui todo ha ido bien **//
        }%>
    </body>
</html>
