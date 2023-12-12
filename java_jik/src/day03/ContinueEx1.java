package day03;

public class ContinueEx1 {

	public static void main(String[] args) {
		//continue를 이용하여 짝수 출력 예제
		//홀수이면 건너뜀(스킵). 짝수이면 출력
		for(int i = 1; i<=10; i++) {
			if(i % 2 != 0) {
				continue;
			}
			System.out.println(i);
		}
		
	}

}
