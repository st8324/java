package day18.student2;

public class StudentMain {

	public static void main(String[] args) {
		/* 학생 관리 프로그램을 구현하세요.
		 * - 기능
		 *   - 학생 등록
		 *   - 학생 목록 조회
		 *   - 종료
		 * - Student 클래스를 생성해서 구현
		 *   - 학년, 반, 번호, 이름
		 * - 소켓 통신을 이용하여 학생 정보를 서버에 저장, 불러와서 조회
		 * */
		StudentProgram sp = new StudentProgram();
		sp.run();
	}
}
