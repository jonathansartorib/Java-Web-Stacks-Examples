<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Lista Alunos</h2>
		</div>
	</div>
	
	<div id="container">
	
	<h3>Adicionar Estudante</h3>
	
	<form action="StudentControllerServlet" method="GET">
	
		<input type="hidden" name="command" value="ADD"/>
		
		<table>
		
		<tbody>
		
		<tr>
			<td><label>First Name:</label></td>
			<td><input type="text" name="firstName" /></td>
		</tr>
		
		<tr>
			<td><label>Last Name:</label></td>
			<td><input type="text" name="lastName" /></td>
		</tr>
		
		<tr>
			<td><label>Email:</label></td>
			<td><input type="text" name="email" /></td>
		</tr>
		
		<tr>
			<td><label></></label></td>
			<td><input type="submit" value="Save"/></td>
		</tr>
		
		</tbody>
		
		</table>
	
	</form>
	
	
	</div>

</body>
</html>