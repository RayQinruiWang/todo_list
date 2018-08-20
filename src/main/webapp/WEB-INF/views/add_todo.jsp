<%@include file="../common/header.jspf" %>
<%@include file="../common/navigation.jspf" %>

	<div class="container">
			<p><font color = "red"> ${Todoexisterror}</font></p>
			Please specify your new action item <br>

		<form action="/add-todo.do" method = "post" >
			<fieldset class="form-group">
				<label>Description</label>
				<input name = "todo" type ="text" class="form-control"/><br>
			</fieldset>
			
			<fieldset class="form-group">
				<label>Category</label>
				<input name = "category" type ="text" class="form-control"/><br>
			</fieldset>
			
			<input type= "submit" value = "Submit" class = "btn btn-success" role = "button">
		</form>
	</div>

<%@include file="../common/footer.jspf" %>