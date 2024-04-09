package kr.kh.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.sample.model.vo.MemberVO;
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
	
	@GetMapping("/login")
	public String login() {
		
		return "/main/login";
	}
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member) {
		MemberVO user = memberService.login(member);
		model.addAttribute("user", user);
		if(user != null)
			return "redirect:/";
		else
			return "redirect:/login";
	}
	@GetMapping("/sse")
	public String sse() {
		
		return "/ex/sse";
	}
}
