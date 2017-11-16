<%-- 
    Document   : JSTLFMT
    Created on : 16-nov-2017, 18:40:28
    Author     : shirone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>jstlFMT</title>
    </head>
    <body>
        <!-- format Number -->
        <h2>Format number</h2>
        <c:set var="numero" value="1223.231" />
        
        <fmt:formatNumber  value="${numero}" type="currency" currencySymbol="€"/><br>
        <fmt:formatNumber maxIntegerDigits="2" value="${numero}" type="number"/><br>
        <fmt:formatNumber minFractionDigits="24" value="${numero}" type="number"/><br>
        <fmt:formatNumber maxFractionDigits="2" value="${numero}" type="number"/><br>
        <!-- fin format number -->
        
        <!-- ejemplo prueba bundle -->
        <h2>Ejemplo Bundle</h2>
        <fmt:bundle basename = "${PageContext.request.contextPath}/prueba">
           <fmt:message key = "mensaje"/>
        </fmt:bundle>
        <!-- FINejemplo prueba bundle -->
        
        <!-- format date -->
        <h2>Format Date</h2>
        <c:set var="fecha" value="${sessionScope.fecha}"/>
        <fmt:formatDate dateStyle="long" type = "date" value = "${fecha}" />
        <!-- FINformat date -->
        
        <!-- setTimeZone -->
        <c:set var="gmt" value="GMT+1"/>
        <fmt:setTimeZone value = "${gmt}" />
        <!-- finsetTimeZone -->
        
        <!-- fmt:setLocale -->
        <c:set var="pais" value="Italia"/>
        <fmt:setLocale value = "${pais}"/>
        <!-- fmt:setLocale --> 
        
        
        <form method="post" action="${pageContext.request.contextPath}/Controlajstl">
            <input type="submit" name="fecha" value="pedirFecha">
        </form>
            
        <br><a href="${pageContext.request.contextPath}">Volver al inicio</a>
    </body>
</html>
