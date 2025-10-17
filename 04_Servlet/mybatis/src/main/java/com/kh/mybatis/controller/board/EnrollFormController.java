package com.kh.mybatis.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import com.kh.mybatis.model.vo.Category;
import com.kh.mybatis.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/enrollForm.bo")
public class EnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EnrollFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Category> categories = new BoardService().selectAllCategory();
		
		request.setAttribute("categories", categories);
		
		request.getRequestDispatcher("views/board/enrollForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}