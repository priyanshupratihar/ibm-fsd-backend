<%@page import="java.time.LocalDateTime,java.util.List,java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	
	List<String> countries=Arrays.asList("India","China","USA");
	//out.println(countries);
	out.println(request.getRemoteUser());
	
%>

</body>
</html>