<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<meta charset="utf-8">
<title>Arac Takip Formu</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />

</head>

<spring:url value="/" var="urlHome" />
<%--<spring:url value="/users/add" var="urlAddUser" /> --%>
<spring:url value="/arac/addarac" var="urlAddArac" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Araç Takip Formu</a>
		</div>
		<%--<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddUser}">Add User</a></li>
			</ul>
		</div>
		--%>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddArac}">Add Araç</a></li>
			</ul>
		</div>
	</div>
</nav>