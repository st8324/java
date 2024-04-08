package kr.kh.spring3.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.service.BoardService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/post/list")
	public String postList(Model model, Criteria cri) {
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getBoardTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		model.addAttribute("pm", pm);
		model.addAttribute("title", "게시글 목록");
		model.addAttribute("list", list);
		return "/post/list";
	}
	
	@GetMapping("/post/insert")
	public String postInsert(Model model) {
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		model.addAttribute("list", list);
		model.addAttribute("title", "게시글 등록");
		return "/post/insert";
	}
	@PostMapping("/post/insert")
	public String postInsertPost(Model model, BoardVO board, 
			HttpSession session, MultipartFile [] files) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.insertBoard(board, user, files);
		if(res) {
			model.addAttribute("msg", "게시글을 등록했습니다.");
			model.addAttribute("url", "/post/list");
		}else {
			model.addAttribute("msg", "게시글을 등록하지 못했습니다.");
			model.addAttribute("url", "/post/insert");
		}
		return "message";
	}
	@GetMapping("/post/detail")
	public String postDetail(Model model, int num) {
		//게시글 조회수 증가
		boardService.updateView(num);
		//게시글을 가져옴
		BoardVO board = boardService.getBoard(num);
		//게시글 첨부파일을 가져옴
		ArrayList<FileVO> list = boardService.getFileList(num);
		log.info(list);
		//화면에 게시글, 첨부파일을 전송
		model.addAttribute("board", board);
		model.addAttribute("list", list);
		return "/post/detail";
	}
}
