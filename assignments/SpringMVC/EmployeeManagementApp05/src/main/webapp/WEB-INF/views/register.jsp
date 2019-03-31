<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style>
    .error {
        color: red;
    }
</style>
</head>
<body>
        <h2>Registration</h2>
        <table>
        <form:form action="register" modelAttribute="user">
                <tr>
                    <td>Username: </td>
                    <td><form:input path="userName"/></td>
                    <td><form:errors path="userName" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><form:password path="password"/></td>
                    <td><form:errors path="password" cssClass="error"/></td>
                </tr>
                <tr>
                	<td></td>
                    <td><input type="submit" value="Register"/></td>
                </tr>
        </form:form>
        </table>
</body>
</html>