package com.kh.jpa.repository;

import com.kh.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JPARepository를 상속받아 기본 CRUD 메서드를 자동으로 제공받을 수 있음
// save(Member m) - 저장
// findById(String id) - id(PK)로 조회
// findAll() - 전체 조회
// delete(Member m) - 삭제
// count() - 개수 조회
// existsById(String id) - 존재 여부(OneToOne 관계에서 역방향 조회)

public interface MemberJPARepository extends JpaRepository<Member, String> {
    List<Member> findByUserNameContaining(String userName);
}
