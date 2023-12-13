package day04;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		/* Up Down 게임을 구현하세요.
		 * - 다음과 같은 메뉴를 가져야 합니다.
		 * 1. 새게임
		 * 2. 최고기록 확인
		 * 3. 프로그램 종료
		 * 
		 * - 새게임은 업다운 게임을 시작
		 *   - 랜덤으로 생성된 수를 맞추는 게임
		 *   - 맞췄을 때 맞춘 회수를 출력하고 메뉴로 돌아감
		 * - 최고기록 확인 업다운 게임을 하면서 맞춘 횟수 중 가장 적은
		 *   횟수를 알려줌
		 * */
		Scanner scan = new Scanner(System.in);
		int menu;//메뉴
		int count, bestCount = -1;//게임 플레이 횟수, 최고기록
		int random;//랜덤한 수
		int num;//입력한 정수
		int max = 100, min = 1;//랜덤 수 범위
		//반복문 - 
		do {
			//메뉴를 출력
			System.out.println("--------------");
			System.out.println("메뉴");
			System.out.println("1. 새게임");
			System.out.println("2. 최고기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.println("--------------");
			System.out.print("메뉴 선택 : ");
			//메뉴를 선택
			menu = scan.nextInt();
			//선택한 메뉴에 따라 기능을 실행
			switch(menu) {
			//1번메뉴 선택
			case 1:
				//업다운 게임을 실행
				//랜덤한 수 생성
				random = (int)(Math.random()*(max-min+1) + min);
				System.out.println("랜덤 : " + random);
				//반복문
				count = 0;
				do {
					//정수 입력
					System.out.print("입력 : ");
					num = scan.nextInt();
					//입력횟수를 1증가
					count++;
					//입력한 정수와 랜덤한 수 비교후 up/down/정답 출력
					if(num > random) {
						System.out.println("Down!");
					}else if(num < random) {
						System.out.println("Up!");
					}else {
						System.out.println("정답!");
					}
				}while(num != random);
				//현재 기록을 출력
				System.out.println("기록 : " + count);
				//게임이 끝났으면 현재 횟수가 최고기록 횟수보다 좋으면
				if(bestCount == -1 || count < bestCount) {
					//최고 기록횟수를 현재 횟수로 수정
					bestCount = count;
				}
				break;
			//2번메뉴 선택
			case 2:
				//최고기록을 출력
				if(bestCount == -1) {
					System.out.println("플레이한 기록이 없습니다.");
					break;
				}
				System.out.println("최고 기록 : " + bestCount);
				break;
			//3번메뉴 선택
			case 3:
				System.out.println("프로그램을 종료합니다.");
				//프로그램을 종료
				break;
			}
		}while(menu != 3);
	}

}








