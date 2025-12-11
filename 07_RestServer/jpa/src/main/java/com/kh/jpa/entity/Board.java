package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long boardId;

    @Column(name = "BOARD_TITLE", length = 100, nullable = false)
    private String boardTitle;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
    private int boardCount = 0;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createdAt;

    @Column(name = "STATUS", length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status boardStatus = Status.Y;
}
