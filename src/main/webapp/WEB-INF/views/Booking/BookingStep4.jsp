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
	<title>Step4</title>
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
						<div class="card-header">Dodaj opis dla mechanika</div>
						 	<div class="card-body">
						 		<div class="form-group row" align="center">
						 		</div>
							 	<form:form action="${pageContext.request.contextPath}/booking/add" method="post" modelAttribute="booking">
									<div class="form-group row">
								 		<label for="description" class="col-md-4 col-form-label text-md-right">Opis dla mechanika</label>
								 			<div class="col-md-6"> 
			         							<form:input class="form-control" path="description" placeholder = "opis"/>
			            					</div>
			            					<div class="col-md-12" align="center">
			            						<form:errors path="description" cssClass="error" />
			            					</div>
								 	</div>
								 	<div class="form-group row" align="center">
								 		<div class="col-md-12">
			            					<input class="btn btn-outline-light btn-lg" type="submit" value="Zakończ"/>
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