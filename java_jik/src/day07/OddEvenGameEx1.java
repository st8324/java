package day07;

import java.util.Scanner;

public class OddEvenGameEx1 {

	public static void main(String[] args) {
		/* 다음 기능을 가진 프로그램을 작성하세요. 
		 * 메서드 이용
		 * --------------
		 * 메뉴
		 * 1. 새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 1
		 * --------------
		 * 선택(홀:1, 짝:0) : 1
		 * 3 홀입니다.
		 * 성공!
		 * --------------
		 * 메뉴
		 * 1. 새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * --------------
		 * 결과 : 1승 0패
		 * --------------
		 * 메뉴
		 * 1. 새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 3
		 * --------------
		 * 프로그램 종료
		 * */
		//반복문 : 프로그램 종료를 선택하기 전까지 반복
		int menu;
		Scanner scan = new Scanner(System.in);
		int win = 0, lose = 0;
		do {
			//메뉴 출력 : 메서드
			printMenu();
			
			//메뉴 선택
			menu = scan.nextInt();
			System.out.println("--------------");
			//선택한 메뉴에 따른 기능 실행
			switch(menu){
			case 1:
				//새 게임 : 메서드
				boolean result = newGame();
				if(result) {
					System.out.println("승!");
					win++;
				}else {
					System.out.println("패!");
					lose++;
				}
				break;
			case 2:
				//기록 확인 : 메서드
				printRecord(win, lose);
				break;
			case 3:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못된 메뉴 선택");
			}
		}while(menu != 3);
		scan.close();
	}

	/* 기능 : 메뉴를 출력하는 메서드
	 * 매개변수 : 없음 
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printMenu
	 * */
	public static void printMenu() {
		System.out.println("--------------");
		System.out.println("메뉴");
		System.out.println("1. 새 게임");
		System.out.println("2. 결과 조회");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	/* 기능 : 랜덤으로 숫자를 생성하고, 정수(홀/짝)를 입력받아
	 *  	 홀짝을 맞추고 승패를 알려주는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 승 또는 패, 승은 참, 패는 거짓 => boolean
	 * 메서드명 : newGame
	 * */
	public static boolean newGame() {
		//정수를 입력 받음(0,1) 
		Scanner scan = new Scanner(System.in);
		System.out.print("선택(홀:1, 짝:0) : ");
		int user = scan.nextInt();
		//랜덤으로 정수를 생성
		int r = random(1, 100);
		System.out.println(r + " " + (r%2==0?"짝":"홀") + "입니다.");
		//승패를 알려줌
		return r % 2 == user;
	}
	/* 기능 : 승 횟수와 패 횟수가 주어지면 a승 b패로 출력하는 메서드 
	 * 매개변수 : 승 횟수, 패 횟수=> int win, int lose
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printRecord
	 */
	public static void printRecord(int win, int lose) {
		System.out.println(win + "승 " + lose + "패");
	}
	/* 기능 : min ~ max 사이의 랜덤한 수를 생성해서 알려주는 메서드
	 * 매개변수 : 최소값과 최댓값 => int min, int max
	 * 리턴타입 : 생성된 랜덤한 수 => 정수 => int
	 * 메서드명 : random
	 * */
	public static int random(int min, int max) {
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		return (int)(Math.random() * (max - min + 1) + min);
	}
}


















