package com.kh.spring.service;

import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.PageInfo;

import java.util.ArrayList;

public interface BoardService {
    ArrayList<Board> selectAllBoard();
    ArrayList<Board> selectAllBoard(PageInfo pageInfo);
    int selectAllBoardCount();
}
