package com.kh.mybatis.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.vo.Attachment;
import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.model.vo.Category;
import com.kh.mybatis.model.vo.Reply;

public class BoardDao {
	
	public int selectAllBoardCount(SqlSession sqlSession) {
		return sqlSession.selectOne("BoardMapper.selectAllBoardCount");
	}
	
	public int selectAllBoardCount(SqlSession sqlSession, HashMap<String, String> searchMap) {
		return sqlSession.selectOne("BoardMapper.searchBoardCount");
	}
	
	public ArrayList<Board> selectAllBoard(SqlSession sqlSession, PageInfo pi){
		//mybatis에서 자체적으로 페이징 처리를 위해 RowBounds라는 class를 제공
		//offset : 몇개의 게시글을 건너뛰고 조회할 것인가
		//boardLimit : 몇개의 게시글을 가지고 올 것인가
		
		//한페이지 보여줄 boardLimit 10개
		// 1 -> 0개
		// 2 -> 10개 
		// 3 -> 20개
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("BoardMapper.selectAllBoard", null, rowBounds);
		
		return list;
	}
	
	public ArrayList<Board> selectAllBoard(SqlSession sqlSession, PageInfo pi, HashMap<String, String> searchMap){

		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("BoardMapper.searchAllBoard", null, rowBounds);
		
		return list;
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("BoardMapper.increaseCount", boardNo);
	}
	
	public Board selectBoardByBoardNo(SqlSession sqlSession, int boardNo) {
		Board b = sqlSession.selectOne("BoardMapper.selectBoardByBoardNo", boardNo);
		
		return b;
	}
	
	public Attachment selectAttachment(SqlSession sqlSession, int boardNo) {
		Attachment at = sqlSession.selectOne("BoardMapper.selectAttachment", boardNo);
		
		return at;
	}
	
	public ArrayList<Category> selectAllCategory(SqlSession sqlSession) {
		ArrayList<Category> list = (ArrayList)sqlSession.selectList("BoardMapper.selectAllCategory");
		
		return list;
	}
	
	public int insertBoard(SqlSession sqlSession, Board b) {
		return sqlSession.insert("BoardMapper.insertBoard", b);
	}
	
	public int insertAttachment(SqlSession sqlSession, Attachment at) {
		return sqlSession.insert("BoardMapper.insertAttachment", at);
	}
	
	public int insertAttachment(SqlSession sqlSession, ArrayList<Attachment> list) {
		return sqlSession.insert("BoardMapper.insertThumbnailAttachment", list);
	}
	
	public int deleteBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("BoardMapper.deleteBoard", boardNo);
	}
	
	public int updateBoard(SqlSession sqlSession, Board b) {
		return sqlSession.update("BoardMapper.updateBoard", b);
	}
	
	public int updateAttachment(SqlSession sqlSession, Attachment at) {
		return sqlSession.update("BoardMapper.updateAttachment", at);
	}
	
	public int insertNewAttachment(SqlSession sqlSession, Attachment at) {
		return sqlSession.insert("BoardMapper.insertNewAttachment", at);
	}
	
	public ArrayList<Reply> selectReplyByBoardNo(SqlSession sqlSession, int BoardNo) {
		ArrayList<Reply> list = (ArrayList)sqlSession.selectList("BoardMapper.selectReplyByBoardNo", BoardNo);
		
		return list;
	}
	
	public int insertReply(SqlSession sqlSession, Reply r) {
		return sqlSession.insert("BoardMapper.insertReply", r);
	}
	
	public int deleteReply(SqlSession sqlSession, int replyNo) {
		return sqlSession.delete("BoardMapper.deleteReply", replyNo);
	}
	
	public ArrayList<Board> selectThumbnailList(SqlSession sqlSession) {
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("BoardMapper.selectThumbnailList");
		
		return list;
	}
	
	public ArrayList<Attachment> selectAttachmentList (SqlSession sqlSession, int boardNo) {
		ArrayList<Attachment> list = (ArrayList)sqlSession.selectList("BoardMapper.selectAttachmentList", boardNo);
		
		return list;
	}
}
