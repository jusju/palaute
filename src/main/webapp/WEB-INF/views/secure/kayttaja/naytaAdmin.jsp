<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Henkilön tietojen näyttäminen</title>

</head>	
<body>
<jsp:include page="navigointi.jsp"></jsp:include>

<div class="right_col" role="main">

				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="dashboard_graph">

							<div class="row x_title">
								<div class="col-md-6">
									<h3>Tervetuloa käyttäjä paneeliin!</h3>
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="col-md-12 col-sm-12 col-xs-12">
								Vasemmalta löydät kaiken tarvittavan.
							</div>

							<div class="clearfix"></div>
						</div>
					</div>

				</div>
				<br />

			<div class="row">
				<div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                      <div class="tile-stats">
                        <div class="icon"><i class="fa fa-clock-o"></i>
                        </div>
                        <div class="count">179</div>

                        <h3>Tunteja tehty</h3>
                        <p>Softalaprojekti 1</p>
                      </div>
                    </div>
                    <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                      <div class="tile-stats">
                        <div class="icon"><i class="fa fa-clock-o"></i>
                        </div>
                        <div class="count">15</div>

                        <h3>Tunteja tehty</h3>
                        <p>Softalaprojekti 2</p>
                      </div>
                    </div>
                    <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                      <div class="tile-stats">
                        <div class="icon"><i class="fa fa-clock-o"></i>
                        </div>
                        <div class="count">0</div>

                        <h3>Tunteja tehty</h3>
                        <p>Uusi joku projekti</p>
                      </div>
                    </div>
                </div>
				<!-- footer content -->

				<footer>
					<div class="copyright-info">
						<p class="pull-right">Tuntikirjaus <i class="fa fa-copyright"></i> Team Lila		
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