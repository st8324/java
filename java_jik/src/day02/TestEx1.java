package day02;

public class TestEx1 {

	// 연산자 예제
	public static void main(String[] args) {
		/* 다음 코드를 이용하여 국어, 영어, 수학 성적의 평균을 구하여 콘솔에 출력하는 코드를 작성하세요. */
		int korScore = 100, engScore = 50, mathScore = 92;
		int sum = 0;
		double avg = 0.0;
		
		//총점
		sum = korScore + engScore + mathScore;
		avg = (double)sum / 3.0;
		
		System.out.println("세 과목의 총합 : " + sum);
		System.out.println("세 과목의 평균 : " + avg);
		System.out.println("세 과목의 총합 : " + (korScore + engScore + mathScore));
		System.out.println("세 과목의 평균 : " + (korScore + engScore + mathScore)/3.0);
	}

}
