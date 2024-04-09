package kr.kh.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.sample.dao.MemberDAO;
import kr.kh.sample.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	private BCryptPasswordEncoder passwordEncoder;
	
	private MemberDAO memberDao;
	
	@Autowired
	public MemberServiceImp(
			BCryptPasswordEncoder passwordEncoder, 
			MemberDAO memberDao) {
		this.passwordEncoder = passwordEncoder;
		this.memberDao = memberDao;
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user == null)
			return null;
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw()))
			return user;
		return null;
	}
}
