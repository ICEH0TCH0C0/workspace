package com.kh.jpa.repository;

import com.kh.jpa.entity.Board;
import com.kh.jpa.entity.Member;
import com.kh.jpa.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardJPARepository extends JpaRepository<Board, Long> {

    //상태값을 통한 게시글 조회
    Page<Board> findByBoardStatus(Status boardStatus, Pageable pageable);

    //작성자로 게시글 조회
    // *** 키가 아닌 객체 자체를 넣어야 함.
    List<Board> findBuMember(Member member);
    
    //작성자의 아이디로 조회
    //참조 객체의 아이디 값을 넣어야 함.
    List<Board> findByMemberUserId(String userId);

    //제목 또는 내용으로 게시글 검색
    List<Board> findByBoardTitleContainingOrBoardContentContaining(String title, String content);

    //조회수가 높은 순으로 게시글 조회
    List<Board> findByOrderByBoardCountDesc();

    //특정 작성자의 활성 게시글 조회(페이징) -> JPQL
    @Query("SELECT b FROM Board b WHERE b.boardStatus == 'Y' AND b.boardWriter.userId = :userId")
    Page<Board> findByBoardStatusAndBoardWriter(@Param("userId") List<Board> board, Pageable pageable);

    //특정 태그를 가진 게시글 조회
    @Query("SELECT distinct b FROM Board b " +
            "Join b.boardTags bt " +
            "Join bt.tagId t " +
            "WHERE t.tagName = :tagName and b.boardStatus = 'Y'")
    List<Board> findByBoardTags(@Param("tagName") String tagName);
}
