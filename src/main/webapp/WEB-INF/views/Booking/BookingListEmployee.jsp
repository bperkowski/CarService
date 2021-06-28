<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
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
			<h1 align="center">Lista wizyt</h1>
			<div class="table-responsive">
				<table class="table table-sm table-dark">
					<thead>
						<tr>
							<th>Klient</th>
						    <th>Rodzaj Usługi</th>
						    <th>Data Złożenia</th>
						    <th>Status</th>
						    <th>Marka</th>
						    <th>Model</th>
						    <th>Data przyjęcia</th>
						    <th>Przyjęte przez</th>
						    <th></th>
						</tr>
					</thead>
					<c:forEach var="tmpBooking" items="${bookingList}">
						<c:url var="showLink" value="/booking">
							<c:param name="id" value="${tmpBooking.id}" />
						</c:url>
						<c:forEach items="${tmpBooking.user}" var="items">
							<c:if test="${empty items.position}"><c:set  var="customer" value="${items.name} ${items.surname}"></c:set></c:if>
						</c:forEach>
						<c:forEach items="${tmpBooking.user}" var="items" varStatus="status">
							<c:if test="${not empty items.position}"><c:set var="employee" value="${items.name} ${items.surname}" /></c:if>
						</c:forEach>
						<tr>
							<td>${customer}<c:set var = "customer" value = ''></c:set></td>
							<td>${tmpBooking.typeOfService}</td>
							<td>${tmpBooking.dateOfSubmission}</td>
							<td>${tmpBooking.status}</td>
							<td>${tmpBooking.car.theCarBrand}</td>
							<td>${tmpBooking.car.carModel}</td>
							<td><fmt:formatDate value="${tmpBooking.dateOfAdmission}" pattern="dd-MM-yyyy" /></td>
							<td>${employee}<c:set var = "employee" value = ''></c:set></td>
							<td><a class="btn btn-outline-light btn-sm" href="${showLink}">Zobacz Szczegóły</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>