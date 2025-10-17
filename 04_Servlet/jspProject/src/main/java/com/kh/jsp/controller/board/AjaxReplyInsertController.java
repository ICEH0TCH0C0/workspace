package com.kh.jsp.controller.board;

import java.io.IOException;

import com.kh.jsp.model.vo.Member;
import com.kh.jsp.model.vo.Reply;
import com.kh.jsp.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/rinsert.bo")
public class AjaxReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjaxReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//보내준 정보를 받아서 Reply 저장 -> 결과값은 int 그대로 반환
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		int memberNo = loginMember.getMemberNo();
		
		Reply r = new Reply();
		r.setRefBoardNo(boardNo);
		r.setReplyContent(content);
		r.setReplyWriter(memberNo);
		
		int result = new BoardService().insertReply(r);
		response.getWriter().print(result);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
