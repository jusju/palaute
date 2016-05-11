<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Henkilön tietojen näyttäminen</title>

</head>

<body>

	<jsp:include page="navigointi.jsp"></jsp:include>


	<div class="right_col" style="min-height: 614px;" role="main">

		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="dashboard_graph">

					<div class="row x_title">
						<div class="col-md-6">
							<h3>Tervetuloa käyttäjä paneeliin!</h3>



						</div>
					</div>
					<div class="ln_solid"></div>
					
					<div class="clearfix"></div>
				</div>
			</div>

		</div>
		<br />
		<sec:authorize access="hasRole('ROLE_USER')">
		<div class="row">
			<c:forEach items="${projektit}" var="projekti">
			
				<c:set var="kaikkiTun" value="${0}" />
				<c:set var="kaikkiMin" value="${0}" />

				
					<div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							<div class="icon">
								<i class="fa fa-clock-o"></i>
							</div>

							<div class="count"></div>
							<c:forEach items="${tunnit}" var="tunti">
								<c:if test="${projekti.projID == tunti.projID}">



									<c:set var="at" value="${tunti.aloitusaika}" />
									<c:set var="atunnit" value="${fn:substring(at, 0, 2)}" />

									<c:set var="am" value="${tunti.aloitusaika}" />
									<c:set var="aminuutit" value="${fn:substring(am, 3, 5)}" />

									<c:set var="lot" value="${tunti.lopetusaika}" />
									<c:set var="ltunnit" value="${fn:substring(lot, 0, 2)}" />

									<c:set var="lm" value="${tunti.lopetusaika}" />
									<c:set var="lminuutit" value="${fn:substring(lm, 3, 5)}" />






									<c:if test="${ltunnit < atunnit}">
										<c:set var="yhtt" value="${ltunnit+24 - atunnit}"></c:set>
									</c:if>

									<c:if test="${ltunnit > atunnit}">
										<c:set var="yhtt" value="${ltunnit - atunnit}"></c:set>
									</c:if>

									<c:if test="${lminuutit < aminuutit}">
										<c:set var="yhtm" value="${lminuutit+60 - aminuutit}"></c:set>
									</c:if>

									<c:if test="${lminuutit > aminuutit || lminuutit == aminuutit}">
										<c:set var="yhtm" value="${lminuutit - aminuutit}"></c:set>
									</c:if>



									<c:set var="kaikkiTun" value="${kaikkiTun+yhtt}" />
									<c:set var="kaikkiMin" value="${kaikkiMin+yhtm}" />


								</c:if>

							</c:forEach>

							<c:forEach items="${tunnit}" var="tunti">
								<c:if test="${kaikkiMin > 59}">
									<c:set var="kaikkiTun" value="${kaikkiTun+1}"></c:set>
									<c:set var="kaikkiMin" value="${kaikkiMin-60}"></c:set>
								</c:if>
							</c:forEach>

							<h3>
								Yhteensä:
								<c:out value="${kaikkiTun}" />
								tuntia
								<c:out value="${kaikkiMin}" />
								minuuttia
							</h3>

							<h2><c:out value="${projekti.projnimi}" />
							</h2>

						</div>
					</div>
					
			</c:forEach>
			
		</sec:authorize>

		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<div class="row">
			<c:forEach items="${projektit}" var="projekti">
				<c:set var="kaikkiTun" value="${0}" />
				<c:set var="kaikkiMin" value="${0}" />

				
					<div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="tile-stats">
							<div class="icon">
								<i class="fa fa-clock-o"></i>
							</div>
							<div class="count"></div>
							<c:forEach items="${kaikki}" var="tunti">
								<c:if test="${projekti.projID == tunti.projID}">



									<c:set var="at" value="${tunti.aloitusaika}" />
									<c:set var="atunnit" value="${fn:substring(at, 0, 2)}" />

									<c:set var="am" value="${tunti.aloitusaika}" />
									<c:set var="aminuutit" value="${fn:substring(am, 3, 5)}" />

									<c:set var="lot" value="${tunti.lopetusaika}" />
									<c:set var="ltunnit" value="${fn:substring(lot, 0, 2)}" />

									<c:set var="lm" value="${tunti.lopetusaika}" />
									<c:set var="lminuutit" value="${fn:substring(lm, 3, 5)}" />






									<c:if test="${ltunnit < atunnit}">
										<c:set var="yhtt" value="${ltunnit+24 - atunnit}"></c:set>
									</c:if>

									<c:if test="${ltunnit > atunnit}">
										<c:set var="yhtt" value="${ltunnit - atunnit}"></c:set>
									</c:if>

									<c:if test="${lminuutit < aminuutit}">
										<c:set var="yhtm" value="${lminuutit+60 - aminuutit}"></c:set>
									</c:if>

									<c:if test="${lminuutit > aminuutit || lminuutit == aminuutit}">
										<c:set var="yhtm" value="${lminuutit - aminuutit}"></c:set>
									</c:if>



									<c:set var="kaikkiTun" value="${kaikkiTun+yhtt}" />
									<c:set var="kaikkiMin" value="${kaikkiMin+yhtm}" />


								</c:if>

							</c:forEach>

							<c:forEach items="${kaikki}" var="tunti">
								<c:if test="${kaikkiMin > 59}">
									<c:set var="kaikkiTun" value="${kaikkiTun+1}"></c:set>
									<c:set var="kaikkiMin" value="${kaikkiMin-60}"></c:set>
								</c:if>
							</c:forEach>

							<h3>
								Yhteensä:
								<c:out value="${kaikkiTun}" />
								tuntia
								<c:out value="${kaikkiMin}" />
								minuuttia
							</h3>
							
								<h2><a href="<c:out value="/tunnit_lila/secure/admin/super/ptunti/${projekti.projID}"/>"><c:out value="${projekti.projnimi}" /></a></h2>
						
						</div>
					</div>
			</c:forEach>
		</sec:authorize>
	</div>
	<%--<!-- footer content -->

	<footer>
		<div class="copyright-info">
			<p class="pull-right">
				Tuntikirjaus <i class="fa fa-copyright"></i> Team Lila
			</p>
		</div>
		<div class="clearfix"></div>
	</footer>
		<!-- /footer content -->
		--%>	
		</div>
	<!-- /page content -->
















</body>

</html>