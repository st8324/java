package kr.kh.app.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //기본 생성자(매개변수가 없는 생성자)
public class MemberVO {

	private String me_id; 
	private String me_ms_state; 
	private String me_pw; 
	private String me_email;
	private String me_authority; 
	private Date me_stop; 
	private int me_fail;
	
	public MemberVO(String me_id, String me_pw, String me_email) {
		this.me_id = me_id;
		this.me_pw = me_pw;
		this.me_email = me_email;
	}
}
