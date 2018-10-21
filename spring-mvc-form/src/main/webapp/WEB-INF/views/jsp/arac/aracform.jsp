<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>


<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${aracForm['new']}">
			<h1>Add Araç</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Araç</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/arac" var="aracActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="aracForm" action="${aracActionUrl}">

		<form:hidden path="id" />

		<spring:bind path="santral">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Santral</label>
				<div class="col-sm-10">
					<form:input path="santral" type="text" class="form-control " id="santral" placeholder="santral" />
					<form:errors path="santral" class="control-label" />
				</div>
			</div>
		</spring:bind>
			<spring:bind path="aracPlakasi">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Araç Plakası</label>
				<div class="col-sm-10">
					<form:input path="aracPlakasi" type="text" class="form-control " id="aracPlakasi" placeholder="aracPlakasi" />
					<form:errors path="aracPlakasi" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="adSoyad">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Kullanıcı Adı Soyadı</label>
				<div class="col-sm-10">
					<form:input path="adSoyad" type="text" class="form-control " id="adSoyad" placeholder="adSoyad" />
					<form:errors path="adSoyad" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="tarih">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Tarih</label>
				<div class="col-sm-10">
					<form:input path="tarih" type="date" class="form-control " id="tarih" placeholder="tarih" />
					<form:errors path="tarih" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="hareketSaati">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Hareket Saati</label>
				<div class="col-sm-10">
					<form:input path="hareketSaati" type="time" class="form-control " id="hareketSaati" placeholder="hareketSaati" />
					<form:errors path="hareketSaati" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="baslangicKm">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Başlangıç Km</label>
				<div class="col-sm-10">
					<form:input path="baslangicKm" type="number" class="form-control " id="baslangicKm" placeholder="baslangicKm" />
					<form:errors path="baslangicKm" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="sonKm">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Son Km</label>
				<div class="col-sm-10">
					<form:input path="sonKm" type="number" class="form-control " id="sonKm" placeholder="sonKm" />
					<form:errors path="sonKm" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
			<spring:bind path="aracDurumu">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Araç Durumu</label>
				<div class="col-sm-10">
					<form:textarea path="aracDurumu" rows="5" class="form-control" id="aracDurumu" placeholder="aracDurumu" />
					<form:errors path="aracDurumu" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${aracForm['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>