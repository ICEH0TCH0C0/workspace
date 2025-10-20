package com.kh.mybatis.controller.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/search.bo")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition"); //제목, 작성자, 내용
		String keyword = request.getParameter("keyword"); //검색어
		
		//-------------------페이징 처리-----------------------------
		int currentPage = request.getParameter("cpage") != null ? 
							Integer.parseInt(request.getParameter("cpage")) : 1; //지금 보여줄 페이지(사용자가 요청한 페이지)
		
		HashMap<String, String> searchMap = new HashMap<>();
		searchMap.put("keyword", keyword);
		searchMap.put("condition", condition);
		
		int listCount = new BoardService().selectAllBoardCount(searchMap);//검색된 총 게시글 수
		
		PageInfo pi = new PageInfo(currentPage, listCount, 5, 5);
		
		ArrayList<Board> list = new BoardService().selectAllBoard(pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("views/board/listView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
