<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<meta charset="UTF-8">
<title>Menu</title>
  	<style type="text/css">
  		<%@include file="/static/css/style.css" %>
	</style>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/home"><img src="<spring:url value="/static/images/logo.png"/>"></a>
	<button class="navbar-toggler" data-toggle="collapse" data-target="#collapse_target">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapse_target">
		<ul class="navbar-nav ml-auto">
			<sec:authorize access="hasRole('ROLE_KLIENT')">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/update">Uzupełnij dane</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/carList">Lista samochodów</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/booking/step1">Umów wizytę</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/myBooking">Moje wizyty</a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/bookings">Lista wizyt</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/booking/step1">Dodaj wizytę</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/employee/add">Dodaj pracownika</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/workers">Lista pracowników</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/errand">Złóż zamówienie</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/errands">Lista zamówień</a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_PRACOWNIK')">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/bookings?status=W trakcie realizacji">Lista wizyt</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/myBooking">Moje wizyty</a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_DYSTRYBUTOR')">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/carPart/add">Dodaj część</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/carParts">Lista części</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/errands">Lista zamówień</a></li>
			</sec:authorize>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout">Wyloguj</a></li>
		</ul>
	</div>
</nav>

</body>
</html>