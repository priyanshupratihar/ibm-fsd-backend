<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Emp Management app</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h1>Employee Management App</h1>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<input type="button" value="AddEmp"
				onclick="window.location.href='add-emp-form.jsp';return false;"
				class="add-emp-button" />
			<table>
				<tr>
					<th>Emp Id</th>
					<th>Name</th>
					<th>Age</th>
					<th>Salary</th>
					<th>Department</th>
				</tr>
				<c:forEach var="tempEmp" items="${EMPLOYEE_LIST}">
					<tr>
						<td>${tempEmp.eid}</td>
						<td>${tempEmp.name}</td>
						<td>${tempEmp.age}</td>
						<td>${tempEmp.salary}</td>
						<td>${tempEmp.dept}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


</body>
</html>