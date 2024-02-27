package kr.kh.app.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	private int bo_num; 
	private int bo_co_num; 
	private String bo_me_id; 
	private String bo_title; 
	private String bo_content; 
	private int bo_view; 
	private int bo_report_count;
	private CommunityVO community;
	
	public BoardVO(String title, String content, String writer, int co_num) {
		this.bo_title = title;
		this.bo_content = content;
		this.bo_me_id = writer;
		this.bo_co_num = co_num;
	}
}
