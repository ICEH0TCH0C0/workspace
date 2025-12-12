package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "BOARD_TAG")
@IdClass(BoardTagId.class)
public class BoardTag {

    @Id
    @ManyToOne(fetch = FetchType.LAZY) // Cascade 제거!
    @JoinColumn(name = "BOARD_NO")
    private Board boardNo; // 변수명을 boardId -> board 로 변경 (객체니까)

    @Id
    @ManyToOne(fetch = FetchType.LAZY) // Cascade 제거!
    @JoinColumn(name = "TAG_ID")
    private Tag tagId;     // 변수명을 tagId -> tag 로 변경
}