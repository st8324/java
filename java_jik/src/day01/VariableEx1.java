package day01;

public class VariableEx1 {

	//문자형 변수 선언 예제
	public static void main(String[] args) {
		/* 변수 선언 방법
		 * 1. 변수를 선언만 함
		 * 변수타입 변수명;
		 * 2. 변수를 선언하고 초기화 함
		 * 변수타입 변수명 = 값;
		 */
		//문자형 변수 ch1를 선언
		char ch1;
		//문자형 변수 ch2를 선언하고, 문자 A로 초기화
		char ch2 = 'A';
		//변수는 초기화를 하고, 사용해야 한다.
		//초기화 되지 않은 ch1을 사용하려고 하면 에러가 발생
		//System.out.println(ch1);
		ch1 = '+';
		System.out.println(ch1);
		System.out.println(ch2);
		//""는 문자열을 의미, ""안에 한글자가 들어간다 해서 문자가 되는 것이
		//아니라 한글자인 문자열이다.
		//char ch3 = "A";
		//''안에는 한 글자가 들어가야 한다.
		//char ch4 = '12';
		//유니코드 65에 해당하는 문자를 저장
		char ch5 = '\u0065';
		System.out.println(ch5);
		//아스키코드 65에 해당하는 문자를 저장
		char ch6 = 65;
		System.out.println(ch6);
		//\가 들어간 문자들이 있음. \n : 엔터, \t : 탭키만큼의 공백
		//\\ : \문자 등
		char ch7 = '\n';
		System.out.println(ch7);
	}

}




