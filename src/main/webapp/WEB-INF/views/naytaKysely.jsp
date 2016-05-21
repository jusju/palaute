<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kyselylomake</title>
</head>
<body>
<h1>Palaute toteutukselle ${toteutus.toteutusTunnus}</h1>
<h2>${toteutus.toteutusNimi}</h2>
<h2>${toteutus.opettajaNimi}</h2>
	<table border 1>
		<tr>
			<th>Kysymys</th>
			<th>Vastaus</th>
		</tr>
		<form method="post">
					<input type="hidden" name="toteutusID" value="${toteutus.toteutusID}"/>
					<input type="hidden" name="vahvistettu" value="0"/>
			
			<c:forEach items="${kysymykset}" var="k">
				<tr>
					<td><c:out value="${k.kysymysteksti}"></c:out></td>

					<input name="kysymysID" type="hidden" value="${k.kysymysID}"/>

					<td><textarea name="vastausteksti" rows="5" cols="20" placeholder="Vasta tähän"></textarea></td>

				</tr>

			</c:forEach>
			
			<tr>
				<td><label>Anna oikea opiskelijatunnus muodossa a1234567<br> palautteen vahvistuslinkin lähettämistä varten.</label></td>
				<td><input type="text" name="vastaaja" style="width:90%" placeholder="Opiskelijatunnus muodossa a1234567"/></td>
			</tr>
			<tr>
				<td><button type="submit">Lähetä palautetta</button></td>
				<td></td>
			<tr>
			
		</form>
	</table>

</body>
</html>