package kr.kh.app.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentVO {
	private int cm_num; 
	private int cm_bo_num; 
	private String cm_me_id; 
	private String cm_content;

	public CommentVO(int bo_num, String content, String me_id) {
		cm_bo_num = bo_num;
		cm_content = content;
		cm_me_id = me_id;
	}
}
