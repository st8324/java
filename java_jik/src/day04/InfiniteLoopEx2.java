package day04;

import java.util.Scanner;

public class InfiniteLoopEx2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		//조건식에 사용하는 변수가 증감하지 않아서 무한루프 발생하는 예제1
		for(int i = 10; i>0; ) {
			System.out.print("정수 입력 : ");
			num = scan.nextInt();
			System.out.println("정수 출력 : " + num);
		}
		//i에 따라 조건식 true로 될수도 있기 때문에 이코드가 에러가 발생하지 않음
		System.out.println("프로그램 종료");
		
		//위 코드와 차이는 위에는 무한루프이고, 이 코드는 무수히 많이 실행.
		//i가 증가를 하다가 int 양수 표현범위를 넘어가면 오버플로우가 발생해서
		//음수가 되는데 이때 반복문이 종료
		for(int i = 10; i>0; i++) {
			System.out.print("정수 입력 : ");
			num = scan.nextInt();
			System.out.println("정수 출력 : " + num);
		}
	}

}
