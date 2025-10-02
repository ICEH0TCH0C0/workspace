package com.kh.el.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.kh.el.model.vo.Person;

/**
 * Servlet implementation class ElOperationServlet
 */
@WebServlet("/operation.do")
public class ElOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ElOperationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("big", 10);
		request.setAttribute("small", 3);
		
		request.setAttribute("strOne", "");
		request.setAttribute("strTwo", "");
		request.setAttribute("strThree", "hello");
		
		request.setAttribute("PersonOne", new Person("", 20, ""));
		request.setAttribute("PersonTwo", null);
		
		ArrayList<String> list1 = new ArrayList<>();
		request.setAttribute("arrOne", list1);
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("점심 뭐 먹을까");
		request.setAttribute("arrTwo", list2);
		
		request.getRequestDispatcher("views/02_el_operation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
