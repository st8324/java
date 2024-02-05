package db.mybatis.service;

import java.util.ArrayList;

import db.mybatis.model.vo.MemberVO;

public interface MemberService {

	boolean insertMember(MemberVO member);

	ArrayList<MemberVO> getMemberList();

}
