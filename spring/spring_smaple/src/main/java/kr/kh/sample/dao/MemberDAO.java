package kr.kh.sample.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.sample.model.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(@Param("me_id")String me_id);

}
