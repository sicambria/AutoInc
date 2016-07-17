package com.autoinc.buffalo.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.autoinc.buffalo.bpelorder.OrderProcessServiceStub;
import com.autoinc.buffalo.bpelorder.OrderProcessServiceStub.OrderProcessRequest;
import com.autoinc.buffalo.bpelorder.OrderProcessServiceStub.OrderProcessResponse;
import com.autoinc.buffalo.model.CustomerClass;
import com.autoinc.buffalo.model.CustomerObject;
import com.autoinc.buffalo.model.OrderClass;
import com.autoinc.buffalo.model.OrderObject;
import com.autoinc.buffalo.model.PaymentInformationClass;
import com.autoinc.buffalo.model.PaymentInformationObject;

public class ReceiveOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//take all the order parameters
		String email = request.getParameter("email");
		String model = request.getParameter("model");
		String edition = request.getParameter("edition");
		String color = request.getParameter("color");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		//calculate total price
		int unitPrice = 0;
		if(model.equalsIgnoreCase("family")){
			unitPrice = 10000;
		}
		if(model.equalsIgnoreCase("sport")){
			unitPrice = 25000;
		}
		if(model.equalsIgnoreCase("smart")){
			unitPrice = 15000;
		}
		//add 3500 if edition is comfortable
		if (edition.equalsIgnoreCase("comfort")) {
			unitPrice = unitPrice + 3500;
		}
		
		//calculate quantity and set status
		int amount = unitPrice * quantity;
		String status = "initialized";
		
		//use email address to find customer class
		int customerId =0;
		try {
			customerId = CustomerClass.getCustomerIDbyCustomerEmail(email);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//if customer_id = 0, then the email address doesn't exist, so we return unsuccesful!
		if(customerId == 0 || amount<0 || quantity<100 || quantity>10000){
			HttpSession customerSession = request.getSession();
			customerSession.setAttribute("color", "red");
			customerSession.setAttribute("message", "something went wrong!");
			response.sendRedirect("index.jsp");
		}else{
			try {
				int orderId = OrderClass.createOrder(customerId, model, edition, color, quantity, amount, status);
				HttpSession customerSession = request.getSession();
				
				
				//retreive customer object
				CustomerObject customerObject = CustomerClass.getCustomer(email);
				//retreive order object
				OrderObject orderObject = OrderClass.getOrdersObjByOrderId(orderId);
				//retrieve payment information
				PaymentInformationObject paymentInformationObject = PaymentInformationClass.getPaymentInformation(customerId);
				
				//invoke the wsdl
				OrderProcessRequest orderProcessRequest = new OrderProcessRequest();
				
				orderProcessRequest.setCustomerId(customerId);
				orderProcessRequest.setOrderId(orderId);
				orderProcessRequest.setCustomerName(customerObject.getName());
				orderProcessRequest.setAddress(customerObject.getAddress());
				orderProcessRequest.setCountry(customerObject.getCountry());
				orderProcessRequest.setAccountNumber(paymentInformationObject.getAccount_number());
				orderProcessRequest.setBank(paymentInformationObject.getBank());
				orderProcessRequest.setModel(model);
				orderProcessRequest.setColor(color);
				orderProcessRequest.setEdition(edition);
				orderProcessRequest.setQuantity(quantity);
				orderProcessRequest.setAmount(amount);
				
				OrderProcessServiceStub orderProcessServiceStub = new OrderProcessServiceStub();
				OrderProcessResponse orderProcessResponse = new OrderProcessResponse();
				orderProcessResponse = orderProcessServiceStub.process(orderProcessRequest);
				
				//store the information
				OrderClass.updatePostOrderInfo(orderId, orderProcessResponse.getTransactionId(), orderProcessResponse.getDeliveryDate(), orderProcessResponse.getResultPayment(), orderProcessResponse.getResultCheckCars(), orderProcessResponse.getResultManufacturing(), orderProcessResponse.getResult());
				
			    customerSession.setAttribute("color", "green");
			    customerSession.setAttribute("message", "your order was received");
			} catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
				e.printStackTrace();
			}
			response.sendRedirect("index.jsp");
		}
		
		
	}

}
