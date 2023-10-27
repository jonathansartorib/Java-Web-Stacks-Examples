<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro Empregado</title>
</head>
<body>

	<h2>Registrar Empregado</h2>
	
	<form:form action="processForm" modelAttribute="employee">
	
		Id:<form:input path="id"/>
		<form:errors path="id"></form:errors>
		<br/>
		Nome:<form:input path="firstName"/>
		<form:errors path="firstName"></form:errors>
		<br/>
		Sobrenome:<form:input path="lastName"/>
		<br/>
		Cidade:
		<form:select path="city">
			<form:options items="${employee.citiesOptions}"/>
		</form:select>
		<br/>
		<input type="submit" value="Enviar"/>
	
	</form:form>

</body>
</html>