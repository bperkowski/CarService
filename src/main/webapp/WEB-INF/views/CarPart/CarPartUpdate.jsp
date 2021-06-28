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
	<title>Część</title>
	<style type="text/css">
  		<%@include file="/static/css/style.css" %>
	</style>
</head>
<body>
<%@include file="../MenuHomePage.jsp" %>
<div class="home">
	<div class="jumbotron">
		<div class="cotainer">
			<div class="row justify-content-center align-items-center" style="height:100vh">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Modyfikacja danych</div>
						 <div class="card-body">
						 	<form:form action="update" method="post" modelAttribute="carPart">
						 		<form:hidden path="id"/>
						 			<div class="form-group row">
						 				<label for="nazwa" class="col-md-4 col-form-label text-md-right">Nazwa</label>
						 				<div class="col-md-6"> 
	         								<form:input class="form-control" path="name" placeholder = "nazwa"/>
	            						</div>
	            						<div class="col-md-12" align="center">
	            							<form:errors path="name" cssClass="error" />
	            						</div>
						 			</div>
						 			<div class="form-group row">
						 				<label for="producent" class="col-md-4 col-form-label text-md-right">Producent</label>
						 				<div class="col-md-6"> 
	         								<form:input class="form-control" path="manufacturer" placeholder = "producent" />
	            						</div>
	            						<div class="col-md-12" align="center">
	            							<form:errors path="manufacturer" cssClass="error" />
	            						</div>
						 			</div>
						 			<div class="form-group row">
						 				<label for="cena" class="col-md-4 col-form-label text-md-right">Cena</label>
						 				<div class="col-md-6"> 
	         								<form:input class="form-control" type="number" step="0.01" path="price" placeholder = "cena" />
	            						</div>
	            						<div class="col-md-12" align="center">
	            							<form:errors path="price" cssClass="error" />
	            						</div>
						 			</div>
						 			<div class="form-group row">
						 				<label for="availability" class="col-md-4 col-form-label text-md-right">Wprowadzić do sprzedaży?</label>
						 				<div class="col-md-6"> 
	         								 <form:checkbox path="availability" />
	            						</div>
	            						<div class="col-md-12" align="center">
	            							<form:errors path="availability" cssClass="error" />
	            						</div>
						 			</div>
						 			<div class="col-md-6 offset-md-4">
	         							<input type="submit" value="Zatwierdź"/>
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