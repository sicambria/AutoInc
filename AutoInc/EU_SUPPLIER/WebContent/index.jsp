<%@page import="eu.model.ChassisObject"%>
<%@page import="eu.model.ChassisClass"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>EU Supplier Inventory</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

         <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            
            <!-- header part included -->
            <%@include file= "includes/header.jsp" %>
            
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <%@include file ="includes/sidemenu.jsp" %>
            <!-- /.navbar-collapse -->
        </nav>
		
        <div id="page-wrapper">

            <div class="container-fluid">
                
                 <!-- Section Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Chassis Inventory List
                        </h1>
                        
                    </div>
                </div>
                
				<div class="col-lg-12">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
									
                                <thead>
                                    <tr>
                                        <td>Chassis ID</td>
                                        <td>Quantity</td>
                                        <td>Comment</td>
                                    </tr>
                                </thead>
                                <tbody>
                                <%
									ArrayList<ChassisObject> chassisList = ChassisClass.getChassis();
									for (ChassisObject chassisItem : chassisList) {
								%>
                                
                                    <tr>
                                        <th><% out.println(chassisItem.getChassisId()); %></th>
                                        <th><% out.println(chassisItem.getQuantity()); %></th>
                                        <th><% out.println(chassisItem.getComments()); %></th>
              
                                   </tr>
                                <% }%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
              
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>