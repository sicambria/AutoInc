<!-- the index page has three major components which included from page_includes/:
1. the page_includes/header.jsp where there is the logic for displaing login/logout and displaying messages
2. the slider  which is included in page_includes/frontpage.jsp
3. the product display which is included in page_includes/productdisplay.jsp-->

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>AutoInc Web Portal</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>

	<!--header-->
	<!-- the header file contains the all the html and css tags for the header section
	as well as the logic initiating session, and detecting whether a user is logged in
	or not. if an user is logged in we display logout option and if they are not logged
	in we display log in in the top menu from this JSP as well -->
	<jsp:include page="page_includes/header.jsp" />
	<!--header-->
	
	<section id="slider"><!--slider-->
	<jsp:include page="page_includes/frontpage_slider.jsp" />
	</section><!--/slider-->
	
	<section> <!-- Our Products -->
		<div class="container"><!--container-->
			<div class="row"><!--row-->
				
				<div class="col-sm-12 padding-right"><!--column width-->
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Our Products</h2>
						
							<!-- This part is responsible for generating the front view
							of the product items -->
							
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
											<div class="productinfo text-center">
												<img src="images/home/products/family.jpg" alt="" />
											
												</h2>
													<!-- a simple algorithm is used below to render the output name in the front end
														we know that any name will have more than 20 character, after that we find the
														first whitespace and use subSequence to end it at that point so we dont
														display the name in middle of a word -->
													<p>Family</p>
													<a href="family.jsp" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Buy Now</a>
											</div>
									
									</div>
								</div>
							</div>
							
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
											<div class="productinfo text-center">
												<img src="images/home/products/sport.jpg" alt="" />
											
												</h2>
													<!-- a simple algorithm is used below to render the output name in the front end
														we know that any name will have more than 20 character, after that we find the
														first whitespace and use subSequence to end it at that point so we dont
														display the name in middle of a word -->
													<p>Sport</p>
													<a href="sport.jsp" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Buy Now</a>
											</div>
									
									</div>
								</div>
							</div>
							
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
											<div class="productinfo text-center">
												<img src="images/home/products/smart.jpg" alt="" />
											
												</h2>
													<!-- a simple algorithm is used below to render the output name in the front end
														we know that any name will have more than 20 character, after that we find the
														first whitespace and use subSequence to end it at that point so we dont
														display the name in middle of a word -->
													<p>Smart</p>
													<a href="smart.jsp" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Buy Now</a>
											</div>
									
									</div>
								</div>
							</div>
							
					</div>	<!--features_items-->		
				</div>	<!--column width-->
			</div>	<!--row-->
		</div>	<!--container-->
	</section>	<!-- Our Products -->
  
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>