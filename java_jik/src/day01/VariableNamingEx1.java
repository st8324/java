package day01;

public class VariableNamingEx1 {

	// 변수명 작성 규칙(필수)과 관례(선택이지만 추천)
	public static void main(String[] args) {
		//1. 대소문자를 구분
		int num;
		int NUM;
		int Num;
		int nuM;
		//2. 예약어 사용 불가능
		//int int;
		//int public;
		//int class;
		//3. 숫자로 시작 불가능
		//int 2num;
		int num2;
		//4. 특수문자는 _와 $만 가능
		int _num;
		//int #num;
		//int n um;
		int num$;
		//5. 중복 선언 불가능
		//위에서 선언됨
		//int num;
	}

}
