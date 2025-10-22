package com.kh.spring.controller;

import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.PageInfo;
import com.kh.spring.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @GetMapping("list.bo")
    public String listPage(Model model, HttpServletRequest request) {

        //-------------------페이징 처리-----------------------------
        int currentPage = request.getParameter("cpage") != null ?
                Integer.parseInt(request.getParameter("cpage")) : 1; //지금 보여줄 페이지(사용자가 요청한 페이지)
        int listCount = boardService.selectAllBoardCount();//현재 총 게시글 수

        PageInfo pi = new PageInfo(currentPage, listCount, 5, 5);
        model.addAttribute("pi", pi);

        ArrayList<Board> list  = boardService.selectAllBoard(pi);
        model.addAttribute("list", list);

        return "board/listView";
    }
}
