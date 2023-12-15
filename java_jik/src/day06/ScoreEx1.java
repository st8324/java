package day06;

import java.util.Scanner;

public class ScoreEx1 {

	public static void main(String[] args) {
		/* 다음 기능을 가진 성적 관리 프로그램을 작성하세요.
		 * - 1반의 성적을 관리
		 * - 최대 30명
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
		int menu = 1;
		Scanner scan = new Scanner(System.in);
		int subject;//과목
		int num;//학생 번호
		int score;//성적
		int maxStudent = 30;
		//국어, 영어, 수학 성적을 저장할 배열
		int [] kor = new int[maxStudent];
		int [] eng = new int[maxStudent];
		int [] math= new int[maxStudent];
		int submenu;
		//반복문 선택한 메뉴가 프로그램 종료가 아닐때까지
		do {
			//메인 메뉴출력
			System.out.println("메뉴");
			System.out.println("1.성적수정");
			System.out.println("2.성적조회");
			System.out.println("3.프로그램 종료");
			System.out.print("메뉴 선택 : ");
			
			//메인메뉴를 선택
			menu = scan.nextInt();
			
			//선택한 메인메뉴에 따른 기능 실행
			switch(menu) {
			case 1:
				//서브메뉴 출력 
				System.out.println("성적수정");
				System.out.println("1. 국어");
				System.out.println("2. 영어");
				System.out.println("3. 수학");
				System.out.print("과목 선택 : ");
				//과목 선택
				subject = scan.nextInt();
				//학생 선택
				System.out.print("학생 선택 : ");
				num = scan.nextInt();
				//성적 입력
				System.out.print("성적 입력 : ");
				score = scan.nextInt();
				//성적을 저장
				switch(subject) {
				case 1:	kor[num-1] = score;	break;
				case 2:	eng[num-1] = score; break;
				case 3:	math[num-1]= score;	break;
				}
				break;
			case 2:
				//서브 메뉴 출력
				System.out.println("성적조회");
				System.out.println("1. 과목별조회");
				System.out.println("2. 학생별조회");
				System.out.print("선택 : ");
				//서브 메뉴 선택
				submenu = scan.nextInt();
				//서브 메뉴에 따른 기능 실행
				switch(submenu) {
				case 1:
					//과목선택메뉴 출력
					System.out.println("과목별조회");
					System.out.println("1.국어");
					System.out.println("2.영어");
					System.out.println("3.수학");
					System.out.print("과목 선택 : ");
					//과목 선택
					subject = scan.nextInt();
					//선택한 과목의 성적을 출력
					int []selectedSubject = null;
					switch(subject) {
					case 1:	selectedSubject = kor;	break;
					case 2:	selectedSubject = eng;	break;
					case 3:	selectedSubject = math;	break;
					default:
						System.out.println("잘못된 과목입니다.");
					}
					if(selectedSubject != null) {
						for(int i = 0; i<selectedSubject.length; i++) {
							System.out.println((i+1)+"번 : " + selectedSubject[i] + "점");
						}
					}
					break;
				case 2:
					//학생 선택
					System.out.print("학생 선택 : ");
					num = scan.nextInt();
					//선택한 학생의 국어,영어,수학점수를 출력
					System.out.println("국어 : " + kor[num-1]);
					System.out.println("영어 : " + eng[num-1]);
					System.out.println("수학 : " + math[num-1]);
					break;
				default:
					System.out.println("잘못된 메뉴입니다.");
				}
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while( menu != 3);
		
		scan.close();
	}

}








