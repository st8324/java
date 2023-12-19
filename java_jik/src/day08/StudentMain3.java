package day08;

public class StudentMain3 {

	public static void main(String[] args) {
		// Student2클래스의 생성자를 이용한 예제
		//기본 생성자가 없어서 에러 발생
		//Student2 std = new Student2();

		Student2 std = new Student2(1, 1, 1, "홍길동");
		std.printScore();
	}

}
