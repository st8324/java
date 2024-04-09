package kr.kh.sample.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.sample.model.vo.MemberVO;
import kr.kh.sample.service.MemberService;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	
	@Autowired
	MemberService memberService;
	
	//컨트롤러에서 디스패처서블릿으로 가기전 작업할 내용 : 컨트롤러 실행 후 동작
	//로그인
	@Override
	public void postHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler, 
		ModelAndView modelAndView)
		throws Exception {
		//ModelAndView 객체에서 model 객체에 넣어준 user를 가져오는 코드
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");

		//회원 정보가 있으면
		if(user != null) {
			//세션에 회원 정보를 추가
			request.getSession().setAttribute("user", user);
		}
	}
}
