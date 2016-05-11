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



</head>

<body>
	<jsp:include page="../../kayttaja/navigointi.jsp"></jsp:include>

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
											<th>Projekti</th>
											<th>Työntekijä</th>
											<th>Selite</th>
											<th>Päivämäärä</th>
										</tr>
									</thead>

									<tbody>
				 
						
						
						<tr class="even pointer">
											<c:forEach items="${ptunnit}" var="tunnit">
		<tr>
			<c:forEach items="${projektit}" var="projektit">
				<c:if test="${tunnit.projID == projektit.projID}">
					<td><c:out value="${projektit.projnimi}"></c:out></td>
				</c:if>
			</c:forEach>
			
			<c:forEach items="${henkilot}" var="henkilo">
			<c:if test="${tunnit.kaytID == henkilo.id}">
					<td><c:out value="${henkilo.etunimi} ${henkilo.sukunimi}"></c:out></td>
					<td><c:out value="${tunnit.kuvaus}"></c:out></td>
					<td><c:out value="${tunnit.date}"></c:out></td>
				</c:if>
				
			</c:forEach>
</tr>

		</c:forEach>
		</tr></tbody></table>
							</div>
						</div>
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