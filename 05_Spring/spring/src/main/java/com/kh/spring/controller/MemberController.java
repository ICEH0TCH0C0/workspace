package com.kh.spring.controller;

import com.kh.spring.model.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

//Bean에 클래스 등록하는 방법 @Component를 클래스에 부여
//@Controller -> @Component + Controller 객체가 가질 수 있는 예외처리등의 기능을 포함하는 어노테이션
@Controller
public class MemberController {
    
    /*
    *   Spring에서 클라이언트가 보낸 정보를 받는 방법(Form 데이터)
    *   1. HttpServletRequest를 활용해서 전달값을 가져옴.
    *       메서드에 매개변수로 HttpServletRequest를 작성해주면
    *       스프링 컨테이너가 해당 메서드를 호출할 때 자동으로 매개변수로 주입
    * */
    
//  이 방식은 잘 사용하지 않음
//    @PostMapping("login.me")
//    public String login(HttpServletRequest request, HttpServletResponse response){
//        String id =  request.getParameter("id");
//        String pw = request.getParameter("pw");
//        System.out.println(id);
//        System.out.println(pw);
//
//        return null;
//    }

    /*
    *   2. @RequestParam 언노테이션을 활용하는 방법
    *       request.getParameter로 value를 추출하는 역할을 대신 해주는 어노테이션
    *       요청 parameter의 key값과 동일하게 매개변수명으로
    * */

//    DispatcherServlet가 request에서 userId, userPwd를 꺼낸다.
//    @PostMapping("login.me")
//    public String login(@RequestParam(value = "userId", defaultValue = "user01") String userId, String userPwd){
//        System.out.println(id);
//        System.out.println(pw);
//
//        return null;
//    }

    @PostMapping("login.me")
    public String login(Member member){
        System.out.print(member);

        return null;
    }
}

