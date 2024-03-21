package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String login(Model model, HttpServletRequest request) {
		//login 페이지로 넘어오기 이전 경로를 가져옴
		String url = request.getHeader("Referer");
		//이전 url에 login이 들어가 있는 경우를 제외
		if(url != null && !url.contains("login")) {
			request.getSession().setAttribute("prevUrl", url);
		}
		return "/member/login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Model model, LoginDTO loginDto) {
		MemberVO user = memberService.login(loginDto);
		
		if(user != null) {
			user.setAutoLogin(loginDto.isAutoLogin());
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
		//DB에서 cookie정보를 삭제
		MemberVO user = (MemberVO)session.getAttribute("user");
		user.setMe_cookie(null);
		user.setMe_cookie_limit(null);
		memberService.updateMemberCookie(user);
		
		//로그아웃 => 세션에 회원 정보를 제거
		session.removeAttribute("user");
		model.addAttribute("msg", "로그아웃 했습니다.");
		model.addAttribute("url", "/");
		return "message";
	}
	@ResponseBody
	@GetMapping("/id/check/dup")
	public Map<String, Object> idCheckDup(@RequestParam("id") String id){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = memberService.idCheck(id);
		map.put("result", res);
		return map;
	}
	
	@GetMapping("/find/pw")
	public String findPw() {
		
		return "/member/findpw";
	}
	@ResponseBody
	@PostMapping("/find/pw")
	public Map<String, Object> findPwPost(@RequestParam("id") String id){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = memberService.findPw(id);
		map.put("result", res);
		return map;
	}
	@GetMapping("/mypage")
	public String mypage() {
		
		return "/member/mypage";
	}
	
	@ResponseBody
	@PostMapping("/check/pw")
	public Map<String, Object> checkPw(@RequestParam("pw") String pw,
			HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = memberService.pwCheck(pw, user);
		map.put("result", res);
		return map;
	}
	@PostMapping("/mypage")
	public String mypagePost(Model model, MemberVO member, HttpSession session) {
		System.out.println(member);
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = memberService.updateMember(member, user);
		if(res) {
			model.addAttribute("msg", "회원 정보를 수정했습니다.");
			model.addAttribute("url", "/mypage");
		}else {
			model.addAttribute("msg", "회원 정보를 수정하지 못했습니다.");
			model.addAttribute("url", "/mypage");
		}
		//세션에 회원 정보 수정
		session.setAttribute("user", user);
		return "message";
	}
}
