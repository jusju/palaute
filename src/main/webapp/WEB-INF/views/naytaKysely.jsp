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
<script   src="https://code.jquery.com/jquery-1.12.4.js"   integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="   crossorigin="anonymous"></script>
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

		<form:form method="post" modelAttribute="VastausWrapper">
					<input type="hidden" name="toteutusID" value="${toteutus.toteutusID}"/>
					<input type="hidden" name="vahvistettu" value="0"/>
			
			<c:forEach items="${kysymykset}" var="k" varStatus="count">
			
				<tr>
					<p><c:out value="${k.kysymysteksti}"></c:out></p>
					<c:choose>
						<c:when test="${k.kysymysID !='2' && k.kysymysID !='6'}">
					<form:checkboxes path="vastList" items="${vaihtoehdot}" class="${count.index}" element="div"/>
					<script>
						$('.${count.index}').on('change', function(){
							$('.${count.index}').not(this).prop('checked', false);
						});
					</script>
						</c:when>
						<c:otherwise>
					<form:textarea path="vastList" rows="5" cols="40" placeholder="Vasta tähän"></form:textarea>
						</c:otherwise>
					</c:choose>
				</tr>
			
			</c:forEach>
			
			<br><p>Anna oikea opiskelijatunnus muodossa a1234567<br> palautteen vahvistuslinkin lähettämistä varten.</p>
			<textarea rows="1" cols="40" name="vastaaja" placeholder="Opiskelijatunnus muodossa a1234567"></textarea>
			<br>
			<button type="submit" style="margin-top:10px">Lähetä palautetta</button>
			
			
		</form:form>

</body>
</html>