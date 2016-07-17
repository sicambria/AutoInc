package com.autoinc.buffalo.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.autoinc.buffalo.model.CustomerClass;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this is used to log the customer out
		//first capture the action
		try {
			String action = request.getParameter("action");
			//if the action has logout parameter, then we sign them out
			if(action.equalsIgnoreCase("signout")){
				HttpSession customerSession = request.getSession();
				customerSession.invalidate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// this is used to log in the customer
		//first capture the action
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//create checkFlag and validate the login
		boolean checkFlag=false;
		try {
			checkFlag = CustomerClass.Login(email, password);
		} catch (Exception e) {
			HttpSession customerSession = request.getSession();
			customerSession.setAttribute("color", "red");
			customerSession.setAttribute("message", "login not succesful");
		}
		
		//check the state of customer login and store in session object
				if(checkFlag) {
					HttpSession customerSession = request.getSession();
					customerSession.setAttribute("email", email);
					customerSession.setAttribute("color", "green");
					customerSession.setAttribute("message", "login succesful");
				}else{
					HttpSession customerSession = request.getSession();
					customerSession.setAttribute("color", "red");
					customerSession.setAttribute("message", "login not succesful");
				}
				response.sendRedirect("index.jsp");
	}

}
