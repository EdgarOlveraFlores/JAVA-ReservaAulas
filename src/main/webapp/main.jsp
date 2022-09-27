<%@ page import="java.util.Date" %>
<%@ include file="util.jsp"%>
<%@ taglib uti="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Vista main de la aplicacion</h1>
	<h3>Hoy es: <%= new java.util.Date() %></h3>
	<c:set var="numero" scope="session" value="${1000}"></c:set>
	<p> El numero es: <c:out value="${numero}"><c:out> </p>
	<c:if test="${numero>0}">
		<p> El numero es mayor que 0  </p>
	</c:if>
</body>
</html>