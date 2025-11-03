package com.kh.spring.service;

import com.kh.spring.model.mapper.BoardMapper;
import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Category> getCategorys() {
        return boardMapper.getCategorys();
    }

    @Override
    public int insertBoard(Board board) {
        return boardMapper.insertBoard();
    }
}
