<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<title>Lista wizyt</title>
	<style type="text/css">
  		<%@include file="/static/css/style.css" %>
	</style>
	<script type="text/javascript">
		var Msg ='<%=session.getAttribute("alert")%>';
	    	if (Msg != "null") {
	 		function alertName(){
	 			swal("Komunikat","Twoj koszyk jest pusty","error");
	 		<c:remove var="alert" scope="session" />
	 		} 
	 	}
	 </script>
</head>
<body>
<%@include file="../MenuHomePage.jsp" %>
<div class="home">
	<div class="jumbotron">
		<div class="container">
			<div class="table-responsive">
			<h1 align="center">Koszyk z produktami</h1>
			<h1><a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/errand">Lista części</a>
			<a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/errand/basket/finalize">Zatwierdź zamówienie</a></h1>
				<table class="table table-sm table-dark">
					<thead>
						<tr>
							<th>Nazwa</th>
							<th>Producent</th>
							<th>Cena</th>
							<th>Ilość</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<c:forEach var="tmpBasket" items="${basket}">
						<c:url var="deleteLink" value="/errand/basket/delete">
							<c:param name="id" value="${tmpBasket.carPart.id}"/>
						</c:url>
						<tr>
							<form:form action="${pageContext.request.contextPath}/errand/modify" method="get">
								<input type="hidden" name="id" value="${tmpBasket.carPart.id}"/>
								<td>${tmpBasket.carPart.name}</td>
								<td>${tmpBasket.carPart.manufacturer}</td>
								<td>${tmpBasket.price}</td>
								<td align="center"><input type="number" name="quantity" value="${tmpBasket.quantity}" min="1" max="10" /></td>
								<td align="center"><input class="btn btn-outline-light btn-sm" type="submit" value="Zatwierdź"/>
								<a class="btn btn-outline-light btn-sm" href="${deleteLink}" class="btn btn-dangerous">Usuń element</a></td>
							</form:form>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript"> window.onload = alertName; </script>
</body>
</html>