<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>

	function addstudent() {
		window.location.href='add-student-form.jsp';
		return false;
	}
	
	function delstudent() {
		
		
	}

</script>

</head>

<body>

	<div id="wrapper">

		<div id="header">
			<h2>Lista de Alunos</h2>
		</div>

		<div id="content">

			<input type="button" value="Add Student" onclick="addstudent()" />
			<table border="1">

				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<c:forEach var="tempStudent" items="${STUDENTS_LIST}">

					<c:url var="templink" value="StudentControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="studentId" value="${tempStudent.id}"/>
					</c:url>

					<c:url var="templinkDelete" value="StudentControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="studentId" value="${tempStudent.id}"/>
					</c:url>

					<tr>
						<td>${tempStudent.firstName}</td>
						<td>${tempStudent.lastName}</td>
						<td>${tempStudent.email}</td>
						<td>
							<a href="$tempLink">Update</a>
							
							<a href="$tempLinkDelete"
							onclick="if (!(confirm('Deseja excluir o registro?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>
				
			</table>

		</div>

	</div>

</body>
</html>