package kr.kh.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//화면에서 서버로 전송할 때 인코딩 설정 : UTF-8
		request.setCharacterEncoding("UTF-8");
		//서버에서 화면으로 전송할 때 인코딩 설정 : UTF-8
		response.setCharacterEncoding("UTF-8");
		//다른 필터가 있는 경우 필터 적용을 위한 코드
		chain.doFilter(request, response);
	}

}
