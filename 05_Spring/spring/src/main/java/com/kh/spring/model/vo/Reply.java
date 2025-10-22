package com.kh.spring.model.vo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Reply {
    private int replyNo;
    private String replyContent;
    private int refBoardNo;
    private int replyWriter;
    private String createDate;
    private String status;

    private String memberId;
}

