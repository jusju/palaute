<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<title>Salasanan unohdus</title>
 
</head>	
<body>
	<h1>
		Nollaa salasanasi
	</h1>
		<form:form modelAttribute="nollaus" method="post">
		  	<fieldset>		
				<legend>Sähköpostiosoite</legend>
				
				<p>
					<form:label path="email">Sähköposti</form:label><br/>
					<form:input path="email" />
				</p>
				<p>	
				<p>	
					<button type="submit">Lähetä</button>
				</p>
			</fieldset>
		</form:form>
		
		
</body>
</html>