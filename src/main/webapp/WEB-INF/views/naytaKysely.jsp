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
<title>Palautelomake</title>
</head>
<body>
<img src="<c:url value="/resources/kuvat/haaga-helia.png"/>">
<h1>Opintojaksopalaute</h1>
<p style="font-weight:bold">Opintojakso:</p>
<p>${toteutus.toteutusNimi} (${toteutus.toteutusTunnus})</p>
<p style="font-weight:bold">Opettaja(t):</p>
<p>${toteutus.opettajaNimi}</p>
<hr style="width:370px; margin-left:0">

		<form method="post">
					<input type="hidden" name="toteutusID" value="${toteutus.toteutusID}"/>
					<input type="hidden" name="vahvistettu" value="0"/>
			
			<c:forEach items="${kysymykset}" var="k">
				<tr>
					<p><c:out value="${k.kysymysteksti}"></c:out></p>

					<input name="kysymysID" type="hidden" value="${k.kysymysID}"/>

					<textarea name="vastausteksti" rows="5" cols="40" placeholder="Vasta tähän"></textarea>

				</tr>

			</c:forEach>
			
			<br><p>Anna oikea opiskelijatunnus muodossa a1234567<br> palautteen vahvistuslinkin lähettämistä varten.</p>
			<textarea rows="1" cols="40" name="vastaaja" placeholder="Opiskelijatunnus muodossa a1234567"></textarea>
			<br>
			<button type="submit" style="margin-top:10px">Lähetä palautetta</button>
			
			
		</form>
	</table>

</body>
</html>