<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Sisäänkirjautuminen</title>
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
		<c:if test="${not empty loginerror}">
		<p class="Error">Sisäänkirjautuminen epäonnistui. Käyttäjätunnus tai salasana on syötetty väärin.</p>
	</c:if>

	<c:if test="${not empty loggedout}">
		<p class="Info">Uloskirjautuminen onnistui</p>
	</c:if>
          <form action="j_spring_security_check" method="post">
            <h1>Kirjautuminen</h1>
            
            <div>
              <input type="text" name='j_username' class="form-control" placeholder="Kirjaudu Sähköpostiosoitteella"/>
            </div>
            <div>
              <input type="password" name='j_password' class="form-control" placeholder="Salasana"/>
            </div>
            <div>
              
              <button class="btn btn-default submit" type="submit">Kirjaudu sisään</button>
              <a class="reset_pass" href="nollaus/resetPassword">Unohditko salasanasi?</a>
            </div>
            <div class="clearfix"></div>
            <div class="separator">

              <p class="change_link">Uusi sivustolla?
                <a href="henkilo/uusi" class="to_register"> Rekisteröidy </a>
              </p>
             
            </div>
          </form>
          <!-- form -->
        </section>
        <!-- content -->
 

        <!-- content -->
      </div>
    </div>
  </div>

</body>
</html>