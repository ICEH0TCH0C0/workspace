package com.kh.jsp.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.MemberService;


@WebServlet("/delete.me")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPwd = request.getParameter("userPwd");
		
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember == null || !loginMember.getMemberPwd().equals(userPwd) || loginMember.getStatus().equals("N")) {
			request.setAttribute("errorMsg", "이미 탈퇴한 회원이거나 정상적인 접근이 아닙니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
			return;
		}
		
		int result = new MemberService().deleteMember(loginMember.getMemberId());
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 회원탈퇴하셨습니다.");
			session.removeAttribute("loginMember");
			response.sendRedirect(request.getContextPath()); //ContextPath.request.contextPath와 동일(/jsp)
		} else {
			request.setAttribute("errorLog", "회원탈퇴를 실패되었습니다.");
			request.getRequestDispatcher("views/common/error.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
