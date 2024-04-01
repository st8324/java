package kr.kh.spring2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring2.model.dto.LoginDTO;

@RestController //@Controller + @ResponseBoddy
@RequestMapping("/ajax")
public class AjaxController {
	
	@PostMapping("/json/json")
	public Map<String, Object> jsonJson(@RequestBody LoginDTO member){
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(member);
		map.put("member", member);
		map.put("name", "홍길동");
		return map;
	}
	
	@GetMapping("/object/json")
	public Map<String, Object> objectJson(
		@RequestParam("id")String id, @RequestParam("name")String name){
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(id);
		System.out.println(name);
		map.put("age", 31);
		return map;
	}
	@GetMapping("/object/json2")
	public Map<String, Object> objectJson2(
		@RequestParam("age")int age, @RequestParam("name")String name){
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(age);
		System.out.println(name);
		map.put("result", "성공");
		return map;
	}
	@GetMapping("/object/object")
	public ArrayList<String> objectObject(@RequestParam("name") String name) {
		System.out.println(name);
		ArrayList<String> list = new ArrayList<String>();
		list.add("안녕하세요");
		list.add("테스트");
		return list;
	}
	
}
