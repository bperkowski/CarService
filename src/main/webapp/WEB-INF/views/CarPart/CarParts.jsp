<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<title>Lista części</title>
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
			<h1 align="center">Lista części</h1>
				<table class="table table-sm table-dark">
					<thead>
						<tr>
							<td>Nazwa</td>
							<td>Producent</td>
							<td>Cena</td>
							<td>Produkt w sprzedaży</td>
							<td></td>
						</tr>
					</thead>
					<tr>
						<c:forEach var="tmpCarPart" items="${carParts}">
							<c:url var="updateLink" value="carParts/update">
								<c:param name="id" value="${tmpCarPart.id}" />
							</c:url>
							<tr>
							<td>${tmpCarPart.name}</td>
							<td>${tmpCarPart.manufacturer}</td>
							<td>${tmpCarPart.price}</td>
							<td>
								<c:choose>
									<c:when test="${tmpCarPart.availability}">
										Tak
									</c:when>
									<c:otherwise>
										Nie
									</c:otherwise>
								</c:choose>
							</td>
							<td><a class="btn btn-outline-light btn-sm" href="${updateLink}">Zmień dane</a></td>
							</tr>
						</c:forEach>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>