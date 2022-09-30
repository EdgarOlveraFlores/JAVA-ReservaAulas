<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
	<link rel="stylesheet" href="https//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="#">Aulas</a>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="aula?action=listar">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="">Mis resrevas</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Mi perfil</a></li>
			<c:if test="${user.perfil.equals('administrador')}">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Administracion</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Alta aula</a>
						<a class="dropdown-item" href="#">Alta usuario</a>
					</div>
				</li>
			</c:if>
		</ul>
		<ul class="navbar-var ml-auto">
			<li class="nav-item">
				<a class="nav-link" href="#"><i class="fa fa-sign-out"></i>Log Out</a>
			</li>
		</ul>
	</nav>
</body>
</html>