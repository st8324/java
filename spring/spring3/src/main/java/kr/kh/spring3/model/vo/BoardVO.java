package kr.kh.spring3.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	int bo_num; 
	int bo_co_num; 
	String bo_me_id; 
	String bo_title; 
	String bo_content; 
	int bo_view;
	int bo_report_count;
}
