package day13;

public class InterfaceEx1 {

	public static void main(String[] args) {
		System.out.println(KiaCar.brand);
		Printer.print();

	}

}

class KiaCar{
	public static String brand = "기아";
}

interface Printer{
	//static이 붙은 메서드는 반드시 구현 해야 함
	static void print() {
		System.out.println("프린터입니다.");
	}
	//static이 안 붙은 메서드는 추상메서드로 만들어서 구현하지 않거나
	void test();
	//default 메서드로 만들어서 구현
	default void test2() {}
}






