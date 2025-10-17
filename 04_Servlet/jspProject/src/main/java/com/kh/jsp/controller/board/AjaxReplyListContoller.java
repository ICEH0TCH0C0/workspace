package com.kh.jsp.controller.board;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.kh.jsp.model.vo.Reply;
import com.kh.jsp.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/rlist.bo")
public class AjaxReplyListContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxReplyListContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//댓글 목록을 Db에서 추출한 다음 응답
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		ArrayList<Reply> list = new BoardService().selectReplyByBoardNo(boardNo);
		
		//객체가 아니라 문자열로 보내야 하기 때문에 직접 문자열을 작성
//		String res = "{result : [";
//		for(Reply r : list) {
//			res += ("{" + "replyNo : " + r.getReplyNo() + ", "
//					+ "replyContent : \"" + r.getReplyContent() + "\""
//					+ "}");
//		}
//		res += "]}";
//		
//		response.setContentType("application/json; charset=UTF-8");
//		response.getWriter().print(res);
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(list, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
