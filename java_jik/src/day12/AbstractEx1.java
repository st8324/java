package day12;

public class AbstractEx1 {

	public static void main(String[] args) {
		// 추상 클래스 예제
		//AA 추상 클래스는 추상 메서드가 없지만 추상 클래스를 이용하여
		//인스턴스를 생성할 수 없음
		//AA aa1 = new AA();//에러 발생
		//추상 클래스의 인스턴스를 만들려면 익명 클래스를 이용하거나
		AA aa1 = new AA() {
		};
		//추상 클래스를 상속받은 일반 클래스를 생성해서 인스턴스를 생성(업캐스팅)
		AA aa2 = new CA();
		
		DA da1 = new DA();
		da1.print();
	}

}

abstract class AA{
	int num;
}
abstract class AB{
	int num;
	public abstract void print();
}
class CA extends AA{
	
}
class DA extends AB{

	@Override
	public void print() {
		System.out.println("num : " + num);
	}
	
}














