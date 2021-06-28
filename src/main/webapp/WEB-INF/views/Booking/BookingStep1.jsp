<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<title>Step1</title>
	<style type="text/css">
  		<%@include file="/static/css/style.css" %>
	</style>
</head>
<body>
<%@include file="../MenuHomePage.jsp" %> 
<div class="home">
	<div class="jumbotron">
		<div class="container">
			<h1 align="center">Wybierz rodzaj wizyty:</h1>
			<div class="narrow">
				<div class="row text-center">
					<div class="col-md-3">
						<div class="card mb-2">
				          <img class="card-img-top" src="<spring:url value="/static/images/oilChange.jpg"/>">
				          <div class="card-body">
				            <h4 class="card-title"><a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/booking/step1?type=Wymiana Oleju">Wymiana oleju</a></h4>
				          </div>
				        </div>
					</div>
					<div class="col-md-3" >
						<div class="card mb-2">
				          <img class="card-img-top" src="<spring:url value="/static/images/autoRepair.jpg"/>">
				          <div class="card-body">
				            <h4 class="card-title"><a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/booking/step1?type=Awaria Silnika">Awaria Silnika</a></h4>
				          </div>
				        </div>
					</div>
					<div class="col-md-3" >
						<div class="card mb-2">
				          <img class="card-img-top" src="<spring:url value="/static/images/autoRepair.jpg"/>">
				          <div class="card-body">
				            <h4 class="card-title"><a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/booking/step1?type=Inna Usługa">Inna usługa</a></h4>
				          </div>
				        </div>
					</div>
					<div class="col-md-3" >
						<div class="card mb-2">
				          <img class="card-img-top" src="<spring:url value="/static/images/carTireChange.jpg"/>">
				          <div class="card-body">
				            <h4 class="card-title"><a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/booking/step1?type=Wymiana Opon">Wymiana opon</a></h4>
				          </div>
				        </div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>