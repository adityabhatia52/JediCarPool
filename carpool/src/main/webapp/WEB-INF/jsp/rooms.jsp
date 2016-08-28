<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>


<html lang="en">
<!--  Head   -->

<head>
<title>User</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="Car Pooling app for Practeons">
<meta name="keywords"
	content="Hotel in the City,City Hotels, 5 Star Hotel in the city">

<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,600,300,700"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Comfortaa:300,700"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/themes/smoothness/jquery-ui.css?ver=4.2.4"
	type="text/css" media="all" />

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-slider.css">
<link rel="stylesheet" href="css/sticky.css">
<link rel="stylesheet" type="text/css"
	href="js/lightbox/jquery.fancybox8cbb.css?v=2.1.5" media="screen" />
<link rel="stylesheet" type="text/css"
	href="js/lightbox/jquery.fancybox-buttons3447.css?v=1.0.5" />
<link rel="stylesheet" type="text/css"
	href="js/lightbox/jquery.fancybox-thumbsf2ad.css?v=1.0.7" />
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" type="text/css" href="sliderfiles/slick.css" />
<link rel="stylesheet" type="text/css"
	href="sliderfiles/slick-theme.css" />
<link rel="icon" type="image/png" href="images/favicon.png">
<link rel="shortcut icon" href="images/favicon.ico"
	type="image/vnd.microsoft.icon">

</head>
<!-- // End Of Head   -->


<!--  Body   -->
<body class="roomspage" id="roomspage">
	<div class="row imgstillback">
		<!--  Header  -->
		<header class="row menubar menu" id="myHeader">
			<div class="container">
				<div class="col-sm-10">
					<div class="navbar navbar-default" role="navigation">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#firstmenu">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#"></a>
						</div>
						<div class="navbar-collapse collapse" id="firstmenu">
							<ul class="nav navbar-nav">
								<li><a href="index-2.html" class="homepagelink">HOME</a></li>
								<li><a href="rooms.html" class="roomspagelink">LISTINGS</a></li>
								<li><a href="spa.html" class="spapagelink">BOOKINGS</a></li>
								<li><a href="#" class="booknow" data-toggle="modal"
									data-target="#booknowmodal">BOOK NOW</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</header>
		<!-- // End Of Header  -->

		<!-- Book Now Button in Header  -->
		<div class="modal fade" id="booknowmodal" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="tac">
							<span>BOOK NOW</span>
						</h2>
						<a class="close" data-dismiss="modal" aria-label="Close"><span
							aria-hidden="true"><img src="images/modalexit.png"
								class="modalexit" alt=""></span></a>
					</div>
					<div class="modal-body">
						<div class="row memberselection">
							<div class="col-sm-12 pld0">
								<div class="row">
									<div class="col-sm-9">
										<div class="col-xs-6 col-sm-3">
											<table class="datetable">
												<tr>
													<td><input type="text" id="check_in_date1"
														placeholder="CHECK IN"></td>
													<td class="calenicon"><i class="fa fa-calendar"></i></td>
												</tr>
											</table>
										</div>
										<div class="col-xs-6 col-sm-3">
											<table class="datetable">
												<tr>
													<td><input type="text" id="check_out_date1"
														placeholder="CHECK OUT"></td>
													<td class="calenicon"><i class="fa fa-calendar"></i></td>
												</tr>
											</table>
										</div>
										<div class="col-xs-6 col-sm-3">
											<select name="#">
												<option value="Guests" selected>Guests</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="2">3</option>
												<option value="2">4</option>
											</select>
										</div>
										<div class="col-xs-6 col-sm-3">
											<select name="#" class="pr1r">
												<option value="Children" selected>Children</option>
												<option value="1">0</option>
												<option value="2">1</option>
												<option value="3">2</option>
											</select>
										</div>
									</div>
									<div class="col-sm-3">
										<div>
											<button class="searchbutton opl"
												onclick="window.location='search.html'">
												<i class="fa fa-search"></i>CHECK AVAILABILITY
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- // End Of Book Now Button in Header  -->

		<!-- Page Navigation  -->
		<div class="row pagetitle">
			<div class="container">
				<h1 class="opl">Available Listings</h1>
			</div>
		</div>
		<!-- // End Of Page Navigation  -->
	</div>
	<!-- // End Of Class  -->


	<!-- Room Type 1  -->
	<div class="row greyback">
		<div class="container">
			<div class="col-sm-9 p0">
				<div class="row">
					<div class="col-sm-12">
						<c:forEach var="list" items="${getListing}">
							<p class="reddish opb">Destination:${list.getAddressModel().getDestination()}</p>

							<div class="row roomfacdiv">

								<div class="col-sm-4">
									<p class="e7 smaller">
										<img src="images/list.png" class="mr5p"><strong>Source</strong>:${list.getSourceModel().getNameOffice()}<br>
										<img src="images/list.png" class="mr5p"><strong>Time</strong>:${list.getDepartTime()}<br>
										<img src="images/list.png" class="mr5p"><strong>User</strong>:${list.getUserModel().getName()}<br>
									</p>
								</div>
								<div class="col-sm-4">
									<p class="e7 smaller">
										<img src="images/list.png" class="mr5p"><strong>Vehicle</strong>:${list.getVehicleModel().getModel()}<br>
										<img src="images/list.png" class="mr5p" alt="Hotel Plus"><strong>Seats
											Available</strong>:${list.getSeatAvailable()}<br>
									</p>
								</div>
								<div class="col-sm-4">
									<div class="col-sm-4 txt-right">
										<button class="sendmessage"
											onclick="window.location='search.html'">BOOK NOW</button>
									</div>
								</div>
							</div>
							<br>
							<br>
						</c:forEach>
						<br>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- // End Of Room Type 1  -->


	<script src="js/jquery-2.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/classie.js"></script>
	<script src="js/sticky.js"></script>
	<script type="text/javascript" src="js/jquery.nicescroll.js"></script>
	<script src="js/bose.slider.js"></script>
	<script src="js/bose.js"></script>
	<script type="text/javascript" src="js/custom-script.js"></script>



	<script type="text/javascript" src="sliderfiles/slick.js"></script>
	<script type="text/javascript">
		$('.your-class').slick({
			slidesToShow : 1,
			slidesToScroll : 1,
			arrows : true,
			fade : true,
			asNavFor : '.slider-nav'
		});
		$('.slider-nav').slick({
			slidesToShow : 1,
			slidesToScroll : 1,
			asNavFor : '.your-class',
			dots : false,
			centerMode : true,
			focusOnSelect : true
		});
	</script>
	<script type="text/javascript" src="js/core.min.js"></script>
	<script type="text/javascript" src="js/datepicker.min.js"></script>
	<script type="text/javascript"
		src="js/lightbox/jquery.mousewheel-3.0.6.pack.js"></script>
	<script type="text/javascript"
		src="js/lightbox/jquery.fancybox8cbb.js?v=2.1.5"></script>
	<script type="text/javascript"
		src="js/lightbox/jquery.fancybox-buttons3447.js?v=1.0.5"></script>
	<script type="text/javascript"
		src="js/lightbox/jquery.fancybox-thumbsf2ad.js?v=1.0.7"></script>
	<script type="text/javascript"
		src="js/lightbox/jquery.fancybox-mediac924.js?v=1.0.6"></script>
	<script type="text/javascript" src="js/lightbox/fancybox.js"></script>
</body>