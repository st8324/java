package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

@WebServlet("/id/check")
public class IdCheckServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	private MemberService memberService = new MemberServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아이디를 가져옴
		String id = request.getParameter("id");
		//아이디와 일치하는 회원 정보 있는지 요청
		boolean res = memberService.checkId(id);
		//결과를 화면에 전송
		response.getWriter().write(""+res);
	}

}
