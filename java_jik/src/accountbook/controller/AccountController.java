package accountbook.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import accountbook.model.Item;
import accountbook.model.PrintError;
import accountbook.service.AccountBookService;
import accountbook.service.AccountBookServiceImp;
import accountbook.service.FileService;
import accountbook.service.FileServiceImp;
import accountbook.service.PrintService;
import accountbook.service.PrintServiceImp;

public class AccountController {

	private PrintService printService = new PrintServiceImp();
	private AccountBookService accountBookService = new AccountBookServiceImp();
	private FileService fileService = new FileServiceImp();
	
	private Scanner scan = new Scanner(System.in);
	private List<Item> list;
	
	
	public AccountController(Scanner scan) {
		list = new ArrayList<Item>();
		if(scan != null) {
			this.scan = scan;
		}
	}
	
	//메인 메뉴 출력
	public void printMainmenu() {
		printService.printMainMenu();
	}
	//추가와 삭제에서 같이 쓰기 위해 메서드로 따로 만듬
		private Item inputItem() {
			try {
				//수입/지출 입력
				System.out.print("수입(i)/지출(e) 선택 : ");
				char incomeChar = scan.next().charAt(0);
				boolean income = false;
				//수입/지출 입력 체크
				switch (incomeChar) {
				case 'i': case 'I': income = true; 	break; 
				case 'e': case 'E': income = false;	break;
				default:
					throw new Exception("수입/지출 입력 오류입니다.");
				}
				//날짜 입력
				System.out.print("날짜 입력("+Item.datePatter+") : ");
				String date = scan.next();
				//날짜 유효성 체크
				if(!Item.checkDate(date)) {
					throw new Exception("날짜 형식 오류입니다.");
				}
				//카테고리
				System.out.print("다음 분류 중 하나를 입력하세요.");
				printService.printItemCategory(income);
				System.out.print("분류 입력 : ");
				//카테고리는 금액, 내용 입력받고 처리
				String category = scan.next();
				//금액
				System.out.print("금액 입력 : ");
				int money = scan.nextInt();
				//내용
				System.out.print("내용 입력 : ");
				scan.nextLine();
				String content = scan.nextLine();
				return new Item(income, date, category, money, content);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
	public void insertItem() {
		
		Item item = inputItem();
		if(!accountBookService.insertItem(list, item)) {
			System.out.println("내역 추가에 실패했습니다.");
		}else {
			System.out.println("내역 추가에 성공했습니다.");
			//정렬
			accountBookService.sort(list);
		}
		
	}

	//날짜를 입력하여 수정할 내역을 선택 후 내역 전체를 새로 입력받아 수정
	public void updateItem() {
		//날짜 입력
		System.out.print("수정하려는 내역의 날짜 입력 : ");

		String date = scan.next();
		
		if(!Item.checkDate(date)) {
			System.out.println(PrintError.DATE_ERROR);
			return;
		}
		//해당 날짜와 일치하는 내역들 조회
		printService.printItemListByDate(list, date);
		System.out.print("수정할 내역 선택 : ");
		int index = scan.nextInt() - 1;
		//입력한 번호가 유효한지 체크
		if(!accountBookService.checkIndex(list, index)) {
			System.out.println(PrintError.INDEX_ERROR);
			return;
		}
		//수정할 항목을 입력
		Item item = inputItem();
		if(accountBookService.updateItem(list, index, item)) {
			System.out.println("내역 수정에 성공!");
			accountBookService.sort(list);
		}else {
			System.out.println("내역 수정에 실패!");
		}
	}
	//날짜를 입력받아 조회 후 삭제할 항목을 선택하여 삭제
	public void deleteItem() {
		//날짜 입력
		System.out.print("삭제하려는 내역의 날짜 입력 : ");

		String date = scan.next();
		
		if(!Item.checkDate(date)) {
			System.out.println(PrintError.DATE_ERROR);
			return;
		}
		//해당 날짜와 일치하는 내역들 조회
		printService.printItemListByDate(list, date);
		System.out.print("수정할 내역 선택 : ");
		int index = scan.nextInt() - 1;
		//입력한 번호가 유효한지 체크
		if(!accountBookService.checkIndex(list, index)) {
			System.out.println(PrintError.INDEX_ERROR);
			return;
		}
		if(accountBookService.deleteItem(list, index)) {
			System.out.println("내역 삭제에 성공!");
		}else {
			System.out.println("내역 삭제에 실패!");
		}
	}

	public void printIem() {
		printService.printSubMenu();
		int menu = 0;
		
		try {
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				printService.printItemListByDate(list, "");
				break;
			case 2:
				printByYear();
				break;
			case 3:
				printByMonth();
				break;
			case 4:
				printByDay();
				break;
			case 5:
				printByCategory();
				break;
			case 6:
				throw new InputMismatchException();
			}
		}catch(InputMismatchException e) {
			System.out.println("잘못된 메뉴 선택!");
			scan.nextLine();
		}
		
	}

	private void printByYear() {
		System.out.print("년도 입력 : ");
		String year = scan.next();
		printService.printItemListByDate(list, year);
	}

	private void printByMonth() {
		System.out.print("년도 입력 : ");
		String year = scan.next();
		System.out.print("월 입력 : ");
		int month = scan.nextInt();
		String date = year +"-"+ String.format("%02d", month);
		printService.printItemListByDate(list, date);
	}

	private void printByDay() {
		System.out.print("년도 입력 : ");
		String year = scan.next();
		System.out.print("월 입력 : ");
		int month = scan.nextInt();
		System.out.print("일 입력 : ");
		int day = scan.nextInt();
		String date = year +"-"+ String.format("%02d", month) +"-"+ String.format("%02d", day);
		printService.printItemListByDate(list, date);		
	}

	private void printByCategory() {
		System.out.print("분류 입력 : ");
		String category = scan.next();
		printService.printItemListByCategory(list,category);
		
	}

	public void load(String fileName) {
		list = fileService.load(fileName);
		if(list == null) {
			System.out.println("파일 로딩 실패!");
			list = new ArrayList<Item>();
		}else {
			System.out.println("파일 로딩 성공!");
		}
	}

	public void save(String fileName) {
		if(fileService.save(fileName, list)) {
			System.out.println("파일 저장 성공!");
		}else {
			System.out.println("파일 저장 실패!");
		}
	}
	
}
