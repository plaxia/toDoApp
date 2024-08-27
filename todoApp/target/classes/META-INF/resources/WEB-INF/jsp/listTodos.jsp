
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">

	<hr>
	<h1>Your Todos</h1>
	<table class="table">
		<thead>
			<tr>
				<th>description</th>
				<th>Target date</th>
				<th>Is Done?</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="delete-todo?id=${todo.id}"
						class="btn btn-warning">DELETE </a>
					<td><a href="update-todo?id=${todo.id}"
						class="btn btn-primary">UPDATE </a></td>
				</tr>

			</c:forEach>
		</tbody>
		<a href="add-todo" class="btn btn-success">Add Todo </a>
	</table>
</div>
<%@ include file="common/footer.jspf"%>
