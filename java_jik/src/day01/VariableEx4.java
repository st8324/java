package day01;

public class VariableEx4 {

	//논리형 변수 선언 예제
	public static void main(String[]args) {
		boolean isEven = true;
		System.out.println(isEven);
		//아래 코드는 논리형 변수가 이런식으로 사용된다는걸 보여주기 위한 예제
		//아직은 이해할 필요가 없음
		isEven = 3 % 2 == 0;
		System.out.println("3 is Even number? " + isEven);
	}
}
