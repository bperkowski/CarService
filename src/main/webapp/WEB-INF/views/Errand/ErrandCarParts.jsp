<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="UTF-8">
	<title>Zamówienie</title>
	<style type="text/css">
  		<%@include file="/static/css/style.css" %>
	</style>
</head>
<body>
<%@include file="../MenuHomePage.jsp" %> 
<div class="home">
	<div class="jumbotron">
		<div class="container">
			<div class="table-responsive">
			<h1 align="center">Lista produktów</h1>
			<h1><a class="btn btn-outline-light btn-lg" href="errand/basket">Koszyk <span class="badge">${basket.size()}</span></a></h1>
				<table class="table table-sm table-dark">
					<thead>
						<tr>
							<th>Nazwa</th>
							<th>Producent</th>
							<th>Cena<th>
							<th></th>
						</tr>
					</thead>
					<c:forEach var="tmpCarPart" items="${carParts}">
						<c:url var="addLink" value="errand/addToCart">
							<c:param name="id" value="${tmpCarPart.id}" />
						</c:url>
						<tr>
							<td>${tmpCarPart.name}</td>
							<td>${tmpCarPart.manufacturer}</td>
							<td>${tmpCarPart.price}</td>
							<td><a class="btn btn-outline-light btn-sm" href="${addLink}">Dodaj do koszyka</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>