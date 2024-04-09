package kr.kh.sample.service;

import org.springframework.stereotype.Service;

import kr.kh.sample.dao.MemberDAO;

@Service
public class MemberServiceImp implements MemberService {

	private MemberDAO memberDao;
	
	public MemberServiceImp(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
}
