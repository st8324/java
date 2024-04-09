package kr.kh.sample.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import kr.kh.sample.model.dto.MessageDTO;
import kr.kh.sample.model.vo.MemberVO;
import kr.kh.sample.utils.SseEmitters;

@RestController
public class SseController {

	private final SseEmitters sseEmitters;
	
	@Autowired
	public SseController(SseEmitters sseEmitters) {
		this.sseEmitters = sseEmitters;
	}
	@GetMapping(value = "/sse/connect", produces = MediaType.TEXT_EVENT_STREAM_VALUE)  
	public ResponseEntity<SseEmitter> connect(HttpSession session) {  
		SseEmitter emitter = new SseEmitter(60 * 1000L);  
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user == null)
			return ResponseEntity.ok(emitter);  
		sseEmitters.add(user.getMe_id(), emitter);
		try {  
			emitter.send(SseEmitter.event()  
	              .name("connect")  
	              .data("connected!"));  
		} catch (IOException e) {  
			throw new RuntimeException(e);  
		}  
		return ResponseEntity.ok(emitter);  
	}
	@PostMapping(value = "/sse/send")  
	public String send(HttpSession session, 
			@RequestParam("to")String to, @RequestParam("msg") String msg) {  
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user == null)
			return "로그인을 하지 않았습니다.";  
		//msg를 보낼 상대방의 에미터를 가져옴
		SseEmitter emitter = sseEmitters.get(to);
		if(emitter == null)
			return "상대방이 로그인을 하지 않았습니다.";
		try {  
			MessageDTO messge = new MessageDTO(to, user.getMe_id(), msg);
			emitter.send(SseEmitter.event()  
	              .name("receive")  
	              .data(messge));  
		} catch (IOException e) {  
			throw new RuntimeException(e);  
		}  
		return "전송을 성공했습니다.";  
	}
}
