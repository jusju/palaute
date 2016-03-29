<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Henkilön tietojen näyttäminen</title>

</head>
<body>
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
						
								<td><a href="muokkaa/${henkilo.id}">muokkaa</a></td>
								<td><a href="delete/${henkilo.id}">poista</a></td>
						</tr>

				</c:forEach>
		

		</table>
	<a href="<c:out value="uusi"/>">Lisää</a>
		
</body>
</html>