package day02;

import java.util.Scanner;

public class HomeworkEx1 {

	public static void main(String[] args) {
		/* 성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		 * 90이상 ~ 100이하 : A
		 * 80이상 ~ 90미만 : B
		 * 70이상 ~ 80미만 : C
		 * 60이상 ~ 70미만 : D
		 * 60미만 : F
		 * 0보다 작거나 100보다 큰 경우 : 잘못된 점수
		 * */
		
		//성적을 콘솔에서 입력 받음
		Scanner scan = new Scanner(System.in);
		System.out.print("성적 입력(0~100) : ");
		int score = scan.nextInt();
		
		//성적을 기준으로 학점을 출력
		//성적이 90점이상이고 성적이 100점이하이면 A학점 출력
		if(score >= 90 && score <= 100) {
			System.out.println(score + "점은 A");
		}
		else if(score >= 70 && score < 80) {
			System.out.println(score + "점은 C");
		}
		//성적이 80점이상이고 성적이 90점미만이면 B학점 출력
		else if(score >= 80 && score < 90) {
			System.out.println(score + "점은 B");
		}
		else if(score >= 60 && score < 70) {
			System.out.println(score + "점은 D");
		}
		else if(score >= 0 && score < 60) {
			System.out.println(score + "점은 F");
		}
		else {
			System.out.println("잘못된 점수");
		}
		
		//순서가 중요한 대신 조건식이 간결해지는 방법
		if(score < 0 || score > 100) {
			System.out.println("잘못된 점수");
		}else if(score >= 90) {
			System.out.println(score + "점은 A");
		}else if(score >= 80) {
			System.out.println(score + "점은 B");
		}else if(score >= 70) {
			System.out.println(score + "점은 C");
		}else if(score >= 60) {
			System.out.println(score + "점은 D");
		}else {
			System.out.println(score + "점은 F");
		}
		
		scan.close();
	}

}



