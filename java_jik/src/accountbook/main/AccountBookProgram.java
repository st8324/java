package accountbook.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import accountbook.controller.AccountController;
import accountbook.program.Program;


public class AccountBookProgram implements Program {

	private final int EXIT = 5;
	
	private Scanner scan = new Scanner(System.in);
	private AccountController controller = new AccountController(scan);
	
	private final String fileName = "src/accountbook/item.txt";
	@Override
	public void run() {
		
		int menu = 0;
		controller.load(fileName);
		do {
			try {
				printMenu();
				menu = scan.nextInt();
				runMenu(menu);
				
			}catch(InputMismatchException e) {
				System.out.println("없는 메뉴입니다.");
				scan.nextLine();//입력 버퍼 비우기
			}
		}while(menu != EXIT);
		controller.save(fileName);
	}

	@Override
	public void printMenu() {
		controller.printMainmenu();
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1 : 
			controller.insertItem();
			break;
		case 2:
			controller.updateItem();
			break;
		case 3:
			controller.deleteItem();
			break;
		case 4:
			controller.printIem();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}

}
