<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
</head>
<body>
<h2>Login Here</h2>
<form:form name="formLogin" method="post" action="save" modelAttribute="employee">

<table>
<tr>
<td>UserName</td>
<td><form:input path="name" placeholder="Enter Username"></form:input></td>
 </tr>
<tr>
<td>Password</td>
<td><form:input path="password" placeholder="Enter PassWord"></form:input></td>
 </tr>

</table>
</form:form>
</body>
</html>
