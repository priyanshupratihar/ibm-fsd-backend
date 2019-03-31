<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
 	<center>
 		<h2>Employee Management System</h2>
 	</center><hr><br/>
    <div class="container">
    <%
		String msg ="";
		if(request.getAttribute("msg")!=null){
			msg = (String)request.getAttribute("msg");
	%>
	<div id="alert" class="alert alert-danger" role="alert"><%=msg %></div>
	<%} %>
      <div class="row">
        <div class="col-md-7 mx-auto">
          
            <div class="h4 text-center">
              Add Employee
            </div><br/>
            <form action="EmployeeAdd.do" method="post">
             	<div class="form-group">
                  <label for="exampleInputEid">Emp ID</label>
                  <input
                    type="text"
                    class="form-control"
                    id="exampleInputEid1"
                    name="eid"
                    aria-describedby="eidHelp"
                    placeholder="Enter Emp ID"
                    required
                  />
                </div>
                <div class="form-group">
                  <label for="exampleInputName">Name</label>
                  <input
                    type="text"
                    class="form-control"
                    id="exampleInputName1"
                    name="name"
                    aria-describedby="nameHelp"
                    placeholder="Enter name"
                    required
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
                  />
               
              </div>
              
                <div class="col-md-6 mx-auto">
                	<button type="submit" class="btn btn-info btn-block btn-lg">Add</button>
                </div>
            
            </form>
          
        </div>
      </div>
      <div class="row mt-3">
          <div class="col-md-12">
            <a href="EmployeeList.do" class="btn btn-success btn-lg">View List</a>
          </div>
      </div>
    </div>
    
    <script type="text/javascript">
		var alert = document.getElementById("alert");
		setTimeout(() => {
			alert.remove();
		}, 5000);
	</script>
  </body>
</html>