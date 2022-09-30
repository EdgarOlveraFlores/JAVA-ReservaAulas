<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
	<link rel="stylesheet" href="https//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
</head>
<body>
	<main class="p-4 d-flex flex-column">
		<form class="form-inline" method="post"> 
			<input type="text" class="form-control" id="query" name="query" placeholder="Buscar aula"/>
			<input type="hidden" name="action" value="listar"/>
			<button type="submit" class="btn btn-info">Buscar</button>
		</form>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>Num. Aula</th>
					<th>Capacidad</th>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Estado</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:foreach items="${aulas}" var="aula">
					<tr>
						<td>${aula.numaula}</td>
						<td>${aula.capacidad}</td>
						<td>${aula.nombre}</td>
						<td>${aula.descripcion}</td>
						<td>
							<c:choose>
								<c:when test="${aula.estado == false}">
									Libre
								</c:when>
								<c:otherwise>
									Reservada
								</c:otherwise>
							</c:choose>
						</td>
						<td><a classs="btn btn-primary" herf="#" role="button">Ver detalles</a></td>
						<td>
							<c:if test="${aula.estado == false }">
								<a class="btn btn-success" href="#" role="button">Reservar</a>
							</c:if>
						</td>
						<td>
							<c:if test="${user.perfil.equals('administrador')}">
								<a class="btn btn-danger" href="#" role="button">Eliminar</a>
							</c:if>
						</td>
					</tr>
				</c:foreach>
			</tbody>
		</table>
	</main>
</body>
</html>