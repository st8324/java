package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.kh.app.model.vo.MemberVO;

@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글은 회원만 작성 가능하기 때문에 아래 작업을 진행
		//로그인한 회원 정보를 가져옴 => 세션에서 user 정보를 가져옴  
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		//MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//회원정보가 없으면 게시글 리스트로 이동
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/board/list");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
