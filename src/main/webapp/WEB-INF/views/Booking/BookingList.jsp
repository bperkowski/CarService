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
	<title>Lista wizyt</title>
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
				<h1 align="center">Lista napraw:</h1>
				<table class="table table-sm table-dark">
					<thead>
						<tr>
							<th>Data złożenia wizyty</th>
					     	<th>Rodzaj usługi</th>
					        <th>Wizyta dotyczy samochodu</th>
					        <th>Status</th>
					        <th></th>
						</tr>
					</thead>
					<c:forEach var="tmpBooking" items="${bookingList}">
						<c:url var="showLink" value="/booking">
		      				<c:param name="id" value="${tmpBooking.id}" />
		      			</c:url>
		      			<tr>
					        <td>${tmpBooking.dateOfSubmission}</td>
					        <td>${tmpBooking.typeOfService}</td>
					        <td>${tmpBooking.car.theCarBrand} ${tmpBooking.car.carModel}</td>
					        <td>${tmpBooking.status}</td>
					        <td><a class="btn btn-outline-light btn-sm" href="${showLink}">Sprawdź</a></td>
					      </tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>