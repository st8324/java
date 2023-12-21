package day10;

public class SingletonEx1 {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		System.out.println(s.getStr());
		s.setStr("abc");
		System.out.println(s.getStr());
		
		Singleton s2 = Singleton.getInstance();
		//str의 초기값인 "Hi"가 아니라 앞에서 수정한 abc가 출력
		System.out.println(s2.getStr());
		//싱글톤 클래스의 인스턴스 s와 s2는 같은 인스턴스를 공유하기 때문에
		//s2에서 값을 수정하면 s에서 변경된 값을 확인
		s2.setStr("def");
		System.out.println(s.getStr());
		
	}
}

class Singleton{
	//본인 클래스의 인스턴스를 static으로 선언
	private static Singleton singleton = new Singleton();
	private String str;
	//생성자의 접근제어자가 private
	private Singleton() {
		str = "Hi";
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
}







