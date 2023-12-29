package day15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaEx2 {

	public static void main(String[] args) {
		//람다식을 이용하여 리스트를 정렬하는 예제
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(30);
		list.add(5);
		list.add(28);
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		list2.addAll(list);
		list3.addAll(list);
		
		System.out.println("정렬 전 : " + list);
		//방법1로 정렬
		list.sort(new ListA());
		System.out.println("정렬 후 : " + list);
		
		//방법2로 정렬
		list2.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		System.out.println("정렬 후 : " + list2);
		
		//방법3로 정렬
		/*
		list3.sort((o1,o2)->{
			return o1-o2;
		});
		*/
		list.sort((o1, o2)-> o1 - o2);
		System.out.println("정렬 후 : " + list3);

	}
}

class ListA implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}
}

