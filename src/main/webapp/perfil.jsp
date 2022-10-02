
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<title>Perfil</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<main class="p-4 d-flex-column align-items-center">
		<div class="card" style="width: 40vw">
			<div class="card-body">
				<h3 class="text-center">Datos de usuario</h3>
				<form method="GET" class="pb-4" action="usuario">
					<label for="username">Nombre de usuario</label>
					<input type="text" class="form-control" id="username" name="username" value="${user.username}" disabled/><br/>
					
					<label for="password"></label>
					<input type="password" class="form-control" id="password" name="password" value="${user.password}"/><br/>
					
					<label for="nombre">Nombre</label>
					<input type="text" class="form-control" id="nombre" name="nombre" value="${user.nombre}"/><br/>
					
					<label for="email">Email</label>
					<input type="text" class="form-control" id="email" name="email" value="${user.email}"/><br/>
					
					<label for="puesto">Puesto</label>
					<input type="text" class="form-control" id="puesto" name="puesto" value="${user.puesto}"/><br/>
					
					<input type="hidden" name="action" value="editar"/>
					
					<div class="p-4 d-flex flex-row justify-content-araound">
						<input type="submit" class="btn btn-primary" value="Modificar datos"/>
					</div>
				</form>
			</div>
		</div>
	</main>
</body>
</html>