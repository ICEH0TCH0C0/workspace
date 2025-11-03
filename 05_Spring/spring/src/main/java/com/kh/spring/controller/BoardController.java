package com.kh.spring.controller;

import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.PageInfo;
import com.kh.spring.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/enrollForm.bo")
    public String enrollForm(Model model, HttpServletRequest request) {
        List<Category> categories = boardService.getCategorys();
        model.addAttribute("categories", categories);

        return "board/enrollForm";
    }

    //spring boot에는 spring-boot-starter-web 의존을 추가하면.
    @PostMapping("/insert.bo")
    public String insertBoard(Board board,
                              @RequestParam(value = "upfile", required = false) MultipartFile upfile) {


        int insertBoard = boardService.insertBoard(board);
    }
}
