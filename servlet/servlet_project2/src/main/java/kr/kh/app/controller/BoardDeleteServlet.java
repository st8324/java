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

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//num를 가져옴
		int num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}catch(Exception e) {
			num = 0;
		}
		//회원 정보를 가져옴
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//서비스에게 회원 정보와 게시글 번호를 주면서 삭제하라고 요청
		boolean res = boardService.deleteBoard(num, user);
		//삭제 했으면 삭제했다고 알리고 게시글 리스트로 이동
		if(res) {
			request.setAttribute("msg", "게시글을 삭제 했습니다.");
			request.setAttribute("url", "board/list");
		}
		//실패 했으면 실패했다고 알리고 게시글 상세로 이동
		else {
			request.setAttribute("msg", "게시글을 삭제하지 못했습니다.");
			request.setAttribute("url", "board/detail?num="+num);
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
	}
}
