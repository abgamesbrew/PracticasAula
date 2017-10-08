<%-- 
    Document   : calculadora

    Author     : shirone
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/PracticasAula/CSS/conjunto.css"/>
        <title>calculadora JSP</title>
    </head>
    <body>
    <div id="calculadorajsp">
        <% Date fecha = new Date();
        DateFormat formato = new SimpleDateFormat("d MMM YYYY HH:mm:ss a");//** formato que tendra nuestro Date **//
        if (request.getParameter("operar") == null){//** Si no hemos pulsado el boton operar **//
            
        }else{//** si hemos pulsado el boton operar **//
        %>
        <h1>Resultado</h1>
        <p><strong>La fecha y hora actual del sistema es : </strong><%= formato.format(fecha)%></p>
        <%  
            try{//** Controlaremos las excepciones de valor1 y valor2 **//
                int resultado=0;
                int valor1=Integer.parseInt(request.getParameter("valor1"));
                int valor2=Integer.parseInt(request.getParameter("valor2"));
                switch(Integer.parseInt(request.getParameter("operacion"))){//** Sacamos el valor de operacion **//
                    case 1:
                      resultado=valor1+valor2;
                      break;
                    case 2:
                      resultado=valor1-valor2;
                      break; 
                    case 3:
                      resultado=valor1*valor2;
                      break; 
                    case 4:
                      resultado=valor1/valor2;
                      break; 
                }%>
                <p>El resultado es <%= resultado %></p>
            <%}catch(NumberFormatException a){//** Si hay algun problema con el numero introducido **//
            if(request.getParameter("valor1") == "" || request.getParameter("valor2") == ""){ //** comprobamos que los dos valores esten vacios **//
            %>
            <p>No has introducido nada en algun campo!</p>
            <%
            }
            //** Si ninguno de los dos esta vacio, es que alguno de los dos es erroneo **//
            else{%>
            <p>Alguno de los campos tiene un valor erróneo.</p>
            <%}
            }catch(ArithmeticException a){//** Si esta dividiendo por 0 **//%>
            <p>Estas haciendo una división por 0!</p>
            <%}
            }
        %>
            <h1>Calculadora Jsp</h1>
            <form method="post" action="calculadora.jsp">
                <label>Valor 1: </label> <input type="text" name="valor1"/><br/><br/>
                <label>Valor 2: </label> <input type="text" name="valor2"/><br/><br/>
                <label>Sumar<label><input type="radio" name="operacion" value="1" checked/>
                <label>Restar<label><input type="radio" name="operacion" value="2"/>
                <label>Multiplicar<label><input type="radio" name="operacion" value="3"/>
                <label>Dividir<label><input type="radio" name="operacion" value="4"/><br/>
                        <input type="submit" value="Operar" name="operar"/><br/><br/>
            </form> 
            <a href="../index.html">Voler al inicio!</a>
        </div>
        
    </body>
</html>
