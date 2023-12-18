package day07;

public class PrimeNumberMethodEx2 {

	public static void main(String[] args) {
		//1~100사이의 소수를 출력하는 코드를 작성하세요.(이미 만들어진 메서드를 이용)
		for(int i = 1; i<=100; i++) {
			if(isPrimeNumber(i)) {
				System.out.print(i + " ");
			}
		}
	}
	/* 기능 : 정수가 주어지면 주어진 정수가 소수이면 소수라고 알려주고 아니면 아니라고 알려주는 메서드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 소수인지 아닌지 => boolean
	 * 메서드명 : isPrimeNumber
	 */
	public static boolean isPrimeNumber(int num) {
		//약수의 개수가 2개이면 소수 아니면 소수가 아님
		int count = 0;//약수의 개수
		for(int i = 1; i<= num; i++) {
			if(isDivisor(num, i)) {
				count++;
			}
		}
		if(count == 2) {
			return true;
		}
		return false;
	}
	/* 기능 : 정수 num1과 정수 num2가 주어졌을 때 num2가 num1의 약수이면 참, 아니면 거짓을 알려주는 메서드
	 * 매개변수 : 정수 num1과 정수 num2 => int num1, int num2 
	 * 리턴타입 : 약수이거나 아니거나 => boolean
	 * 메서드명 : isDivisor
	 * */
	public static boolean isDivisor(int num1, int num2) {
		return num1 % num2 == 0;
	}
	
	//1과 자기자신을 제외한 약수가 존재하면 소수가 아니고 존재하지 않으면 소수
	/* 기능 : 정수가 주어지면 주어진 정수가 소수이면 소수라고 알려주고 아니면 아니라고 알려주는 메서드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 소수인지 아닌지 => boolean
	 * 메서드명 : isPrimeNumber2
	 */
	public static boolean isPrimeNumber2(int num) {
		
		for(int i = 2; i<num; i++) {
			if(isDivisor(num, i)) {
				return false;
			}
		}
		return num != 1;
	}
}





