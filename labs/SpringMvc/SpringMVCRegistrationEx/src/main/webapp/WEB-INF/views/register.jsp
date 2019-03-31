<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<title>Registration</title>
</head>
<body>
<form:form target="register" method="POST" modelAttribute="user">
	<p>Enter Username: <form:input path="username"/></p>
	<p>Enter Password: <form:input path="password"/></p>
	<p>Country: <form:select path="country" items="${countries}"></form:select></p>
	<p><button type="submit" value="Submit">Submit</button> <button type="reset" value="Reset">Reset</button> </p>
</form:form>
<a href="login.jsp">login</a>
</body>
</html>
