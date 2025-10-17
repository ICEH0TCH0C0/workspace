package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kh.jsp.service.BoardService;

@WebServlet("/rdelete.bo")
public class AjaxReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxReplyDeleteController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		
		int result = new BoardService().deleteReply(replyNo);
		
		response.getWriter().print(result);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
