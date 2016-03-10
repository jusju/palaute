<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Tuntien lisääminen</title>

</head>	
<body>
	<h1>
		Lisää tunnit
	</h1>
		<form:form modelAttribute="tunti" method="post">
		  	<fieldset>		
				<legend>Tunnin tiedot</legend>
				<p>
					<form:label	path="kaytID">Käyttäjä ID</form:label><br/>
					<form:input path="kaytID" />		
				</p>
				<p>	
					<form:label path="projID">Projekti ID</form:label><br/>
					<form:input path="projID" />
				</p>
				<p>	
					<form:label path="date">Päivämäärä</form:label><br/>
					<form:input path="date" />
				</p>
				<p>	
					<form:label path="aloitusaika">Aloitusaika</form:label><br/>
					<form:input path="aloitusaika" />
				</p>
				<p>	
					<form:label path="lopetusaika">Lopetusaika</form:label><br/>
					<form:input path="lopetusaika" />
				</p>
				<p>
					<form:label path="kuvaus">Kuvaus</form:label><br/>
					<form:input path="kuvaus" />
				</p>
				<p>	
				<p>	
					<button type="submit">Lisää</button>
				</p>
			</fieldset>
		</form:form>
</body>
</html>