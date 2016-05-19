<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kyselylomake</title>
</head>
<body>
	<table>
		<tr>
			<c:forEach items="${kysymykset}" var="k">
				<td><c:out value="${k.kysymysteksti}"></c:out></td>
		</tr>
		</c:forEach>
	</table>
	<%-- <form:form modelAttribute="uusiVastaus" method="post">
		<fieldset>
	
			<p>
				<form:input path="vastausID" type="hidden" />
			</p>
			<p>
				<form:input path="kysymysID" type="hidden" />
			</p>
			
			


			<p>
				<form:label path="vastausteksti">Vastaus</form:label>
				<br />
				<form:input path="vastausteksti" />
		
			</p>
			
			
			<p>
				<button type="submit">Lisää</button>
			</p>
		</fieldset>
	</form:form>
--%>





</body>
</html>