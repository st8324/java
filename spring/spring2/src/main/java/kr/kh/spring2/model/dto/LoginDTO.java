package kr.kh.spring2.model.dto;

import lombok.Data;

@Data
public class LoginDTO {
	private String id;
	private String pw;
	
	public String getIdPw() {
		return id + ", " + pw;
	}
}
