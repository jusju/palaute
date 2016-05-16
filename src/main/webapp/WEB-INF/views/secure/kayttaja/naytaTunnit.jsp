<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Henkilön tietojen näyttäminen</title>

<jsp:include page="navigointi.jsp"></jsp:include>

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
	

	<!-- page content -->
	<div class="right_col" role="main">
		<div class="">
			<div class="page-title">
				<div class="title_left">
					<h3>Tunnit</h3>
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>Kaikki tunnit</h2>
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
											<th>Päivämäärä</th>
											<th>Projekti</th>
											<th>Selite</th>
											<th>Aloitus-aika</th>
											<th>Lopetus-aika</th>
											<th>Yhteensä</th>
											<th>Poista</th>
										</tr>
									</thead>

									<tbody>
				 
						<sec:authorize access="hasRole('ROLE_USER')">
						
						<tr class="even pointer">
											<c:set var="kaikkiTun" value="${0}" />
											<c:set var="kaikkiMin" value="${0}" />
											<c:forEach items="${tunnit}" var="tunti">
												<td class=" "><c:out value="${tunti.date}"></c:out></td>

												<c:forEach items="${projektit}" var="projektit">
													<c:if test="${tunti.projID == projektit.projID}">
														<td><c:out value="${projektit.projnimi}"></c:out></td>
													</c:if>
												</c:forEach>
												<td class=" "><c:out value="${tunti.kuvaus}"></c:out></td>
												<td><c:out value="${tunti.aloitusaika}" /></td>
												<td><c:out value="${tunti.lopetusaika}" /></td>


											<c:set var="at" value="${tunti.aloitusaika}" />
													<c:set var="atunnit" value="${fn:substring(at, 0, 2)}" />

													<c:set var="am" value="${tunti.aloitusaika}" />
													<c:set var="aminuutit" value="${fn:substring(am, 3, 5)}" />

													<c:set var="lot" value="${tunti.lopetusaika}" />
													<c:set var="ltunnit" value="${fn:substring(lot, 0, 2)}" />

													<c:set var="lm" value="${tunti.lopetusaika}" />
													<c:set var="lminuutit" value="${fn:substring(lm, 3, 5)}" />



													<c:if test="${lminuutit < aminuutit && ltunnit > atunnit}">
														<c:set var="yhtm" value="${lminuutit+60 - aminuutit}"></c:set>
														<c:set var="yhtt" value="${ltunnit - atunnit-1}"></c:set>
													</c:if>

													<c:if test="${lminuutit > aminuutit && ltunnit > atunnit}">
														<c:set var="yhtm" value="${lminuutit - aminuutit}"></c:set>
														<c:set var="yhtt" value="${ltunnit - atunnit}"></c:set>
													</c:if>
													
													<c:if test="${lminuutit < aminuutit && ltunnit < atunnit}">
														<c:set var="yhtm" value="${lminuutit+60 - aminuutit}"></c:set>
														<c:set var="yhtt" value="${ltunnit+23 - atunnit-1}"></c:set>
													</c:if>

													<c:if test="${lminuutit > aminuutit && ltunnit < atunnit}">
														<c:set var="yhtm" value="${lminuutit - aminuutit}"></c:set>
														<c:set var="yhtt" value="${ltunnit+23 - atunnit}"></c:set>
													</c:if>



													<c:if test="${ltunnit == atunnit && aminuutit > lminuutit}">
														<c:set var="yhtt" value="${23}"></c:set>
														<c:set var="yhtm" value="${lminuutit+60 - aminuutit}"></c:set>
													</c:if>


													<c:if test="${ltunnit == atunnit && aminuutit < lminuutit}">
														<c:set var="yhtt" value="${0}"></c:set>
														<c:set var="yhtm" value="${lminuutit - aminuutit}"></c:set>
													</c:if>

													<td><c:out value="${yhtt} tuntia ${yhtm} minuuttia" /></td>

													<c:set var="kaikkiTun" value="${kaikkiTun+yhtt}" />
													<c:set var="kaikkiMin" value="${kaikkiMin+yhtm}" />

												

												<td class=" "><a
													href="/tunnit_lila/secure/oma/tunnit/delete/${tunti.tuntiID}"><button
															type="button" class="btn btn-danger btn-xs">Poista</button></a></td>
										</tr>


										</c:forEach>

										<c:forEach items="${tunnit}" var="tunti">
											<c:if test="${kaikkiMin > 59}">
												<c:set var="kaikkiTun" value="${kaikkiTun+1}"></c:set>
												<c:set var="kaikkiMin" value="${kaikkiMin-60}"></c:set>
											</c:if>
										</c:forEach>
										
						</sec:authorize>
										

										

									</tbody>

								</table>
								<h2>
												Yhteensä:
												<c:out value="${kaikkiTun}" />
												tuntia
												<c:out value="${kaikkiMin}" />
												minuuttia
											</h2>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel">
						<a href="/tunnit_lila/secure/oma/uusi"><button
								type="button" class="btn btn-success ">Lisää tunti</button></a>
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
		</footer>
		<!-- /footer content -->
	</div>
	<!-- /page content -->


</body>

</html>