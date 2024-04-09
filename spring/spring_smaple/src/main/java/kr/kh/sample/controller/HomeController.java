package kr.kh.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.sample.service.MemberService;

@Controller
public class HomeController {
	
	private MemberService memberService;
	
	@Autowired
	public HomeController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/")
	public String home() {
		
		return "/main/home";
	}
	
	
}
