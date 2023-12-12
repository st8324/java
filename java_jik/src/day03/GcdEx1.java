package day03;

public class GcdEx1 {

	public static void main(String[] args) {
		/* 정수의 약수를 출력하는 예제를 작성하세요.
		 * 약수는 나누어서 떨어지는 수 
		 * 4의 약수 : 1, 2, 4
		 * */
		int num = 4;

		System.out.print("4의 약수 : ");
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				System.out.print(i+ (i == num?"\n":", "));
			}
		}
		// 조건식 ? 참일때값 : 거짓일때값;
	}
}
