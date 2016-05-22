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
<h1>Toteutuksen palautteet</h1>
<br>
	<table border 1>
		<tr>
			<th>Vastaaja</th>
			<th>Kysymys 1</th>
			<th>Kysymys 2</th>
			<th>Kysymys 3</th>
			<th>Kysymys 4</th>
			<th>Kysymys 5</th>
			<th>Pvm</th>
		</tr>
	<c:forEach items="${palautteet}" var="palaute">
		<c:if test="${palaute.toteutusID == toteutus.toteutusID}">
			<tr>
				<td>Anonymous</td>
				<td>${palaute.timestamp}</td>
			<tr>
		</c:if>

	</c:forEach>
	</table>
</body>
</html>