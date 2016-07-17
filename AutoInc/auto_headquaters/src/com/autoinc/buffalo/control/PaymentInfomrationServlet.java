package com.autoinc.buffalo.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.autoinc.buffalo.model.CustomerClass;
import com.autoinc.buffalo.model.CustomerObject;
import com.autoinc.buffalo.model.PaymentInformationClass;

/**
 * Servlet implementation class PaymentInfomrationServlet
 */
public class PaymentInfomrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//capture the parameters
		String accountNumber = null;
		String email = null;
		String bank = null;
		try {
			accountNumber = request.getParameter("account_number");
			email = request.getParameter("email");
			bank = request.getParameter("bank");
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		}
		System.out.println(accountNumber);
		//get the customer_id
		int customerId = 0;
		try {
			customerId = CustomerClass.getCustomerIDbyCustomerEmail(email);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//update bank information
		boolean result = false;
		try {
			result = PaymentInformationClass.enterPaymentInformation(customerId, bank, accountNumber);
			result = true;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		if(result){
			HttpSession customerSession = request.getSession();
			customerSession.setAttribute("color", "green");
			customerSession.setAttribute("message", "information updated");
		}else{
			HttpSession customerSession = request.getSession();
			customerSession.setAttribute("color", "red");
			customerSession.setAttribute("message", "information NOT updated");
		}
		
		response.sendRedirect("account.jsp");
		
	}

}
