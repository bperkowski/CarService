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
	<title>Zmiana danych pracownika</title>
	<style type="text/css">
  		<%@include file="/static/css/style.css" %>
	</style>
	<script>
		$(document).ready(function(){
		    $('.check').click(function() {
		        $('.check').not(this).prop('checked', false);
		    });
		});
	</script>
</head>
<body>
<%@include file="../MenuHomePage.jsp" %>
<div class="home">
	<div class="jumbotron">
		<div class="container">
			<div class="row justify-content-center align-items-center" style="height:70vh">
					<div class="col-md-8">
						<div class="card">
							<div class="card-header">Zmień dane pracownika</div>
							 	<div class="card-body">
								 	<form:form action="${pageContext.request.contextPath}/workers/update" method="post" modelAttribute="employee">
									<form:hidden path="id"></form:hidden>
									<form:hidden path="isActive"></form:hidden>	
									 	<div class="form-group row">
									 		<label for="name" class="col-md-4 col-form-label text-md-right">Imię</label>
									 			<div class="col-md-6"> 
				         							<form:input class="form-control" path="name" placeholder = "imię"/>
				            					</div>
				            					<div class="col-md-12" align="center">
				            						<form:errors path="name" cssClass="error" />
				            					</div>
									 	</div>
									 	<div class="form-group row">
									 		<label for="surname" class="col-md-4 col-form-label text-md-right">Nazwisko</label>
									 			<div class="col-md-6"> 
				         							<form:input class="form-control" path="surname" placeholder = "nazwisko" />
				            					</div>
				            					<div class="col-md-12" align="center">
				            						<form:errors path="surname" cssClass="error" />
				            					</div>
									 	</div>
									 	<div class="form-group row">
									 		<label for="pesel" class="col-md-4 col-form-label text-md-right">Pesel</label>
									 			<div class="col-md-6"> 
				         							<form:input class="form-control" type="number" min="0" path="pesel" placeholder = "pesel" />
				            					</div>
				            					<div class="col-md-12" align="center">
				            						<form:errors path="pesel" cssClass="error" />
				            					</div>
									 	</div>
									 	<div class="form-group row">
									 		<label for="dateOfBirth" class="col-md-4 col-form-label text-md-right">Data urodzenia</label>
									 			<div class="col-md-6"> 
				         							<form:input class="form-control" type="date" path="dateOfBirth" placeholder = "data urodzenia" />
				            					</div>
				            					<div class="col-md-12" align="center">
				            						<form:errors path="dateOfBirth" cssClass="error" />
				            					</div>
									 	</div>
									 	<div class="form-group row">
									 		<label for="dateOfEmployment" class="col-md-4 col-form-label text-md-right">Data zatrudnienia</label>
									 			<div class="col-md-6"> 
				         							<form:input class="form-control" type="date" path="dateOfEmployment" placeholder = "data zatrudnienia" />
				            					</div>
				            					<div class="col-md-12" align="center">
				            						<form:errors path="dateOfEmployment" cssClass="error" />
				            					</div>
									 	</div>
									 	<div class="form-group row">
									 		<label for="adres" class="col-md-4 col-form-label text-md-right">Adres</label>
									 			<div class="col-md-6"> 
				         							<form:input class="form-control" path="adres" placeholder = "adres" />
				            					</div>
				            					<div class="col-md-12" align="center">
				            						<form:errors path="adres" cssClass="error" />
				            					</div>
									 	</div>
									 	<div class="form-group row">
									 		<label for="phoneNumber" class="col-md-4 col-form-label text-md-right">Numer telefonu</label>
									 			<div class="col-md-6"> 
				         							<form:input class="form-control" type="number" min="0" path="phoneNumber" placeholder = "numer telefonu" />
				            					</div>
				            					<div class="col-md-12" align="center">
				            						<form:errors path="phoneNumber" cssClass="error" />
				            					</div>
									 	</div>
									 	<div class="form-group row">
									 		<label for="position" class="col-md-4 col-form-label text-md-right">Stanowisko</label>
									 			<div class="col-md-6"> 
				         							<form:checkbox path="position" value="Mechanik" class="check"/>Mechanik
				         							<form:checkbox path="position" value="Pomocnik mechanika" class="check"/>Pomocnik Mechanika
				            					</div>
				            					<div class="col-md-12" align="center">
				            						<form:errors path="position" cssClass="error" />
				            					</div>
									 	</div>
									 	<div class="form-group row">
									 		<label for="reward" class="col-md-4 col-form-label text-md-right">Wynagrodzenie</label>
									 			<div class="col-md-6"> 
				         							<form:input class="form-control" type="number" min="0" path="reward" placeholder = "wynagrodzenie" />
				            					</div>
				            					<div class="col-md-12" align="center">
				            						<form:errors path="reward" cssClass="error" />
				            					</div>
									 	</div>
									 	<div class="form-group row" align="center">
									 		<div class="col-md-12">
				            					<input class="btn btn-outline-light btn-lg" type="submit" value="Zatwierdź"/>
				            				</div>
									 	</div>
		            				</form:form>
						 	</div>
						</div>
					</div>
				</div>
		</div>
	</div>
</div>
</body>
</html>