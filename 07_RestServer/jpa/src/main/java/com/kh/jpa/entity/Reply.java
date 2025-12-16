package com.kh.jpa.entity;

import com.kh.jpa.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "REPLY")
@EntityListeners(AuditingEntityListener.class) // Auditing 자동으로 값을 맵핑
public class Reply extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_NO")
    private Long replyNo;

    @Column(name = "REPLY_CONTENT", nullable = false, length = 400)
    private String replyContent;

    //댓글 : 게시글 (N : 1) - 연관관계 주인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REF_BNO", nullable = false)
    private Board boardId;

    //댓글 : 작성자 (N : 1) - 연관관계 주인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REPLY_WRITER", nullable = false)
    private Member replyWriter;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 1)
    @Builder.Default
    private Status replyStatus = Status.Y;
}
