package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/update")
@MultipartConfig(
	maxFileSize = 1024 * 1024 * 10, //10Mb
	maxRequestSize = 1024 * 1024 * 10 * 3, //10Mb 최대 3개
	fileSizeThreshold = 1024 * 1024 //1Mb : 파일 업로드 시 메모리에 저장되는 임시 파일 크기
)
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//게시글 번호를 가져옴
		int num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}catch(Exception e) {
			num = 0;
		}
		//번호와 일치하는 게시글을 가져옴
		BoardVO board = boardService.getBoard(num);
		//게시판 리스트를 가져옴
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		
		//게시글 번호를 이용하여 첨부파일 리스트를 가져옴
		ArrayList<FileVO> fileList = boardService.getFileList(num);
		//가져온 첨부파일 리스트를 화면에 전송
		request.setAttribute("fileList", fileList);
		
		//게시글과 게시판 리스트를 화면에 전송
		request.setAttribute("list", list);
		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 번호, 내용, 제목, 게시판 번호를 가져옴
		int num, co_num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
			co_num = Integer.parseInt(request.getParameter("community"));
		}catch (Exception e) {
			num = 0;
			co_num = 0;
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//게시글 번호, 내용, 제목, 게시판 번호를 이용해서 게시글 객체를 생성
		BoardVO board = new BoardVO(title, content, "", co_num);
		board.setBo_num(num);

		//회원 가져옴
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		//삭제할 첨부파일 번호들
		String [] nums = request.getParameterValues("fi_num");
		
		//추가할 첨부파일들을 가져옴	
		ArrayList<Part> partList = (ArrayList<Part>) request.getParts();
		
		//서비스에게 회원 정보와 수정할 게시글 정보를 주면서 수정하라고 요청
		boolean res = boardService.updateBoard(board, user, nums, partList);
		//수정했으면 게시글을 수정했습니다
		if(res) {
			request.setAttribute("msg", "게시글을 수정했습니다");
		}
		//못햇으면 게시글을 수정하지 못했습니다라고 알림
		else {
			request.setAttribute("msg", "게시글을 수정하지 못했습니다");
		}
		//게시글 상세로 이동
		request.setAttribute("url", "board/detail?num="+num);
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
