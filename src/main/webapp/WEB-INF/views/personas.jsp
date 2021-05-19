<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>personas</h1>
	<table border="1">
		<tr>
			<td>nombre</td>
			<td>direccion</td>
			<td>telefono</td>
			<td>edad</td>
		</tr>
		<c:forEach items="${personas}" var="persona">
		<tr>
			<td>${persona.nombre }</td>
			<td>${persona.direccion }</td>
			<td>${persona.telegono }</td>
			<td>${persona.edad }</td>
		</tr>
		
		</c:forEach>
		 
	</table>
	
	<br>
	<form action="">
	<input type="date" name="a">
	</form>

</body>
</html>