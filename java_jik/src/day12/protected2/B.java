package day12.protected2;

import day12.protected1.A;

public class B extends A {
	
	public void print() {
		//num1은 private이어서 자식 클래스에서도 접근 X
		//System.out.println("num1" + num1);
		//num2는 default에어서 다른 패키지에 있는 클래스에서는 접근 X
		//System.out.println("num2" + num2);
		//num3는 protected이어서 다른 패키지와 상관 없이 자식 클래스에서 접근 O
		System.out.println("num3" + num3);
		//numm4는 public이어서 접근 가능
		System.out.println("num4" + num4);
	}
}
