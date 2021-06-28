<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	<style>
		#formStatus{
			display: none;
		}	
	</style>
	<script>
		$(document).ready(function(){
			$('#changeStatusButton').click(function(){	
			$('#formStatus').toggle(500);
	  	});
	});
	</script>
</head>
<body>
<%@include file="../MenuHomePage.jsp" %> 
<div class="home">
	<div class="jumbotron">
		<div class="container">
			<div class="table-responsive">
			<h1 align="center">Zamówienie</h1>
				<table class="table table-sm table-dark">
					<thead>
						<tr>
							<th>Nr.</th>
							<th>Data zamówienia</th>
							<th>Status</th>
							<th>Ilość produktów</th>
							<th>Kwota zamówienia</th>
						</tr>
					</thead>
					<tr>
						<td>${errand.id}</td>
						<td>${errand.dateOfErrand}</td>
						<td>${errand.status}</td>
						<td>${errand.amountOfProducts}</td>
						<td>${errand.amount}</td>
					</tr>
				</table>
			</div>
			<div class="narrow">
			<div class="row text-center">
				<c:forEach var="detailErrand" items="${detailsErrand}">
					<div class="col-md-6" >
						<div class="card mb-2">
				          <div class="card-body">
				            <div>Nazwa: ${detailErrand.carPart.name}</div>
				            <div>Producent:  ${detailErrand.carPart.manufacturer}</div>
				            <div>Cena za sztukę ${detailErrand.carPart.price} zł</div>
				            <div>Ilość:  ${detailErrand.quantity} szt</div>
				            <div>Kwota:  ${detailErrand.price}  zł</div>
				          </div>
				        </div>
					</div>
				</c:forEach>
				
			</div>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			<c:if test="${errand.status eq 'Odebrane przez kuriera'}"> 
			<div class="table-responsive">
				<table class="table table-bordered">
					<tr>
					<td><h3 align="center"><a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/errand/status?id=${errand.id}&value=Zakończone">Części Odebrane</a></h3></td>
					</tr>
				</table>
			</div>
			</c:if>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_DYSTRYBUTOR')">
		<div class="table-responsive">
				<table class="table table-bordered">
					<tr>
					<td><h3 align="center"><a class="btn btn-outline-light btn-lg" id="changeStatusButton">Zmień status</a></h3></td>
					</tr>
				</table>
			</div>
			<form:form id="formStatus" method="post" modelAttribute="errand" action="status">
			<div class="row">
				<div class="col-lg-4 col-sm-12"></div>
				<div class="col-lg-4 col-sm-12">
					<form:hidden path="id"/>
					<div class="table-responsive">
						<table class="table table-bordered">
							<tr>
								<td><h1>Ustaw status</h1></td>
							</tr>
							<tr>
								<td>
									<form:select path="status">
										<form:option value="Oczekiwanie na realizację" label="Oczekiwanie na realizację" />
										<form:option value="W trakcie realizacji" label="W trakcie realizacji" />
										<form:option value="Odebrane przez kuriera" label="Odebrane przez kuriera" />
										<form:option value="Zakończone" label="Zakończone" />
									</form:select>
								</td>
							</tr>
							<tr>
							<td><input class="btn btn-outline-light btn-lg" type="submit" value="Zatwierdź"/></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="col-lg-4 col-sm-12"></div>
			</div>
			</form:form>
		</sec:authorize>
		</div>
		</div>
	</div>
</div>
</body>
</html>