<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Add a new customer</h1>

<div>
	<form:form action="${pageContext.request.contextPath }/saveCustomer" 
	modelAttribute="newCustomer" method="POST">
	
	<form:hidden path="id"/>
<table>
	<tr>
		<td>
		<label>First Name</label>
		</td>
		
		<td>
		<form:input path="firstName"/>
		</td>
	</tr>
	
	<tr>
		<td>
		<label>Last Name</label>
		</td>
		
		<td>
		<form:input path="lastName"/>
		</td>
	</tr>
	
	<tr>
		<td>
		<label>Email</label>
		</td>
		
		<td>
		<form:input path="email"/>
		</td>
	</tr>
</table>			
		<input type="submit" value="Save Customer">
		
	</form:form>
</div>


</body>
</html>