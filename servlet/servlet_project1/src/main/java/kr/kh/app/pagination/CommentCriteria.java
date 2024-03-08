package kr.kh.app.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentCriteria extends Criteria {


	private int boNum;

	public CommentCriteria(int page, int perPageNum, int boNum) {	
		super(page, perPageNum);
		this.boNum = boNum;
	}
}
