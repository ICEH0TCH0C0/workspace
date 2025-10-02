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

@WebServlet("/update.me")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청된 회원정보 -> 정보 수정 -> int -> 성공(mypage), 실패(error)
		String userId = request.getParameter("userId");
		String phone = request.getParameter("phone"); 
		String email = request.getParameter("email");  
		String address = request.getParameter("address"); 
		String[] interestArr = request.getParameterValues("interest"); 
		
		//String[] -> string
		String interest = "";
		if(interestArr != null) {
			interest = String.join(",", interestArr);
		}
		
		Member updateMember = Member.updateCreateMember(userId, phone, email, address, interest);
		updateMember = new MemberService().updateMember(updateMember);
		
		if(updateMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", updateMember);			
			request.setAttribute("alertMsg", "회원정보가 수정하는데 성공하였습니다.");
			response.sendRedirect(request.getContextPath()+"/myPage.me");
			
		} else {
			request.setAttribute("errorMsg", "회원정보를 수정하는데 실패하였습니다.");
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
