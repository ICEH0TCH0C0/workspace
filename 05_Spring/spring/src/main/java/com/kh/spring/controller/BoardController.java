package com.kh.spring.controller;

import com.kh.spring.model.vo.Board;
import com.kh.spring.service.BoardService;
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
    public String listPage(Model model) {
        ArrayList<Board> list  = boardService.selectAllBoard();
        model.addAttribute("list", list);

        return "board/listView";
    }
}
