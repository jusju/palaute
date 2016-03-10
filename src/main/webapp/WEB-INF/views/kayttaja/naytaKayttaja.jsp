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
	
	<table border="1">
	<tr>
	<td>Tunti ID</td>
	<td>Päivämäärä</td>
	<td>Projektin ID</td>
	<td></td>
	<td></td>
	</tr>

<c:forEach items="${tunnit}" var="tunti">
	<td><c:out value="${tunti.tuntiID}"></c:out></td>
	<td><c:out value="${tunti.date}"></c:out></a></td>
	<td><c:out value="${tunti.projID}"></c:out></a></td>
	<td><a href="<c:out value="/tunnit_lila/henkilo/ttunti/${tunti.tuntiID}"/>">Tunnin tiedot</a></td>
	<td><a href="<c:out value="/tunnit_lila/henkilo/ptunti/${tunti.projID}"/>">Projektin tiedot</a></td>
	</tr>
	</c:forEach>
	</table>
	
	
	
	
	
	

	
	
	<a href="#" onclick="history.go(-1)">Takaisin</a>
</body>
</html>