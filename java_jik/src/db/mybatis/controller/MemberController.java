package db.mybatis.controller;

import java.util.ArrayList;
import java.util.Scanner;

import db.mybatis.model.vo.MemberVO;
import db.mybatis.service.MemberService;
import db.mybatis.service.MemberServiceImp;

public class MemberController {

	private MemberService memberService = new MemberServiceImp();
	private Scanner scan = new Scanner(System.in);
	
	public void run() {
		int menu;
		do {
			printMemberMenu();
			menu = scan.nextInt();
			runMemberMenu(menu);
		}while(menu != 5);
	}

	private void runMemberMenu(int menu) {
		switch(menu) {
		case 1:
			insertMember();
			break;
		case 4:
			printMember();
			break;
		}
		
	}

	private void printMember() {
		ArrayList<MemberVO> list = memberService.getMemberList();
		if(list.size() == 0) {
			System.out.println("등록된 회원이 없습니다.");
			return;
		}
		for(MemberVO tmp : list) {
			System.out.println(tmp);
		}
	}

	private void insertMember() {
		System.out.println("아이디 : ");
		String id = scan.next();
		System.out.println("비번 : ");
		String pw = scan.next();
		System.out.println("이메일 : ");
		String email = scan.next();
		MemberVO member = new MemberVO(id, pw, email);
		if(memberService.insertMember(member)) {
			System.out.println("회원을 추가했습니다.");
		}else {
			System.out.println("회원 추가에 실패했습니다.");
		}
	}

	private void printMemberMenu() {
		System.out.println("회원 메뉴");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 수정");
		System.out.println("3. 회원 삭제");
		System.out.println("4. 회원 조회");
		System.out.print("메뉴 선택 : ");
	}

}
