<%@page import="java.time.LocalDateTime" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Arrays" %>
<html>
<body>
<h1>Curent DateTime: <%=LocalDateTime.now() %></h1>
<!-- declaration tag -->
<%!
	int a=10;
	int b=20;
	List<String> countries=Arrays.asList("India","China","USA");
%>

<!-- scriptlet tag -->
<p>
<% 

out.println(countries);
out.println(a+b);
out.println(Math.pow(a, 2));
%></p>
<p>
<!-- expression tag -->
Expression result:
<%= (a+b)*10 %>
</p>
</body>
</html>
