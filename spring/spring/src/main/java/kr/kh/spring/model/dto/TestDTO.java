package kr.kh.spring.model.dto;

public class TestDTO {

	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public TestDTO() {}
	public TestDTO(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "TestDTO [name=" + name + ", age=" + age + "]";
	}
	
}
