package com.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/confirmPizza.do")
public class PizzaOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PizzaOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		
        String pizza = request.getParameter("pizza");
        String[] toppingArr = request.getParameterValues("topping");
        String[] sideArr = request.getParameterValues("side");
        String payment = request.getParameter("payment");
        
        int priceTotal = 0;
        
        switch (pizza) {
		case "콤비네이션": {
			priceTotal += 20000;
			break;
			}
		case "포테이토피자": {
				priceTotal += 23000;
				break;
			}
		case "고구마피자": {
				priceTotal += 25000;
				break;
			}
		case "치즈피자": {
				priceTotal += 23000;
				break;
			}
		case "하와이안피자": {
				priceTotal += 25000;
				break;
			}
        }
		        
        if(toppingArr != null) {
			for(String topping : toppingArr) {
				switch(topping) {
				case "베이컨":
				case "파인애플" : priceTotal += 3000; break;
				case "치즈크러스트":
				case "치즈바이트": priceTotal += 2000; break;
				default: priceTotal += 1000;
				}
			}
		}
		
		if(sideArr != null) {
			for(String side : sideArr) {
				switch(side) {
				case "콜라":
				case "사이다" : priceTotal += 3000; break;
				case "핫소스":
				case "파마산": priceTotal += 2000; break;
				default: priceTotal += 1000;
				}
			}
		}

		request.setAttribute("userName", userName);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		
		request.setAttribute("pizza", pizza);
		request.setAttribute("topping", toppingArr);
		request.setAttribute("side", sideArr);
		request.setAttribute("payment", payment);
		
		request.setAttribute("priceTotal", priceTotal);
		
		RequestDispatcher view = request.getRequestDispatcher("views/pizza/pizzaPayment.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}