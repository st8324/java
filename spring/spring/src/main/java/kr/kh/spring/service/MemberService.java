package kr.kh.spring.service;

import kr.kh.spring.model.dto.LoginDTO;
import kr.kh.spring.model.vo.MemberVO;

public interface MemberService {

	boolean insertMember(MemberVO member);

	MemberVO login(LoginDTO loginDto);

	boolean idCheck(String id);

	boolean findPw(String id);

}
