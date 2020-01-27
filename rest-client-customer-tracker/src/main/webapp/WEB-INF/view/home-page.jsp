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
	
	<h1>Customer Tracker Rest Client</h1>



	<div>
	
		<button onclick="window.location.href='${pageContext.request.contextPath}/addCustomer'">
		Add a new customer
		</button>
	
		<table>
			<tr>
				<th>
					First Name
				</th>
				
				<th>
					Last Name
				</th>
				
				<th>
					Email
				</th>
				
				<th>
					Actions
				</th>
			</tr>
			
			
			
				
				<c:forEach var="customer" items="${customerList}">
				<c:url var="updateLink" value="/updateCustomer">
					<c:param name="customerId" value="${customer.id }"></c:param>
				</c:url>
				
				<c:url var="deleteLink"  value="/deleteCustomer">
					<c:param name="customerId" value="${customer.id }" ></c:param>
				</c:url>
				<tr>
				
					<td>
					${customer.firstName} 
					</td>
					
					<td>
					${customer.lastName}
					</td>
					
					<td>
					${customer.email}
					</td>
					
					<td>
					<a href="${updateLink }">Update</a> | <a href="${deleteLink }" 
					onclick="if(!confirm('Are you sure to delete this customer?')) return false">Delete</a>
					</td>
					
				</tr>
				</c:forEach>
					
			
			
			
		</table>
	</div>


</body>
</html>