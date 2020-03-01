	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> --%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Spring MVC</title>
	</head>
	<body>
	<c:url var="addAction" value="/login" ></c:url>
	<c:url var="addAction" value="/register" ></c:url>
	<form:form action="${addAction}" commandName="login"> 
	<table align="center">
			<tr>
				<td><a href="login">Login</a></td>
				<td><a href="register">Register</a></td>
			</tr>
		</table>
	<c:if test="${!empty result}">
	<c:forEach items="${result}" var="result">
	<td>
	${result}
	</td>
	</c:forEach>
	</c:if>
	
	
	<c:if test="${!empty register}">
	<c:forEach items="${register}" var="result">
	<tr>
	<td>
	${result}
	</td>
       <%--  <td>User ID: <c:out value="${result.id}"/></td>
        <td>User UserName: <c:out value="${result.username}"/></td>  
        <td>User FirstName: <c:out value="${result.firstName}"/></td>
        <td>User LastName: <c:out value="${result.lastName}"/></td> 
        <td>User Email: <c:out value="${result.email}"/></td>
        <td>User Address: <c:out value="${result.address}"/></td> 
        <td>User Phone: <c:out value="${result.phone}"/></td> --%>
    </tr>
	</c:forEach>
	</c:if>
	</form:form>
		
	</body>
	
	</html>