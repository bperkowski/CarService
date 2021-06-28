<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="UTF-8">
	<title>Rejestracja</title>
	<style type="text/css">
  		<%@include file="/static/css/style.css" %>
	</style>
</head>
<body data-spy="scroll" data-targer="#collapse_target">
<div id="home">
	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
				<a class="navbar-brand" href="${pageContext.request.contextPath}"><img src="<spring:url value="/static/images/logo.png"/>"></a>
				<button class="navbar-toggler" data-toggle="collapse" data-target="#collapse_target">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapse_target">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/#home">Strona główna</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/#offer">Nasza oferta</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/#aboutUs">O nas</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/#contact">Kontakt</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Logowanie</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/registry">Rejestracja</a></li>
					</ul>
				</div>
			</nav>
	<div class="landing">
		<div class="home-wrap">
			<div class="home-inner">
				<div class="container">
					<div class="row">
						<div class="col-sm-6 offset-sm-3 text-center">
							<div class="card border">
								<div class="card-header">Rejestracja</div>
								<div class="card-body">
									<form:form action="registry" method="post" modelAttribute="User">
										<div class="form-group row">
											<label for="name" class="col-md-4 col-form-label text-md-right">Imię</label>
	        								<div class="col-md-6"> 
	         									<form:input class="form-control" path="name" placeholder = "imię" />
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
											<label for="email" class="col-md-4 col-form-label text-md-right">Email</label>
	        								<div class="col-md-6"> 
	         									<form:input class="form-control" path="email" placeholder = "email" />
	            							</div>
	            							<div class="col-md-12" align="center">
	            								<form:errors path="email" cssClass="error" />
	            							</div>
										</div>
										<div class="form-group row">
											<label for="password" class="col-md-4 col-form-label text-md-right">Hasło</label>
	        								<div class="col-md-6"> 
	         									<form:input class="form-control" path="password" placeholder = "password" />
	            							</div>
	            							<div class="col-md-12" align="center">
	            								<form:errors path="password" cssClass="error" />
	            							</div>
										</div>
										<div class="col-sm-10 offset-sm-1 text-center">
	         								<input class="btn btn-outline-light btn-lg" type="submit" value="Zarejestruj"/>
	            						</div>
									</form:form>
								</div>
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