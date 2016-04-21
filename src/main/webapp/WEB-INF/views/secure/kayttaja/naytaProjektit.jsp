<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
												<td class=" "><c:out value="${projekti.projnimi}"></c:out>
												</td>
												
												<td class=" "><a
													href="/tunnit_lila/projektit/delete/${projekti.projID}"><button
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
													href="/tunnit_lila/projektit/uusi"><button
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
		</footer>
		<!-- /footer content -->
	</div>
	<!-- /page content -->

	</div>

	</div>












</body>

</html>