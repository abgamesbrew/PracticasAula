<%-- 
    Document   : contadorVisitas
    Created on : 10-oct-2017, 9:31:41
    Author     : shirone
--%>

<%@page import="java.util.Enumeration"%>
<%@page import="javax.websocket.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contador sesiones</title>
        <link rel="stylesheet" href="/PracticasAula/CSS/conjunto.css"/>
    </head>
    <body>
        <% 
            
        HttpSession sesionok = request.getSession(false);
        if(sesionok != null){ //** si la sesion no esta invalidada seguimos adelante **//
            HttpSession sesion = request.getSession();
           Enumeration<String> atributos = sesion.getAttributeNames();
           String contador= null;
           boolean encontrado=false;
           while(atributos.hasMoreElements()){
              String atributo = atributos.nextElement();
               if(atributo.equals("contador")){//** si encontramos el atributo con el nombre contador dentro de los atributos de la sesion **//
                contador= (String) sesion.getAttribute("contador");//** sacamos el valor del atributo contador **//
                encontrado= true;//** se ha encontrado el atributo contador **//
               } 
           }
           if(encontrado != true){//** si el atributo contador no se ha encontrado, lo inicializamos **//
               sesion.setAttribute("contador", "0");
               contador=(String) sesion.getAttribute("contador");//** el valor de el atributo contador ira a la variable contador **//
           }
           if(request.getParameter("borrar") == null){//** Si no hemos entrado por el boton borrar **//
            int cuentavueltas=Integer.parseInt(contador);//** el valor de contador se pasa a entero para operar **//
            sesion.removeAttribute("contador");//** borramos el atributo contador **//
            sesion.setAttribute("contador", Integer.toString(cuentavueltas+1));//** guardamos en sesion un atributo contador con las vueltas actualizadas **//
            if(request.getParameter("menu") != null){//** si hemos venido por menu asignaremos al atributo contador de la sesion lo que tenia al entrar en esta página **//
                response.sendRedirect("../index.html");
                sesion.setAttribute("contador", Integer.toString(cuentavueltas));//** dejamos en el atributo contador lo que hemos recogido al entrar y revertimos la vuelta hecha anteriormente **//
            }
           %>
           <div id="contadorsesion">
            <h1>Has visitado la página <%=  sesion.getAttribute("contador") %> veces!</h1>
            <form method="post" action="contadorSesiones.jsp">
                <input type="checkbox" name="borrar" /><label>Eliminar sesion</label><br/><br/>
                <input type="submit" name="continuar" value="continuar"/>
                <input type="submit" name="menu" value="menu"/>
            </form>
            </div> 
          <%}else{//** Si hemos venido por el boton borrar, invalidamos la sesion y mostramos este div **//
            sesion.invalidate();
           %>
           <div id="contadorsesion">
            <h1>La sesión ha finalizado</h1>
            <form method="post" action="contadorSesiones.jsp">
                <input type="submit" name="continuar" value="continuar"/>
                <input type="submit" name="menu" value="menu"/>
            </form>
        </div> 
           <%}
        }%>
        
    </body>
</html>
