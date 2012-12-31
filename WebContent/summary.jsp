<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
	Title: Hiberante Made Easy
	Author: Cameron McKenzie
	Page: 433 summary.jsp 
-->

<%@ page import = "com.examscam.dao.*, com.examscam.model.*;" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean class = "com.examscam.model.Client" id = "client" scope = "session" />

<%
DAOFactory factory = DAOFactory.getFactory();
factory.getClientDAO().beginTransaction();
client = (Client) factory.getClientDAO().findByPrimaryKey(client.getId());
%>

<html>
	<head>
		<title>summary</title>
	</head>
	<body>
		<p>Congratulations! You have registered!</p>
		<c:out value = "${client.id}" /><br />
		<c:out value = "${client.username}" /><br />
		<c:out value = "${client.password}" /><br />
		<c:out value = "${client.clientDetail.passwordHint}" /><br />
		<c:out value = "${client.id}" /><br />
		<c:out value = "${client.clientDetail.firstName}" /><br />
		<c:out value = "${client.clientDetail.middleName}" /><br />
		<c:out value = "${client.clientDetail.lastName}" /><br />
		<c:out value = "${client.clientDetail.emailAddress}" /><br />
		<c:out value = "${client.clientDetail.registrationDate}" /><br />
		<c:out value = "${client.clientDetail.verificationDate}" /><br />
		<c:out value = "${client.clientDetail.middleName }" /><br />

		<p>Skills: </p>
		<c:forEach items = "${client.skills}" var = "skill">
			<c:out value = "${skill.name}" /><br />
		</c:forEach>

		<p>Address Info</p>
		<c:forEach items = "${client.addresses}" var = "addr">
			<c:out value = "${addr.addressLine1}" /><br />
			<c:out value = "${addr.addressLine2}" /><br />
			<c:out value = "${addr.city}" /><br />
			<c:out value = "${addr.state}" /><br />
			<c:out value = "${addr.country}" /><br /><hr />
		</c:forEach>
	</body>
</html>
<% factory.getClientDAO().commitTransaction(); %>