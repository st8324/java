package day05;

import java.util.Scanner;

public class ThirtyOneEx1 {

	public static void main(String[] args) {
		/* 사용자와 컴퓨터가 돌아가면서 최대 3개의 숫자를 부르고,
		 * 31을 입력한 사용자 또는 컴퓨터가 지는 게임을 작성하세요.
		 * 예
		 * com : 1 2 3
		 * 정수 : 2
		 * user: 4 5
		 * com : 6
		 * 정수 : 3
		 * user: 7 8 9
		 * ...
		 * com : 31
		 * */
		Scanner scan = new Scanner(System.in);
		//사용자가 입력할 숫자를 저장할 변수 선언
		int user;
		//현재 부른 숫자를 저장할 변수 선언 후 0으로 초기화
		int count = 0;
		int min = 1, max = 3;
		//반복문(현재 숫자가 31이 아닐때까지)
		while(count < 31) {
			//컴퓨터가 랜덤으로 1~3사이의 숫자를 생성
			int com = (int)(Math.random()*(max - min + 1) + min);
			int end = count + com;
			//현재 숫자부터 랜덤으로 생성된 숫자를 합했을 때 31이상이 되면 31까지 출력하고,
			//컴퓨터가 졌다고 출력 후 반복문 종료
			end = end >= 31 ? 31 : end;
			/*if(end >= 31) {
				end = 31;
			}*/
			//아니면 현재 숫자부터 랜덤으로 생성된 숫자 개수만큼 출력
			System.out.print("com : ");
			for(int i = count + 1; i<= end; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
			//현재 숫자를 출력된 마지막 숫자로 수정
			count = end;
			if(count == 31) {
				System.out.println("유저 승!");
				break;
			}
		
			//사용자가 1~3사이의 숫자를 입력
			System.out.print("정수 : ");
			user = scan.nextInt();
			//현재 숫자부터 입력한 숫자를 합했을 때 31이상 되면 31까지 출력하고
			//사용자가 졌다고 출력 후 반복문 종료
			end = count + user;
			end = end >= 31 ? 31 : end;
			//아니면 현재 숫자부터 입력한 숫자 개수만큼 출력
			System.out.print("user: ");
			for(int i = count+1; i<=end; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
			//현재 숫자를 출력된 마지막 숫자로 수정
			count = end;
			if(count == 31) {
				System.out.println("컴퓨터 승!");
			}
		}
	}

}






