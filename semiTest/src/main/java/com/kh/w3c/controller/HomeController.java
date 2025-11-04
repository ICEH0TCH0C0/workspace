package com.kh.w3c.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //응답을 받아 index로 return
    //application.properties에서 .jsp로 했기 때문에 View 파일명만 적어도 알아서 맵핑.
    @RequestMapping("/")
    public String Home(){
        return "index"; // WEB-INF/views/index.jsp
    }
}