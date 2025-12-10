package com.kh.board.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "MEMBER")
@Builder
@Entity
public class Member {

    @Id
    @Column(length = 255)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String nickname;

    @CreationTimestamp
    @Column(name ="create_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    /*
    * member : board = 1 : N 관계 (회원 한명은 여러개의 게시글을 작성 가능)
    * mappedBy : "member" -> Board 엔티티의 "MEMBER" 필드의 주인
    * cascade : CascadeType.ALL -> 회원 삭제시 관련 게시글을 모두 삭제
    * */

    //member는 board를 여러개 가질 수 있는 1대다 이기 때문에 생성될때 기본값으로 설정
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    // 1대다의 주인은 member이기 때문에 mappedBy를 사용해 주인 지정(연관관계 주인), member 지우면 board를 전부 지워라
    private List<Board> boards = new ArrayList<>();
}
