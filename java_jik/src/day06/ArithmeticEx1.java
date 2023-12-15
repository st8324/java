package day06;

import java.util.Scanner;

public class ArithmeticEx1 {

	public static void main(String[] args) {
		/* 랜덤으로 산수(+, -, *) 문제를 생성하여 맞추는 게임
		 * 단, 숫자 범위는 1~99, 연산자는 +, -, *
		 * 1 + 2 = 3
		 * 정답입니다.
		 * 
		 * 2 * 3 = 5
		 * 틀렸습니다.
		 * */
		int min = 1, max = 99;
		//정수1을 랜덤으로 생성 - 1~99
		int num1 = (int)(Math.random() * (max-min + 1) + min);
		//정수2를 랜덤으로 생성 - 1~99
		int num2 = (int)(Math.random() * (max-min + 1) + min);
		//정수3(연산자)를 랜덤으로 생성 - 1~3
		int op = (int)(Math.random() * 3 + 1);
		Scanner scan = new Scanner(System.in);
		int user, answer;
		switch(op) {
		//연산자가 1이면
		case 1:
			//정수1 + 정수2 =을 콘솔에 출력
			System.out.print(num1 + " + " + num2 + " =");
			//정답을 입력
			user = scan.nextInt();
			//입력받은 정답과 정수1+정수2가 같으면 정답이라고 출력
			answer = num1 + num2;
			if(user == answer) {
				System.out.println("정답입니다!");
			}
			//아니면 틀렸다고 출력
			else {
				System.out.println("틀렸습니다!");
			}
			break;
		//연산자가 2이면
		case 2:
			//정수1 - 정수2 =을 콘솔에 출력
			System.out.print(num1 + " - " + num2 + " =");
			//정답을 입력
			user = scan.nextInt();
			//입력받은 정답과 정수1-정수2가 같으면 정답이라고 출력
			answer = num1 - num2;
			if(user == answer) {
				System.out.println("정답입니다!");
			}
			//아니면 틀렸다고 출력
			else {
				System.out.println("틀렸습니다!");
			}
			break;
		//연산자가 3이면
		case 3:
			//정수1 * 정수2 =을 콘솔에 출력
			System.out.print(num1 + " * " + num2 + " =");
			//정답을 입력
			user = scan.nextInt();
			//입력받은 정답과 정수1*정수2가 같으면 정답이라고 출력
			answer = num1 * num2;
			if(user == answer) {
				System.out.println("정답입니다!");
			}
			//아니면 틀렸다고 출력
			else {
				System.out.println("틀렸습니다!");
			}
			break;
		default:
			System.out.println("잘못된 연산자입니다.");
		}
		
		scan.close();
	}
}











