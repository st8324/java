package day13;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternEx2 {

	public static void main(String[] args) {
		/* 아이디를 입력받아 아이디 형식에 맞는지 틀린지를 출력하는 프로그램을 작성하세요.
		 * 아이디 정규 표현식 : 영문,숫자로 구성, 8~13자
		 * 
		 * 아이디 : abc
		 * 아이디 형식에 맞지 않습니다.
		 * 
		 * 아이디 : abcd1234
		 * 아이디로 사용 가능합니다.
		 * */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String id = scan.next();
		
		String regex = "^[a-zA-Z0-9]{8,13}$";
		if(Pattern.matches(regex, id)) {
			System.out.println("아이디로 사용 가능합니다.");
		}else {
			System.out.println("아이디 형식에 맞지 않습니다.");
		}
	}

}








