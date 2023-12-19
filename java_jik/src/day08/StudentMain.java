package day08;

public class StudentMain {

	public static void main(String[] args) {
		//학생 1명의 정보를 저장하는 인스턴스를 생성해보세요.
		Student std = new Student();
		std.printInfo();
		//1학년 1반 1번 홍길동
		std.grade = 1;
		std.classNum = 1;
		std.num = 1;
		std.name = "홍길동";
		std.printInfo();
		//국어 : 90, 영어 : 100, 수학 : 80으로 수정해보세요.
		std.setKor(90);//std.kor = 90;
		std.setEng(100);
		std.setMath(80);
		std.printScore();
	}

}
