package com.kh.mybatis.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/logout.me")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그아웃 -> session에서 loginMember삭제 또는 session 만료
		HttpSession session = request.getSession();
		//session.invalidate(); 세션 만료 -> 세션에 저장된 모든 데이터가 삭제되고 새로운 세션 아이디 부여
		session.removeAttribute("loginMember");
		
		session.setAttribute("alertMsg", "로그아웃 성공하셨습니다.");
		
		response.sendRedirect(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
