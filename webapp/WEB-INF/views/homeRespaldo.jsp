<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a CineApp</title>
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet"
	href="${urlPlulic}/bootstrap/css/bootstrap.min.css">
</head>
<body>

	<!-- 	<h1>Lista de Peliculas</h1> -->
	<!-- 	<ol> -->
	<%-- 		<c:forEach items="${peliculas }" var="pelicula"> --%>
	<%-- 			<li>${pelicula }</li> --%>
	<%-- 		</c:forEach> --%>
	<!-- 	</ol> -->

	<div class="card">
		<div class="card-header">Tabla de peliculas</div>
		<div class="card-body">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Titulo</th>
						<th>Duracion</th>
						<th>Clasificacion</th>
						<th>Genero</th>
						<th>Imagen</th>
						<th>Fecha Estreno</th>
						<th>Estatus</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${peliculas }" var="pelicula">
						<tr>
							<td>${pelicula.id }</td>
							<td>${pelicula.titulo }</td>
							<td>${pelicula.duracion }min.</td>
							<td>${pelicula.clasificacion }</td>
							<td>${pelicula.genero }</td>
							<td><img src="${urlPublic }/images/${pelicula.imagen }"
								width="80" height="100"></td>
							<td><fmt:formatDate value="${pelicula.fechaEstreno }"
									pattern="dd-MM-yyyy" /></td>
							<td><c:choose>
									<c:when test="${pelicula.estatus == 'Activa'}">
										<span class="badge badge-success">ACTIVA</span>
									</c:when>
									<c:otherwise>
										<span class="badge badge-danger">INACTIVA</span>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>