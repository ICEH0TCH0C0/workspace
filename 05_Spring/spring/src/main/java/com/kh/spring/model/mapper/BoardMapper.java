package com.kh.spring.model.mapper;

import com.kh.spring.model.vo.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;

@Mapper
public interface BoardMapper {
    ArrayList<Board> selectAllBoard();
    ArrayList<Board> selectAllBoard(RowBounds rowBounds);
    int selectAllBoardCount();
}
