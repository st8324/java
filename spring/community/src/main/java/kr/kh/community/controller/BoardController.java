package kr.kh.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.community.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/regist")
	public String regist() {
		return "/board/regist";
	}
	@RequestMapping("/list")
	public String list() {
		return "/board/list";
	}
	@RequestMapping("/update")
	public String update() {
		return "/board/update";
	}
	@RequestMapping("/delete")
	public String delete() {
		return "/board/delete";
	}
}
