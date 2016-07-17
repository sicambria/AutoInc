package com.autoinc.buffalo.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.autoinc.buffalo.model.CustomerClass;

public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String country = request.getParameter("country");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String retrypassword = request.getParameter("retryPassword");
		
		
		if(!password.equals(retrypassword))
		{
		    HttpSession customerSession = request.getSession();
		    customerSession.setAttribute("color", "red");
		    customerSession.setAttribute("message", "password didn't match");
		    response.sendRedirect("login.jsp");
		}
		else{
			
		boolean checkRegistration = false;
		
		try {
			checkRegistration = CustomerClass.Register(country, name, address, phoneNumber, email, password);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(checkRegistration);
		if(checkRegistration)
		{
		    HttpSession customerSession = request.getSession();
		    customerSession.setAttribute("color", "green");
		    customerSession.setAttribute("message", "your account was created");
		}
		response.sendRedirect("index.jsp");
		}
		
	}
		

}
