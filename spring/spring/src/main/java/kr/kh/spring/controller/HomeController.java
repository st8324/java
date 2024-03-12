package kr.kh.spring.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.dto.TestDTO;

@Controller
public class HomeController {
	
	//value : url, method : 전송박식을 GET 또는 POST
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//model.addAttribute("화면에서 사용할 이름","보낼 데이터");
		model.addAttribute("name","홍길동");
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(Model model,TestDTO testDto/*,String name, int age*/) {
		/*System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		TestDTO testDto = new TestDTO(name, age);
		*/
		System.out.println(testDto);
		return "home";
	}
	@RequestMapping(value = "/test/{num}", method = RequestMethod.GET)
	public String test(Model model,@PathVariable("num")int num) {
		System.out.println("경로 데이터 : " + num);
		return "redirect:/";
	}
}
