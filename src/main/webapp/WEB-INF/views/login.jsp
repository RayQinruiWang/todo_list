<%@include file="../common/header.jspf" %>
	<div class ="container">
		<nav class="navbar navbar-default">
		<a href="/" class="navbar-brand">Ray's to-do List</a>
		<ul class="nav navbar-nav">
			<li class="active"><a href="/list_todo.do"><span class = "glyphicon glyphicon-home"> Home</span></a></li>
			<li><a href="/list_todo.do"><span class = "glyphicon glyphicon-list-alt"> Todos</span></a></li>
			<li><a href="https://ozone.oakton.com.au/"><span class = "glyphicon glyphicon-flag"> Ozone</span></a></li>
			<li><a href="/contact.do"><span class = "glyphicon glyphicon-envelope"> Contact</span>
			</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/signup.do"><span class = "glyphicon glyphicon-user"> SignUp</span></a></li>
		</ul>
		</nav>
	</div>

	<div class="container">
			<h1>Welcome to the to-do list</h1>
			<h3>Please login first :)</h3> <br>
			<form action="/login.do" method= "post">
				<p><font color = "red"> ${Wrongcredentialerror}</font></p>
					Enter your username: <input type="text" name="username" class="form-control"/>
					Enter your password: <input type="password" name="password" type ="text" class="form-control"/> <br>
					<input type = "submit" value = "login" class = "btn btn-success login_button"> <br>
					or <br>
					<a type = "button" 
						class ="btn btn-danger login_button" 
						href="/google_login.do"
						role="button">Login with Google</a>  
					<a type = "button" 
						class ="btn btn-primary login_button" 
						href="/facebook_login.do"
						role="button">Login with Faceook</a>
			</form>
	</div>

<%@include file="../common/footer.jspf" %>