<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Edit</title>
</head>
<body>
	<%
	Object obj = request.getAttribute("user");
	User user = (User) obj;
	%>
	<h1>Edit User</h1>

	<form action="/manageuser/user/edit" method="post">
		<div>
			<input type="number" name="id" placeholder="Enter id..."
				value="<%=user.getId()%>" readonly="readonly">
		</div>
		<div>
			<input type="text" name="name" placeholder="Enter name..."
				value="<%=user.getName()%>">
		</div>
		<div>
			<input type="text" name="username" placeholder="Enter username..."
				value="<%=user.getUsername()%>">
		</div>
		<div>
			<input type="password" name="password"
				placeholder="Enter password..." value="<%=user.getPassword()%>">
		</div>
		<div>
			<button type="submit">Edit</button>
		</div>
	</form>
</body>
</html>