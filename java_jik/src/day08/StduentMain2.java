package day08;

public class StduentMain2 {

	public static void main(String[] args) {
		//5명의 학생을 저장하기 위한 배열을 생성하세요.
		Student [] stds = new Student[5];
		
		//학생 5명의 학생 정보를 출력하는 코드를 작성하세요.
		for(int i = 0; i<stds.length; i++) {
			stds[i] = new Student();
			stds[i].printInfo();
		}
	}

}
