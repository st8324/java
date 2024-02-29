package kr.kh.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import kr.kh.app.model.vo.MemberVO;

//로그인한 회원만 접근할 수 있는 URL에서 동작하는 필터
@WebFilter({"/board/insert","/board/update","/board/delete"})
public class MemberFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = -5262224032098686359L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//회원 정보를 가져옴
		MemberVO user = 
			(MemberVO)((HttpServletRequest)request).getSession().getAttribute("user");
		//회원 정보가 없으면 로그인이 필요한 서비스입니다라고 알림 후 로그인페이지로 이동
		if(user == null) {
			request.setAttribute("msg", "로그인이 필요한 서비스입니다");
			request.setAttribute("url", "login");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
			return;
		}
		//있으면 하려던 작업을 수행
		chain.doFilter(request, response);
	}
}
