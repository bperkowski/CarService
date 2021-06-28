<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%-- <link rel="stylesheet" href="<spring:url value="/static/css/style.css"/>">--%>
  <meta charset="UTF-8">
  <title>Strona Główna</title>
  	<style type="text/css">
  		<%@include file="/static/css/style.css" %>
	</style>
<script type="text/javascript">
	var Msg ='${message}';
	   	if (Msg != "") {
			function alertName(){
				swal("Komunikat!", "<c:out value="${message}"/>", "<c:out value="${type}"/>");
		} 
	 }
</script>
<script type="text/javascript">
	var Msg ='${showLoginModal}';
	if (Msg == "true") {
		$(window).on('load',function(){
	        $('#modalLogin').modal('show');
	    });
	}
</script>

<body data-spy="scroll" data-targer="#collapse_target"> 
<!--           START HOME SECTION            -->
 <div id="home">
	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
			<a class="navbar-brand" href="${pageContext.request.contextPath}"><img src="<spring:url value="/static/images/logo.png"/>"></a>
			<button class="navbar-toggler" data-toggle="collapse" data-target="#collapse_target">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapse_target">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#home">Strona główna</a></li>
					<li class="nav-item"><a class="nav-link" href="#offer">Nasza oferta</a></li>
					<li class="nav-item"><a class="nav-link" href="#aboutUs">O nas</a></li>
					<li class="nav-item"><a class="nav-link" href="#contact">Kontakt</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Logowanie</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/registry">Rejestracja</a></li>
				</ul>
			</div>
		</nav>
	<div class="landing">
		<div class="home-wrap">
			<div class="home-inner">
			</div>
		</div>
	</div>
	
	<div class="caption text-center">
		<h1>Car Service</h1>
		<a class="btn btn-outline-light btn-lg" href="#offer">Nasza oferta</a>
	</div>
</div>
<!--           END HOME SECTION             -->   

<!--           START OFFER SECTION            -->
<div id="offer" class="offset">
	<div class="jumbotron">
		<div class="narrow">
			<div class="col-12">
				<h1 class="heading text-center">Nasza oferta wykonywanych usług</h1>
			</div>
			<div class="row text-center">
				<div class="col-md-3" >
					<div class="card mb-2">
			          <img class="card-img-top" src="<spring:url value="/static/images/oilChange.jpg"/>">
			          <div class="card-body">
			            <h4 class="card-title">Wymiana oleju</h4>
			          </div>
			        </div>
				</div>
				<div class="col-md-3" >
					<div class="card mb-2">
			          <img class="card-img-top" src="<spring:url value="/static/images/autoRepair.jpg"/>">
			          <div class="card-body">
			            <h4 class="card-title">Naprawa silnika</h4>
			          </div>
			        </div>
				</div>
				<div class="col-md-3" >
					<div class="card mb-2">
			          <img class="card-img-top" src="<spring:url value="/static/images/autoRepair.jpg"/>">
			          <div class="card-body">
			            <h4 class="card-title">Wymiana rozrządu</h4>
			          </div>
			        </div>
				</div>
				<div class="col-md-3" >
					<div class="card mb-2">
			          <img class="card-img-top" src="<spring:url value="/static/images/carTireChange.jpg"/>">
			          <div class="card-body">
			            <h4 class="card-title">Wymiana opon</h4>
			          </div>
			        </div>
				</div>
			</div>
			<div class="col-12">
				<h1 class="heading text-center"></h1>
				<h3 class="heading text-center">Świadczymy również wiele innych usług</h3>
			</div>
		</div>
</div>
</div>
<!--           END OFFER SECTION            -->

<!--           START ABOUT US SECTION            -->
<div id="aboutUs" class="aboutUs">
	<h1 class="heading text-center">O nas</h1>
	<p>Tutaj muszą znaleźć się informację na temat czym się firma zajmuje</p>
</div>
<!--           END ABOUT US SECTION            -->

<!--           START CONTACT SECTION            -->
<div id="contact">
	<div class="footer">
		<div class="row justify-content-center">
			<div class="col-md-5 text-center">
				<img src="<spring:url value="/static/images/logo.png"/>" width="75">
				<h1 class="heading">Dane kontaktowe</h1>
				<p>Numer telefonu: 000-000-000</p>
				<p>Email: carservice.apk@gmail.com</p>
			</div>
		</div>
	</div>
</div>
<!--           END CONTANT SECTION            -->

<!--           START LOGIN SECTION            -->
<div class="modal fade" id=modalLogin tabindex="-1" role="dialog" aria-labelledby="modalLoginLabel" aria-hidden="true">
	<div class="modal-dialog border" role="document">
	    <div class="modal-content">
	      <div class="row">
	      	<div class="col-sm-12">
	      		<div class="card center">
	      			<div class="card-header">Panel logowania</div>
	      			<div class="card-body">
	      				<form:form action="login" method="post" modelAttribute="User">
	      					<c:if test="${not empty error}">
	      						<div class="form-group row">
	      							<div class="col-md-12" align="center">
	      								<label for="error" class="error">${error}</label>
	      							</div>
	      						</div>
	      					</c:if>
	      					<div class="form-group row">
	      						<label for="email" class="col-md-4 col-form-label text-md-right">Email</label>
	      						<div class="col-md-6"> 
	         						<form:input class="form-control" path="email" placeholder = "email" />
	            				</div>
	      					</div>
	      					<div class="form-group row">
	      						<label for="password" class="col-md-4 col-form-label text-md-right">Hasło</label>
	      						<div class="col-md-6"> 
	         						<form:password class="form-control" path="password" placeholder = "hasło" />
	            				</div>
	      					</div>
	      					<div class="col-sm-10 offset-sm-1 text-center">
	         					<input class="btn btn-outline-light btn-lg" type="submit" value="Zaloguj"/>
	            			</div>
	      				</form:form>
	      			</div>
	      		</div>
	      	</div>
	      </div>
    	</div>
  	</div>
</div>
<!--           END LOGIN SECTION            -->

<script type="text/javascript"> window.onload = alertName; </script>
</body>
</html>