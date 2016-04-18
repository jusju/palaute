<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN-SIVU</title>
<link rel="stylesheet" type="text/css"
	href="../../resources/styles/common.css">
</head>
<body>
<h1>EXTREME SUOJATTU ADMIN-SIVU</h1>

<p>Admin tools...</p>

	<h2>Kaikki käyttäjät</h2>
	<table border="0">
		<tr>
 		<td>Käyttäjän ID</td> 
		<td>Etunimi</td> 
		<td>Sukunimi</td> 
		<td></td> 
		<td></td> 
		</tr>
			<c:forEach items="${henkilot}" var="henkilo">
						<tr>
							
							<td><a href="ktunti/${henkilo.id}">${henkilo.id}</a></td> 
							<td><c:out value="${henkilo.etunimi}"></c:out></td> 
							<td><c:out value="${henkilo.sukunimi}"></c:out></td> 
							<td><c:out value="${henkilo.sposti}"></c:out></td> 
						
								<td><a href="/tunnit_lila/henkilo/muokkaa/${henkilo.id}">muokkaa</a></td>
								<td><a href="/tunnit_lila/henkilo/delete/${henkilo.id}">poista</a></td>
						</tr>

				</c:forEach>
		

		</table>

<p><a href="../main">Pääsivu</a></p>
<p><a href="../../j_spring_security_logout" > Kirjaudu ulos</a></p>
</body>
</html>