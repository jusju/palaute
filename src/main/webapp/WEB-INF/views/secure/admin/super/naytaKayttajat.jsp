<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN-SIVU</title>
<link rel="stylesheet" type="text/css"
	href="../../resources/styles/common.css">
</head>
<body>
	<jsp:include page="../../kayttaja/navigointi.jsp"></jsp:include>
<sec:authorize access="hasRole('ROLE_ADMIN')">
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
											<th>Etunimi</th>
											<th>Sukunimi</th>
											<th>Muokkaa</th>
											<th>Poista</th>
										</tr>
									</thead>

									<tbody>

										<tr class="even pointer">
											<c:forEach items="${henkilot}" var="henkilo">
												<td class=" "><c:out value="${henkilo.etunimi}"></c:out></td>
												<td class=" "><c:out value="${henkilo.sukunimi}"></c:out></td>
												<td class=" "><a
													href="/tunnit_lila/secure/admin/super/muokkaa/${henkilo.id}"><button
															type="button" class="btn btn-danger btn-xs">Muokkaa</button></a></td>
												<td class=" "><a
													href="/tunnit_lila/secure/admin/super/delete/${henkilo.id}"><button
															type="button" class="btn btn-danger btn-xs">poista</button></a></td>
										</tr>
										
										</c:forEach>

</sec:authorize>


									</tbody>

								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			</tbody>








		</div>

	</div>

</body>
</html>