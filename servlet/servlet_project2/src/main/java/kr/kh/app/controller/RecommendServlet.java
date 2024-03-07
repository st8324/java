package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/recommend")
public class RecommendServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	private BoardService boardService = new BoardServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//화면에서 보낸 게시글 번호를 가져옴
			int boNum = Integer.parseInt(request.getParameter("boNum"));
			//화면에서 보낸 추천 상태를 가져옴
			int state = Integer.parseInt(request.getParameter("state"));
			
			//회원 정보를 가져옴
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			
			//게시글 번호, 추천상태, 회원 정보를 주면서 추천하라고 시킨 후 결과를 알려달라고 함
			int res = boardService.recommend(boNum, state, user.getMe_id());
			response.getWriter().write(""+res);
		}catch(Exception e) {
			
			response.getWriter().write("추천할 수 없습니다.");
		}
		
	}
}
