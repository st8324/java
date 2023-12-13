package day04;

import java.util.Scanner;

public class DoWhileMenuEx1 {

	public static void main(String[] args) {
		/* 메뉴를 출력하는 예제 
		 * 메뉴
		 * 1. 새 게임
		 * 2. 최고기록 확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 1
		 * 메뉴
		 * 1. 새 게임
		 * 2. 최고기록 확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * 메뉴
		 * 1. 새 게임
		 * 2. 최고기록 확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 3
		 * 프로그램 프로그램을 종료합니다.
		 * */
		Scanner scan = new Scanner(System.in);
		int menu;
		do {
			System.out.println("메뉴");
			System.out.println("1. 새게임");
			System.out.println("2. 최고기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
		}while(menu != 3);
		System.out.println("프로그램을 종료합니다.");
	}
}












