package kr.kh.account.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import kr.kh.account.model.vo.Category;
import kr.kh.account.model.vo.Item;
import kr.kh.account.model.vo.Type;
import kr.kh.account.service.AccountService;
import kr.kh.account.service.AccountServiceImp;

public class AccountController {
	
	private Scanner scan;
	private AccountService accountService;
	
	public AccountController(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		accountService = new AccountServiceImp();
	}

	public void run() {
		int menu;
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
		}while(menu != 5);
	}

	private void printMenu() {
		System.out.println("-------메뉴-------");
		System.out.println("1. 내역 입력");
		System.out.println("2. 내역 수정");
		System.out.println("3. 내역 삭제");
		System.out.println("4. 내역 조회");
		System.out.println("5. 이전");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			System.out.println("이전으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private void insert() {
		//수입/지출 선택
		List<Type> typeList = accountService.getTypeList();
		
		for(int i = 0; i < typeList.size(); i++) {
			System.out.print(typeList.get(i).getTy_name());
			if(i != typeList.size() - 1) {
				System.out.print("/");
			}
		}
		System.out.print(" 중 하나를 입력 하세요:");
		String type = scan.next();
		
		//카테고리 선택
		List<Category> categoryList = accountService.getCategoryList(type);
		for(Category category : categoryList) {
			System.out.println(category);
		}
		System.out.print("분류를 선택하세요 : ");
		int categoryNum = scan.nextInt();
		//날짜
		System.out.print("날짜를 입력하세요(yyyy-MM-dd) : ");
		String date = scan.next();
		
		//금액
		System.out.print("금액을 입력하세요 : ");
		int money = scan.nextInt();

		//내용
		scan.nextLine();
		System.out.print("내용을 입력하세요 : ");
		String content = scan.nextLine();
		
		try {
			Item item = new Item(categoryNum, date, money, content);
			if(accountService.insertItem(item, type)) {
				System.out.println("내역을 추가했습니다.");
			}else {
				System.out.println("내역을 추가하지 못했습니다.");
			}
		} catch (ParseException e) {
			System.out.println("날짜 형식이 잘못됐습니다.");
		}
	}
}




