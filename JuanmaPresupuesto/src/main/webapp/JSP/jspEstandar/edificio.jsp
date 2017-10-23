<%-- 
    Document   : edificio
    Created on : 20-oct-2017, 16:26:51
    Author     : shirone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/conjunto.css"/>
        <title>Edificio</title>
    </head>
    <body>
        <%@ include file="../../INCLUDES/cabecera.inc" %>
        <h1>Detalles de la póliza de edificios</h1>
        <h2>Sírvase proporcionar información acerca de dónde usted vive en el siguiente formulario, y a continuacion haga click en Enviar.</h2>
        <form method="post" action="edificio">
          <label>Tipo de edificio: </label>
          <select name="tipoEdificio">
                <optgroup>
                    <option value="piso" selected="selected">Piso</option>
                    <option value="casa">Casa</option>
                    <option value="adosado" >Adosado</option>
                    <option value="duplex">Duplex</option>
                    <option value="chalet">Chalet</option>
                </optgroup> 
          </select><br><br>
          <label>Numero de habitaciones: </label>
          <select name="numHab">
                <optgroup>
                    <option value="1" selected="selected">1</option>
                    <option value="2">2</option>
                    <option value="3" >3</option>
                    <option value="4">4</option>
                    <option value="5">5 o mas</option>
                </optgroup> 
          </select><br><br>
          <label>Fecha de construccion: </label>
          <select name="anioConstruccion">
                <optgroup>
                    <option value="1949" selected="selected">Antes de 1950</option>
                    <option value="1950">Entre 1950 y 1990</option>
                    <option value="1991" >Entre 1991 y 2005</option>
                    <option value="2006"> Entre 2006 y 2015</option>
                    <option value="2016">Después de 2015</option>
                </optgroup> 
          </select><br><br>
          <label>Tipo de construccion: </label>
          <select name="tipoConstruccion">
                <optgroup>
                    <option value="hormigon" selected="selected">Hormigon</option>
                    <option value="madera">Madera</option>
                </optgroup> 
          </select><br><br>
          <label>Valor estimado de mercado: </label>
          <select name="valorMercado">
                <optgroup>
                    <option value="25000" selected="selected">Menos de 50.000</option>
                    <option value="50001"> Entre 50.001 y 80.000</option>
                    <option value="80001"> Entre 80.001 y 100.000</option>
                    <option value="100001"> Entre 100.001 y 150.000</option>
                    <option value="125000"> Mas de 150.000</option>
                </optgroup> 
          </select><br><br>
          <input type="submit" value="Enviar" name="edificio"/>
        </form>
        <%@ include file="../../INCLUDES/footer.inc" %>
    </body>
</html>
