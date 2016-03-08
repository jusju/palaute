<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Henkilön tietojen näyttäminen</title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
</head>	
<body>
	<h1>
		Henkilön tiedot
	</h1>
	<p><c:out value="${henkilo.etunimi}" default="-----"/></p>
	<p><c:out value="${henkilo.sukunimi}" default="-----"/></p>

<table>
	<tr><td>
	<c:forEach items="${tunnit}" var="tunti">
	<table>
	<tr><td>
	<c:out value="${tunti.tuntiID}" default="-----"/></td>
<td><c:out value="${tunti.kuvaus}" default="-----"/>
</td></tr>
</table>
	</c:forEach>
	<p><a href="lista">Takaisin</a>
</body>
</html>