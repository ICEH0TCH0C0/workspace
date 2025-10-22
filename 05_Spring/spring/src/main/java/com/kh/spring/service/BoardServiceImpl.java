package com.kh.spring.service;

import com.kh.spring.model.mapper.BoardMapper;
import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public ArrayList<Board> selectAllBoard() {
        return boardMapper.selectAllBoard();
    }

    @Override
    public ArrayList<Board> selectAllBoard(PageInfo pi) {
        int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
        return boardMapper.selectAllBoard(rowBounds);
    }

    @Override
    public int selectAllBoardCount() {
        return boardMapper.selectAllBoardCount();
    }
}
