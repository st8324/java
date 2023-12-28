package day14;

public class ExceptionEx3 {

	public static void main(String[] args) {
		//throws와 throw를 이용한 예외 처리
		try {
			printDiv1(1, 0);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		printDiv1(1, 0);
		try {
			printDiv2(1, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	//두 수를 나눈 후 결과를 출력하는 메서드
	//throw를 통해 예외를 발생 시킴
	//발생한 예외가 RuntimeException의 자식 예외이기 때문에 throws를 생략 함
	public static void printDiv1(int num1, int num2) {
		if(num2 == 0) {
			throw new ArithmeticException("0으로 나눌 수 없습니다.");
		}
		System.out.println(num1 / (double)num2);
	}
	
	public static void printDiv2(int num1, int num2) throws Exception {
		if(num2 == 0) {
			throw new Exception("0으로 나눌 수 없습니다.");
		}
		System.out.println(num1 / (double)num2);
	}
}
