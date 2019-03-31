<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.employee.model.Employee" %>
<%

	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma","no-cache");
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
    <div class="container">
    <%
    	String name = "", dept = "",eid="";
    	int salary = 0,age=0;
    	
    	Employee<Integer> emp = null;
    	if(session.getAttribute("username")!=null){
			if(request.getAttribute("emp")!=null){
				emp = (Employee<Integer>)request.getAttribute("emp");
				name = emp.getName();
				dept = emp.getDept();
				salary = emp.getSalary();
				eid = emp.getEid();
			}
			else{
				response.sendRedirect("EmployeeList.do");
			}
		}
		else{
			response.sendRedirect("EmployeeList.do");
		}
    	
		String msg ="";
		if(request.getAttribute("msg")!=null){
			msg = (String)request.getAttribute("msg");
	%>
	<div id="alert" class="alert alert-danger" role="alert"><%=msg %></div>
	<%} %>
      <div class="row">
        <div class="col-md-7 mx-auto">
         
            <div class=" h3 text-center">
              Update Employee
            </div>
            <br/>
            <form action="UpdateEmployee.do" method="post">
              
              
                <div class="form-group">
                <input type="hidden" name="eid" value="<%=eid %>"/>
                  <label for="exampleInputName">Name</label>
                  <input
                    type="text"
                    class="form-control"
                    id="exampleInputName1"
                    name="name"
                    aria-describedby="nameHelp"
                    placeholder="Enter name"
                    required
                    value="<%=name %>"
                  />
                </div>
                
               
                <div class="form-group">
                  <label for="exampleInputSalary">Salary</label>
                  <input
                    type="number"
                    class="form-control"
                    id="exampleInputSalary"
                    name="salary"
                    aria-describedby="salaryHelp"
                    placeholder="Enter salary"
                    min="0"
                    required
                    value="<%=salary %>"
                  />
                </div>
               <div class="form-group">
                  <label for="exampleInputAge">Age</label>
                  <input
                    type="number"
                    class="form-control"
                    id="exampleInputAge"
                    name="age"
                    aria-describedby="ageHelp"
                    placeholder="Enter age"
                    min="0"
                    required
                    value="<%=age %>"
                  />
                </div>
              
                <div class="form-group">
                  <label for="exampleInputDepartment">Department</label>
                  <input
                    type="text"
                    class="form-control"
                    id="exampleInputdepartment1" 
                    name="department"
                    aria-describedby="departmentHelp"
                    placeholder="Enter department"
                    required
                    value="<%=dept %>"
                  />
                  </div>
              
             
                <div class="col-md-6 mx-auto">
                	<button type="submit" class="btn btn-info btn-block btn-lg">Update</button>
                </div>
           
            </form>
          </div>
       
      </div>
     <!--  <div class="row mt-3">
          <div class="col-md-12">
            <a href="EmployeeList.do" class="btn btn-success btn-lg">View List</a>
          </div>
      </div>
    </div> -->
    
    <script type="text/javascript">
		var alert = document.getElementById("alert");
		setTimeout(() => {
			alert.remove();
		}, 5000);
	</script>
  </body>
</html>