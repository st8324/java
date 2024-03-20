package kr.kh.spring.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecommendVO {

	int re_num; 
	String re_me_id; 
	int re_bo_num; 
	int re_state;
	public RecommendVO(int bo_num, String me_id) {
		re_bo_num = bo_num;
		re_me_id = me_id;
	}
}
