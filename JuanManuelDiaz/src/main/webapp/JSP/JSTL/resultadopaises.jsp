<%-- 
    Document   : resultadopaises
    Created on : 17-nov-2017, 17:12:59
    Author     : shirone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>País elegido</title>
    </head>
    <body>
        <c:set var="fecha" value="${requestScope.fecha}"/>
        <c:set var="numero" value="1223.231" />
        <fmt:bundle basename = "${PageContext.request.contextPath}/prueba">
           <fmt:message var="gmt" key="${requestScope.localepais}" />
        </fmt:bundle>
        <fmt:bundle basename = "${PageContext.request.contextPath}/${requestScope.localepais}">
           <fmt:message var="hola" key="hola" />
           <fmt:message var="adios" key="adios" />
        </fmt:bundle>
        <fmt:setLocale value = "${requestScope.localepais}"/>
        <fmt:setTimeZone value = "${gmt}" />
        
        <h1>${requestScope.nombrepais} y la hora es <fmt:formatDate dateStyle="long" type = "both" value = "${fecha}" /> </h1>
        <c:choose>
            <c:when test="${hola != \"???hola???\" && adios != \"???adios???\"}">
               <p>Palabra hola su traducción: ${hola}</p>
               <p>Palabra adios su traducción: ${adios}</p>
            </c:when>
            <c:otherwise>
                <p>No hay traduccion de hola y adios para este idioma</p>
            </c:otherwise>
        </c:choose>
        <h1>Horas</h1>
        <p>Formato de horas: <fmt:formatDate type = "time" value = "${fecha}" /></p>
        <p>Formato de fecha y hora: <fmt:formatDate type = "both" value = "${fecha}" /></p>
        <p>Formato de horas corto: <fmt:formatDate dateStyle="short" type = "both" value = "${fecha}" /></p>
        <p>Formato de horas medio: <fmt:formatDate dateStyle="medium" type = "both" value = "${fecha}" /></p>
        <p>Formato de horas largo: <fmt:formatDate dateStyle="long" type = "both" value = "${fecha}" /></p>
        <h1>Numeros</h1>
        <p>Formato de numeros 1: <fmt:formatNumber  value="${numero}" type="currency"/></p>
        <p>Formato de numeros 2:<fmt:formatNumber maxIntegerDigits="2" value="${numero}" type="number"/><br>
        <p>Formato de numeros 3:<fmt:formatNumber minFractionDigits="24" value="${numero}" type="number"/><br>
        <p>Formato de numeros 4:<fmt:formatNumber maxFractionDigits="2" value="${numero}" type="number"/><br>
        
        
        
    </body>
</html>
