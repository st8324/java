package day03;

import java.util.Scanner;

public class BreakEx1 {

	public static void main(String[] args) {
		//문자를 입력해서 입력한 문자를 출력하고, q를 입력하면 종료하는 예제
		Scanner scan = new Scanner(System.in);

		char ch = 'a';
		while(true) {
			System.out.print("문자 입력 : ");
			ch = scan.next().charAt(0);
			System.out.println("문자 : " + ch);
			if(ch == 'q') {
				break;
			}
		}
		
		scan.close();
	}

}








