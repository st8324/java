package kr.kh.app.service;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	MemberVO getMember(LoginDTO loginDto);

	String checkId(String id);

}
