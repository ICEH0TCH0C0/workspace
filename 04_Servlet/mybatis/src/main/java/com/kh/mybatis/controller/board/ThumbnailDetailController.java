package com.kh.mybatis.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import com.kh.mybatis.model.vo.Attachment;
import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detail.th")
public class ThumbnailDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThumbnailDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		BoardService boardService = new BoardService();
		
		//board의 조회수 1 증가
		int result = boardService.increaseCount(boardNo);
		Board board = boardService.selectBoardByBoardNo(boardNo);
		
		System.out.println(boardNo);
		System.out.println(board);
		if(result > 0 && board != null) {
			//at조회 -> request담기
			ArrayList<Attachment> list = boardService.selectAttachmentList(board.getBoardNo());
			
			request.setAttribute("board", board);
			request.setAttribute("atList", list);
			
			request.getRequestDispatcher("views/board/thumbnailDetailView.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "정상적인 접근이 아닙니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}