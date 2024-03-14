package kr.kh.test.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	int bo_num;
	String bo_title;
	String bo_content;
	String bo_me_id;
}
