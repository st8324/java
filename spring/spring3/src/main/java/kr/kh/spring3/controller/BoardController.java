package kr.kh.spring3.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.spring3.model.vo.BoardVO;
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
}
