package ex;

import java.util.Scanner;

public class EnumEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("계절 입력(봄,여름,가을,겨울) : ");
		String seasonStr = scan.next();
		
		Season season = Season.valueOf(seasonStr);//문자열을 Season 객체로
		switch(season) {
		case 봄:		System.out.println("봄입니다."); break;
		case 여름:	System.out.println("여름입니다."); break;
		case 가을:	System.out.println("가을입니다."); break;
		case 겨울:	System.out.println("겨울입니다."); break;
		default:	System.out.println("잘못된 계절입니다.");
		}

	}

}

enum Season{
	//영어도 가능
	봄, 여름, 가을, 겨울
}
