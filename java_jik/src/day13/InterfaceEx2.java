package day13;

public class InterfaceEx2 {

	public static void main(String[] args) {
		print(new Product());
		print(new Student());
	}

	public static void print(Print p) {
		p.print();
	}
}

interface Print{
	void print();
}

class Product implements Print{

	String name = "TV";
	String code = "TV001";
	
	@Override
	public void print() {
		System.out.println("제품명 : " + name);
		System.out.println("제품코드: " + code);
	}
}

class Student implements Print{

	int grade = 1, classNum = 1, num = 1;
	String name = "홍길동";
	
	@Override
	public void print() {
		System.out.println("학년 : " + grade);
		System.out.println("반  : " + classNum);
		System.out.println("번호 : " + num);
		System.out.println("이름 : " + name);
		
	}
	
}





















