<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,org.employee.model.Employee" %>
<%

	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma","no-cache");
	
	session = request.getSession(false);
	String name = "";
	if (session.getAttribute("username") == null || session.getAttribute("username").equals("")){
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	else
	{
		name = (String)session.getAttribute("username");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body class="bg-light">
    <div class="container-fluid">
        <div class="row mb-12">
            <div class="col-md-12">
            	<div class="text-center h2">Employee Management System</div>
                <div class="h4">Welcome <%=name %></div>
            </div>
            
        </div>
        <hr>
        <div class="row mb-2">
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="add.jsp" class="btn btn-success">Add Employee</a> <div class="offset-md-4 col-md-4">
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <a href="logout.do" class="btn btn-danger align-right">Logout</a>
            </div>
        </div>
        <div class="row mb-2">
            <div class="col-md-2 h4"><u>Employee List</u></div>
        </div>
        <div class="row">   
            <table class="table table-hover">
                <thead>
                  <tr>
                    <th scope="col">Emp ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Age</th>                    
                    <th scope="col">Department</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Actions</th>
                  </tr>
                </thead>
                <tbody>
                <%
					if(request.getAttribute("empList")!=null){
					List<Employee<Integer>> empList = (List<Employee<Integer>>)request.getAttribute("empList");
					for(Employee emp : empList){
			
				%>
                  <tr>
                    <th scope="row"><%=emp.getEid() %></th>
                    <td><%=emp.getName() %></td>
                    <td><%=emp.getAge() %></td>                    
                    <td><%=emp.getDept() %></td>
                    <td><%=emp.getSalary() %></td>
                    <td>
                    	<a href="FindEmployee.do?eid=<%=emp.getEid() %>" class="btn btn-info">Edit</a>
                    	<a href="delete.do?eid=<%=emp.getEid() %>" class="btn btn-danger">Delete</a>
                    </td>
                  </tr>
<%}} %>
                </tbody>
              </table>
        </div>
    </div>
</body>
</html>
</html>