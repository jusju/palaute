<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Henkilön lisääminen</title>

</head>
<body>
	<h1>Luo Henkilö</h1>
	<form:form modelAttribute="henkilo" method="post">
		<fieldset>
			<legend>Henkilön tiedot</legend>
			<p>
				<form:label path="etunimi">Etunimi</form:label>
				<br />
				<form:input path="etunimi" />
			</p>
			<p>
				<form:label path="sukunimi">Sukunimi</form:label>
				<br />
				<form:input path="sukunimi" />
			</p>
			<p>
				<form:label path="sposti">Sähköposti</form:label>
				<br />
				<form:input path="sposti" />
			</p>
			<p>
				<form:label path="salasana">Salasana</form:label>
				<br />
				<form:input path="salasana" />
			</p>
			<p>
				<button type="submit">tallenna</button>
			</p>
		</fieldset>
	</form:form>
</body>
</html>