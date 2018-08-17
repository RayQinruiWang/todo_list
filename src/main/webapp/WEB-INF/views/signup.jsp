<%@include file="../common/header.jspf" %>
<%@include file="../common/navigation.jspf" %>

	<div class="container">
		<h1>You made a good choice!</h1>
			<form action="/signup.do" method= "post">
					Please choose a username: <input type="text" name="name" class="form-control"/>
					Please choose a password: <input type="password" name="password" type ="text" class="form-control"/> <br>
					<input type = "submit" value = "sign up" class = "btn btn-success">
			</form>
	</div>

<%@include file="../common/footer.jspf" %>