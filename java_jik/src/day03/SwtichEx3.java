package day03;

import java.util.Scanner;

public class SwtichEx3 {

	//switch문
	public static void main(String[] args) {
		/* 월을 입력받아 입력받은 월의 계절을 출력하세요.
		 * 3,4,5  : 봄
		 * 6,7,8  : 여름
		 * 9,10,11: 가을
		 * 12,1,2 : 겨울
		 * 그 외 : 잘못된 월
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("월 입력(1~12) : ");
		int month = scan.nextInt();
		
		switch(month) {
		case 1, 2, 12:
			System.out.println(month + "월은 겨울");
			break;
		case 3: case 4: case 5:
			System.out.println(month + "월은 봄");
			break;
		case 6:	case 7:	case 8:
			System.out.println(month + "월은 여름");
			break;
		case 9: case 10: case 11:
			System.out.println(month + "월은 가을");
			break;
		default:
			System.out.println(month + "월은 잘못된 월");
		}
		
		scan.close();
	}

}
