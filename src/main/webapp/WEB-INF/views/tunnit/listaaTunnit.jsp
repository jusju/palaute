<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr><td>
	<c:forEach items="${tunnit}" var="tunti">
	<table>
	<tr><td>
		<a href="<c:out value="${tunti.tuntiID}"/>"></a>
	
	<c:out value="${tunti.tuntiID}" default="-----"/></td>
<td><c:out value="${tunti.kuvaus}" default="-----"/></td>
<td><a href="delete/${tunti.tuntiID}">poista</a>
</td></tr>

</table>
	</c:forEach>
	<tr><td><a href="<c:out value="uusi"/>">Lisää</td></tr>



</body>
</html>