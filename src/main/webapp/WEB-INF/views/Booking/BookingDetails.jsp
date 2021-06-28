<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<title>Szczegóły zamówienia</title>
	<style>
		#formBooking, #historyTable, #zamowCzesci, #zamowioneCzesciTable, #formStatus,#formFinalizeBooking{
		display: none;
		}	
	</style>
<script>
$(document).ready(function(){
	$('#terminButton').click(function(){
  		$('#formBooking').toggle(500);
  		$('#historyTable').hide(500);
  		$('#formStatus').hide(500);
  		$('#formFinalizeBooking').hide(500);
  });
	$('#historiaButton').click(function(){
		$('#formBooking').hide(500);
		$('#historyTable').toggle(500);
		$('#formStatus').hide(500);
		$('#formFinalizeBooking').hide(500);
  });
	$('#zmienStatusButton').click(function(){
		$('#formBooking').hide(500);
		$('#historyTable').hide(500);
		$('#formStatus').toggle(500);
		$('#formFinalizeBooking').hide(500);
  });
	$('#zakonczButton').click(function(){
		$('#formBooking').hide(500);
		$('#historyTable').hide(500);
		$('#formStatus').hide(500);
		$('#formFinalizeBooking').toggle(500);
  });
	$('#wizytaButton').click(function(){
			$('#formBooking').toggle(500);
  });
});
</script>
	<style type="text/css">
  		<%@include file="/static/css/style.css" %>
	</style>
</head>
<body>
<%@include file="../MenuHomePage.jsp" %> 
<div class="home">
<div class="jumbotron">
		<div class="narrow">
			<div class="col-12">
				<h1 class="heading text-center">Dane wizyty</h1>
			</div>
			<div class="row text-center">
				<div class="col-lg-4 col-sm-12" >
					<div class="card mb-2">
			          <div class="card-body">
			          <h3>Wizyta</h3>
			            <div class="row border-bottom">
			            	<div class="col-md-6 border-right">Rodzaj usługi</div>
			            	<div class="col-md-6">${booking.typeOfService}</div>
			            </div>
			            <div class="row border-bottom">
			            	<div class="col-md-6 border-right">Data złożenia</div>
			            	<div class="col-md-6">${booking.dateOfSubmission}</div>
			            </div>
			            <div class="row border-bottom">
			            	<div class="col-md-6 border-right">Status</div>
			            	<div class="col-md-6">${booking.status}</div>
			            </div>
			            <div class="row border-bottom">
			            	<div class="col-md-6 border-right">Opis</div>
			            	<div class="col-md-6">${booking.description}</div>
			            </div>
			            <div class="row border-bottom">
			            	<div class="col-md-6 border-right">Data przyjęcia</div>
			            	<div class="col-md-6"><fmt:formatDate value="${booking.dateOfAdmission}" type="date" pattern="dd-MM-yyyy"/></div>
			            </div>
			            <div class="row border-bottom">
			            	<div class="col-md-6 border-right">Czas realizacji</div>
			            	<div class="col-md-6">${booking.leadTime}</div>
			            </div>
			            <div class="row border-bottom">
			            	<div class="col-md-6 border-right">Cena</div>
			            	<div class="col-md-6">${booking.price}</div>
			            </div>
			          </div>
			        </div>
				</div>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<div class="col-lg-4 col-sm-12" >
						<div class="card mb-2">
				          <div class="card-body">
				            <h3>Klient</h3>
				            <div class="row border-bottom">
				            	<div class="col-md-6 border-right">Imię</div>
				            	<div class="col-md-6">${user.name}</div>
				            </div>
				            <div class="row border-bottom">
				            	<div class="col-md-6 border-right">Nazwisko</div>
				            	<div class="col-md-6">${user.surname}</div>
				            </div>
				            <div class="row border-bottom">
				            	<div class="col-md-6 border-right">Pesel</div>
				            	<div class="col-md-6">${user.pesel}</div>
				            </div>
				            <div class="row border-bottom">
				            	<div class="col-md-6 border-right">Nip</div>
				            	<div class="col-md-6">${user.nip}</div>
				            </div>
				            <div class="row border-bottom">
				            	<div class="col-md-6 border-right">Adres</div>
				            	<div class="col-md-6">${user.adres}</div>
				            </div>
				            <div class="row border-bottom">
				            	<div class="col-md-6 border-right">Numer telefonu</div>
				            	<div class="col-md-6">${user.phoneNumber}</div>
				            </div>
				          </div>
				        </div>
					</div>
				</sec:authorize>
				<div class="col-lg-4 col-sm-12" >
					<div class="card mb-2">
			          <div class="card-body">
			            <h3>Samochód</h3>
			            	<div class="row border-bottom">
				            	<div class="col-md-6 border-right">Marka</div>
				            	<div class="col-md-6">${car.theCarBrand}</div>
				      		</div>
				      		<div class="row border-bottom">
				            	<div class="col-md-6 border-right">Model</div>
				            	<div class="col-md-6">${car.carModel}</div>
				      		</div>
				      		<div class="row border-bottom">
				            	<div class="col-md-6 border-right">Numer rejestracyjny</div>
				            	<div class="col-md-6">${car.registrationNumber}</div>
				      		</div>
				      		<div class="row border-bottom">
				            	<div class="col-md-6 border-right">Numer VIN</div>
				            	<div class="col-md-6">${car.VINnumber}</div>
				      		</div>
				      		<div class="row border-bottom">
				            	<div class="col-md-6 border-right">Przebieg</div>
				            	<div class="col-md-6">${car.carMileage}</div>
				      		</div>
				      		<div class="row border-bottom">
				            	<div class="col-md-6 border-right">Rok produkcji</div>
				            	<div class="col-md-6"><fmt:formatDate value="${car.yearOfProduction}" type="date" pattern="yyyy-MM"/></div>
				      		</div>
				      		<div class="row border-bottom">
				            	<div class="col-md-6 border-right">Silnik (cm3)</div>
				            	<div class="col-md-6">${car.engineCapacity}</div>
				      		</div>
				      		<div class="row border-bottom">
				            	<div class="col-md-6 border-right">Rodzaj paliwa</div>
				            	<div class="col-md-6">${car.fuelType}</div>
				      		</div>
				      		<div class="row border-bottom">
				            	<div class="col-md-6 border-right">Ilość KW</div>
				            	<div class="col-md-6">${car.enginePower}</div>
				      		</div>
			          </div>
			        </div>
				</div>
			</div>
			<c:url var="deleteLink" value="/booking/delete">
      <c:param name="id" value="${booking.id}" />
</c:url>
<%--                              METODY DLA KLIENTA                                   --%>
<sec:authorize access="hasRole('ROLE_KLIENT')">
<c:if test="${booking.status eq 'Negocjacje'}">
	<h3 align="center">Proponowany termin: <fmt:formatDate value="${booking.dateOfAdmission}" type="date" pattern="dd-MM-yyyy"/></h3>
</c:if>
<div class="table-responsive">
	<table class="table table-bordered">
		<c:if test="${booking.status eq 'Negocjacje'}">
			<tr>
				<td><h3 align="center"><a class="btn btn-outline-light btn-lg" href="booking/status?id=${booking.id}&value=Termin zaakceptowany"> Zaakceptuj termin</a></h3></td>
				<td><h3 align="center"><a class="btn btn-outline-light btn-lg" href="booking/status?id=${booking.id}&value=Termin odrzucony"> Odrzuć termin</a></h3></td>
				<td><h3 align="center"><a class="btn btn-outline-light btn-lg" href="booking/status?id=${booking.id}&value=Rezygnacja"> Zrezygnuj z wizyty</a></h3></td>
			</tr>
		</c:if>
	</table>
</div>
</sec:authorize>

<%--                              METODY DLA ADMINA                                   --%>                    
<sec:authorize access="hasRole('ROLE_ADMIN')">
<div class="table-responsive">
	<table class="table table-bordered">
		<tr>
			<c:if test="${booking.status eq 'Oczekiwanie na realizację' or booking.status eq 'Termin odrzucony'}">
				<td><h3 align="center"><a class="btn btn-outline-light btn-lg"  id="terminButton"> Zaproponuj termin</a></h3></td>
			</c:if>
			<td><h3 align="center"><a class="btn btn-outline-light btn-lg" id="historiaButton">Historia napraw</a></h3></td>
			<td><h3 align="center"><a class="btn btn-outline-light btn-lg" class="btn btn-outline-light btn-lg" href="${deleteLink}" onclick="if (!(confirm('Czy napewno chcesz usunać wizytę?'))) return false">Usuń wizyte</a></h3></td>
			<td><h3 align="center"><a class="btn btn-outline-light btn-lg" id="zmienStatusButton">Zmień status</a></h3></td>
			<c:if test="${booking.status eq 'Termin zaakceptowany'}"> 
				<td><h3 align="center"><a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/booking/status?id=${booking.id}&value=W trakcie realizacji" id="przekazNaWarsztatButton">Przekaż na warsztat</a></h3></td>
			</c:if>
			<c:if test="${booking.status eq 'Zrealizowane'}"> 
				<td><h3 align="center"><a class="btn btn-outline-light btn-lg" id="zakonczButton">Zakończ</a></h3></td>
			</c:if>
		</tr>
	</table>
</div>

<form:form id="formStatus" method="post" modelAttribute="booking" action="booking/update">
	<div class="row">
		<div class="col-lg-4 col-sm-12"></div>
		<div class="col-lg-4 col-sm-12">
			<form:hidden path="id"/>
			<div class="table-responsive">
			<table class="table table-bordered">
				<tr>
					<td><h1>Ustaw status:</h1></td>
				</tr>
				<tr>
					<td>
						<form:select class="custom-select mr-sm-2" path="status">
						<form:option value="Oczekiwanie na realizację" label="Oczekiwanie na realizację" />
						<form:option value="Negocjacje" label="Negocjacje" />
						<form:option value="Termin odrzucony" label="Termin odrzucony" />
						<form:option value="Termin zaakceptowany" label="Termin zaakceptowany" />
						<form:option value="Rezygnacja" label="Rezygnacja" /> 
						<form:option value="W trakcie realizacji" label="W trakcie realizacji" />
						<form:option value="Przywrócone do realizacji" label="Przywrócone do realizacji" />
						<form:option value="Oczekiwanie na części" label="Oczekiwanie na części" />
						<form:option value="Zrealizowane" label="Zrealizowane" />
						<form:option value="Zakończone" label="Zakończone" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td><input class="btn btn-outline-light btn-lg" type="submit" value="Zatwierdź"/></td>
				</tr>
			</table>
		</div>
		<div class="col-lg-4 col-sm-12"></div>
		</div>
	</div>
</form:form>

<form:form id="formBooking" method="post" modelAttribute="booking" action="booking/update">
	<div class="row">
		<div class="col-lg-4 col-sm-12"></div>
		<div class="col-lg-4 col-sm-12">
			<form:hidden path="id"/>
			<div class="table-responsive">
			<table class="table table-bordered">
				<tr>
					<td><h1>Proponowany termin:</h1></td>
				</tr>
				<tr>
					<td><form:input class="form-control" type="date" path="dateOfAdmission"/></td>
				</tr>
				<tr>
					<td><input class="btn btn-outline-light btn-lg" type="submit" value="Zatwierdź"/></td>
				</tr>
			</table>
		</div>
		<div class="col-lg-4 col-sm-12"></div>
		</div>
	</div>
</form:form>

<form:form id="formFinalizeBooking" method="post" modelAttribute="booking" action="booking/update">
		<form:hidden path="id"/>
		<div class="row">
		<div class="col-lg-4 col-sm-12"></div>
		<div class="col-lg-4 col-sm-12">
			<div class="table-responsive">
			<table class="table table-bordered">
				<tr>
					<td><h1>Wpisz kwotę naprawy:</h1></td>
				</tr>
				<tr>
					<td>
						<form:input class="form-control" type="number" step="0.01" path="price"/>
					</td>
				</tr>
				<tr>
					<td><input class="btn btn-outline-light btn-lg" type="submit" value="Zakończ"/></td>
				</tr>
			</table>
		</div>
		<div class="col-lg-4 col-sm-12"></div>
		</div>
	</div>
</form:form>

<div class="table-responsive">
	<table class="table table-sm table-dark" id="historyTable">
		<thead>	
			<tr>
				<th>Rodzaj usługi</th>
				<th>Opis</th>
				<th>Status</th>
				<th>Data przyjęcia</th>
				<th>Data zakończenia</th>
				<th>Czas realizacji</th>
				<th>Cena</th>
				<th>Usługę wykonał</th>
			</tr>
		</thead>
		<c:forEach var="tmpBooking" items="${bookingList}">
			<c:forEach items="${tmpBooking.user}" var="items">
				<c:if test="${empty items.position}"><c:set  var="klient" value="${items.name} ${items.surname}"></c:set></c:if>
			</c:forEach>
			<c:forEach items="${tmpBooking.user}" var="items" varStatus="status">
				<c:if test="${not empty items.position}"><c:set var="pracownik" value="${items.name} ${items.surname}" /></c:if>
			</c:forEach>
			<tr>
				<td>${tmpBooking.typeOfService}</td>
				<td>${tmpBooking.description}</td>
				<td>${tmpBooking.status}</td>
				<td><fmt:formatDate value="${tmpBooking.dateOfAdmission}" pattern="dd-MM-yyyy" /></td>
				<td><fmt:formatDate value="${tmpBooking.endDate}" pattern="dd-MM-yyyy" /></td>
				<td>${tmpBooking.leadTime}</td>
				<td>${tmpBooking.price}</td>
				<td>${pracownik}<c:set var = "pracownik" value = ''></c:set></td>
			</tr>
		</c:forEach>
	</table>
</div>
</sec:authorize>
<%--                              METODY DLA PRACOWNIKA                                   --%>                    
<sec:authorize access="hasRole('ROLE_PRACOWNIK')">
	<div class="table-responsive">
		<table class="table table-bordered">
			<tr>
				<c:if test="${booking.user.size()<2 and booking.status eq 'W trakcie realizacji'}">
					<td><h3 align="center"><a class="btn btn-outline-light btn-lg" id="wizytaButton">Przyjmij wizytę</a></h3></td>
				</c:if>
				<c:if test="${fn:length(booking.user) gt 1 and booking.status eq 'W trakcie realizacji' or booking.status eq 'Przywrócone do realizacji'}">
					<td><h3 align="center"><a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/booking/status?id=${booking.id}&value=Zrealizowane">Wizyta zrealizowana</a></h3></td>
				</c:if>
				<c:if test="${fn:length(booking.user) gt 1 and booking.status eq 'W trakcie realizacji'}">
					<td><h3 align="center"><a class="btn btn-outline-light btn-lg" href="${pageContext.request.contextPath}/booking/status?id=${booking.id}&value=Oczekiwanie na części">Oczekuję na części</a></h3></td>
				</c:if>
			</tr>
		</table>
	</div>
<form:form id="formBooking" method="post" modelAttribute="booking" action="booking/accept">
	<form:hidden path="id"/>
		<div class="row">
		<div class="col-lg-4 col-sm-12"></div>
		<div class="col-lg-4 col-sm-12">
			<div class="table-responsive">
			<table class="table table-bordered">
				<tr>
					<td><h1>Wpisz czas realizacji:</h1></td>
				</tr>
				<tr>
					<td>
						<form:input class="form-control" path="leadTime" type="number"/>
						<form:errors path="leadTime" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td><input class="btn btn-outline-light btn-lg" type="submit" value="Zatwierdź"/></td>
				</tr>
			</table>
		</div>
		<div class="col-lg-4 col-sm-12"></div>
		</div>
	</div>
	</form:form>
</sec:authorize>
</div>
</div>
</div>
</body>
</html>