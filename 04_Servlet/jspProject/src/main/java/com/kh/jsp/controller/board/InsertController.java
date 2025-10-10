package com.kh.jsp.controller.board;

import java.io.IOException;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/insert.bo")
@MultipartConfig
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
			response.sendRedirect(request.getContextPath()); 
			return;
		}
		
		// 2. DB에 기록할 데이터 추출
		int categoryNo = Integer.parseInt(request.getParameter("category"));
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String boardWriter = String.valueOf(loginMember.getMemberNo()); // DB에는 NUMBER 타입으로 저장되지만, VO 필드는 String
		Part upfile = request.getPart("upfile");

		// 3. Board VO 객체 생성
		Board b = new Board();
		b.setBoardTitle(title);
		b.setBoardContent(content);
		// 파일이 있고 크기가 0보다 클 경우 2, 없거고 파일 크기가 0보다 작거나 같을 경우 1
		b.setBoardType(upfile != null && upfile.getSize() > 0 ? 2 : 1); 
		b.setBoardWriter(boardWriter); // 작성자 회원 번호를 String으로 설정
		
		// 4. Service로 요청 전달 및 결과 받기
		Boolean insertcheck = new BoardService().insertBoard(b, categoryNo, upfile);
		
		// 5. 결과에 따른 응답 처리
		if(insertcheck) { // 성공
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