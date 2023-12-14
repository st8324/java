package day05;

import java.util.Scanner;

public class ArrayEx1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		/*int kor1, kor2, kor3, kor4, kor5;
		kor1 = scan.nextInt();
		kor2 = scan.nextInt();
		kor3 = scan.nextInt();
		kor4 = scan.nextInt();
		kor5 = scan.nextInt();
		// 아래 반복문은 변수명에 숫자가 들어가서 i로 변경 후 반복문을 쓰려고 해도
		// 불가능
		for(int i = 1; i<=5; i++) {
			kori = scan.nextInt();
		}
		*/
		//학생 5명의 국어 성적을 저장하기 위한 배열
		int [] korScores = new int[5];
		/*
		korScores[0] = scan.nextInt();
		korScores[1] = scan.nextInt();
		korScores[2] = scan.nextInt();
		korScores[3] = scan.nextInt();
		korScores[4] = scan.nextInt();
		*/
		for(int i = 0; i<5; i++) {
			System.out.print("학생" + (i+1) + " 성적 : ");
			korScores[i] = scan.nextInt();
		}
		for(int i = 0; i<5; i++) {
			System.out.println("학생" + (i+1) + " 성적 : " + korScores[i]);
		}
		scan.close();
	}
}







