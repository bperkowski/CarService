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
	<title>Lista zamówień</title>
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
			<h1 align="center">Lista zamówień</h1>
				<table class="table table-sm table-dark">
					<thead>
						<tr>
							<th>Nr.</th>
							<th>Data zamówienia</th>
							<th>Status</th>
							<th>Ilość produktów</th>
							<th>Kwota zamówienia</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach var="tmpErrand" items="${errands}">
						<c:url var="showLink" value="errand/">
							<c:param name="id" value="${tmpErrand.id}" />
						</c:url>
						<tr>
							<td>${tmpErrand.id}</td>
							<td>${tmpErrand.dateOfErrand}</td>
							<td>${tmpErrand.status}</td>
							<td>${tmpErrand.amountOfProducts}</td>
							<td>${tmpErrand.amount}</td>
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