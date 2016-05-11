<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
		uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Henkilön tietojen näyttäminen</title>

<jsp:include page="../../kayttaja/navigointi.jsp"></jsp:include>

<script src="<c:url value="/resources/js/custom.js"/>"></script>

	<!-- flot js -->
	<!--[if lte IE 8]><script type="text/javascript" src="js/excanvas.min.js"/>"></script><![endif]-->
	<script type="text/javascript" src="<c:url value="/resources/js/flot/jquery.flot.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/flot/jquery.flot.pie.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/flot/jquery.flot.orderBars.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/flot/jquery.flot.time.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/flot/date.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/flot/jquery.flot.spline.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/flot/jquery.flot.stack.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/flot/curvedLines.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/flot/jquery.flot.resize.js"/>"></script>

</head>

<body>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<!-- page content -->
	<div class="right_col" role="main">
		<div class="">
			<div class="page-title">
				<div class="title_left">
					<h3>Projektit</h3>
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>Kaikki projektit</h2>
							<ul class="nav navbar-right panel_toolbox">
								<li><a class="collapse-link"><i
										class="fa fa-chevron-up"></i></a></li>
							</ul>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<div class="table-responsive">
								<table id="example"
									class="table table-striped responsive-utilities jambo_table">
									<thead>
										<tr class="headings ">
											<th>Projektin nimi</th>
											<th>Poista</th>
										</tr>
									</thead>

									<tbody>

										<tr class="even pointer">
											<c:forEach items="${projektit}" var="projekti">
												<td class=" "><a
															href="<c:out value="/tunnit_lila/secure/admin/super/ptunti/${projekti.projID}"/>"><c:out value="${projekti.projnimi}"></c:out></a>
												</td>
												
												<td class=" "><a
													href="/tunnit_lila/secure/admin/super/delete/projekti/${projekti.projID}"><button
															type="button" class="btn btn-danger btn-xs">Poista</button></a></td>
										</tr>
										</c:forEach>


										

									</tbody>

								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel">
							<a
													href="/tunnit_lila/secure/admin/super/uusi/projekti"><button
															type="button" class="btn btn-success">Lisää projekti</button></a>
					</div>
				</div>
			</div>
		</div>
		<!-- footer content -->

		<footer>
			<div class="copyright-info">
				<p class="pull-right">
					Tuntikirjaus <i class="fa fa-copyright"></i> Team Lila
				</p>
			</div>
			<div class="clearfix"></div>
			</sec:authorize>
		</footer>
		<!-- /footer content -->
	</div>
	<!-- /page content -->

	</div>

	</div>












</body>

</html>