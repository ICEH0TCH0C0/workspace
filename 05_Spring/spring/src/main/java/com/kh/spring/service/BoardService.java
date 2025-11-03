package com.kh.spring.service;

import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.PageInfo;

import java.util.ArrayList;
import java.util.List;

public interface BoardService {
    ArrayList<Board> selectAllBoard();
    ArrayList<Board> selectAllBoard(PageInfo pageInfo);
    int selectAllBoardCount();
    List<Category> getCategorys();
    int insertBoard(Board board);
}
