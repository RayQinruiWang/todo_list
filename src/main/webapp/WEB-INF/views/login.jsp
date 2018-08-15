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
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/login.do">Login</a></li>
		</ul>
	</nav>

	<div class="container">
			Welcome to the to-do list developed by Ray.Wang@Oakton <br><br>
			Please login first <br>
			<form action="/login.do" method= "post">
				<p><font color = "red"> ${errorMessage}</font></p>
					Enter your name: <input type="text" name="name"/>
					Enter your password: <input type="password" name="password"/> <input type = "submit" value = "login">
			</form>
	</div>

	<footer class="footer">
		<p>© Copyright Ray.Wang@Oakton.com.au 2018</p>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>