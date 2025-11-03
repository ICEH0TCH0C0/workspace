package com.kh.spring.model.mapper;

import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface BoardMapper {
    ArrayList<Board> selectAllBoard();
    ArrayList<Board> selectAllBoard(RowBounds rowBounds);
    int selectAllBoardCount();
    List<Category> getCategorys();
    int insertBoard(Board board);
}
