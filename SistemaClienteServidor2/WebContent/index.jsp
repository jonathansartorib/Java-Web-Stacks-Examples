<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cidades</title>
</head>
<body>
	<sql:setDataSource 
		var="snapshot" 
		driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC"
		user="root"
		password="root"/>
		
	<sql:query dataSource="${snapshot}" var="result">
		select ID, Name from city
	</sql:query>
	
	<table border="1" width="100%">
	
		<tr>
			<th>Id Cidade:</th>
			<th>Cidade:</th>
		</tr>
		
		<c:forEach var="registro" items="${result.rows}">
			<tr>
				<td><c:out value="${registro.ID}"/></td>
				<td><c:out value="${registro.Name}"/></td>
			</tr>	
		</c:forEach>
		
		
	</table>
	
</body>
</html>