<%-- 
    Document   : paises
    Created on : 17-nov-2017, 16:35:48
    Author     : shirone
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paises</title>
    </head>
    <body>
        <h1>Lista de países</h1>

            <form method="post" action="${pageContext.request.contextPath}/Controlajstl">
                <c:set value="${sessionScope.localizaciones}" scope="session" var="lista2"/>
                <select name="paiselegido">
                  <c:forEach varStatus="i" var="x" items="${sessionScope.paises}" >
                       <option value="${x.toString()}/${lista2[i.index].toString()}">${lista2[i.index].toString()}</option>
                   </c:forEach>   
                </select>

                <br><br><br><input type="submit" name="listapaises" value="Enviar">
                    <input type="button" onclick=" location.href='${pageContext.request.contextPath}/index.html' " value="Volver al inicio" name="boton" />
            </form>
            
        </select>
    </body>
</html>
