<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Lista Cidades</h2>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Id</th>
			<th>Distrito</th>
		</tr>
		<c:forEach var="listCitys" items="${citys_list}">
			<tr>
				<td>${listCitys.name}</td>
				<td>${listCitys.id}</td>
				<td>${listCitys.district}</td>
			</tr>	
		</c:forEach>	
	</table>
	
</body>
</html>