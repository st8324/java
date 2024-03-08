package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/comment/list")
public class CommentListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	private BoardService boardService = new BoardServiceImp();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 보낸 현재 페이지 정보를 가져옴
		int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		Criteria cri = new Criteria(page, 2);
		//현재 페이지에 맞는 댓글을 가져오라고 시킴
		ArrayList<CommentVO> list = boardService.getCommentList(cri);

		JSONObject jobj = new JSONObject();
		
		jobj.put("list", list);
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
	}

}
