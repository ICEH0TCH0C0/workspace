package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.core.metrics.StartupStep;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "BOARD_TAG")
//@IdClass(BoardTagId.class)
public class BoardTag {

//    @Id
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "BOARD_NO")
//    private Board boardNo;
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "TAG_ID")
//    private Tag tagId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_TAG_ID")
    private Long boardTagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_NO")
    private Board boardNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID")
    private Tag tagId;

    public void changeBoard(Board board) {
        this.boardNo = board;
    }
}