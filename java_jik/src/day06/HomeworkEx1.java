package day06;

import java.util.Scanner;

public class HomeworkEx1 {

	public static void main(String[] args) {
		/* 숫자 야구게임을 구현하세요.
		 * - 1~9사이의 중복되지 않은 3개의 수를 랜덤으로 선택해서 해당 숫자를 맞추는 게임
		 * - S : 숫자가 있고, 위치가 같은 경우
		 * - B : 숫자가 있지만 위치가 다른 경우
		 * - O : 일치하는 숫자가 하나도 없는 경우
		 * - 3S가 되면 게임이 종료
		 * 
		 * 예시
		 * 랜덤으로 생성된 숫자 : 3 9 1
		 * 입력 : 1 2 3
		 * 결과 : 2B
		 * 입력 : 4 5 6
		 * 결과 : O
		 * 입력 : 7 9 8
		 * 결과 : 1S
		 * 입력 : 3 1 9
		 * 결과 : 1S2B
		 * 입력 : 3 9 1
		 * 결과 : 3S
		 * 정답입니다.
		 * */
		
		//컴퓨터가 랜덤으로 중복되지 않은 숫자 3개를 생성(1~9)
		//랜덤으로 중복되지 않은 숫자 6개를 생성(1~45)
		int min = 1, max = 9;
		int com[] = new int[3];
		int count = 0;
		
		//랜덤으로 중복되지 않은 3개의 수를 생성
		while(count < com.length) {
			//랜덤한 수 생성
			int r = (int)(Math.random() * (max - min + 1) + min);
			
			//중복 확인
			int i;
			for(i = 0; i<count; i++) {
				if(com[i] == r) {
					break;
				}
			}
			//중복되지 않으면 저장 후 count증가
			if(i == count) {
				com[count++] = r;
			}
		}
		
		//출력
		for(int i = 0; i<com.length; i++) {
			System.out.print(com[i] + " ");
		}
		System.out.println();
		//반복문 : 맞출때까지 => 스트라이크의 개수가 3개 미만인 경우 반복
		int strike, ball;
		int user [] = new int[com.length];
		Scanner scan = new Scanner(System.in);
		do {
			//중복되지 않은 숫자 3개를 입력
			count = 0;
			System.out.print("입력 : ");
			while(count < user.length) {
				int input = scan.nextInt();
				int i;
				for(i = 0; i<count; i++) {
					if(user[i] == input) {
						break;
					}
				}
				//중복되지 않으면 저장 후 count증가
				if(i == count) {
					user[count++] = input;
				}
			}
			//스트라이크와 볼의 개수를 계산
			strike = 0;
			ball = 0;
			for(int i = 0; i<com.length; i++) {
				for(int j = 0; j<user.length; j++) {
					//두 수가 같으면
					if(com[i] == user[j]) {
						//위치가 같으면 스트라이트
						if(i == j) {
							strike++;
						}else { //다르면 볼
							ball++;
						}
					}
				}
			}
			
			//스트라이크와 볼의 개수에 따른 결과를 출력
			if(strike != 0) {
				System.out.print(strike + "S");
			}
			if(ball != 0) {
				System.out.print(ball + "B");
			}
			if(strike == 0 && ball == 0) {
				System.out.print("O");
			}
			System.out.println();
				
		}while(strike < 3);
		//정답입니다.를 출력
		System.out.println("정답입니다.!");
		scan.close();
	}

}









