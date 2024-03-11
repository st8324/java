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
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/comment/list")
public class CommentListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private BoardService boardService = new BoardServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boNum = 0, page = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
			boNum = Integer.parseInt(request.getParameter("boNum"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		Criteria cri = new Criteria(page, 2, "", "" + boNum);
		ArrayList<CommentVO> list = boardService.getCommentList(cri);
		//현재 게시글에 있는 총 댓글 수를 가져옴
		int totalCount = boardService.getTotalCommentCount(cri);
		//페이지네이션 객체 생성
		PageMaker pm = new PageMaker(5, cri, totalCount);
		
		//화면에 list를 전송(객체로)
		JSONObject jobj = new JSONObject();
		
		//화면에 pm을 전송(JSON 문자열로)
		ObjectMapper om = new ObjectMapper();
		String pmStr = "";
		try {
			//객체를 JSON형태의 문자열로 변환
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
