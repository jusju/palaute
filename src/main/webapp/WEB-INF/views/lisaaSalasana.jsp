<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Uusi salasana</title>

</head>
<body>

	<table><tr>

		<td></td> 
		</tr>
			<c:forEach items="${poletti}" var="poletti">
						<tr>
							

							<td><c:out value="${poletti.satunnainen}"></c:out></td> 
						

						</tr>

				</c:forEach>
		

		</table>
	
</body>
</html>