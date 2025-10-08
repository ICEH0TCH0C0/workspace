package com.kh.jsp.controller.board;

import java.io.IOException;

import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete.bo")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		// 1. 로그인 확인
		if(loginMember == null) {
			session.setAttribute("alertMsg", "로그인 후 이용해주세요.");
			response.sendRedirect(request.getContextPath()); 
			return;
		}
		
		// 2. 삭제할 게시글 번호 추출
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		// 3. Service로 요청 전달 및 결과 받기
		int result = new BoardService().deleteBoard(boardNo);
		
		// 4. 결과에 따른 응답 처리
		if(result > 0) { // 성공
			session.setAttribute("alertMsg", "게시글이 성공적으로 삭제되었습니다.");
			response.sendRedirect(request.getContextPath() + "/list.bo");
		} else { // 실패
			request.setAttribute("errorMsg", "게시글 삭제에 실패했습니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}