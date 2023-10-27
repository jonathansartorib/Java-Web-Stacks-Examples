<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><% out.println("Unidade 1"); %></title>
</head>
<body>
	<form action="estudante-response.jsp" method="POST">
		Nome: <input type="text" name="nome"/>
		<br/><br/>
		RGM: <input type="text" name="rgm"/>
		<br/><br/>
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>
