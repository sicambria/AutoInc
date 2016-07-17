<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- script to check if the user is logged in or not -->
<% 
HttpSession customerSession = request.getSession();
if(customerSession.getAttribute("auth")==null)
	response.sendRedirect("login.jsp");	
%>
<div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">AutoInc FACTORY</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    
                        <a href="LoginServlet?action=signout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                    
                </li>
            </ul>