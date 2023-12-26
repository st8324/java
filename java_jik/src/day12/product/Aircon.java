package day12.product;

public class Aircon extends Product {

	double area;//냉방 면적

	public Aircon(String brand, String code, String name, double area) {
		super(brand, code, name);
		this.area = area;
	}
	
	@Override
	public void print() {
		System.out.println("------------------");
		System.out.println("브랜드 : " + brand);
		System.out.println("제품명 : " + name);
		System.out.println("제품코드 : " + code);
		System.out.println("냉방면적 : " + area + "m2");
		
	}
}
