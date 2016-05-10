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

 <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>

</head>
<sec:authorize access="hasRole('ROLE_USER')">
<body>
	<jsp:include page="navigointi.jsp"></jsp:include>

	<!-- page content -->
	<div class="right_col" role="main">
		<div class="">
			<div class="page-title">
				<div class="title_left">
					
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							
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
								

									<tbody>

										<sec:authorize access="hasRole('ROLE_USER')">

											<tr class="even pointer">
												<form:form modelAttribute="tunti" method="post">
													<fieldset>
														<legend>Tunnin tiedot</legend>
														<p>
															<form:input path="kaytID" type="hidden" />
														</p>
														<p>
															<form:label path="projID">Projekti</form:label>
															<br /> <select class="form-control" name="projID">
																<c:forEach items="${projektit}" var="projekti">


																	<option value="${projekti.projID}"><c:out
																			value="${projekti.projnimi}" /></option>


																</c:forEach>
															</select>
														</p>
														<p>

															<form:label path="date">Päivämäärä</form:label>
															<br />
															<form:input type="text" id="datepicker" name="datepicker"
																path="date" />
														</p>
														<p>
															<form:label path="aloitusaika">Aloitusaika</form:label>
															<br />
															<form:input path="aloitusaika" />
														</p>
														<p>
															<form:label path="lopetusaika">Lopetusaika</form:label>
															<br />
															<form:input path="lopetusaika" />
														</p>
														<p>
															<form:label path="kuvaus">Kuvaus</form:label>
															<br />
															<form:input path="kuvaus" />
														</p>
														<p>
														<p>
															<button type="submit">Lisää</button>
														</p>
													</fieldset>
												</form:form>
										</sec:authorize>




									</tbody>

								</table>
							
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

	</sec:authorize>
</body>

</html>