package accountbook.service;

import java.util.List;

import accountbook.Item;

public interface AccountBookService {


	//가계부(리스트)에 내역을 추가하는 메서드 : 홍길동
	boolean addItem(List<Item> list, Item item);
	
	//가계부(리스트에)에 내역을 수정하는 메서드 : 임꺽정
	boolean setItem(List<Item> list, String title, int moeny);
}
