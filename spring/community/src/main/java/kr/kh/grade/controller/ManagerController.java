package kr.kh.grade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.grade.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	ManagerService managerService;

	@RequestMapping("/regist")
	public String regist() {
		return "/manager/regist";
	}
	@RequestMapping("/list")
	public String list() {
		return "/manager/list";
	}
	@RequestMapping("/update")
	public String update() {
		return "/manager/update";
	}
	@RequestMapping("/delete")
	public String delete() {
		return "/manager/delete";
	}
}
