<%@page import="java.time.LocalDateTime,java.util.List,java.util.Arrays" %>

<html>
<body>
<h1>Curent DateTime: <%=LocalDateTime.now() %></h1>
<!-- declaration tag -->
<%
	
	List<String> countries=Arrays.asList("India","China","USA");
	out.println(countries);
	
	out.println(request.getRemoteUser());
	
%>


</body>
</html>
