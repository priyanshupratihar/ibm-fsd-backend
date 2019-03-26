<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="emp" class="com.examples.java.servlet.jsp.bean.EmployeeBean"/>
	<jsp:setProperty property="name" name="emp" value="abc"/>
	<jsp:getProperty property="name" name="emp"/>
</body>
</html>