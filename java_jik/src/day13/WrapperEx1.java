package day13;

public class WrapperEx1 {

	public static void main(String[] args) {
		int num1 = 1;
		Integer num2 = 1;
		num2 = null;
		num2 = num1;
		System.out.println(num2);
		num2 = 20;
		num1 = num2;
		System.out.println(num1);
		//예외 발생 : num2가 null이어서 int로 저장할 수 없음
		/*
		num2 = null;
		num1 = num2;
		System.out.println(num1);
		*/
		
		//문자열을 정수로
		String str = "12345";
		int num3 = Integer.parseInt(str);
		System.out.println(num3 * 10);
	}

}










