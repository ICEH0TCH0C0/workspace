package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;
import com.kh.jsp.model.vo.Category;

import com.kh.jsp.service.BoardService;
@WebServlet("/updateForm.bo")
public class UpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateFormController() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // BoardService 인스턴스 생성
        BoardService boardService = new BoardService();

        // 1. 수정할 게시글 정보 조회
        int bno = Integer.parseInt(request.getParameter("bno"));
        request.setAttribute("board", boardService.selectUpdateBoard(bno)); // 조회수 증가 없는 메소드 호출
        
        // 2. 카테고리 목록 조회
        List<Category> list = boardService.selectCategory();
        request.setAttribute("categoryList", list);

        request
            .getRequestDispatcher("views/board/updateForm.jsp")
            .forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
