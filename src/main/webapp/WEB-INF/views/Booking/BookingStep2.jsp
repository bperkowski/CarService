<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<title>Step2</title>
	<style type="text/css">
  		<%@include file="/static/css/style.css" %>
	</style>
</head>
<body>
<%@include file="../MenuHomePage.jsp" %>
<div class="home">
	<div class="jumbotron">
		<div class="container">
			<div class="row justify-content-center align-items-center" style="height:70vh">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Dane klienta</div>
						 	<div class="card-body">
						 		<div class="form-group row" align="center">
							 		<sec:authorize access="hasRole('ROLE_ADMIN')">
							 			<div class="col-md-6">
											<a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/booking/step2/addCustomer">Dodaj użytkownika</a>
										</div>
										<div class="col-md-6">
											<a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/booking/step2/customers">Wybierz z listy istniejących</a>
										</div>
									</sec:authorize>
						 		</div>
							 	<form:form action="${pageContext.request.contextPath}/booking/step2" method="post" modelAttribute="User">
							 	<form:hidden path="id"></form:hidden>
							 	<form:hidden path="isActive"></form:hidden>
								 	<div class="form-group row">
								 		<label for="name" class="col-md-4 col-form-label text-md-right">Imię</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" path="name" readonly="${disabled}" placeholder = "imię"/>
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="name" cssClass="error" />
			            					</div>
								 	</div>
								 	<div class="form-group row">
								 		<label for="surname" class="col-md-4 col-form-label text-md-right">Nazwisko</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" path="surname" readonly="${disabled}" placeholder = "nazwisko" />
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="surname" cssClass="error" />
			            					</div>
								 	</div>
								 	<div class="form-group row">
								 		<label for="pesel" class="col-md-4 col-form-label text-md-right">Pesel</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" type="number" min="0" path="pesel" readonly="${disabled}" placeholder = "pesel" />
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="pesel" cssClass="error" />
			            					</div>
								 	</div>
							 		<div class="form-group row">
							 			<label for="nip" class="col-md-4 col-form-label text-md-right">Nip</label>
							 				<div class="col-md-6"> 
		         								<form:input class="form-control" type="number" min="0" path="nip" readonly="${disabled}" placeholder = "NIP" />
		            						</div>
		            						<div class="col-md-12" align="center">
		            							<form:errors path="nip" cssClass="error" />
		            						</div>
							 		</div>
								 	<div class="form-group row">
								 		<label for="dateOfBirth" class="col-md-4 col-form-label text-md-right">Data urodzenia</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" type="date" path="dateOfBirth" readonly="${disabled}" placeholder = "data urodzenia" />
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="dateOfBirth" cssClass="error" />
			            					</div>
								 	</div>
								 	<div class="form-group row">
								 		<label for="adres" class="col-md-4 col-form-label text-md-right">Adres</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" path="adres" readonly="${disabled}" placeholder = "adres" />
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="adres" cssClass="error" />
			            					</div>
								 	</div>
								 	<div class="form-group row">
								 		<label for="phoneNumber" class="col-md-4 col-form-label text-md-right">Numer telefonu</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" type="number" min="0" path="phoneNumber" readonly="${disabled}" placeholder = "numer telefonu" />
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="phoneNumber" cssClass="error" />
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