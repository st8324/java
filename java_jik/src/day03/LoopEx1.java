package day03;

import java.util.Scanner;

public class LoopEx1 {

	public static void main(String[] args) {
		//문자를 입력받아 입력받은 문자를 출력하고, q를 입력하면 종료하는 예제
		Scanner scan = new Scanner(System.in);
		char ch = 'a';
		for( ; ch != 'q'; ) {
			System.out.print("입력 : ");
			ch = scan.next().charAt(0);
			System.out.println("문자 : " + ch);
		}
		
		scan.close();
	}

}
