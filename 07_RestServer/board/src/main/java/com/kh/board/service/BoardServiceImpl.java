package com.kh.board.service;

import com.kh.board.entity.Board;
import com.kh.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

//    public BoardServiceImpl(BoardMapper boardMapper) {
//        this.boardMapper = boardMapper;
//    }

    @Override
    public List<Board> findAll() {
        return boardMapper.findAll();
    }
}
