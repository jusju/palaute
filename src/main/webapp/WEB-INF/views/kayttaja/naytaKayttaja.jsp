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
	<tr><td>
	<c:forEach items="${tunnit}" var="tunti">
	<table>
	<tr><td>
	<a href="<c:out value="/tunnit_lila/tunnit/ttunti/${tunti.tuntiID}"/>"><c:out value="${tunti.kuvaus}"></c:out> <c:out value="${tunti.date}"></c:out></a>


</td></tr>
</table>
	</c:forEach>
	<a href="#" onclick="history.go(-1)">Takaisin</a>
</body>
</html>