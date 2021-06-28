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
	<title>Step3</title>
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
			<h1 align="center">Lista samochodów:</h1>
			<h1><a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/booking/step3/addCar">Dodaj samochód</a></h1>
				<table class="table table-sm table-dark">
					<thead>
						<tr>
							<th>Model</th>
							<th>Marka</th>
							<th>Numer rejestracyjny</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach var="tmpCar" items="${cars}">
						<c:url var="checkLink" value="/booking/step4/">
				      		<c:param name="id" value="${tmpCar.id}" />
				      	</c:url>
						<tr>
							<td>${tmpCar.theCarBrand}</td>
					        <td>${tmpCar.carModel}</td>
					        <td>${tmpCar.registrationNumber}</td>
							<td><a class="btn btn-outline-light btn-sm" href="${checkLink}">Wybierz</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>