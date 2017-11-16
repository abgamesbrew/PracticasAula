<%-- 
    Document   : header
    Created on : 16-nov-2017, 17:20:16
    Author     : shirone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<table width="100%">
  <tr>
    <td align="left" bgcolor="#888888">
      <big><font color="#FFFFFF">
           <c:out value="${param.titulo}"/>
      </font></big>
    </td>
    <td align="right">
      <small>
        Import example application
      </small>
    </td>
  </tr>
</table>
<hr />
</html>
