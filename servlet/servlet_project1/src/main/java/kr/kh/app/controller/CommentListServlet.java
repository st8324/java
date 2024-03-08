package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.pagination.CommentCriteria;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/comment/list")
public class CommentListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	private BoardService boardService = new BoardServiceImp();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 보낸 현재 페이지 정보를 가져옴
		int page = 1;
		int boNum = 0;
		try {
			page = Integer.parseInt(request.getParameter("page"));
			boNum = Integer.parseInt(request.getParameter("boNum"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		CommentCriteria cri = new CommentCriteria(page, 2, boNum);
		//현재 페이지에 맞는 댓글을 가져오라고 시킴
		ArrayList<CommentVO> list = boardService.getCommentList(cri);

		//전체 댓글 수 (현재 게시글에 대한)
		int totalCount = boardService.getTotalCountComment(cri);
		
		//페이지네이션 생성
		PageMaker pm = new PageMaker(5, cri, totalCount);
		JSONObject jobj = new JSONObject();
		
		ObjectMapper om = new ObjectMapper();
		String pmStr = "";
		try {
			pmStr = om.writeValueAsString(pm);
		}catch(Exception e) {
			e.printStackTrace();
		}
		jobj.put("list", list);
		jobj.put("pm", pmStr);
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
	}

}
