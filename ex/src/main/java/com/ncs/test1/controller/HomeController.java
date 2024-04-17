package com.ncs.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncs.test.model.vo.Board;
import com.ncs.test.service.BoardService;

@Controller
public class HomeController {
	
	@Autowired
	BoardService boardService;
	
	/*
	@Autowired
	public HomeController(BoardService boardService) {
		this.boardService = boardService;
	}
	*/
	
	
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public String home(Model model, Board board, HttpSession session) {
		Board tmp = boardService.getBoard(board);
		if(tmp != null) {
			session.setAttribute("board", tmp);
			return "redirect:/";
		}else {
			model.addAttribute("msg", "게시글 불러오기 실패");
			return "errorPage";
		}
	}
	
}
