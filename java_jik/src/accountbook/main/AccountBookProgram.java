package accountbook.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import accountbook.controller.AccountController;
import accountbook.service.PrintService;
import accountbook.service.PrintServiceImp;
import accountbook.vo.Item;
import program.Program;

public class AccountBookProgram implements Program {

	List<Item> list;//수입 지출 내역
	
	private AccountController accountController;
	private PrintService printService;
	
	//생성자에서 서비스와 컨트롤러 생성
	public AccountBookProgram() {
		list = new ArrayList<Item>();
		accountController = new AccountController(list);
		printService = new PrintServiceImp();
	}
	
	@Override
	public void run() {
		//메뉴 초기값은 종료만 아니면 됨
		int menu = AccountController.EXIT+1;
		Scanner scan = new Scanner(System.in);
		do {
			try {
				//메뉴 출력
				printMenu();
				//메뉴 선택
				menu = scan.nextInt();
				//메뉴 선택
				runMenu(menu);
			}
			//잘못 입력된 메뉴 처리
			catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
			}
			//종료 메뉴를 static 상수로 지정
		}while(menu != AccountController.EXIT);
	}

	@Override
	public void printMenu() {
		printService.printMainMenu();
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			accountController.insertItem();
			break;
		case 2: 
			accountController.updateItem();
			break;
		case 3:
			accountController.deleteItem();
			break;
		case 4:
			accountController.printItem();
			break;
		default:
			throw new InputMismatchException();
		}
	}

}
