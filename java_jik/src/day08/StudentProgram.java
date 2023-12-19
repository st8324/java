package day08;

import java.util.Scanner;

public class StudentProgram {

	/* 다음 기능을 가진 성적 관리 프로그램을 작성하세요.
	 * - 1반의 성적을 관리
	 * - 최대 5명
	 * - 성적은 번호순으로 관리
	 * - 성적은 국어, 영어, 수학 성적을 관리
	 * 메뉴
	 * 1.성적수정
	 * 2.성적조회
	 * 3.프로그램 종료
	 * 메뉴 선택 : 
	 * 
	 * --성적수정--
	 * 1. 국어
	 * 2. 영어
	 * 3. 수학
	 * 과목 선택 : 1
	 * 
	 * 학생 선택 : 3 번호를 선택
	 * 성적 입력 : 100
	 * 
	 * --성적조회--
	 * 1. 과목별조회
	 * 2. 학생별조회
	 * 선택 : 1
	 * --과목별조회--
	 * 1. 국어
	 * 2. 영어
	 * 3. 수학
	 * 과목 선택 : 1
	 * 1번 : 0점
	 * 2번 : 0점
	 * 3번 : 100점
	 * ....
	 * 30번 : 0점
	 * 
	 * --성적조회--
	 * 1. 과목별조회
	 * 2. 학생별조회
	 * 선택 : 2
	 * 학생 선택 : 3
	 * 국어 : 100점
	 * 영어 : 0점
	 * 수학 : 0점
	 * */
	public static void main(String[] args) {
		//학년,이른은 생략하고, 반은 1반으로 고정.
		//번호는 각각 1번부터 5번으로 저장
		
		//5명의 학생 정보를 저장할 수 있는 배열을 생성
		Student [] stds = new Student[5];
		//각 학생의 번호를 1번부터 5번까지 지정
		//각 학생의 인스터스를 생성
		for(int i = 0; i<stds.length; i++) {
			stds[i] = new Student();
			//stds[i].classNum = 1;
			//stds[i].num = i+1;
		}
		//학생 번호를 수정
		int count = 1;
		/* 향상된 for문을 이용하여 std를 다른 인스턴스로 교체하는 건 안되지만
		 * std의 멤버변수를 바꾸는 건 가능 */
		for(Student std : stds) {
			//std = new Student();
			std.classNum = 1;
			std.num = count++;
		}
		//stds[0].printInfo();
		//반복문 : 프로그램 종료를 선택하지 않으면 반복
		int menu = 0;
		do {
			//메뉴 출력
			printMenu();
			
			//메뉴 선택
			Scanner scan = new Scanner(System.in);
			menu = scan.nextInt();
			
			//선택한 메뉴에 따른 기능 실행
			switch(menu) {
			case 1:
				//주어진 학생 정보에 추가 정보를 입력하여 학생 성적을 수정하는 메서드
				updateScore(stds);
				break;
			case 2:
				//주어진 학생 정보를 조회하는 기능을 구현하세요. : 메서드
				//학생 배열을 주고 조회를 하라고 시킴
				printScore(stds);
				break;
			case 3:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 3);
		//프로그램 종료를 출력
	}
	
	public static void printMenu() {
		System.out.println("---------------");
		System.out.println("메뉴");
		System.out.println("1. 성적 수정");
		System.out.println("2. 성적 조회");
		System.out.println("3. 프로그램 종료");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
	}
	/* 기능 : 학생 배열이 주어지면 정보를 입력받아 학생 성적을 출력하는 메서드
	 * 매개변수 : 학생 배열 => Student []stds
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printScore
	 * */
	public static void printScore(Student []stds) {
		//성적 조회를 위한 서브메뉴를 출력
		System.out.println("---------------");
		System.out.println("성적조회");
		System.out.println("1. 과목별 조회");
		System.out.println("2. 학생별 조회");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
		//서브 메뉴를 선택
		Scanner scan = new Scanner(System.in);
		int menu = scan.nextInt();
		//선택한 서브 메뉴에 따른 기능을 실행
		switch(menu) {
		//서브 메뉴가 1이면 과목별 조회
		case 1:
			//학생 배열을 주고 조회할 과목을 입력받아 과목에 맞는 성적을 출력하라고 시킴 : 메서드
			printScoreBySubject(stds);
			break;
		//서브 메뉴가 2이면 학생별 조회
		case 2:
			//학생 배열을 주고 학생 번호를 입력받아 번호에 맞는 학생 성적을 출력하라고 시킴 : 메서드
			printScoreByNum(stds);
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	/* 기능 : 학생 배열을 주고 학생 번호를 입력받아 번호에 맞는 학생 성적을 출력하는 메서드
	 * 매개변수 : 학생 배열 => Student [] stds
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printScoreByNum
	 * */
	public static void printScoreByNum(Student [] stds) {
		//학생 번호를 입력
		System.out.print("학생 번호 : ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		//반복문 : 학생 전체
		for(Student std : stds) {
			//입력한 학생 번호와 일치하는 학생 성적을 출력
			if(std.num == num) {
				std.printScore();
				return;
			}
		}
		//없는 학생 번호이면 없는 학생이라고 출력
		System.out.println("일치하는 학생이 없습니다.");
	}
	/* 기능 : 학생 배열을 주고 조회할 과목을 입력받아 과목에 맞는 성적을 출력하는 메서드
	 * 매개변수 : 학생 배열 => Student[] stds
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printScoreBySubject
	 * */
	public static void printScoreBySubject(Student [] stds) {
		//과목을 입력
		System.out.print("과목(국어 : 1, 영어 : 2, 수학 : 3) : ");
		Scanner scan = new Scanner(System.in);
		int subject = scan.nextInt();
		//반복문 : 학생 전체
		for(Student std : stds) {
			//입력한 과목에 맞는 성적을 출력
			switch(subject) {
			case 1:
				System.out.println("번호 : " + std.num + ", 국어 : " + std.kor);
				break;
			case 2:
				System.out.println("번호 : " + std.num + ", 영어 : " + std.eng);
				break;
			case 3:
				System.out.println("번호 : " + std.num + ", 수학 : " + std.math);
				break;
			default:
				System.out.println("잘못된 과목입니다.");
			}
		}
	}
	/* 기능 : 학생들 정보가 주어지고 추가정보를 입력하면 학생 성적을 수정하는 메서드
	 * 매개변수 : 학생들 정보 => Student[] stds
	 * 리턴타입 : 없음 => void
	 * 메서드명 : updateScore
	 * */
	public static void updateScore(Student[] stds) {
		Scanner scan = new Scanner(System.in);
		//과목을 선택
		System.out.print("과목(국어 : 1, 영어 : 2, 수학 : 3): ");
		int subject = scan.nextInt();
		//학생 번호를 선택
		System.out.print("학생 번호 : ");
		int num = scan.nextInt();
		//성적은 입력
		System.out.print("성적 : ");
		int score = scan.nextInt();
		//반복문 : 학생 전체
		for(Student std: stds) {
			//입력한 학생 번호와 일치하는 학생 정보를 찾아서 해당하는 과목에 맞는 성적을 수정
			if(std.num != num) {
				continue;
			}
			//일치하는 학생이 있을 때
			switch(subject) {
			case 1:
				std.setKor(score);
				return;
			case 2:
				std.setEng(score);
				return;
			case 3:
				std.setMath(score);
				return;
			}
		}
		//과목 또는 학생 번호가 잘못되면 안내문구 출력
		System.out.println("과목 또는 학생 번호가 잘못됐습니다.");
	}
}
