package kr.kh.spring3.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring3.model.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");//1
		if(user == null) {
			return;
		}
		request.getSession().setAttribute("user", user);//2
		/* 1번에 있는 문자열 user와 2번에 있는 문자열 user는 같아야한다(X)
		 *  - 1번 user는 컨트롤러에서 보낸 user와 맞춰야 함
		 *  - 2번 user는 화면에서 세션에 있는 정보를 사용할 때 user와 맞춰야 함
		 * */
	}
	
}