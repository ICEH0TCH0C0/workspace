package com.kh.jsp.controller.board;

import java.io.IOException;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/insert.bo")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		// 1. 로그인 상태 확인
		if(loginMember == null) {
			session.setAttribute("alertMsg", "로그인 후 이용해주세요.");
			response.sendRedirect(request.getContextPath()+"/list.bo"); 
			return;
		}
		
		// 2. DB에 기록할 데이터 추출
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String boardWriter = String.valueOf(loginMember.getMemberNo());
		
		// 3. Board VO 객체 생성
		Board b = Board.builder()
					   .boardType(1) // 일반 게시글 타입만 가능 -> 나중에 파일타입 추가
					   .categoryNo(category)
					   .boardTitle(title)
					   .boardContent(content)
					   .boardWriter(boardWriter)
					   .build();
		
		// 4. Service로 요청 전달 및 결과 받기
		int result = new BoardService().insertBoard(b);
		
		// 5. 결과에 따른 응답 처리
		if(result > 0) { // 성공
			session.setAttribute("alertMsg", "게시글이 성공적으로 등록되었습니다.");
			response.sendRedirect(request.getContextPath() + "/list.bo");
		} else { // 실패
			request.setAttribute("errorMsg", "게시글 등록에 실패했습니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}