<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
	Title: Hiberante Made Easy
	Author: Cameron McKenzie
	Page: 412 index.jsp 
-->

<html>
  <head>
    	<title>index</title>
  </head>
  <body>
    <form action = "address.jsp" method = "get">
    	First Name: <input type = "text" name = "firstName" size = "30"><br />
    	Middle Name: <input type = "text" name = "middleName" size = "30"><br />
    	Last Name: <input type = "text" name = "lastName" size = "30"><br />
    	Email Address: <input type = "text" name = "emailAddress" size = "30"><br />
    	Login Name: <input type = "text" name = "username" size = "30"><br />
    	Password: <input type = "text" name = "password" size = "30"><br />
    	Password Hint: <input type = "text" name = "passwordHint" size = "30"><br />
    	<input type = "submit" name = "command" value = "Next">
    </form>
  </body>
</html>