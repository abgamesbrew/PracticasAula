<%-- 
    Document   : calculadora
    Created on : 17-oct-2017, 16:10:18
    Author     : shirone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/conjunto.css"/>
        <title>Calculadora</title>
    </head>
    <body>
        <div id="calculadora">
        <img src="<%= request.getContextPath() %>/IMAGE/calculadora.png"/>
        <br><form method="post" action="../calculadora">
            <label>Operador 1: </label><input type="text" name="operador1"><br><br>
            <label>Operador 2: </label><input type="text" name="operador2"><br><br>
            <input type="radio" name="operador" value="+" checked><label>Sumar </label>
            <input type="radio" name="operador" value="-"><label>Restar </label>
            <input type="radio" name="operador" value="*"><label>Multiplicar </label>
            <input type="radio" name="operador" value="/"><label>Dividir </label><br><br>
            <input type="submit" value="enviar"/>
        </form>
        </div>
        
    </body>
</html>
