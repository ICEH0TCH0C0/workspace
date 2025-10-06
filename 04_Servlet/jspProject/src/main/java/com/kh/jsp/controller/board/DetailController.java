package com.kh.jsp.controller.board;

import java.io.IOException;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detail.bo")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 게시글 번호 추출
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		// 2. BoardService의 selectBoard 메소드 호출 (조회수 증가 + 게시글 조회)
		Board b = new BoardService().selectBoard(boardNo);
		
		// 3. 조회 결과에 따라 응답 페이지 지정
		if(b != null) { // 조회 성공
			// request에 조회된 Board 객체를 "board"라는 키로 담기
			request.setAttribute("board", b);
			// detailView.jsp로 포워딩
			request.getRequestDispatcher("views/board/detailView.jsp").forward(request, response);
		} else { // 조회 실패
			request.setAttribute("errorMsg", "게시글 상세조회에 실패했습니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
