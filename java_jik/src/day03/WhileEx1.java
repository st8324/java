package day03;

public class WhileEx1 {

	// while문 예제
	public static void main(String[] args) {
		//Hello world를 5번 출력하는 예제
		
		int i = 1; //초기화
		int count = 5;
		while(i <= count) {
			System.out.println("Hello world!");
			++i; //i++; i+=1; i=i+1;
		}
		/*
		System.out.println("Hello world!"); //i = 1
		System.out.println("Hello world!");	//i = 2
		System.out.println("Hello world!");	//i = 3
		System.out.println("Hello world!"); //i = 4
		System.out.println("Hello world!"); //i = 5
		*/
	}

}
