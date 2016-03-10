<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Tunnin tiedot</title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
</head>	
<body>
	<h1>
		Tunnin tiedot
	</h1>
	<table border="1">
	<tr>
	<td>Tunti-ID</td>
	<td>Päivämäärä</td>
	<td>Aloitusaika</td>
	<td>Lopetusaika</td>
	<td>Kuvaus</td>
	</tr>
	<tr>
	<td><c:out value="${tunnit.tuntiID}" default="-----"/></td>
	<td><c:out value="${tunnit.date}" default="-----"/></td>
	<td><c:out value="${tunnit.aloitusaika}" default="-----"/></td>
	<td><c:out value="${tunnit.lopetusaika}" default="-----"/></td>
	<td><c:out value="${tunnit.kuvaus}" default="-----"/></td>
	</tr></table>

	<a href="#" onclick="history.go(-1)">Takaisin</a>
</body>
</html>