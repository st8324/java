package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImp();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 보낸 type과 search를 가져옴
		String type = request.getParameter("type");
		String search = request.getParameter("search");
		//type과 search를 이용해서 Criteria 객체를 생성
		Criteria cri = new Criteria(1, 2, type, search);
		
		//서비스에게 현재 페이지 정보를 주면서 게시글 리스트를 달라고 요청
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		//화면에 게시글 리스트를 전송 : 화면에서 사용할 이름 - boardList
		request.setAttribute("boardList", list);
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	}
}
