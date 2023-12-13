package day04;

public class RandomEx1 {

	public static void main(String[] args) {
		//랜덤으로 가위바위보를 생성하는 예제
		//이전에 했던 1~3이 아닌 P,R,S를 직접 선택
		String str = "PRS";
		for(int i = 1; i<=3; i++) {
			//랜덤으로 0~2사이의 번지를 선택
			int r = (int)(Math.random()*3);
			//r번지에 있는 문자를 가져옴
			System.out.println(str.charAt(r));
		}

	}

}
