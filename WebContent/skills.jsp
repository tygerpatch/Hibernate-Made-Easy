<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
	Title: Hiberante Made Easy
	Author: Cameron McKenzie
	Page: 429 skills.jsp 
 -->

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import = "com.examscam.dao.*, com.examscam.model.*;" %> 
<jsp:useBean class = "com.examscam.model.Client" id = "client" scope = "session">
</jsp:useBean>

<%
DAOFactory factory = DAOFactory.getFactory();
factory.getClientDAO().beginTransaction();
String[] clientSkills = request.getParameterValues("allskills");
if(clientSkills != null) {
	client.getSkills().clear();
	for(int i = 0; i < clientSkills.length; i++) {
		Long id = new Long(clientSkills[i]);
		Skill skill = (Skill)factory.getSkillDAO().findByPrimaryKey(id);
		client.getSkills().add(skill);
	}
	factory.getClientDAO().save(client);
}
%>

<html>
	<head>
		<title>skills</title>
	</head>
	<body>
		<form action = "skills.jsp" method = "post">
			<select size = "20"  name = "allskills" multiple>
				<c:forEach items = "<%= factory.getSkillDAO().findAll(0, 100) %>" var = "skill">
					<option value = "${skill.id}" id = "${skill.id}">
						<c:out value = "${skill.name}"></c:out>
					</option>
				</c:forEach>
			</select>
			<input type = "submit" name = "command" value = "Update Skills">
			<select size = "20" name = "allskills" multiple>
			<c:forEach items = "<%= client.getSkills() %>" var = "skill">
				<option value = "${skill.id}" id = "${skill.id}">
					<c:out value = "${skill.name}"></c:out>
				</option>
			</c:forEach>
			</select>
 		</form>
 		<a href = "summary.jsp">Finish</a>
	</body>
</html>
<% factory.getClientDAO().commitTransaction(); %>