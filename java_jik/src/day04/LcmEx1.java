package day04;

public class LcmEx1 {

	public static void main(String[] args) {
		/* 두 정수의 최소 공배수를 구하는 코드를 작성하세요.
		 * 10의 배수 : 10, 20, 30, ...
		 * 15의 배수 : 15, 30, 45, ...
		 * 10과 15의 공배수 : 30, 60, 90, ...
		 * 10과 15의 최소 공배수 : 30
		 * 반복회수 	: i는 1부터 num1 * num2까지 1씩 증가
		 * 규칙성		: i가 num1과 num2의 공배수이면 i를 출력하고 반복문 종료
		 * 			=>i가 num1의 배수이고, i가 num2의 배수이면 i를 출력하고 반복문 종료
		 * 			=>i를 num1으로 나누었을 때 나머지가 0과 같고 i를 num2로 나누었을 때 나머지가 0과 같다면
		 * 			  i를 출력하고 반복문 종료
		 * */
		int num1 = 10, num2 = 15;
		//i가 1부터 1씩 증가
		for(int i = 1; i<=num1*num2; i++) {
			if(i % num1 == 0 && i % num2 == 0) {
				System.out.println(num1 + "과 " + num2 + "의 최소 공배수 : " +i);
				break;
			}
		}
		//i가 num1부터 num1씩 증가 => i를 num1의 배수들로만 계산
		for(int i = num1; i<=num1*num2; i+=num1) {
			if(i % num2 == 0) {
				System.out.println(num1 + "과 " + num2 + "의 최소 공배수 : " +i);
				break;
			}
		}
	}

}
