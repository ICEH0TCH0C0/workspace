package com.kh.jsp.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Category {
	private int categoryNo;
	private String categoryName;
	
	
	public static Category selectCategory(int categoryNo, String categoryName) {
		Category c = new Category();
		
		c.setCategoryNo(categoryNo);
		c.setCategoryName(categoryName);
		
		return c;
	}
}
