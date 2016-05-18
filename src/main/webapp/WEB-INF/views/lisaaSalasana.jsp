<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<title>Uusi salasana</title>
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap core CSS -->
  <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
  <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
  <link href="<c:url value="/resources/css/animate.min.css"/>" rel="stylesheet">
  <!-- Custom styling plus plugins -->
  <link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet">
  <link href="<c:url value="/resources/css/icheck/flat/green.css"/>" rel="stylesheet">
  <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
</head>
<body style="background:#F7F7F7;">

 
    <div id="wrapper">
      <div id="login" class="animate form">
	 <section class="login_content">
		<form:form modelAttribute="kayttaja" method="post">
		
			<legend>Uusi salasana</legend>
				<form:input type="hidden" path="id"/>
				<form:input type="hidden" class="form-control" path="tunnus"/>
			<p>
				<form:label path="salasana"></form:label>
				<br />
				<form:input class="form-control" placeholder="Salasana" path="salasana" type="password" cssErrorClass="VirheellinenKentta"/> <form:errors path="salasana" cssClass="Virheteksti"/>
			</p>
			<p>
				<form:label path="vertailu"></form:label>
				<br />
				<form:input class="form-control" placeholder="Salasana uudelleen" path="vertailu" type="password" cssErrorClass="VirheellinenKentta"/> <form:errors path="" cssClass="Virheteksti"/>
			</p>
			<p>
				<button class="btn btn-default submit" type="submit">Lisää</button>
			</p>
	
	</form:form>
	</section>
	</div>
	</div>
</body>
</html>