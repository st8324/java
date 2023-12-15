package day06;

import java.util.Scanner;

public class ArithmeticEx2 {

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
		int opNum = (int)(Math.random() * 3);
		Scanner scan = new Scanner(System.in);
		int user, answer = 0;
		String str = "+-*";
		char op = str.charAt(opNum);
		
		System.out.print("" + num1 + op + num2 +"=");
		user = scan.nextInt();
		
		//정답을 계산
		switch(op) {
		case '+':	answer = num1 + num2;	break;
		case '-':	answer = num1 - num2;	break;
		case '*':	answer = num1 * num2;	break;
		default:
			System.out.println("잘못된 연산자입니다.");
		}
		
		//맞췄는지 틀렸는지
		if(user == answer) {
			System.out.println("정답입니다!");
		}else {
			System.out.println("틀렸습니다!");
		}
		
		scan.close();
	}
}











