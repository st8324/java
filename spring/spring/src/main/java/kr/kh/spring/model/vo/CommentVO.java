package kr.kh.spring.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentVO {
	private int cm_num; 
	private int cm_bo_num; 
	private String cm_me_id; 
	private String cm_content;

	public CommentVO(int cm_bo_num, String cm_me_id, String cm_content) {
		this.cm_bo_num = cm_bo_num;
		this.cm_me_id = cm_me_id;
		this.cm_content = cm_content;
	}
	
	
}
