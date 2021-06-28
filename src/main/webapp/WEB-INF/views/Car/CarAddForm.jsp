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
	<title>Dodaj samochód</title>
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
						<div class="card-header">Dodaj samochód</div>
						 	<div class="card-body">
						 		<div class="form-group row" align="center">
						 		</div>
							 	<form:form action="addCar" method="post" modelAttribute="Car">
								<form:hidden path="id"></form:hidden>
								 	<div class="form-group row">
								 		<label for="theCarBrand" class="col-md-4 col-form-label text-md-right">Marka</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" path="theCarBrand" placeholder = "marka"/>
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="theCarBrand" cssClass="error" />
			            					</div>
								 	</div>
								 	<div class="form-group row">
								 		<label for="carModel" class="col-md-4 col-form-label text-md-right">Model</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" path="carModel" placeholder = "model" />
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="carModel" cssClass="error" />
			            					</div>
								 	</div>
								 	<div class="form-group row">
								 		<label for="registrationNumber" class="col-md-4 col-form-label text-md-right">Numer rejestracyjny</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" path="registrationNumber" placeholder = "numer rejestracyjny" />
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="registrationNumber" cssClass="error" />
			            					</div>
								 	</div>
							 		<div class="form-group row">
							 			<label for="VINnumber" class="col-md-4 col-form-label text-md-right">Numer VIN</label>
							 				<div class="col-md-6"> 
		         								<form:input class="form-control" path="VINnumber" placeholder = "numer VIN" />
		            						</div>
		            						<div class="col-md-12" align="center">
		            							<form:errors path="VINnumber" cssClass="error" />
		            						</div>
							 		</div>
								 	<div class="form-group row">
								 		<label for="carMileage" class="col-md-4 col-form-label text-md-right">Przebieg</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" type="number" path="carMileage" placeholder = "przebieg" />
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="carMileage" cssClass="error" />
			            					</div>
								 	</div>
								 	<div class="form-group row">
								 		<label for="yearOfProduction" class="col-md-4 col-form-label text-md-right">Rok produkcji</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" type="month" path="yearOfProduction" placeholder = "rok produkcji" />
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="yearOfProduction" cssClass="error" />
			            					</div>
								 	</div>
								 	<div class="form-group row">
								 		<label for="engineCapacity" class="col-md-4 col-form-label text-md-right">Silnik cm3</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" type="number" min="0" path="engineCapacity" placeholder = "pojemność cm3" />
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="engineCapacity" cssClass="error" />
			            					</div>
								 	</div>
								 	<div class="form-group row">
								 		<label for="fuelType" class="col-md-4 col-form-label text-md-right">Rodzaj paliwa</label>
								 			<div class="col-md-6"> 
								 				<div class="form-check">
								 					<form:checkbox path="fuelType" value="benzyna" class="check"/>benzyna
								 				</div>
								 				<div class="form-check">
								 					<form:checkbox path="fuelType" value="diesel" class="check"/>diesel 
								 				</div>
								 				<div class="form-check">
								 					<form:checkbox path="fuelType" value="benzyna/gaz" class="check" />benzyna/gaz
								 				</div>
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="engineCapacity" cssClass="error" />
			            					</div>
								 	</div>
								 	<div class="form-group row">
								 		<label for="enginePower" class="col-md-4 col-form-label text-md-right">Ilość KW</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" type="number" min="0" path="enginePower" placeholder = "ilość KW" />
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="enginePower" cssClass="error" />
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