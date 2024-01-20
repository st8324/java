package accountbook.service;

import java.util.List;

import accountbook.model.Item;

public interface AccountBookService {


	//가계부(리스트)에 내역을 추가하는 메서드 : 홍길동
	boolean insertItem(List<Item> list, Item item);

	void sort(List<Item> list);

	boolean checkIndex(List<Item> list, int index);

	boolean updateItem(List<Item> list, int index, Item item);

	boolean deleteItem(List<Item> list, int index);
}
