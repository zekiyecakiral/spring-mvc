<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="tr">

<jsp:include page="../fragments/header.jsp" />

<body>

	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>All Arac</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Santral</th>
					<th>AracPlakasi</th>
					<th>AdSoyad</th>
					
				<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="arac" items="${aracs}">
				<tr>
					<td>
						${arac.id}
					</td>
					<td>${arac.santral}</td>
					<td>${arac.aracPlakasi}</td>
					<td>${arac.adSoyad}</td>
				<td>
						<spring:url value="/arac/${arac.id}" var="aracUrl" />
						<spring:url value="/arac/${arac.id}/delete" var="deleteUrl" /> 
						<spring:url value="/arac/${arac.id}/update" var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${aracUrl}'">Query</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../fragments/footer.jsp" />

</body>
</html>