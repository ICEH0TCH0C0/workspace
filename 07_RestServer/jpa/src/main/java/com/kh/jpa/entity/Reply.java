package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "REPLY")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    @Column(name = "REPLY_CONTENT", nullable = false, length = 400)
    private String replyContent;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "REF_BNO", nullable = false)
    private Board boardId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "REPLY_WRITER", nullable = false)
    private Member replyWriter;

    @CreationTimestamp
    @Column(name = "CREATE_DATE", nullable = false)
    private LocalDateTime replyDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 1)
    private Status replyStatus = Status.Y;
}
