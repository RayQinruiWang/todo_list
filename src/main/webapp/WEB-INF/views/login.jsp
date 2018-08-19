<%@include file="../common/header.jspf" %>
	<nav class="navbar navbar-default">
		<a href="/" class="navbar-brand">Ray's to-do List</a>
		<ul class="nav navbar-nav">
			<li class="active"><a href="/list_todo.do">Home</a></li>
			<li><a href="/list_todo.do">Todos</a></li>
			<li><a href="https://ozone.oakton.com.au/">Ozone</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/signup.do">Sign Up</a></li>
		</ul>
	</nav>

	<div class="container">
			<h1>Welcome to the to-do list</h1>
			Please login first <br>
			<form action="/login.do" method= "post">
				<p><font color = "red"> ${errorMessage}</font></p>
					Enter your username: <input type="text" name="username" class="form-control"/>
					Enter your password: <input type="password" name="password" type ="text" class="form-control"/> <br>
					<input type = "submit" value = "login" class = "btn btn-success">
			</form>
	</div>

<%@include file="../common/footer.jspf" %>