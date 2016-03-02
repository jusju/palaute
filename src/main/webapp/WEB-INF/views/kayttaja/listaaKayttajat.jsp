<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Henkilön tietojen näyttäminen</title>

</head>	
<body>
<h2>Kaikki käyttäjät</h2>

	<c:forEach items="${henkilot}" var="henkilo">
	<c:out value="${henkilo.etunimi}"></c:out>
	<c:out value="${henkilo.sukunimi}"></c:out>
	</c:forEach>
	



</body>
</html>