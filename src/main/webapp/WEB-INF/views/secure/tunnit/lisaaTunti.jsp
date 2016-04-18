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
<title>Tuntien lisääminen</title>
 <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
</head>	
<body>
	<h1>
		Lisää tunnit
	</h1>
		<form:form modelAttribute="tunti" method="post">
		  	<fieldset>		
				<legend>Tunnin tiedot</legend>
				<p>
					<form:input path="kaytID" type="hidden" />		
				</p>
				<p>	
					<form:label path="projID">Projekti</form:label><br/>
															<select class="form-control" name="projID">
											<c:forEach items="${projektit}" var="projekti">


												<option value="${projekti.projID}"><c:out value="${projekti.projnimi}" /></option>


											</c:forEach>
										</select>
				</p>
				<p>	
					
					<form:label path="date">Päivämäärä</form:label><br/>
					<form:input type="text" id="datepicker" name="datepicker" path="date" />
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