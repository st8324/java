package kr.kh.spring.service;

import kr.kh.spring.model.dto.LoginDTO;
import kr.kh.spring.model.vo.MemberVO;

public interface MemberService {

	boolean insertMember(MemberVO member);

	MemberVO login(LoginDTO loginDto);

	boolean idCheck(String id);

	boolean findPw(String id);

	boolean pwCheck(String pw, MemberVO user);

	boolean updateMember(MemberVO member, MemberVO user);

	void updateMemberCookie(MemberVO user);

	MemberVO getMemberByCookie(String sessionId);

	boolean idCheck(String sns, String id);

	boolean signupSns(String sns, String id, String email);

	MemberVO loginSns(String sns, String id);

}
