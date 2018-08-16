<%@include file="../common/header.jspf" %>
<%@include file="../common/navigation.jspf" %>

	<div class="container">
			<h1>Welcome to the to-do list</h1>
			Please login first <br>
			<form action="/login.do" method= "post">
				<p><font color = "red"> ${errorMessage}</font></p>
					Enter your name: <input type="text" name="name" class="form-control"/>
					Enter your password: <input type="password" name="password" type ="text" class="form-control"/> <br>
					<input type = "submit" value = "login" class = "btn btn-success">
			</form>
	</div>

<%@include file="../common/footer.jspf" %>