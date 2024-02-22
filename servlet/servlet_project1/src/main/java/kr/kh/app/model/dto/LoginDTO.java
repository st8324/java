package kr.kh.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//DTO는 주로 화면에서 입력받은 정보를 서버에 전달할 때 사용하기 때문에,
//기본생성자가 없어도 됨(서블릿에서는)
@Data
@AllArgsConstructor
public class LoginDTO {
	private String id;
	private String pw;
	
	
}
