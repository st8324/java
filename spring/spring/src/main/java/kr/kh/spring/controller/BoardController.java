package kr.kh.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.RecommendVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	//@RequestMapping(value="/board/list", method=RequestMethod.GET)
	@GetMapping("/board/list")
	public String boardList(Model model, Criteria cri) {
		cri.setPerPageNum(5);
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getBoardTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/board/list";
	}
	@GetMapping("/board/insert")
	public String boardInsert(Model model) {
		//커뮤니티 리스트를 가져와서 화면에 전송
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		model.addAttribute("list", list);
		return "/board/insert";
	}
	@PostMapping("/board/insert")
	public String boardInsertPost(Model model, BoardVO board, 
			HttpServletRequest request, MultipartFile[] file) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(boardService.insertBoard(board,user, file)) {
			model.addAttribute("msg", "게시글을 등록했습니다.");
			model.addAttribute("url", "/board/list");
		}else {
			model.addAttribute("msg", "게시글을 등록하지 못했습니다.");
			model.addAttribute("url", "/board/insert");
		}
		return "message";
	}
	
	@GetMapping("/board/detail")
	public String boardDetail(Model model, int boNum, Criteria cri) {
		//조회수 증가
		boardService.updateView(boNum);
		//게시글을 가져옴
		BoardVO board = boardService.getBoard(boNum);
		//첨부파일을 가져옴
		ArrayList<FileVO> fileList = boardService.getFileList(boNum);
		//화면에 게시글, 첨부파일, 검색 정보를 전송
		model.addAttribute("board", board);
		model.addAttribute("fileList", fileList);
		model.addAttribute("cri", cri);
		
		return "/board/detail";
	}
	
	@GetMapping("/board/delete")
	public String boardDelete(Model model, int boNum, HttpSession session) {
		//회원 정보를 가져옴
		MemberVO user = (MemberVO) session.getAttribute("user");
		
		//서비스에게 게시글 번호와 회원 정보를 주면서 삭제하라고 요청
		boolean res = boardService.deleteBoard(boNum, user);
		//삭제 성공시 성공 처리
		if(res) {
			model.addAttribute("url", "/board/list");
			model.addAttribute("msg", "게시글을 삭제했습니다.");
		}
		//삭제 실패시 실패 처리
		else {
			model.addAttribute("url", "/board/detail?boNum=" + boNum);
			model.addAttribute("msg", "게시글을 삭제하지 못했습니다.");
		}
		
		return "message";
	}
	
	@GetMapping("/board/update")
	public String boardUpdate(Model model, int boNum) {
		//커뮤니티 리스트를 가져와서 화면에 전송
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		//게시글을 가져옴
		BoardVO board = boardService.getBoard(boNum);
		//첨부파일을 가져옴
		ArrayList<FileVO> fileList = boardService.getFileList(boNum);
		
		model.addAttribute("fileList", fileList);
		model.addAttribute("board", board);
		model.addAttribute("list", list);
		return "/board/update";
	}
	@PostMapping("/board/update")
	public String boardUpdatePost(Model model, BoardVO board, MultipartFile []file,
			int [] delNums, HttpSession session) {
		//회원 정보를 가져옴. 왜? 작성자만 수정해야하기 때문에
		MemberVO user = (MemberVO) session.getAttribute("user");
		boolean res = boardService.updateBoard(board, user, file, delNums);
		if(res) {
			model.addAttribute("url", "/board/detail?boNum="+board.getBo_num());
			model.addAttribute("msg", "게시글을 수정했습니다.");
		}else {
			model.addAttribute("url", "/board/detail?boNum="+board.getBo_num());
			model.addAttribute("msg", "게시글을 수정하지 못했습니다.");
		}
		
		return "message";
	}
	@ResponseBody
	@PostMapping("/recommend/check")
	public Map<String, Object> 메서드명(@RequestBody RecommendVO recommend,
			HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO) session.getAttribute("user");
		int res = boardService.recommend(recommend, user);
		map.put("result", res);
		return map;
	}
	
	@ResponseBody
	@PostMapping("/recommend")
	public Map<String, Object> recommend(@RequestParam("num") int num,
		HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		//로그인한 회원의 추천 정보
		MemberVO user = (MemberVO)session.getAttribute("user");
		int state = boardService.getUserRecommend(num, user);
		//게시글의 추천/비추천수를 가져옴
		BoardVO board = boardService.getBoard(num);
		map.put("state", state);
		map.put("board", board);
		return map;
	}
	
	@ResponseBody
	@GetMapping("/api/board/list")
	public Map<String, Object> apiBoardList(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<BoardVO> list = boardService.getBoardList(new Criteria());
		map.put("list", list);
		return map;
	}
	
}







