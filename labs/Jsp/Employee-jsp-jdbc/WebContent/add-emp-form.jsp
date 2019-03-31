<!DOCTYPE>
<html>
<head>
<title>Add Employee</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Employee Management App</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add Employee Here..</h3>

		<form action="EmployeeControllerservlet" method="post">
		<input type="hidden" name="command" value="ADD" />
		<table>
			<tbody>
				<tr>
					<td><label>Emp Id:</label></td>
					<td><input type="text" name="eid"></td>
				</tr>
				<tr>
					<td><label>Name:</label></td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td><label>Age:</label></td>
					<td><input type="number" name="age"></td>
				</tr>
				<tr>
					<td><label>Salary:</label></td>
					<td><input type="number" name="salary"></td>
				</tr>
				<tr>
					<td><label>Salary:</label></td>
					<td><input type="text" name="dept"></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"></td>
				</tr>


			</tbody>
		</table>
		</form>
		<p>
		<a href="EmployeeControllerservlet">Back to list</a>
		</p>
	</div>
</body>
</html>