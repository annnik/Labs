<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Current table state</h3>

	<h4>Enter name</h4>
	<form:form method="post" modelAttribute="userForm" action="${userActionUrl}">
		name<br><form:input type="text" name="name_input"  size="1000" /><br>
		<form:input type="submit" value="Send" name="send_button" />
	</form:form>

	
	
</body>
</html>