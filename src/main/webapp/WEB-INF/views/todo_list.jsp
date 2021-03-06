<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style>
	.footer {
		position: absolute;
		bottom: 0;
		width: 100%;
		height: 60px;
		background-color: #f5f5f5;
	}
</style>
</head>

<body>

	<nav class="navbar navbar-default">
		<a href="/" class="navbar-brand">Ray's to-do List</a>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="/todo.do">Todos</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/login.do">Login</a></li>
		</ul>
	</nav>

	<div class="container">
			Some front-end magic still has to happen here <br>
			But anyways, welcome ${name}, here's your to-dos: <br>

		<ol>
			<%-- the "c" here in the for loop is the prefix defined in the taglib above --%>
			<c:forEach items = "${todos}" var= "todo">
				<li>${todo.name}; &nbsp; <a href="/delete-todo.do?todo=${todo.name}">Delete</a></li>
			</c:forEach>	
		</ol>
		<form action="/add-todo.do" method = "post" >
			Add New:
			<input type= "text" name = "todo"/>  <input type= "submit" value = "Add new to-do">
		</form>
	</div>

	<footer class="footer">
		<p>� Copyright Ray.Wang@Oakton.com.au 2018</p>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>