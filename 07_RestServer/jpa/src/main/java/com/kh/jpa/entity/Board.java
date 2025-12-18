package com.kh.jpa.entity;

import com.kh.jpa.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "BOARD")
@Builder
@EntityListeners(AuditingEntityListener.class) // Auditing 자동으로 값을 맵핑
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_NO")
    private Long boardNo;

    @Column(name = "BOARD_TITLE", length = 100, nullable = false)
    private String boardTitle;

    //게시글 : 회원 (1 : N) -> 연관관계 주인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_WRITER", nullable = false)
    private Member boardWriter;

    @Column(name = "BOARD_CONTENT", nullable = false)
    @Lob
    private String boardContent;

    @Column(name = "ORIGIN_NAME")
    private String boardOriginName;

    @Column(name = "CHANGE_NAME")
    private String boardChangeName;

    @Column(name = "COUNT")
    @Builder.Default
    //@Builder.Default : 빌드패턴으로 객체 생성시 count 값이 없다면, 기본값을 사용한다.
    private Integer boardCount = 0;

    @Column(name = "CREATE_DATE")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "STATUS", length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status boardStatus = Status.Y;

    @OneToMany(mappedBy = "boardId", fetch = FetchType.LAZY)
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "boardNo", fetch = FetchType.LAZY)
    private List<BoardTag> boardTags = new ArrayList<>();

    public void changeMember(Member member) {
        this.boardWriter = member;

        if(!member.getBoards().contains(this))
            member.getBoards().add(this);
    }

    public void changeFile(String originName, String changeName) {
        if(originName != null) this.boardOriginName = originName;
        if(changeName != null) this.boardChangeName = changeName;
    }

    public void addTag(Tag tag){
        BoardTag boardTag = BoardTag.builder()
                .tagId(tag)
                .build();

        boardTag.changeBoard(this);
        this.boardTags.add(boardTag);
    }
}
