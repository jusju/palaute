<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Tunnin tiedot</title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
</head>	
<body>
	<h1>
		Projektin tiedot
	</h1>
	<table border="1">
	<tr>
	<td>Projekti ID</td>
	<td>Projekti nimi</td>

	</tr>
	<tr>
	<td><c:out value="${projekti.projID}" default="-----"/></td>
	<td><c:out value="${projekti.projnimi}" default="-----"/></td>
	
	</tr></table>

	<a href="#" onclick="history.go(-1)">Takaisin</a>
</body>
</html>