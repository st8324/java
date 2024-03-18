package kr.kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.dto.LoginDTO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "/main/home";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {

		return "/member/signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(Model model,MemberVO member) {
		if(memberService.insertMember(member)) {
			model.addAttribute("msg", "회원가입을 완료했습니다");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "회원가입을 하지 못했습니다");
			model.addAttribute("url", "/signup");
		}
		return "message";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {

		return "/member/login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Model model, LoginDTO loginDto) {
		MemberVO user = memberService.login(loginDto);

		if(user != null) {
			model.addAttribute("user", user);
			model.addAttribute("msg", "로그인 했습니다");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "로그인 하지 못습니다");
			model.addAttribute("url", "/login");
		}
		return "message";
	}
	@GetMapping(value = "/logout")
	public String logout(Model model, HttpSession session) {
		//로그아웃 => 세션에 회원 정보를 제거
		session.removeAttribute("user");
		
		model.addAttribute("msg", "로그아웃 했습니다.");
		model.addAttribute("url", "/");
		return "message";
	}
}
