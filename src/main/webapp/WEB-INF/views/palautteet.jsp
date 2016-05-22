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
<img src="<c:url value="/resources/kuvat/haaga-helia.png"/>">
<p style="font-size: 20px">Toteutuksen <span style="text-decoration:underline"> ${toteutus.toteutusTunnus}</span> palautteet</p>
<br>
	<table border 1>
		<tr>
			<th>Vastaaja</th>
		<c:forEach items="${kysymykset}" var="kysymys">
			<th>${kysymys.kysymysteksti}</th>
		</c:forEach>
			<th>Pvm</th>
		</tr>
	<c:forEach items="${palautteet}" var="palaute">
		<c:if test="${palaute.toteutusID == toteutus.toteutusID}">
			<tr>
			<td>Anonymous</td>
			<c:forEach items="${vastaukset}" var="vastaukset">
			<c:forEach items="${pvastaukset}" var="pvast">
				<c:if test="${vastaukset.vastausID == pvast.vastausID}">
				<td>${vastaukset.vastausteksti}</td>
				</c:if>
			</c:forEach>
			</c:forEach>
			<td>${palaute.timestamp}</td>
			<tr>
		</c:if>

	</c:forEach>
	</table>
</body>
</html>