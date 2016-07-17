package com.autoinc.buffalo.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.autoinc.buffalo.bpelcancel.OrderCancelServiceStub;
import com.autoinc.buffalo.bpelcancel.OrderCancelServiceStub.OrderCancelRequest;
import com.autoinc.buffalo.bpelcancel.OrderCancelServiceStub.OrderCancelResponse;
import com.autoinc.buffalo.model.OrderClass;

/**
 * Servlet implementation class CancelOrderServlet
 */
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//take all the order parameters
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		int transactionId = Integer.parseInt(request.getParameter("transactionId"));
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		
		OrderCancelRequest orderCancelRequest = new OrderCancelRequest();
		orderCancelRequest.setCustomerId(customerId);
		orderCancelRequest.setOrderId(orderId);
		orderCancelRequest.setTransactionId(transactionId);
		
		OrderCancelServiceStub orderCancelServiceStub = new OrderCancelServiceStub();
		OrderCancelResponse orderCancelResponse = new OrderCancelResponse();
		
		orderCancelResponse = orderCancelServiceStub.process(orderCancelRequest);
		
		boolean result = orderCancelResponse.getResultTransaction();
		
		if(result){
			try {
				OrderClass.updateStatus(orderId, "canceled");
				HttpSession customerSession = request.getSession();
				customerSession.setAttribute("color", "green");
				customerSession.setAttribute("message", "order canceled!");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("order.jsp");
		}
	}

}
