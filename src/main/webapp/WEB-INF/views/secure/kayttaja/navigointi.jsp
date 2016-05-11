<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Sisäänkirjautuminen</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css"/>">
<link href="<c:url value="/resources/fonts/css/font-awesome.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/animate.min.css"/>"
	rel="stylesheet">

<!-- Custom styling plus plugins -->

<link
	href="<c:url value="/resources/css/maps/jquery-jvectormap-2.0.3.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/icheck/flat/green.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/floatexamples.css"/>"
	rel="stylesheet" type="text/css" />

<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/nprogress.js"/>"></script>
<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet">

<script type="text/javascript" src="<c:url value="/resources/moment/min/moment.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"/>"></script>
</head>
<body class="nav-md">

	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">

					<div class="navbar nav_title" style="border: 0;">
						<a href="/tunnit_lila/secure/oma" class="site_title"><i
							class="fa fa-home"></i> <span>Käyttäjä paneeli</span></a>
					</div>
					<div class="clearfix"></div>

					<!-- menu prile quick info -->
					<div class="profile">
						<div class="profile_pic">
							<img src="<c:url value="/resources/images/user.png"/>" alt="..."
								class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Tervetuloa,</span>
							<h2>Käyttäjä</h2>
						</div>
					</div>
					<!-- /menu prile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">

						<div class="menu_section">
							

							
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<h3>Admin</h3>
									<ul class="nav side-menu">
										<li><a href="/tunnit_lila/secure/admin/super/kayttajalista"><i
												class="fa fa-users"></i>Käyttäjät </a></li>
										<li><a href="/tunnit_lila/secure/admin/super/projektilista"><i
												class="fa fa-folder-open-o"></i> Projektit </a></li>
										<li><a href="/tunnit_lila/secure/admin/super/tuntilista"><i
												class="fa fa-clock-o"></i> Tunnit </a></li>
									</ul>

								</sec:authorize>
							
					 
						<sec:authorize access="hasRole('ROLE_USER')">
						
							<h3>Käyttäjä</h3>
						<ul class="nav side-menu">
							
							<li><a href="/tunnit_lila/secure/oma/tunnit"><i
									class="fa fa-clock-o"></i> Tunnit </a></li>
						</ul>
						</sec:authorize>
					</div>
				</div>
				<!-- /sidebar menu -->

				<!-- /menu footer buttons -->
				<div class="sidebar-footer hidden-small">
					<a href="/tunnit_lila/logout" data-toggle="tooltip"
						data-placement="top" title="Kirjaudu ulos"> <span
						class="glyphicon glyphicon-off" aria-hidden="true"></span>
					</a>
				</div>
				<!-- /menu footer buttons -->
			</div>
		</div>

		<!-- top navigation -->
		<div class="top_nav">

			<div class="nav_menu">
				<nav class="" role="navigation">
					<div class="nav toggle">
						<a id="menu_toggle"><i class="fa fa-bars"></i></a>
					</div>

					<ul class="nav navbar-nav navbar-right">
						<li class=""><a href="javascript:;"
							class="user-profile dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false"> <img src="<c:url value="/resources/images/user.png"/>" alt="">Käyttäjä
								<span class=" fa fa-angle-down"></span>
						</a>
						
						
							<ul
								class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
								<li><a href="/tunnit_lila/logout""><i
										class="fa fa-sign-out pull-right"></i> Kirjaudu ulos</a></li>
							</ul></li>
							
							
					</ul>
				</nav>
			</div>

		</div>

</body>
<!-- /top navigation -->
</body>
</html>

















