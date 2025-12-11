package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "NOTICE")
public class Notice {

    @Id
    @Column(name = "NOTICE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeNo;

    @Column(name = "NOTICE_TITLE", length = 30, nullable = false)
    private String noticeTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NOTICE_WRITER", nullable = false)
    private Member noticeWriter;

    @Column(name = "NOTICE_CONTENT", length = 200, nullable = false)
    private String noticeContent;

    @CreationTimestamp
    @Column(name = "CREATE_DATE")
    private LocalDateTime createdAt;
}
