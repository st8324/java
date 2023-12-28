package day14;

import lombok.Data;

public class GenericEx1 {

	public static void main(String[] args) {
		Array1<Integer> array = new Array1<Integer>(5);
		
		for(int i = 0; i<5; i++) {
			array.add(i, i+1);
		}
		for(int i = 0; i<5; i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println();
		//Array1에 T extends Number를 적용하면 Character 클래스는 Number 클래스의 자식 클래스가
		//아니기 때문에 에러가 발생
		Array1<Character> array2 = new Array1<Character>(10);
		for(int i = 0; i<10; i++) {
			array2.add(i, (char)('a'+i));
		}
		for(int i = 0; i<10; i++) {
			System.out.print(array2.get(i) + " ");
		}
	}

}
//배열 클래스
class Array1<T /*extends Number*/>{
	private T [] array ;
	
	public Array1() {
		this(10);
	}
	public Array1(int size) {
		array = (T[])new Object[size];
	}
	
	//index번지에 요소를 추가하는 메서드 
	public boolean add(int index, T t) {
		if(array.length <= index) {
			return false;
		}
		array[index] = t;
		return true;
	}
	public T get(int index) {
		if(array.length <= index) {
			return null;
		}
		return array[index];
	}
}

class TestB<T, C>{
	private T num1;
	private C num2;
}


