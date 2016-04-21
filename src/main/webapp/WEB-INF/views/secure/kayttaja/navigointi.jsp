<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Sisäänkirjautuminen</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<link href="<c:url value="/resources/fonts/css/font-awesome.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/animate.min.css"/>"
	rel="stylesheet">

<!-- Custom styling plus plugins -->
<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet">
<link
	href="<c:url value="/resources/css/maps/jquery-jvectormap-2.0.3.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/icheck/flat/green.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/floatexamples.css"/>"
	rel="stylesheet" type="text/css" />

<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/nprogress.js"/>"></script>
</head>
<body class="nav-md">

	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">

					<div class="navbar nav_title" style="border: 0;">
						<a href="/tunnit_lila/secure/oma" class="site_title"><i
							class="fa fa-home"></i> <span>Käyttäjä paneeli</span></a>
					</div>
					<div class="clearfix"></div>

					<!-- menu prile quick info -->
					<div class="profile">
						<div class="profile_pic">
							<img src="images/user.png" alt="..."
								class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Tervetuloa,</span>
							<h2>Käyttäjä</h2>
						</div>
					</div>
					<!-- /menu prile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">

						<div class="menu_section">
							

							
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<h3>Admin</h3>
									<ul class="nav side-menu">
										<li><a href="/tunnit_lila/secure/admin/super/tools"><i
												class="fa fa-users"></i>Käyttäjät </a></li>
										<li><a href="/tunnit_lila/secure/oma/projektit"><i
												class="fa fa-folder-open-o"></i> Projektit </a></li>
										<li><a href="/tunnit_lila/secure/oma/tunnit"><i
												class="fa fa-clock-o"></i> Tunnit </a></li>
									</ul>

								</sec:authorize>
							
						</div>
						<div class="menu_section">
							<h3>Käyttäjä</h3>
						<ul class="nav side-menu">
							<li><a href="/tunnit_lila/secure/oma/projektit"><i
									class="fa fa-folder-open-o"></i> Projektit </a></li>
							<li><a href="/tunnit_lila/secure/oma/tunnit"><i
									class="fa fa-clock-o"></i> Tunnit </a></li>
						</ul>
						
					</div>
				</div>
				<!-- /sidebar menu -->

				<!-- /menu footer buttons -->
				<div class="sidebar-footer hidden-small">
					<a href="/tunnit_lila/logout" data-toggle="tooltip"
						data-placement="top" title="Kirjaudu ulos"> <span
						class="glyphicon glyphicon-off" aria-hidden="true"></span>
					</a>
				</div>
				<!-- /menu footer buttons -->
			</div>
		</div>

		<!-- top navigation -->
		<div class="top_nav">

			<div class="nav_menu">
				<nav class="" role="navigation">
					<div class="nav toggle">
						<a id="menu_toggle"><i class="fa fa-bars"></i></a>
					</div>

					<ul class="nav navbar-nav navbar-right">
						<li class=""><a href="javascript:;"
							class="user-profile dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false"> <img src="images/user.png" alt="">Käyttäjä
								<span class=" fa fa-angle-down"></span>
						</a>
							<ul
								class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
								<li><a href="/tunnit_lila/logout""><i
										class="fa fa-sign-out pull-right"></i> Kirjaudu ulos</a></li>
							</ul></li>
					</ul>
				</nav>
			</div>

		</div>
		<script src="<c:url value="/resources/js/bootstrap.min.js"/>" /></script>

		<!-- gauge js -->
		<script type="text/javascript"
			src="<c:url value="/resources/js/gauge/gauge.min.js"/>" /></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/gauge/gauge_demo.js"/>" /></script>
		<!-- chart js -->
		<script src="../resources/js/chartjs/chart.min.js"></script>
		<!-- bootstrap progress js -->
		<script
			src="<c:url value="/resources/js/progressbar/bootstrap-progressbar.min.js"/>" /></script>
		<script
			src="<c:url value="/resources/js/nicescroll/jquery.nicescroll.min.js"/>" /></script>
		<!-- icheck -->
		<script src="<c:url value="/resources/js/icheck/icheck.min.js"/>" /></script>
		<!-- daterangepicker -->
		<script type="text/javascript"
			src="<c:url value="/resources/js/moment/moment.min.js"/>" /></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/datepicker/daterangepicker.js"/>" /></script>

		<script src="../resources/js/custom.js"></script>

		<!-- flot js -->
		<!--[if lte IE 8]><script type="text/javascript" src="js/excanvas.min.js"></script><![endif]-->
		<script type="text/javascript"
			src="<c:url value="/resources/js/flot/jquery.flot.js"/>" /></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/flot/jquery.flot.pie.js"/>" /></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/flot/jquery.flot.orderBars.js"/>" /></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/flot/jquery.flot.time.min.js"/>" /></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/flot/date.js"/>" /></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/flot/jquery.flot.spline.js"/>" /></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/flot/jquery.flot.stack.js"/>" /></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/flot/curvedLines.js"/>" /></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/flot/jquery.flot.resize.js"/>" /></script>
		<script>
			$(document)
					.ready(
							function() {
								// [17, 74, 6, 39, 20, 85, 7]
								//[82, 23, 66, 9, 99, 6, 2]
								var data1 = [ [ gd(2012, 1, 1), 17 ],
										[ gd(2012, 1, 2), 74 ],
										[ gd(2012, 1, 3), 6 ],
										[ gd(2012, 1, 4), 39 ],
										[ gd(2012, 1, 5), 20 ],
										[ gd(2012, 1, 6), 85 ],
										[ gd(2012, 1, 7), 7 ] ];

								var data2 = [ [ gd(2012, 1, 1), 82 ],
										[ gd(2012, 1, 2), 23 ],
										[ gd(2012, 1, 3), 66 ],
										[ gd(2012, 1, 4), 9 ],
										[ gd(2012, 1, 5), 119 ],
										[ gd(2012, 1, 6), 6 ],
										[ gd(2012, 1, 7), 9 ] ];
								$("#canvas_dahs").length
										&& $
												.plot(
														$("#canvas_dahs"),
														[ data1, data2 ],
														{
															series : {
																lines : {
																	show : false,
																	fill : true
																},
																splines : {
																	show : true,
																	tension : 0.4,
																	lineWidth : 1,
																	fill : 0.4
																},
																points : {
																	radius : 0,
																	show : true
																},
																shadowSize : 2
															},
															grid : {
																verticalLines : true,
																hoverable : true,
																clickable : true,
																tickColor : "#d5d5d5",
																borderWidth : 1,
																color : '#fff'
															},
															colors : [
																	"rgba(38, 185, 154, 0.38)",
																	"rgba(3, 88, 106, 0.38)" ],
															xaxis : {
																tickColor : "rgba(51, 51, 51, 0.06)",
																mode : "time",
																tickSize : [ 1,
																		"day" ],
																//tickLength: 10,
																axisLabel : "Date",
																axisLabelUseCanvas : true,
																axisLabelFontSizePixels : 12,
																axisLabelFontFamily : 'Verdana, Arial',
																axisLabelPadding : 10
															//mode: "time", timeformat: "%m/%d/%y", minTickSize: [1, "day"]
															},
															yaxis : {
																ticks : 8,
																tickColor : "rgba(51, 51, 51, 0.06)",
															},
															tooltip : false
														});

								function gd(year, month, day) {
									return new Date(year, month - 1, day)
											.getTime();
								}
							});
		</script>

		<!-- worldmap -->
		<script type="text/javascript"
			src="<c:url value="/resources/js/maps/jquery-jvectormap-2.0.3.min.js"/>" /></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/maps/gdp-data.js"/>" /></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/maps/jquery-jvectormap-world-mill-en.js"/>" /></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/maps/jquery-jvectormap-us-aea-en.js"/>" /></script>
		<!-- pace -->
		<script src="js/pace/pace.min.js"></script>
		<script>
			$(function() {
				$('#world-map-gdp').vectorMap({
					map : 'world_mill_en',
					backgroundColor : 'transparent',
					zoomOnScroll : false,
					series : {
						regions : [ {
							values : gdpData,
							scale : [ '#E6F2F0', '#149B7E' ],
							normalizeFunction : 'polynomial'
						} ]
					},
					onRegionTipShow : function(e, el, code) {
						el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
					}
				});
			});
		</script>
		<!-- skycons -->
		<script src="<c:url value="/resources/js/skycons/skycons.min.js"/>" /></script>
		<script>
			var icons = new Skycons({
				"color" : "#73879C"
			}), list = [ "clear-day", "clear-night", "partly-cloudy-day",
					"partly-cloudy-night", "cloudy", "rain", "sleet", "snow",
					"wind", "fog" ], i;

			for (i = list.length; i--;)
				icons.set(list[i], list[i]);

			icons.play();
		</script>

		<!-- dashbord linegraph -->
		<script>
			var doughnutData = [ {
				value : 30,
				color : "#455C73"
			}, {
				value : 30,
				color : "#9B59B6"
			}, {
				value : 60,
				color : "#BDC3C7"
			}, {
				value : 100,
				color : "#26B99A"
			}, {
				value : 120,
				color : "#3498DB"
			} ];
			var myDoughnut = new Chart(document.getElementById("canvas1")
					.getContext("2d")).Doughnut(doughnutData);
		</script>
		<!-- /dashbord linegraph -->
		<!-- datepicker -->
		<script type="text/javascript">
			$(document)
					.ready(
							function() {

								var cb = function(start, end, label) {
									console.log(start.toISOString(), end
											.toISOString(), label);
									$('#reportrange span')
											.html(
													start
															.format('MMMM D, YYYY')
															+ ' - '
															+ end
																	.format('MMMM D, YYYY'));
									//alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + ", label = " + label + "]");
								}

								var optionSet1 = {
									startDate : moment().subtract(29, 'days'),
									endDate : moment(),
									minDate : '01/01/2012',
									maxDate : '12/31/2015',
									dateLimit : {
										days : 60
									},
									showDropdowns : true,
									showWeekNumbers : true,
									timePicker : false,
									timePickerIncrement : 1,
									timePicker12Hour : true,
									ranges : {
										'Today' : [ moment(), moment() ],
										'Yesterday' : [
												moment().subtract(1, 'days'),
												moment().subtract(1, 'days') ],
										'Last 7 Days' : [
												moment().subtract(6, 'days'),
												moment() ],
										'Last 30 Days' : [
												moment().subtract(29, 'days'),
												moment() ],
										'This Month' : [
												moment().startOf('month'),
												moment().endOf('month') ],
										'Last Month' : [
												moment().subtract(1, 'month')
														.startOf('month'),
												moment().subtract(1, 'month')
														.endOf('month') ]
									},
									opens : 'left',
									buttonClasses : [ 'btn btn-default' ],
									applyClass : 'btn-small btn-primary',
									cancelClass : 'btn-small',
									format : 'MM/DD/YYYY',
									separator : ' to ',
									locale : {
										applyLabel : 'Submit',
										cancelLabel : 'Clear',
										fromLabel : 'From',
										toLabel : 'To',
										customRangeLabel : 'Custom',
										daysOfWeek : [ 'Su', 'Mo', 'Tu', 'We',
												'Th', 'Fr', 'Sa' ],
										monthNames : [ 'January', 'February',
												'March', 'April', 'May',
												'June', 'July', 'August',
												'September', 'October',
												'November', 'December' ],
										firstDay : 1
									}
								};
								$('#reportrange span').html(
										moment().subtract(29, 'days').format(
												'MMMM D, YYYY')
												+ ' - '
												+ moment().format(
														'MMMM D, YYYY'));
								$('#reportrange').daterangepicker(optionSet1,
										cb);
								$('#reportrange').on('show.daterangepicker',
										function() {
											console.log("show event fired");
										});
								$('#reportrange').on('hide.daterangepicker',
										function() {
											console.log("hide event fired");
										});
								$('#reportrange')
										.on(
												'apply.daterangepicker',
												function(ev, picker) {
													console
															.log("apply event fired, start/end dates are "
																	+ picker.startDate
																			.format('MMMM D, YYYY')
																	+ " to "
																	+ picker.endDate
																			.format('MMMM D, YYYY'));
												});
								$('#reportrange').on('cancel.daterangepicker',
										function(ev, picker) {
											console.log("cancel event fired");
										});
								$('#options1')
										.click(
												function() {
													$('#reportrange').data(
															'daterangepicker')
															.setOptions(
																	optionSet1,
																	cb);
												});
								$('#options2')
										.click(
												function() {
													$('#reportrange').data(
															'daterangepicker')
															.setOptions(
																	optionSet2,
																	cb);
												});
								$('#destroy')
										.click(
												function() {
													$('#reportrange').data(
															'daterangepicker')
															.remove();
												});
							});
		</script>
		<script>
			NProgress.done();
		</script>
		<script>
			$(function() {
				$("#datepicker").datepicker();
			});
		</script>
</body>
<!-- /top navigation -->
</body>
</html>

















