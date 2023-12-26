package day12.product;

public abstract class Product {

	String brand, code, name;
	
	public Product(String brand, String code, String name) {
		this.brand = brand;
		this.code = code;
		this.name = name;
	}
	
	public abstract void print();
}
