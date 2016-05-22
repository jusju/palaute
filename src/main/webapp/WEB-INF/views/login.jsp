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
</head>
<body>
<img src="<c:url value="/resources/kuvat/haaga-helia.png"/>">
 
    <div id="wrapper">
      <div id="login" class="animate form">
        <section class="login_content">
		
		<c:if test="${not empty loginerror}">
			<p class="Error">Sisäänkirjautuminen epäonnistui. Opiskelijatunnus tai salasana on syötetty väärin.</p>
		</c:if>

		<c:if test="${not empty loggedout}">
			<p class="Info">Uloskirjautuminen onnistui</p>
		</c:if>
		
          <form action="j_spring_security_check" method="post">
            <h1>Kirjautuminen</h1>
            
            <div>
              <input type="text" name='j_username' class="form-control" placeholder="Tunnus"/>
            </div>
            <div>
              <input type="password" name='j_password' class="form-control" placeholder="Salasana"/>
            </div>
            <div>
              
              <button type="submit">Kirjaudu sisään</button>

            </div>

          </form>

        </section>

      </div>
    </div>
</body>
</html>