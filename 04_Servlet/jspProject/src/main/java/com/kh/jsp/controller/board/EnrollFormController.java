package com.kh.jsp.controller.board;

import java.io.IOException;
import java.util.List;

import com.kh.jsp.model.vo.Category;
import com.kh.jsp.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/selectCategory.bo")
public class EnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EnrollFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> list = new BoardService().selectCategory();
		System.out.println(list);
		request.setAttribute("categoryList", list);

		
		request.getRequestDispatcher("views/board/enrollForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
