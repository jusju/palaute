<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
		uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>Henkilön lisääminen</title>

</head>

<body>
	<jsp:include page="../../kayttaja/navigointi.jsp"></jsp:include>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
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

											<tr class="even pointer">
												<form:form modelAttribute="henkilo" method="post">
													<fieldset>
														<legend>Henkilön tiedot</legend>
														<p>
															<form:label path="etunimi">Etunimi</form:label>
															<br />
															<form:input path="etunimi"
																cssErrorClass="VirheellinenKentta" />
															<form:errors path="etunimi" cssClass="Virheteksti" />
														</p>
														<p>
															<form:label path="sukunimi">Sukunimi</form:label>
															<br />
															<form:input path="sukunimi"
																cssErrorClass="VirheellinenKentta" />
															<form:errors path="sukunimi" cssClass="Virheteksti" />
														</p>
														<p>
															<form:label path="sposti">Sähköpostiosoite</form:label>
															<br />
															<form:input class="form-control"
																placeholder="Sähköpostiosoite" path="sposti"
																cssErrorClass="VirheellinenKentta" />
															<form:errors path="sposti" cssClass="Virheteksti" />
														</p>



														<form:input path="salasana" type="hidden" />

														<p>
															<button type="submit">tallenna</button>
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
				</tbody>








			</div>

		</div>
</body>
</html>
</body>
</html>