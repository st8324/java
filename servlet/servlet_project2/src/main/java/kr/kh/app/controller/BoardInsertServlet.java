package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardService boardService = new BoardServiceImp();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에서 회원 정보를 가져옴 
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//회원 정보가 없으면 로그인이 필요한 서비스입니다라고 출력 후 게시글 리스트로 이동
		//화면에 msg로 로그인이 필요한 서비스입니다라고 전송
		//화면에 url로 /login를 전송
		//message.jsp로 전송
		if(user == null) {
			request.setAttribute("msg", "로그인이 필요한 서비스입니다");
			request.setAttribute("url", "login");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
		//있으면 게시글 등록 화면을 전송
		else {
			//서비스에게 게시판 리스트를 가져오라고 시킴 : getCommunityList
			ArrayList<CommunityVO> list = boardService.getCommunityList();
			//화면에 게시판 리스트를 보냄 
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 보낸 제목, 내용을 가져옴
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//세션에서 회원 정보를 가져옴
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//회원 정보가 없으면 
		if(user == null) {
			//화면에 msg로 로그인이 필요한 서비스입니다라고 전송
			request.setAttribute("msg", "로그인이 필요한 서비스입니다.");
			//화면에 url로 board/list를 전송
			request.setAttribute("url", "board/list");
			//message.jsp를 전송
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
			return;
		}
		//회원 정보가 있으면
		//작성자에 회원 아이디를 저장
		String writer = user.getMe_id();
		//게시판 번호는 1번으로 저장
		int co_num = Integer.parseInt(request.getParameter("community"));
		//제목, 내용, 작성자, 게시판 번호를 이용하여 게시글 객체를 생성
		BoardVO board = new BoardVO(title, content, writer, co_num);
		//서비스에게 게시글 객체를 주면서 등록하라고 시킴
		System.out.println(board);
		boolean res = boardService.insertBoard(board);
		//등록을 하면 화면에 msg로 게시글을 등록했습니다라고 전송
		if(res) {
			request.setAttribute("msg", "게시글을 등록했습니다.");
		}
		//등록하지 못하면 화면에 msg로 게시글을 등록하지 못했습니다라고 전송
		else {
			request.setAttribute("msg", "게시글을 등록하지 못했습니다.");
		}
		//화면에 url로 board/list를 전송
		request.setAttribute("url", "board/list");
		//message.jsp를 전송
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
	}

}
