<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Kaikki Projektit</h2>
	<table>
		<tr>
			<td><c:forEach items="${projektit}" var="projekti">
					<table border="0">
						<tr>
							<td><a href="<c:out value="${projekti.projID}"/>"></a></td>
							<td><c:out value="${projekti.projID}" default="-----" /></td>
							<td><c:out value="${projekti.projnimi}" default="-----" /></td>
							<td><a href="delete/${projekti.projID}">poista</a></td>
						</tr>

					</table>
				</c:forEach>
		<tr>
			<td><a href="<c:out value="uusi"/>">Lisää</td>
		</tr>
</body>
</html>