<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<body>
<h2>Login Here</h2>
<form:form name="formLogin" method="get" action="userLogin/name/password" commandName="emp">
<table>
<tr>
<td>UserName</td>
<td><form:input path="name" placeholder="Enter Username"></form:input></td>
 </tr>
<tr>
<td>Password</td>
<td><form:input path="password" placeholder="Enter PassWord"></form:input></td>
 </tr>
 <tr>
 <td><form:button name="Login" >Login</form:button></td>
 </tr>

</table>
</form:form>
</body>
</html>
