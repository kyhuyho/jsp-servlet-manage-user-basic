<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
	<%Object obj = request.getAttribute("listUser");
   List<User> listUser = (List<User>) obj;
   %>
	<a href="/manageuser/user/new">Add new user</a>
	<form action="/manageuser/user/search" method="post">
		<div>
			<input type="text" name="name" placeholder="Enter ...">
			<button type="submit">Search</button>
		</div>
	</form>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Username</th>
				<th>Password</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%for(User user: listUser) { %>
			<tr>
				<td><%=user.getId() %></td>
				<td><%=user.getName() %></td>
				<td><%=user.getUsername() %></td>
				<td><%=user.getPassword() %></td>
				<td><a href="/manageuser/user/edit?id=<%= user.getId()%>">Edit</a>
					<a href="/manageuser/user/delete?id=<%= user.getId()%>">Delete</a>
				</td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>