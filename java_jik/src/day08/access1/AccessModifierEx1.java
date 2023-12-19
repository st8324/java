package day08.access1;

public class AccessModifierEx1 {

	public static void main(String[] args) {
		Student std = new Student();
		//std.grade = 1;//grade의 접근제어자가 private이어서 같은 패키지에 있는 클래스에서 사용 X
		//grade가 private이어서 grade를 수정하기 위해 setter를 이용하여 수정
		std.setGrade(1);
		std.classNum = 2; //classNum의 접근제어자가 default이어서 같은 패키지에 있는 클래스에서 사용 O
		std.num = 3;//num의 접근제어자가 public이어서 사용 O
		System.out.println(std.getGrade() + "학년");
	}

}
