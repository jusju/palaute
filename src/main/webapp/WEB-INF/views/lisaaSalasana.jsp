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
	
		<form:form modelAttribute="henkilo" method="post">
		<fieldset>
			<legend>Uusi salasana</legend>
			    <form:input type="hidden" path="id"/>
				<form:input type="hidden" path="etunimi" cssErrorClass="VirheellinenKentta"/> <form:errors path="etunimi" cssClass="Virheteksti"/>
				<form:input type="hidden" path="sukunimi" cssErrorClass="VirheellinenKentta"/> <form:errors path="sukunimi" cssClass="Virheteksti"/>
				<form:input path="sposti" cssErrorClass="VirheellinenKentta"/> <form:errors path="sposti" cssClass="Virheteksti"/>
			<p>
				<form:label path="salasana">Salasana</form:label>
				<br />
				<form:input path="salasana" value="" cssErrorClass="VirheellinenKentta"/> <form:errors path="salasana" cssClass="Virheteksti"/>
			</p>
			<p>
				<form:label path="vertailu">Vahvista salasana</form:label>
				<br />
				<form:input path="vertailu" cssErrorClass="VirheellinenKentta"/> <form:errors path="" cssClass="Virheteksti"/>
			</p>
			<p>
				<button type="submit">Lisää</button>
			</p>
		</fieldset>
	</form:form>
	
</body>
</html>