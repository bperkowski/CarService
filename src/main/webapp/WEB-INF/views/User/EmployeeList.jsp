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
			<h1 align="center">Lista pracowników</h1>
				<table class="table table-sm table-dark">
					<thead>
						<tr>
							<td>Imię</td>
							<td>Nazwisko</td>
							<td>Data urodzenia</td>
							<td>Data zatrudnienia</td>
							<td>Stanowisko</td>
							<td>Wynagrodzenie</td>
							<td></td>
							<td></td>
						</tr>
					</thead>
					<c:forEach var="tmpEmployee" items="${workers}">
						<c:url var="showLink" value="workers/update">
							<c:param name="id" value="${tmpEmployee.id}"/>
						</c:url>
						<tr>
							<td>${tmpEmployee.name}</td>
							<td>${tmpEmployee.surname}</td>
							<td><fmt:formatDate value="${tmpEmployee.dateOfBirth}" type="date" pattern="dd-MM-yyyy"/></td>
							<td><fmt:formatDate value="${tmpEmployee.dateOfEmployment}" type="date" pattern="dd-MM-yyyy"/></td>
							<td>${tmpEmployee.position}</td>
							<td>${tmpEmployee.reward}</td>
							<td>
								<a class="btn btn-outline-light btn-sm" href="${showLink}">Zmien dane</a>
								<c:if test="${tmpEmployee.isActive eq '1'}">
									<a class="btn btn-outline-light btn-sm" style="background-color: #8B0000" href="${showLink}&isActive=0">Dezaktywuj konto</a>
								</c:if>
								<c:if test="${tmpEmployee.isActive eq '0'}">
									<a class="btn btn-outline-light btn-sm" style="background-color: #006400" href="${showLink}&isActive=1">Aktywuj konto</a>	
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>