
<%@page import="com.autoinc.buffalo.model.PaymentInformationObject"%>
<%@page import="com.autoinc.buffalo.model.PaymentInformationClass"%>
<%@page import="com.autoinc.buffalo.model.CustomerClass"%>
<%@page import="com.autoinc.buffalo.model.CustomerObject"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>AutoInc - Account</title>
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
	<%@include file ="page_includes/header.jsp" %>
	
	<section id="form"><!--form-->
				<% 
				PaymentInformationObject paymentInformationObject = null;
				
				if(customerSession.getAttribute("email")!=null){
				    CustomerObject customerObject = CustomerClass.getCustomer((String)customerSession.getAttribute("email"));
				    int customerId = customerObject.getCustomerId();
					//check if the payment information is set
				    boolean isPaymentInformationSet = PaymentInformationClass.paymentInformationGiven(customerId);
					//if it is set, then get the payment information
					if(isPaymentInformationSet){
					paymentInformationObject = PaymentInformationClass.getPaymentInformation(customerId);}
				%>
		
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Update Personal Information</h2>
						<form action="#">
							<input type="text" value = "<%=customerObject.getName() %>" placeholder="First Name" name="name"/>
							<input type="text" value = "<%=customerObject.getAddress() %>" placeholder="Address" name="address"/>
							<input type="text" value = "<%=customerObject.getPhoneNumber()%>" placeholder="Phone Number" name="phone_number"/>
							<input type="text" value = "<%=customerObject.getemail()%>" placeholder="Email Address" name="email"/>
							<select name = "country">
							<option selected="selected" value = "<%=customerObject.getCountry()%>"><%=customerObject.getCountry()%></option>
							<option value = "Singapore">Singapore</option>
							<option value = "Malaysia">Malaysia</option>
							<option value = "Thailand">Thailand</option>
							<option value = "Vietnam">Vietnam</option>
							<option value = "Indonesia">Indonesia</option>
							</select>
							<br /><br />
							<input type="hidden" name="email" value="<%=customerSession.getAttribute("email")%>">
							<button type="submit" class="btn btn-default">Update</button>
						</form>
					</div><!--/login form-->
				</div>
				
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>Update Payment Information</h2>
						<form action="PaymentInfomrationServlet" method="post">
							<input type="text"  name="account_number" placeholder="Account Number" 
							<% if(isPaymentInformationSet){ %>
							value="<%=paymentInformationObject.getAccount_number() %>" <% } %>
							/>
							<select name = "bank">
							<%if(isPaymentInformationSet) {%>
							<option selected="selected" value = "<%=paymentInformationObject.getBank()%>"><%=paymentInformationObject.getBank()%></option>
							<% } %>
							<option value = "alpha">Alpha Bank</option>
							<option value = "euro">Euro Bank</option>
							<option value = "piraeus">Piraeus Bank</option>
							</select>
							<br/><br/>
							<button type="submit" class="btn btn-default">Update</button>
							<input type="hidden" name="email" value="<%=customerSession.getAttribute("email")%>">
						</form>
					</div><!--/sign up form-->
				</div>
				<%} %>
		
	</section><!--/form-->
	
	
	
	

  
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>

</body>
</html>