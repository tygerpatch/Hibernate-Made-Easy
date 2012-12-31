<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
	Title: Hiberante Made Easy
	Author: Cameron McKenzie
	Page: 422 address.jsp
-->

<%@ page import = "com.examscam.dao.*, com.examscam.model.*;" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<jsp:useBean class = "com.examscam.model.Client" id = "client" scope = "session" />
<jsp:useBean class = "com.examscam.model.ClientDetail" id = "clientDetail" scope = "request" />
<jsp:useBean class = "com.examscam.model.Address" id = "address" scope = "request" />
<jsp:setProperty name = "client" property = "*" />
<jsp:setProperty name = "clientDetail" property = "*" />
<jsp:setProperty name = "address" property = "*" />
<%
String command = request.getParameter("command");

if((command != null) && command.equals("Next")) {
	client.setClientDetail(clientDetail);
	clientDetail.setClient(client);
	DAOFactory factory = DAOFactory.getFactory();
	factory.getClientDAO().beginTransaction();
	factory.getClientDetailDAO().save(clientDetail);
	factory.getClientDAO().save(client);
	factory.getClientDAO().commitTransaction();
}

if((command != null) && command.equals("Add Address")) {
	address.setClient(client);
	client.getAddresses().add(address);
	DAOFactory factory = DAOFactory.getFactory();
	factory.getAddressDAO().beginTransaction();
	factory.getAddressDAO().save(address);
	factory.getClientDAO().save(client);
	factory.getAddressDAO().commitTransaction();
}	
%>

<html>
	<head>
		<title>address</title>
	</head>
	<body>
		<form action = "address.jsp" method = "get">
			Address Line 1: <input type = "text" name = "addressLine1" size = "30"><br />
			Address Line 2: <input type = "text" name = "addressLine2" size = "30"><br />
			City: <input type = "text" name = "city" size = "30"><br />
			State: <input type = "text" name = "state" size = "30"><br />
			Country: <input type = "text" name = "country" size = "30"><br />
			Code: <input type = "text" name = "code" size = "30"><br />
			<inupt type = "submit" name = "command" value = "Add Address">
		</form>
		<a href = "skills.jsp">Continue to Add Skills++</a>
		<c:forEach items = "${client.addresses}" var = "a">
			<hr />
			<c:out value = "${a.addressLine1}"></c:out><br />
			<c:out value = "${a.addressLine2}"></c:out><br />
			<c:out value = "${a.city}"></c:out><br />
			<c:out value = "${a.state}"></c:out><br />
			<c:out value = "${a.country}"></c:out><br />
		</c:forEach>
		<a href = "skills.jsp">Continue to Add Skills++</a>
	</body>
</html>