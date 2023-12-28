package day14;

import java.util.ArrayList;

public class ListEx1 {

	public static void main(String[] args) {
		//List는 인터페이스이기 때문에 인스턴스를 직접 생성할 수 없다
		//List<Integer> list = new List<Integer>();//에러가 발생
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<100; i++) {
			list.add(i+1);
		}
		for(int i = 0; i<list.size(); i++) {
			//get(index) : index 번지에 있는 인스턴스를 가져옴
			System.out.print(list.get(i) + " ");
		}
		
	}

}
