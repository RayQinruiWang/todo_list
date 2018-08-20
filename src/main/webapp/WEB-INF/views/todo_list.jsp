<%@include file="../common/header.jspf" %>
<%@include file="../common/navigation.jspf" %>

	<div class="container">
		<H1>Welcome ${username}</H1>
		<table class="table table-striped">
		
			<thead>
				<caption><h3>Your to-dos are:</h3></caption>
					<tr>
						<th>Description</th>
						<th>Category</th>
						<th>Actions</th>
					</tr>
			</thead>
			
			<tbody>
			<c:forEach items = "${todo_description_and_categories}" var= "todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.category}</td>
					<td>&nbsp; &nbsp; <a class ="btn btn-danger" 
											href="/delete-todo.do?todo=${todo.description}&category=${todo.category}"
											role="button">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>	
		<a class="btn btn-success" href="/add-todo.do">Add New Todo</a>
		<div class ="push"></div>
	</div>

<%@include file="../common/footer.jspf" %>