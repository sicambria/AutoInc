package com.autoinc.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

import com.autoinc.util.CheckUser;

/**
 * Servlet implementation class LoginServlet
 * This servlet deals with login the user into the system
 */
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//this is used to log the customer out
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("signout")){
			
			HttpSession customerSession = request.getSession();
			
			customerSession.invalidate();
			
			response.sendRedirect("index.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//take input of the incoming password and email
		String email = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		//creating a variable to store the status of authenticating the user
		Boolean checkUser = true;
		
		System.err.println("LOGGED IN...");
		//checkUser = CheckUser.login(email, password);
		//we update the authorization status in the session as per result
		HttpSession customerSession = request.getSession();
		customerSession.setAttribute("auth", checkUser);
		//if the user exists we redirect the user to homepage
		if(checkUser) {
			response.sendRedirect("index.jsp");
		}else
			response.sendRedirect("login.jsp");
			
		
	}

}
