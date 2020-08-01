<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Hover Rows</h2>
		<p>The .table-hover class enables a hover state (grey background
			on mouse over) on table rows:</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>


				<c:forEach items="${employeeList}" var="y">
						<tr>
							<td>${y.first_name}</td>
							<td>${y.last_name}</td>
							<td>${y.email}</td>
							<td><a class="btn btn-info" href="editEmployee/${y.id}">Edit</a>
							<a class="btn btn-danger" href="deleteEmployee/${y.id}">Delete</a>
							</td>
						</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

</body>
</html>
