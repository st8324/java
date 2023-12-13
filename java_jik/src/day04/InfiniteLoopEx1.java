package day04;

import java.util.Scanner;

public class InfiniteLoopEx1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//무한 루프 예제1 : 조건식을 참으로 만들어서 무한루프 발생
		while(true) {
			System.out.print("정수 입력 : ");
			int num = scan.nextInt();
			System.out.println("정수 출력 : " + num);
		}
		//무한루프가 100% 발생하는 코드 아래에 있는 코드는 에러가 발생
		//절대 실행될 일이 없어서
		//System.out.println("프로그램 종료!");
		/*
		for( ; ; ) {
			System.out.print("정수 입력 : ");
			int num = scan.nextInt();
			System.out.println("정수 출력 : " + num);
		}
		 */
	}

}
