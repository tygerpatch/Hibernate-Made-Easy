<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
	Title: Hiberante Made Easy
	Author: Cameron McKenzie
	Page: 256-258 complete user.jsp 
 -->

<%@page import="org.hibernate.*, com.examscam.HibernateUtil, com.examscam.dao.UserDAO, com.examscam.dao.HibernateUserDAO, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean class="com.examscam.model.User" id="user" scope="request" />
<jsp:setProperty name="user" property="*" />
<%
	HibernateUtil.beginTransaction();
	UserDAO userDAO = new HibernateUserDAO();
	List users = null;
	String command = request.getParameter("command");
	if (command != null) {
		if (command.equals("Create")) {
			userDAO.create(user);
		}
		if (command.equals("Update")) {
			userDAO.update(user);
		}
		if (command.equals("edit")) {
			user = userDAO.findByPrimaryKey(user.getId());
			request.setAttribute("user", user);
		}
		if (command.equals("delete")) {
			userDAO.delete(user);
			request.setAttribute("user", null);
		}
		if (command.equals("Fuzzy Search")) {
			users = userDAO.findByExample(user, true);
		}
		if (command.equals("Strict Search")) {
			users = userDAO.findByExample(user, false);
		}
		if (command.equals("Clear")) {
			request.setAttribute("user", null);
		}
	}

	if (users != null) {
		users = userDAO.findAll();
	}

	request.setAttribute("users", users);
	HibernateUtil.commitTransaction();
%>
<html>
<body>
	<form action="user.jsp">
		<!-- Here are our four textfields -->
		<input type="text" size="7" readonly name="id" value="${user.id}">ID<br />
		<input type="text" size="30" name="loginName" value="${user.loginName}">Name<br /> 
		<input type="text" size="30" name="password" value="${user.password}">Password<br />
		<input type="text" size="30" name="emailAddress" value="${user.emailAddress}">Email<br />

		<!-- Here are all of our buttons!!! -->
		<input type="submit" name="command" value="Strict Search"> 
		<input type="submit" name="command" value="Fuzzy Search"> 
		<input type="submit" name="command" value="Update"> 
		<input type="submit" name="command" value="Create"> 
		<input type="submit" name="command" value="Clear"><br />

		<c:forEach items="${users}" var="user">
			<c:url var="editurl" value="user.jsp">
				<c:param name="command" value="edit" />
				<c:param name="id" value="${user.id}" />
			</c:url>
			<c:url var="deleteurl" value="user.jsp">
				<c:param name="command" value="delete" />
				<c:param name="id" value="${user.id}" />
			</c:url>
                | <a href="${editurl}">edit</a>
                | <a href="${deleteurl}">delete</a>
                | <c:out value="${user.id}" />
                | <c:out value="${user.loginName}" />
                | <c:out value="${user.emailAddress}" /> 
                | <br />
		</c:forEach>
	</form>
</body>
</html>
