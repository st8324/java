package kr.kh.account.main;

import java.util.Scanner;

import kr.kh.account.controller.AccountController;

public class Main {

	private static AccountController accountController;
	
	public static void main(String[] args) {
		int menu;
		Scanner scan = new Scanner(System.in);
		accountController = new AccountController(scan);
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
		}while(menu != 2);
	}
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 가계부 관리");
		System.out.println("2. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			accountController.run();
			break;
		case 2:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
}
