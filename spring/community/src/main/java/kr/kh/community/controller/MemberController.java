package kr.kh.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.community.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;

	@RequestMapping("/regist")
	public String regist() {
		return "/member/regist";
	}
	@RequestMapping("/list")
	public String list() {
		return "/member/list";
	}
	@RequestMapping("/update")
	public String update() {
		return "/member/update";
	}
	@RequestMapping("/delete")
	public String delete() {
		return "/member/delete";
	}
}
