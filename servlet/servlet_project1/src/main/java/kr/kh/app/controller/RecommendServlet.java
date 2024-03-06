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
		int bo_num = 0, state = 0;
		try {
			//게시글 번호를 가져옴
			bo_num = Integer.parseInt(request.getParameter("boNum"));
			//추천상태(추천인지 비추천인지)를 가져옴
			state = Integer.parseInt(request.getParameter("state"));
		}catch(Exception e){
			e.printStackTrace();
		}

		response.setContentType("text/plain");
		
		//회원 정보를 가져옴
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//서비스에게 게시글번호, 추천상태, 회원정보를 주면서 추천결과를 알려달라고 요청
		//추천 결과(1 : 추천, -1 : 비추천, 0 : 취소)
		try {
			int result = boardService.recommend(bo_num, state, user);
			response.getWriter().write(""+result);
		}catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("추천을 할 수 없습니다.");
		}
	}
}
