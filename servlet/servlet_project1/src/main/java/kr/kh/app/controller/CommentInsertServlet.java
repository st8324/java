package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/comment/insert")
public class CommentInsertServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private BoardService boardService = new BoardServiceImp();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//화면에서 보낸 댓글 내용과 게시글 번호를 가져옴
    	String content = request.getParameter("content");
    	int bo_num = 0;
    	try {
    		bo_num = Integer.parseInt(request.getParameter("num"));
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	//댓글 작성자를 가져옴 => 회원 정보를 가져옴 
    	MemberVO user = (MemberVO)request.getSession().getAttribute("user");
    	//댓글 등록하라고 시킴
    	CommentVO comment = new CommentVO(bo_num, content, user.getMe_id());
    	boolean res = boardService.insertComment(comment);
    	response.getWriter().write(res?"ok":"");
    }

}
