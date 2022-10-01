<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mis reservas</title>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<main class="p-4 d-flex flex-column">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>Id reserva</th>
					<th>Nombre de usuario</th>
					<th>Nombre</th>
					<th>Email</th>
					<th>Num. Aula</th>
					<th>Nombre de Aula</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach item="${reservas}" var="reserva">
					<tr>
						<td>${resreva.idreserva}</td>
						<td>${resreva.usuario.username}</td>
						<td>${resreva.usuario.nombre}</td>
						<td>${resreva.usuario.email}</td>
						<td>${resreva.aula.numaula}</td>
						<td>${resreva.aula.nombre}</td>
						<td><a class="btn btn-success" href="#" role="button">Liberar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</main>
</body>
</html>