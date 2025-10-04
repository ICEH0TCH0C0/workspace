package com.kh.jsp.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Board {
    private int boardNo;
    private int boardType;
    private String categoryNo; 
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private int count;
    private Date createDate;
    private String status;

    // listView.jsp에서 JOIN을 통해 가져올 추가 데이터
    private String categoryName;

	public static Board insertBoard(String boardTitle, String boardContent, String categoryName) {
		Board b = new Board();
		
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		b.setCategoryName(categoryName);
		
		return b;
	}
    
    
}