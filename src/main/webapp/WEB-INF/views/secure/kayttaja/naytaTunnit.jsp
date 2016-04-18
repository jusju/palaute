<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Henkilön tietojen näyttäminen</title>



</head>

<body>
	<jsp:include page="navigointi.jsp"></jsp:include>

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
											<th>Aika (h)</th>
											<th>Poista</th>
										</tr>
									</thead>

									<tbody>

										<tr class="even pointer">
											<c:forEach items="${tunnit}" var="tunti">
											<td><a href="<c:out value="/tunnit_lila/henkilo/ttunti/${tunti.tuntiID}"/>"><c:out value="${tunti.date}"></c:out></a></td>

												<c:forEach items="${projektit}" var="projektit">
													<c:if test="${tunti.projID == projektit.projID}">
														<td><a href="<c:out value="/tunnit_lila/henkilo/ptunti/${tunti.projID}"/>"><c:out value="${projektit.projnimi}"></c:out></a></td>
													</c:if>
												</c:forEach>
												<td class=" "><c:out value="${tunti.kuvaus}"></c:out>
												</td>
												
												<c:set var="aloitus" value="${tunti.aloitusaika}"/>
												<c:set var="lopetus" value="${tunti.lopetusaika}"/>
												
													<td class=" "><c:out value="${aloitus}"></c:out></td>


												
												<td class=" "><a
													href="/tunnit_lila/tunnit/delete/${tunti.tuntiID}"><button
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
													href="/tunnit_lila/tunnit/uusi/${henkilo.id}"><button
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

	</div>

	</div>








	<a href="#" onclick="history.go(-1)">Takaisin</a>



</body>

</html>
