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
	<title>Lista samochodów</title>
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
				<h1 align="center">Lista samochodów</h1>
				<h1><a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/addCar">Dodaj samochód</a></h1>
				<table class="table table-sm table-dark">
					<thead>
						<tr>
							<th>Model</th>
						    <th>Marka</th>
						    <th>Numer rejestracyjny</th>
						    <th>Numer VIN</th>
						    <th>Przebieg</th>
						    <th>Rok produkcji</th>
						    <th>Silnik(cm3)</th>
						    <th>Rodzaj paliwa</th>
						    <th>Ilość KW</th>
						    <th></th>
						    <th></th>
						    <th></th>
						</tr>
					</thead>
					<c:forEach var="tmpCar" items="${CarList}">
						<c:url var="updateLink" value="/carList/update">
							<c:param name="id" value="${tmpCar.id}" />
						</c:url>
						<c:url var="deleteLink" value="/carList/delete">
	      					<c:param name="id" value="${tmpCar.id}" />
	      				</c:url>
	       				<c:url var="showRepairHistoryLink" value="/carList/repairHistory">
	      					<c:param name="id" value="${tmpCar.id}" />
	      				</c:url>
	      				<tr>
	      					<td>${tmpCar.theCarBrand}</td>
	        				<td>${tmpCar.carModel}</td>
					        <td>${tmpCar.registrationNumber}</td>
							<td>${tmpCar.VINnumber}</td>
							<td>${tmpCar.carMileage}</td>
							<td><fmt:formatDate value="${tmpCar.yearOfProduction}" pattern="yyyy-MM" /></td>
							<td>${tmpCar.engineCapacity}</td>
							<td>${tmpCar.fuelType}</td>
							<td>${tmpCar.enginePower}</td>
							<td><a class="btn btn-outline-light btn-sm" href="${updateLink}">Edytuj</a></td>
							<td><a class="btn btn-outline-light btn-sm" href="${showRepairHistoryLink}">Historia napraw</a></td>
							<td><a class="btn btn-outline-light btn-sm" href="${deleteLink}" onclick="if (!(confirm('Czy napewno usunąć samochód z Twojej listy?'))) return false">Usuń</a></td>
	      				</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
 <script type="text/javascript"> window.onload = alertName; </script>
</body>
</html>