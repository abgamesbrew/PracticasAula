<%-- 
    Document   : JSTL1
    Created on : 14-nov-2017, 16:39:35
    Author     : shirone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <style>
        #tipo1{
        background-color: red;
        color:white;
        }
        #tipo2{
        background-color: blue;
        color:yellow;
        }
        #tipo3{
        color: red;
        }
    </style>
    <body>
        <!-- probando los scope de las variables -->
    <c:set var="variable" value="variable_de_peticion" scope="request"/>
    <c:set var="variable" value="variable_de_sesion" scope="session"/>
    
    <!-- probando los numeros y el parseint -->
    <c:set var="numero" value="12"/>
    <fmt:parseNumber var="numeronumero" type="number" value="${numero}" />
    
    <!-- probamos a borrar y a sacar el resultado de una variable -->
    <c:remove var="variable" scope="request"/>
    <p> <c:out value="${requestScope.variable}" default="la variable se encuentra vacía"/></p>
    <p><c:out value="${sessionScope.variable}" default="la variable se encuentra vacía"/></p>
    
    <!-- uso del switch case default en jstl -->
    <h2>prueba simple choose when</h2>
    <p>
    <c:choose>
        <c:when test="${numeronumero >= 10}">
            <c:out value="el numero es 10 o mayor"/>
        </c:when>
        <c:otherwise>
            <c:out value="el numero es menor que 10"/>
        </c:otherwise>
    </c:choose>
    </p>
    
    
    <!-- iniciamos prueba con servlet y switch case -->
    <h2>prueba choose,when,otherwise (switch,case)</h2>
        <fmt:parseNumber var="numeroaleatorio" type="number" value="${requestScope.numeroaleat}" />
        <c:choose>
               <c:when test="${numeroaleatorio < 4}">
                   <div id="tipo1">
                      <c:out value=" el valor del numero aleatorio generado es ${numeroaleatorio}"/>  
                    </div>
               </c:when>
                <c:when test="${numeroaleatorio >= 4 && numeroaleatorio <= 8}">
                    <div id="tipo2">
                      <c:out value=" el valor del numero aleatorio generado es ${numeroaleatorio}"/>  
                    </div>
               </c:when>
                <c:when test="${numeroaleatorio > 8}">
                    <div id="tipo3">
                      <c:out value=" el valor del numero aleatorio generado es ${numeroaleatorio}"/>  
                    </div>
               </c:when>
               <c:otherwise>
                   <c:out value="${numeroaleatorio}"/>
               </c:otherwise>
           </c:choose> 

        <br><form method="post" action="${pageContext.request.contextPath}/Controlajstl">
        <input type="submit" name="aleatorio" value="Enviar"><br><br>
    </form>
<!-- fin prueba servlet y switch case -->

<!-- capturar excepciones -->
<h2>Captura de excepciones</h2>
<c:catch var="ex">
    <jsp:expression>3*1</jsp:expression>
</c:catch>
<c:if test="${ex != null}">
    <c:out value="${ex}: Se intenta dividir por cero" />
</c:if><br><br>
<!-- fin de la captura de excepciones -->

<!-- realizar un for each -->
<h2>Listado de nombres for each</h2>
<jsp:useBean id="listado" class="es.albarregas.models.ListaNombres"/>
<c:forEach var="x" items="${listado.lista}" varStatus="i" >
    <c:choose>
        <c:when test="${i.index%2 == 0}">
            <div id="tipo1"><c:out value="${x}"/></div>
        </c:when>
        <c:otherwise>
            <div><c:out value="${x}"/></div>
        </c:otherwise>
    </c:choose>
</c:forEach>
<!-- fin for each -->

<!-- uso del c:set y for each tokens -->
<h2>Uso del for each tokens</h2>
<c:set var="listasemana" value="Domingo$Lunes$Martes$Miercoles$Jueves$Viernes$Sabado"/>
<c:forTokens var="x" items="${listasemana}" delims="$" varStatus="i">
    <c:choose>
        <c:when test="${i.index == 0}">
            <c:out value="Domingo el dia del señor"/><br>
        </c:when>
        <c:otherwise>
            <c:out value="${x}"/><br>
        </c:otherwise>
    </c:choose>
</c:forTokens>
    <br>
<!-- fin uso c:set y for each token -->

<!-- realizar un import con parametros -->
<h2>Realizar un import con parámetros</h2>
<c:import url="header.jsp">
    <c:param name="titulo" value="IMPORTADO"/>
</c:import>

<!-- fin import -->
    <a href="${pageContext.request.contextPath}">Volver al inicio</a>
    
    </body>
</html>
