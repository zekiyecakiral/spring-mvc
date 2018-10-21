<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="tr">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>Arac Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${arac.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Santral</label>
		<div class="col-sm-10">${arac.santral}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Araç Plakası</label>
		<div class="col-sm-10">${arac.aracPlakasi}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Kullanıcı Ad Soyadı</label>
		<div class="col-sm-10">${arac.adSoyad}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Tarih</label>
		<div class="col-sm-10">${arac.tarih}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Hareket Saati</label>
		<div class="col-sm-10">${arac.hareketSaati}</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Baslangiç Km</label>
		<div class="col-sm-10">${arac.baslangicKm}</div>
	</div>
	<div class="row">
		<label class="col-sm-2">Son Km</label>
		<div class="col-sm-10">${arac.sonKm}</div>
	</div>
	<div class="row">
		<label class="col-sm-2">Araç Durumu</label>
		<div class="col-sm-10">${arac.aracDurumu}</div>
	</div>

	
</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>