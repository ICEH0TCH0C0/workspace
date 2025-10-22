package com.kh.spring.service;

import com.kh.spring.model.vo.Board;

import java.util.ArrayList;

public interface BoardService {
    ArrayList<Board> selectAllBoard();
}
