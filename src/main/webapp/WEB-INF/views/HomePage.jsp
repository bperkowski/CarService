<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<title>Home</title>
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
</head>
<body>
<%@include file="MenuHomePage.jsp" %> 
<script type="text/javascript"> window.onload = alertName; </script>
	<div class="landing">
		<div class="home-wrap">
			<div class="home-inner">
			</div>
		</div>
	</div>
</body>
</html>