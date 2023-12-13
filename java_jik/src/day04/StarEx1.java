package day04;

public class StarEx1 {

	public static void main(String[] args) {
		/* *****
		 * *****
		 * *****
		 * 위와 같이 출력이 되도록 작성해보세요.
		 * 반복횟수	: i는 1부터 3까지 1씩 증가
		 * 규칙성		: *을 5개 출력
		 * 			=> 	반복횟수	: j는 1부터 5까지 1씩 증가
		 * 				규칙성	: *을 출력
		 * 				반복문종료후: 엔터
		 */
		for(int i = 1; i<=3; i++) {
			for(int j = 1; j<=5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
