package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberDAO {

	int selectMemberCount();

	MemberVO selectMember(@Param("id")String id);

	boolean insertMember(MemberVO member);

}
