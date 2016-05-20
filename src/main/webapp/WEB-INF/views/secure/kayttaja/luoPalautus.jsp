<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Palautuksen luonti</title>
</head>
<body>
<a href="/palaute/logout"><button>Kirjaudu ulos</button></a>
	<h3>Luo palautus toteutukselle </h3><h1>${toteutus.toteutusTunnus}</h1>
	<h2>${toteutus.toteutusNimi}</h2>
	<br>
	<h3>Opettaja/t </h3><p>${toteutus.opettajaNimi}</p>
	<br>
	<h2>Kysymykset</h2>
	<table border 1>
		<tr>
			<th>Kysymys id</th>
			<th>Kysymys teksti</th>
		</tr>
		<c:forEach items="${kysymykset}" var="kysymys">
			<tr>
				<td>${kysymys.kysymysID}</td>
				<td>${kysymys.kysymysteksti}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a type="button" href="/palaute/secure/oma/laheta/${toteutus.toteutusID}""><button>Lähetä linkki</button></a>
</body>
</html>