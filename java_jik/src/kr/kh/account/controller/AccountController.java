package kr.kh.account.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import kr.kh.account.model.vo.Category;
import kr.kh.account.model.vo.Item;
import kr.kh.account.model.vo.Type;
import kr.kh.account.pagination.Criteria;
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
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			view();
			break;
		case 5:
			System.out.println("이전으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private void view() {
		System.out.print("날짜를 입력하세요.(yyyy-MM-dd 또는 yyyy-MM 또는 yyyy) : ");
		String date = scan.next();
		int page = 1;
		int menu;
		do {
			Criteria cri = new Criteria(page, 2);
			cri.setSearch(date);
			List<Item> itemList = accountService.getItemListByDate(cri);
			if(itemList == null || itemList.size() == 0) {
				System.out.println("조회할 내역이 없습니다.");
			}
			else {
				for(Item tmp : itemList) {
					System.out.println(tmp);
				}
			}
			System.out.println("1. 이전 페이지");
			System.out.println("2. 다음 페이지");
			System.out.println("3. 돌아가기");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			switch(menu) {
			case 1: page = page == 1 ? 1 : page - 1;	
				break;
			case 2: ++page; 
				break;
			case 3:	System.out.println("조회를 종료합니다."); break;
			default : System.out.println("잘못 선택");
			}
		}while(menu != 3);
	}

	private void delete() {
		System.out.print("날짜를 입력하세요.(yyyy-MM-dd) : ");
		String date = scan.next();
		List<Item> itemList = accountService.getItemListByDate(date);
		
		if(itemList == null || itemList.size() == 0) {
			System.out.println("삭제할 내역이 없습니다.");
			return;
		}
		//삭제할 내역이 있으면 삭제 가능한 내역을 출력
		for(Item item : itemList) {
			System.out.println(item);
		}
		System.out.print("내역 번호를 선택하세요 : ");
		int it_num = scan.nextInt();
		//입력한 내역 번호가 잘못된 값인지 확인
		if(!itemList.contains(new Item(it_num))) {
			System.out.println("잘못된 내역 번호입니다.");
			return;
		}
		if(accountService.deleteItem(it_num)) {
			System.out.println("내역을 삭제했습니다.");
		}else {
			System.out.println("내역을 삭제하지 못했습니다.");
		}
	}

	private void update() {
		System.out.print("날짜를 입력하세요.(yyyy-MM-dd) : ");
		String date = scan.next();
		List<Item> itemList = accountService.getItemListByDate(date);
		
		if(itemList == null || itemList.size() == 0) {
			System.out.println("수정할 내역이 없습니다.");
			return;
		}
		//수정할 내역이 있으면 수정 가능한 내역을 출력
		for(Item item : itemList) {
			System.out.println(item);
		}
		System.out.print("내역 번호를 선택하세요 : ");
		int it_num = scan.nextInt();
		//입력한 내역 번호가 잘못된 값인지 확인
		if(!itemList.contains(new Item(it_num))) {
			System.out.println("잘못된 내역 번호입니다.");
			return;
		}
		try {
			Item item = inputItem();
			item.setIt_num(it_num);
			if(accountService.updateItem(item)) {
				System.out.println("내역 수정이 완료되었습니다.");
			}else {
				System.out.println("내역을 수정하지 못했습니다.");
			}
		} catch (ParseException e) {
			System.out.println("날짜를 잘못 입력하여 내역을 수정하지 못했습니다.");
			return;
		}
	}

	private Item inputItem() throws ParseException {
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
		
		return new Item(categoryNum, date, money, content, type);
	}
	
	private void insert() {
		
		try {
			Item item = inputItem();
			if(accountService.insertItem(item)) {
				System.out.println("내역을 추가했습니다.");
			}else {
				System.out.println("내역을 추가하지 못했습니다.");
			}
		} catch (ParseException e) {
			System.out.println("날짜 형식이 잘못됐습니다.");
		}
	}
}




