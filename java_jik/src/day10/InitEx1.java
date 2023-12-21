package day10;

public class InitEx1 {

	public static void main(String[] args) {
		B b = new B();
		//num1은 int의 기본값으로 초기화
		System.out.println(b.num1);
		//num2은 int의 기본값으로 초기화
		System.out.println(B.num2);
		//num3은 int의 기본값으로 초기화 => 명시적 초기화로 덮어씀B
		System.out.println(b.num3);
		//num4은 int의 기본값으로 초기화 => 명시적 초기화로 덮어씀B
		System.out.println(B.num4);
		//num5는 기본값 0 -> 명시적초기화 10 -> 초기화 블록 3
		System.out.println(b.num5);
		//num6는 기본값 0 -> 명시적초기화 20 -> 초기화 블록 4
		System.out.println(B.num6);
		//num7은 기본값 0 -> 명시적초기화 30 -> 초기화 블록 500 -> 생성자 5 
		System.out.println(b.num7);
	}
}

class B{
	int num1;
	int num3 = 1;
	int num5 = 10;
	int num7 = 30;
	{
		num5 = 3;
		num7 = 500;
	}
	static int num2;
	static int num4 = 2;
	static int num6 = 20;
	static {
		num6 = 4;
	}
	public B() {
		num7 = 5;
	}
}






