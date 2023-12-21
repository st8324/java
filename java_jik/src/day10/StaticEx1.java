package day10;

public class StaticEx1 {

	public static void main(String[] args) {
		KiaCar c1 ;
		c1 = new KiaCar("모닝");
		KiaCar c2 = new KiaCar("레이");
		KiaCar c3 = new KiaCar("K3");
		//KiaCar에서 brand는 static이 아니기 때문에 인스턴스마다 brand를 수정
		//해야함
		c1.brand = "기아";
		c2.brand = "기아";
		c3.brand = "기아";
		c1.print();
		c2.print();
		c3.print();

		//인스턴스가 생성되기전에 static 변수인 brand는 이미 메모리에 올라가 있어서
		//사용할 수 있음
		System.out.println(KiaCar2.brand);
		KiaCar2 c4;
		c4 = new KiaCar2("모닝");
		KiaCar2 c5 = new KiaCar2("레이");
		KiaCar2 c6 = new KiaCar2("K3");
		//KiaCar에서 brand는 static이 아니기 때문에 인스턴스마다 brand를 수정
		//해야함
		//인스턴스를 통해서 접근이 가능하지만 static는 클래스명을 통해 접근해야 함
		//c4.brand = "기아";
		KiaCar2.brand = "기아";
		c4.print();
		c5.print();
		c6.print();
		
		System.out.println("대표적인 static변수 Math.PI : " + Math.PI);
	}

}

class KiaCar{
	public String brand = "KIA";
	public String name;//차명
	
	public KiaCar(String name) {
		this.name = name;
	}
	public void print() {
		System.out.println(brand);
		System.out.println("차명 : " + name);
	}
}

class KiaCar2{
	public static String brand = "KIA";
	public String name;//차명
	
	public KiaCar2(String name) {
		this.name = name;
	}
	public void print() {
		System.out.println(brand);
		System.out.println("차명 : " + name);
	}
}



