package day10;

public class ThisEx1 {

	public static void main(String[] args) {
		Point pt1 = new Point();
		pt1.print();
		Point pt2 = new Point(1,2);
		pt2.print();
	}
}

//점을 나타내는 Point 클래스
class Point{
	private int x, y;

	//getter와 setter
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		//여기서 this는 생략해도 됨
		//x가 다른 변수와 착각할일이 없기 때문에
		return this.x;
	}

	public void setX(int x) {
		//여기서는 this를 반드시 써야 함
		//멤버변수 x와 매개변수 x를 구별하기 위해서
		this.x = x;
	}
	
	public Point(int x, int y) {
		//this(x);//this를 잘못 사용하면 객체 초기화가 완료되지 않을 있기 때문에
		//조심해서 사용해야 한다.
		this.x = x;
		this.y = y;
		System.out.println("매개변수 2개 생성자");
	}
	public Point() {
		//이 위치에 아래 주석처럼 this생성자 이외의 다른 실행문이 오면 안됨
		//System.out.println("기본 생성자");
		this(0,0);//x=0, y=0으로 초기화 하기 위해 위에 있는 생성자를 호출
		System.out.println("기본 생성자");
	}
	public Point(int x) {
		//this();
		this.x = x;
	}
	public void print() {
		System.out.println("("+x+","+y+")");
	}
}











