package com.kh.jsp.controller.member;

import java.io.IOException;

import com.kh.jsp.model.vo.Member;
import com.kh.jsp.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert.me")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//member 추가
		
		
		//전달받은 데이터를 추출
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone"); // "010~" || ""
		String email = request.getParameter("email");  // "~~" || ""
		String address = request.getParameter("address"); // "~~" || ""
		String[] interestArr = request.getParameterValues("interest"); // ["sports...] || null
		
		//String[] -> string
		String interest = "";
		if(interestArr != null) {
			interest = String.join(",", interestArr);
		}
		
		Member m = Member.insertCreateMember(userId, userPwd, userName, phone, email, address, interest);
		
		int result = new MemberService().insertMember(m);

		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 회원가입하였습니다.");
			response.sendRedirect(request.getContextPath()); //ContextPath.request.contextPath와 동일(/jsp)
		} else {
			request.setAttribute("errorLog", "회원가입이 실패되었습니다.");
			request.getRequestDispatcher("views/common/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}