package com.kh.mybatis.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reply {
	private int replyNo;
	private String replyContent;
	private int refBoardNo;
	private int replyWriter;
	private String createDate;
	private String status;
	
	private String memberId;
}
