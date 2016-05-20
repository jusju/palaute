<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Palaute v0.1</title>
</head>
<body>
<h1>Kaikki toteutukset</h1>
<br>
	<table border 1>
		<tr>
			<th>Toteutus tunnus</th>
			<th>Toteutus nimi</th>
			<th>Toteutus opettaja</th>
		</tr>
	<c:forEach items="${toteutukset}" var="toteutus">
		<tr>
			<td><a href="/palaute/main/toteutuksenpalautteet/${toteutus.toteutusID}">${toteutus.toteutusTunnus}</a></td>
			<td>${toteutus.toteutusNimi}</td>
			<td>${toteutus.opettajaNimi}</td>
		<tr>
	</c:forEach>
	</table>
</body>
</html>